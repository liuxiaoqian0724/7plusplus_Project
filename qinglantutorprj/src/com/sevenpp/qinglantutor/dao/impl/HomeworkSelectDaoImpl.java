package com.sevenpp.qinglantutor.dao.impl;

import com.sevenpp.qinglantutor.entity.HomeWork;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@Repository
public class HomeworkSelectDaoImpl implements com.sevenpp.qinglantutor.dao.HomeworkSelectDao {
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<HomeWork> HomeWorkShow() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from HomeWork ");
		return q.list();
	}

}
