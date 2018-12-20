/**   
		* @Title: IndexDaoImpl.java 
		* @Package com.sevenpp.qinglantutor.dao.Impl 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 上午11:12:26 
		* @version V1.0   
		*/
package com.sevenpp.qinglantutor.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.IndexDao;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.MyJob;
import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexDaoImpl
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 上午11:12:26
		* 修改人：rain
		* 修改时间：2018年12月7日 上午11:12:26
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexDaoImpl 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月7日 上午11:12:26 
		* @version V1.0 
		*/
@Repository
public class IndexDaoImpl implements IndexDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<User> queryUser(){
		System.out.println("IndexDao");
		System.out.println("queryAll");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query1=session.createQuery("from User where role='老师'");
		List<User> list1=query1.list();
		session.getTransaction().commit();
		return list1;
	}
	@Override 
	public List queryTeachage() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query2=session.createQuery("select teacherAge from MyJob");
		List list2=query2.list();
		session.getTransaction().commit();
		return list2;
	}
}