package com.sevenpp.qinglantutor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TeaCourseDao;
import com.sevenpp.qinglantutor.entity.User;
/**
*
* 项目名称：qinglantutorprj
* 类名称：TeaCourseDaoImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月12日 上午11:14:20
* 修改人：rain
* 修改时间：2018年12月12日 上午11:14:20
* 修改备注：
* @version
*
*/
@Repository
public class TeaCourseDaoImpl implements TeaCourseDao {

	@Resource
	private SessionFactory sessionFactory;
	public User getUserByEmail(String email) {
		/**
		* getUserByEmail    根据cookie中的邮箱查找用户表信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email = ?");
		query.setString(0, email);
		List<User> list =  query.list();
		return list.get(0);
	}

}

	