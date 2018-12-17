
package com.sevenpp.qinglantutor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.LogInDaoImpl;
import com.sevenpp.qinglantutor.service.LogInService;
import com.sevenpp.qinglantutor.util.encrypt.RSAEncrypt;

/**
 * code is far away from bug with the animal protecting ┏┓ ┏┓ ┏┛┻━━━┛┻┓ ┃ ┃ ┃ ━
 * ┃ ┃ ┳┛ ┗┳ ┃ ┃ ┃ ┃ ┻ ┃ ┃ ┃ ┗━┓ ┏━┛ ┃ ┃神兽保佑 ┃ ┃代码无BUG！ ┃ ┗━━━┓ ┃ ┣┓ ┃ ┏┛
 * ┗┓┓┏━┳┓┏┛ ┃┫┫ ┃┫┫ ┗┻┛ ┗┻┛
 * 
 * @author 作者 :Mr.Ren
 * @version 创建时间：2018年12月5日 上午10:30:22 类说明
 */

@Transactional
@Service
public class LoginServiceImpl implements LogInService {
	@Resource
	private LogInDaoImpl logInDaoImpl;

	@Override
	public Boolean isPassword(String email, String password) {
		/**
		 * isPassword TODO(验证密码是否正确)
		 * 
		 * @param name
		 * @param      @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
		if (logInDaoImpl.existEmail(email)) {
			String privateKey = logInDaoImpl.getPrivateKey(email);
			String userPwd = logInDaoImpl.getUserPwd(email);
			try {
				userPwd = RSAEncrypt.decrypt(userPwd, privateKey);
			} catch (Exception e) {
				return false;
			}
			return logInDaoImpl.isPassWord(userPwd,password);
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
				/**
				* getRole(获取用户角色)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
			return logInDaoImpl.getRole(email);
	}

	@Override
	public String getUserName(String email) {
				/**
				* getUserName(查询用户名)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
		return logInDaoImpl.getUserName(email);
	}
}
