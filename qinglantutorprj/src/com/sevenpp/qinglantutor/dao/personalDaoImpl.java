package com.sevenpp.qinglantutor.dao;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：presonalDao
		* 类描述：个人中心上方简介信息DAO
		* 创建人：rain
		* 创建时间：2018年12月6日 上午10:57:17
		* 修改人：rain
		* 修改时间：2018年12月6日 上午10:57:17
		* 修改备注：
		* @version
		*
		*/
@Repository
public class personalDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
		
	/**方法需获得id参数 以Id查询User表获得List*/
	public List<User> findAll(int id){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User us where us.id = :id");
		q.setParameter("id", id);
		System.out.println("personal数据库读取成功");
		System.out.println(q.list().get(0));
		return q.list();
		
	}
	/**以Email查询User表获得ID*/
	public User finduridByemail(String email){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User ur where ur.email=:email");
		q.setParameter("email", email);
		List<User> list=q.list();
		User user=list.get(0);
		return user;
	}
	/**获得用户平均分方法*/
	public double getUserAVGstar() {
		return 0;
		
	}

}

	