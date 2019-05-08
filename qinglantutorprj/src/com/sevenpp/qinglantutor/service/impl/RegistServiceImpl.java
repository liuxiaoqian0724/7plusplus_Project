package com.sevenpp.qinglantutor.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.RegistDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.RegistService;
import com.sevenpp.qinglantutor.utils.encrypt.RSAEncrypt;

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
* @version 创建时间：2018年12月9日 下午1:25:54
* 类说明
*/
@Transactional
@Service
public class RegistServiceImpl implements RegistService {
	@Resource
	private RegistDaoImpl registDaoImpl;
	@Override
	public Boolean regist(Map<String, String>map) {
				/**
				* regist(这里用一句话描述这个方法的作用)
				* 注册保存用户信息
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
			if (!registDaoImpl.existEmail(map.get("email"))) {
				
			try {
				RSAEncrypt rsaEncrypt = new RSAEncrypt();
				String publicKey = rsaEncrypt.getPublickey();
				String privateKey = rsaEncrypt.getPrivatekey();
				String userPwd;
				userPwd = RSAEncrypt.encrypt(map.get("password"), publicKey);
				User user = new User();
				user.setUserName(map.get("username"));
				user.setSex(map.get("sex"));
				user.setUserPwd(userPwd);
				user.setUserImg("images/default.jpg");
				user.setEmail(map.get("email"));
				user.setPublicKey(publicKey);
				user.setPrivateKey(privateKey);
				user.setRole(map.get("roles"));
				return registDaoImpl.regist(user);
			} catch (Exception e) {
				return false;
			}
			}
			return false;
			
	}

}
