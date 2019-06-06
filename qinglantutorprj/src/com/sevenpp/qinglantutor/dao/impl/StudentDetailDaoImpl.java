package com.sevenpp.qinglantutor.dao.impl;

import com.sevenpp.qinglantutor.dao.StudentDetailDao;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDetailDaoImpl implements StudentDetailDao {
	@Resource
	private SessionFactory sessionFactory;	
	
	//用户查询
	public User getUserByEmail(String email){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User u where email=?");
		q.setString(0, email);
		return (User) q.list().get(0);
	}	
	
	
//	文章查询
	@Override

	public List<Article> AtricleShow() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Article ");
		return q.list();
			
	}

//回答查询
	@Override
	public List<ArticleReview> AtricleReview() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ArticleReview ");
		return q.list();
			
	}
	
}

	