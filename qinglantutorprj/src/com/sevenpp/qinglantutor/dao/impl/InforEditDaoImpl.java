package com.sevenpp.qinglantutor.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.InforEditDao;
import com.sevenpp.qinglantutor.entity.User;

/**
*
* 项目名称：qinglantutorprj
* 类名称：InforEditDaoImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月18日 下午7:44:24
* 修改人：rain
* 修改时间：2018年12月18日 下午7:44:24
* 修改备注：
* @version
*
*/

@Repository
public class InforEditDaoImpl implements InforEditDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public void changeInformation(User u) {
		// TODO Auto-generated method stub
		/**
		* changeInformation		改变用户详细信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "update User u set u.realName = ? , u.idNumber = ? ,  "
				+ "u.school = ? , u.grade = ? , u.phoneNumber = ? , u.address = ? , "
				+ "u.major = ? , u.introduce = ? , u.stuImg = ? , u.userImg = ? ,"
				+ "u.img1 = ? , u.img2 = ? , u.img3 = ? , u.img4 = ?  where u.email = ?";
		Query query = session.createQuery(hql);
		query.setString(0, u.getRealName());
		query.setString(1, u.getIdNumber());
		query.setString(2, u.getSchool());
		query.setString(3, u.getGrade());
		query.setString(4, u.getPhoneNumber());
		query.setString(5, u.getAddress());
		query.setString(6, u.getMajor());
		query.setString(7, u.getIntroduce());
		query.setString(8, u.getStuImg());
		query.setString(9, u.getUserImg());
		query.setString(10, u.getImg1());
		query.setString(11, u.getImg2());
		query.setString(12, u.getImg3());
		query.setString(13, u.getImg4());
		query.setString(14, u.getEmail());
		query.executeUpdate();
	}

	public User getUserByEmail(String email) {
		/**
		* getUserByEmail	得到用户
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

}

	