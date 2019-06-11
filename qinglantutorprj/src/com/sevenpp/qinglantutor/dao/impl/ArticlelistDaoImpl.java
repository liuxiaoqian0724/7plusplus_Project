package com.sevenpp.qinglantutor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.ArticlelistDao;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.User;

@Repository
public class ArticlelistDaoImpl implements ArticlelistDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<Article> queryArticle(){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Article");
		List<Article> list=query.list();
		session.getTransaction().commit();
		return list;
	}
}