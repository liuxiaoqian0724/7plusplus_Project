package com.sevenpp.qinglantutor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.SendMessageDao;
import com.sevenpp.qinglantutor.entity.MyJob;

/**
*code is far away from bug with the animal protecting
*  ┏┓　　　┏┓
*┏┛┻━━━┛┻┓
*┃　　　　　　　┃ 　
*┃　　　━　　　┃
*┃　┳┛　┗┳　┃
*┃　　　　　　　┃
*┃　　　┻　　　┃
*┃　　　　　　　┃
*┗━┓　　　┏━┛
*　　┃　　　┃神兽保佑
*　　┃　　　┃代码无BUG！
*　　┃　　　┗━━━┓
*　　┃　　　　　　　┣┓
*　　┃　　　　　　　┏┛
*　　┗┓┓┏━┳┓┏┛
*　　　┃┫┫　┃┫┫
*　　　┗┻┛　┗┻┛ 
*　　　
* @author 作者 :Mr.Ren
* @version 创建时间：2018年12月11日 下午5:34:18
* 类说明
*/
@Repository
public class SendMessageDaoImpl implements SendMessageDao {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Boolean sendMessage(MyJob myJob) {
		/**
		* sendMessage(发布家教求职信息)
		* @param MyJob myJob
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		return ((Integer)this.getSession().save(myJob))>0;
	}
	@Override
	public int findId(String email) {
				/**
				* findId(查找id)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
				return ((Integer) this.getSession().createQuery("select id from User where email=?")
						.setParameter(0, email).uniqueResult());
	}

}
