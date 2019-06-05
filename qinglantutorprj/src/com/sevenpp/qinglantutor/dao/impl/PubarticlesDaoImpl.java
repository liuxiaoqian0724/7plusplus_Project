package com.sevenpp.qinglantutor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.PubarticlesDao;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.User;

@Repository
public class PubarticlesDaoImpl implements PubarticlesDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void insertArticles(Article a,User u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		a.setUser(u);
		session.save(a);
		session.getTransaction().commit();
	}
	
	public User findUser(String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User u=new User();
		Query query = session.createQuery("from User where email = ?");
		query.setString(0, email);
		List<User> list=query.list();
		u=list.get(0);
		session.getTransaction().commit();
		return u;
	}
}	