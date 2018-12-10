package com.sevenpp.qinglantutor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.LogInDao;

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
* 实现登录
*/
@Repository
public class LogInDaoImpl implements LogInDao {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Boolean existEmail(String email) {
		/**
		 * existEmail(检查这个邮箱是否存在)
		 * 
		 * @param email
		 * @param       @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
		return ((Number) this.getSession().createQuery("select count(*) from User where email=?").setParameter(0, email)
				.uniqueResult()).intValue() == 1;
	}

	@Override
	public Boolean isPassWord(String Pwd, String password) {
		/**
		 * isPassWord(检查密码与账户是否匹配)
		 * 
		 * @param Pwd password
		 * @param       @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
		return password.equals(Pwd);
	}

	@Override
	public String getUserPwd(String email) {
		/**
		 * getPublicKey 获取公钥
		 * 
		 * @param name
		 * @param      @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
		return ((String) this.getSession().createQuery("select userPwd from User where email=?")
				.setParameter(0, email).uniqueResult());
	}

	public String getPrivateKey(String email) {
		/**
		 * getPublicKey 获取公钥
		 * 
		 * @param name
		 * @param      @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
		return ((String) this.getSession().createQuery("select privateKey from User where email=?")
				.setParameter(0, email).uniqueResult());
	}

}
