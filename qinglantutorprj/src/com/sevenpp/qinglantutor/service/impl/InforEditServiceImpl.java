package com.sevenpp.qinglantutor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.InforEditDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.InforEditService;


/**
*
* 项目名称：qinglantutorprj
* 类名称：InforEditServiceImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月18日 下午8:36:03
* 修改人：rain
* 修改时间：2018年12月18日 下午8:36:03
* 修改备注：
* @version
*
*/
@Service
@Transactional
public class InforEditServiceImpl implements InforEditService {

	@Resource
	private InforEditDaoImpl inforEditDaoImpl;
	
	public void changeInforEdit(User u) {
		/**
		* changeInforEdit	根据邮箱找到所有信息，然后修改
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		this.inforEditDaoImpl.changeInformation(u);
	}

	public User getUserByEmail(String email) {
		/**
		* getUserByEmail	得到用户信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		return  this.inforEditDaoImpl.getUserByEmail(email);
	}

}

	