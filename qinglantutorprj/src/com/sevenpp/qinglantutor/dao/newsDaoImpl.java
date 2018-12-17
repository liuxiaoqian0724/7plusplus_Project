package com.sevenpp.qinglantutor.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.Msg;
/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsDaoImpl
		* 类描述：个人中心页消息dao
		* 创建人：rain
		* 创建时间：2018年12月11日 下午4:20:48
		* 修改人：rain
		* 修改时间：2018年12月11日 下午4:20:48
		* 修改备注：
		* @version
		*
		*/
@Repository
public class newsDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询MSG表返回整msg表的list，本方法需要User类user，需要与personalServiceImpl的finduridByemail方法组合使用
	 * */
	public List<Msg> findMsgByid(User user){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Msg ms where ms.user = :id");
		q.setParameter("id", user);
		return q.list();
	}
}

	