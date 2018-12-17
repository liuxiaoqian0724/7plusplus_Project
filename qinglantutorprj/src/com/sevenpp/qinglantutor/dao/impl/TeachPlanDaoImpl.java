package com.sevenpp.qinglantutor.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TeachPlanDao;
import com.sevenpp.qinglantutor.entity.TeachPlan;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;


/**
*
* 项目名称：qinglantutorprj
* 类名称：TeachPlanDaoImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午4:36:08
* 修改人：rain
* 修改时间：2018年12月14日 下午4:36:08
* 修改备注：
* @version
*
*/
@Repository
public class TeachPlanDaoImpl implements TeachPlanDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public User getUserByEmail(String email) {
		/**
		* getUserByEmail 根据cookie得到用户信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email = ?");
		query.setString(0, email);
		List<User> list =  query.list();
		return list.get(0);
	}

	public void editTeachPlan(Integer id, String content, Date time) {
		/**
		* editTeachPlan		编辑我的教案
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update TeachPlan tp set tp.content = ? , tp.time = ? where id = ?");
		query.setString(0, content);
		query.setDate(1, time);
		query.setInteger(2, id);
		query.executeUpdate();
	}

	public void deleteTeachPlan(Integer id) {
		/**
		* deleteTeachPlan		删除某个教案
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from TeachPlan where id = ?");
		query.setInteger(0, id);
		query.executeUpdate();
	}

	public TeachRelation getTeachRelationByTrid(Integer trid) {
		/**
		* getTeachRelationByTrid	根据trid找出teachRelation,以便后边的插入更方便
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from TeachRelation where trid = ?");
		query.setInteger(0, trid);
		List<TeachRelation> list = query.list();
		return list.get(0);
	}

	public int addTeachPlan(String content, Date time, TeachRelation teachRelation) {
		/**
		* addTeachPlan		插入教案
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		TeachPlan teachPlan = new TeachPlan();
		teachPlan.setContent(content);
		teachPlan.setTime(time);
		teachPlan.setTeachRelation(teachRelation);
		session.save(teachPlan);
		
		String sql = "select max(id) from tbl_teachplan";
		SQLQuery query = session.createSQLQuery(sql);
		List list = query.list();
		return (int) list.get(0);
	}

}

	