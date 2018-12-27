package com.sevenpp.qinglantutor.service;
/**
*
* 项目名称：qinglantutorprj
* 类名称：TeachPlanService
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午4:40:26
* 修改人：rain
* 修改时间：2018年12月14日 下午4:40:26
* 修改备注：
* @version
*
*/

import java.util.List;
import java.util.Map;

import com.sevenpp.qinglantutor.entity.User;

public interface TeachPlanService {
	
	/**
	 * 
			* @Title: getTeachPlanInfor 
			* @Description:		根据cookie邮箱得到我的教案页面的详细信息
			* @param @param email
			* @param @return    入参
			* @return List<String>    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月14日 下午4:41:52 
			* @version V1.0   
	 */
	public List<Object> getTeachPlanInfor(String email);
	
	 /**
	  * 
	 		* @Title: getPersonalDetail 
	 		* @Description:		得到个人中心个人信息学院评分那部分资料
	 		* @param @return    入参
	 		* @return Map<String,Object>    返回类型
	 		* @author （作者） 
	 		* @throws
	 		* @date 2018年12月24日 上午10:02:44 
	 		* @version V1.0   
	  */
	 public Map<String, Object> getPersonalDetail(String email);
	
	/**
	 * 
			* @Title: getRoleByEmail 
			* @Description: 	根据email得到身份
			* @param @param email
			* @param @return    入参
			* @return User    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月16日 下午3:01:12 
			* @version V1.0   
	 */
	public User getRoleByEmail(String email);
	
	/**
	 * 
			* @Title: editTeachPlan 
			* @Description: 	我的教案编辑
			* @param @param content
			* @param @param time
			* @param @param id    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午8:04:42 
			* @version V1.0   
	 */
	public void editTeachPlan(String content,String time,Integer id);
	
	/**
	 * 
			* @Title: deleteTeachPlan 
			* @Description:   删除某个教案
			* @param @param id    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午8:58:19 
			* @version V1.0   
	 */
	public void deleteTeachPlan(Integer id);
	
	/**
	 * 
			* @Title: addTeachPlan 
			* @Description:	插入某个教案
			* @param @param trid
			* @param @param content
			* @param @param time    入参
			* @return void    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月15日 下午9:00:03 
			* @version V1.0   
	 */
	public int addTeachPlan(Integer trid,String content, String time);
}

	