package com.sevenpp.qinglantutor.dao.impl;

import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.sevenpp.qinglantutor.entity.TeachRelation;
@Repository
public class HomeworkSelectDaoImpl implements com.sevenpp.qinglantutor.dao.HomeworkSelectDao {
	@Resource
	private SessionFactory sessionFactory;
	
	
//	作业查询
	@Override
	public List<HomeWork> HomeWorkShow() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from HomeWork");
		return q.list();
	}
	
//	老师查询功能
	public List<User> TeacherShow() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User WHERE role='老师'");
		return q.list();
	}
//	关系查询
	public List<ClassRelation> ClassRelation() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ClassRelation");
		return q.list();
	}
//	教学关系查询
	public List<TeachRelation> TeachRelation(){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from TeachRelation");
		return q.list();
	}

}
