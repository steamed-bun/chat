package com.xiyou.ajax.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	/**
	 * 之后使用的时候就不用再new 直接调用getInit()，就可以是用此类的其它方法了
	 */
	private HibernateUtils() {}

	private static HibernateUtils init = new HibernateUtils();

	public static HibernateUtils getInit() {
		return init;
	}
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		
		if(sessionFactory == null){
			System.out.println("sessionFactory..");
			Configuration configuration = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
													.applySettings(configuration.getProperties())
													.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	
}
