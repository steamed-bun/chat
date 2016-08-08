package com.xiyou.ajax.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	/**
	 * ֮��ʹ�õ�ʱ��Ͳ�����new ֱ�ӵ���getInit()���Ϳ������ô��������������
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
