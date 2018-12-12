package com.sevenpp.qinglantutor.dao;

import java.util.List;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.User;

/**
*
* 项目名称：qinglantutorprj
* 类名称：TeaCourseDao
* 类描述：
* 创建人：rain
* 创建时间：2018年12月12日 上午10:58:41
* 修改人：rain
* 修改时间：2018年12月12日 上午10:58:41
* 修改备注：
* @version
*
*/
public interface TeaCourseDao {
	/**
	 * 
	* @Title: getUserByEmail 
	* @Description: 根据邮箱查用户
	* @param @param email
	* @param @return    入参
	* @return User    返回类型
	* @author （作者） 
	* @throws
	* @date 2018年12月10日 上午10:41:02 
	* @version V1.0   
	 */
	public User getUserByEmail(String email);
	
	
}

	