/**   
		* @Title: IndexDaoImpl.java 
		* @Package com.sevenpp.qinglantutor.dao.Impl 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 上午11:12:26 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.IndexDao;
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
	public List<User> findAll(int startIndex, int pageSize) {
		System.out.println(" IndexDaoImpl");
		System.out.println("findAll");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where role='老师'").setFirstResult(startIndex).setMaxResults(pageSize);
		List<User> list = query.list();
		for(User s : list){
			System.out.println(s.getUserName());
		}
		session.close();
		return list;
	}
	@Override
	public List<User> queryAll(){
		System.out.println("queryAll");
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from User where role='老师'");
		List<User> list=query.list();
		session.close();
		return list;
	}

}

	