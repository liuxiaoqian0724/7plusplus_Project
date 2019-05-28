package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.User;


/**
*
* 项目名称：qinglantutorprj
* 类名称：InfoEditDao
* 类描述：
* 创建人：rain
* 创建时间：2018年12月18日 下午7:40:00
* 修改人：rain
* 修改时间：2018年12月18日 下午7:40:00
* 修改备注：
* @version
*
*/
public interface InforEditDao {
	
	/**
	 * 
			* @Title: changeInformation 
			* @Description: 	改变个人中心的详细信息
			* @param @param user    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月18日 下午7:41:43 
			* @version V1.0   
	 */
	public void changeInformation(User u);
	
	/**
	 * 
			* @Title: getUserByEmail 
			* @Description: 	根据邮箱得到用户信息
			* @param @param email
			* @param @return    入参
			* @return User    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月18日 下午7:45:52 
			* @version V1.0   
	 */
	public User getUserByEmail(String email);
}

	