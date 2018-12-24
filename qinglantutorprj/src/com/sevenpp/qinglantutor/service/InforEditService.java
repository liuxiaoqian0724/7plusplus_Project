package com.sevenpp.qinglantutor.service;
/**
*
* 项目名称：qinglantutorprj
* 类名称：InforEditService
* 类描述：
* 创建人：rain
* 创建时间：2018年12月18日 下午8:34:24
* 修改人：rain
* 修改时间：2018年12月18日 下午8:34:24
* 修改备注：
* @version
*
*/

import com.sevenpp.qinglantutor.entity.User;

public interface InforEditService {
	
	/**
	 * 
			* @Title: changeInforEdit 
			* @Description: 	根据邮箱找到所有信息，然后修改
			* @param @param email    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月18日 下午8:35:12 
			* @version V1.0   
	 */
	public void changeInforEdit(User u);
	
	/**
	 * 
			* @Title: getUserByEmail 
			* @Description: 	得到用户信息
			* @param @param email
			* @param @return    入参
			* @return User    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月18日 下午8:39:11 
			* @version V1.0   
	 */
	public User getUserByEmail(String email);
}

	