package com.sevenpp.qinglantutor.dao;

import java.util.Date;

import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;

/**
*
* 项目名称：qinglantutorprj
* 类名称：TeachPlanDao
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午4:34:32
* 修改人：rain
* 修改时间：2018年12月14日 下午4:34:32
* 修改备注：
* @version
*
*/
public interface TeachPlanDao {
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
	
	/**
	 * 
			* @Title: editTeachPlan 
			* @Description:	我的教案界面编辑键
			* @param @param id
			* @param @param content
			* @param @param time    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午7:56:59 
			* @version V1.0   
	 */
	public void changeTeachPlan(Integer id ,String content, Date time);
	
	/**
	 * 
			* @Title: deleteTeachPlan 
			* @Description: 	删除某个教案
			* @param @param id    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午8:41:42 
			* @version V1.0   
	 */
	public void deleteTeachPlan(Integer id);
	
	/**
	 * 
			* @Title: getTeachRelationByTrid 
			* @Description: 	根据trid找出teachRelation,以便后边的插入更方便
			* @param @param trid
			* @param @return    入参
			* @return TeachRelation    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午8:49:56 
			* @version V1.0   
	 */
	public TeachRelation getTeachRelationByTrid(Integer trid);
	
	/**
	 * 
			* @Title: addTeachPlan 
			* @Description: 	插入某个教案
			* @param @param content
			* @param @param time
			* @param @param teachRelation    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午8:47:34 
			* @version V1.0   
	 */
	public int addTeachPlan(String content, Date time, TeachRelation teachRelation);
	
}

	