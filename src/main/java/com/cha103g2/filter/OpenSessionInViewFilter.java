package com.cha103g2.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.SessionFactory;

import com.cha103g2.*;
import com.cha103g2.util.HibernateUtil;

@WebFilter("/*")
public class OpenSessionInViewFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		try {
			factory.getCurrentSession().beginTransaction();
			System.out.println("*******filterBegin********");
			chain.doFilter(req, res);
			System.out.println("*******filterchain********");
			factory.getCurrentSession().getTransaction().commit();
			System.out.println("*******filtercommit********");
		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			System.out.println("*******filterrollback********");
			e.printStackTrace();
			chain.doFilter(req, res);
		}
	}

}



