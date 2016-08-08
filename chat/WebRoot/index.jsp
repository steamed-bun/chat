<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="CSS/css.css"/>
  <base href="<%=basePath%>">	
  <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
  <script type="text/javascript" src="script/dateFormate.js"></script>
  <script type="text/javascript">
  
  	$(function(){
  	
  		var finalMessageId = 0;
  		
  		ask();
  		
  		function ask(){
  			
  			$.post("servletAsk", {"finalMessageId" : finalMessageId},function(hasNew){
				if(hasNew == "true"){
					getNew();
				}
  			},"text");
  			setTimeout(ask, 1000);
  		}
  		
  		function getNew(){
		
			var $showMessage = $("#showMessage");
		
			$.post("servletGet", {"finalMessageId" : finalMessageId}, function(list){
				
				for(var i = 0;i < list.length; i++){
					var id = list[i].id;
					var content = list[i].content;
					var time = list[i].time;
					
					time = new Date(time).Format("yyyy-MM-dd hh:mm:ss");
					
					var all = "<div>"+ time +":"+ content + "<div>"; 
					
					$showMessage.append(all);
					
					finalMessageId = id;
				}
				
			$showMessage[0].scrollTop = 100000000;
			},"json" );
		
		
  		}
  		
  		$("#sendMessage").keypress(function(event){
  			//当按下Enter是的返回值为13
  			//alert(event.keyCode);
  			
  			if(event.keyCode == 13){
				var message = $.trim(this.value);
				$.post("sendServlet",{"message": message}, function(data){
					
				
				}),"text";
				this.value = "";  				
  			}
  		});
  		
  	})
  
  window.onload = function(){
  	
  	var showTimeEle = document.getElementById("showTime");
  	
  	showTime();
  	
  	function showTime(){
  		showTimeEle.innerHTML = new Date().toLocaleString();
  		setTimeout(showTime, 1000);
  	}
  };
  
  </script>
  </head>
  
  <body>
	
	<p id="showTime"></p>
	<img src="pages/114.png">
	<div id="showMessage"></div>
	<textarea id="sendMessage"></textarea>

  </body>
</html>
