package com.sevenpp.qinglantutor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.RegistDao;
import com.sevenpp.qinglantutor.entity.User;

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
* @version 创建时间：2018年12月9日 下午1:24:25
* 实现用户信息的保存
*/
@Repository
public class RegistDaoImpl implements RegistDao {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Boolean regist(User user) {
				/**
				* regist 
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
			return ((Integer)this.getSession().save(user))>0;
	}
	@Override
	public Boolean existEmail(String email) {
				/**
				* existEmail(这里用一句话描述这个方法的作用)
				* TODO(这里描述这个方法适用条件 – 可选)
				* TODO(这里描述这个方法的执行流程 – 可选)
				* TODO(这里描述这个方法的使用方法 – 可选)
				* TODO(这里描述这个方法的注意事项 – 可选)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
		return ((Number) this.getSession().createQuery("select count(*) from User where email=?").setParameter(0, email)
				.uniqueResult()).intValue() == 1;
			
	}
	
	
}
