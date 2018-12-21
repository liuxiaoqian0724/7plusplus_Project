package com.sevenpp.qinglantutor.dao;

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
* @version 创建时间：2018年12月9日 下午1:23:51
* 类说明 注册接口
*/
/**
 * 

		* @ClassName: RegistDao 
		* @Description: 保存用户的注册信息
		* @author (作者)  
		* @date 2018年12月9日 下午1:30:24 
		* @version V1.0 
 */
public interface RegistDao {
	/**
	 * 
			* @Title: regist 
			* @Description: 保存用户的注册信息
			* @param @param map
			* @param @return    map
			* @return Boolean    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月9日 下午1:30:50 
			* @version V1.0   
	 */
	public Boolean regist(User user);
	/**
	 * 
			* @Title: existEmail 
			* @Description: TODO(这里用一句话描述这个方法的作用) 
			* @param @param email
			* @param @return    入参
			* @return Boolean    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月10日 上午9:02:44 
			* @version V1.0   
	 */
	Boolean existEmail(String email) ;
}
