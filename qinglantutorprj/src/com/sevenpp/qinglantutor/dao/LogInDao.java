package com.sevenpp.qinglantutor.dao;

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
* @version 创建时间：2018年12月5日 上午10:29:00
* 类说明
 * @return 
*/
public interface LogInDao {
	/**
	 * 
			* @Title: existEmail 
			* @Description: 验证邮箱是否存在
			* @param @param email
			* @param @return    入参
			* @return Boolean    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月5日 上午10:54:15 
			* @version V1.0   
	 */
	Boolean existEmail(String email) ;
	/**
	 * 
			* @Title: isPassWord 
			* @Description:存在的话进行密码比对
			* @param @param email
			* @param @return    入参
			* @return Boolean    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月5日 上午10:54:42 
			* @version V1.0   
	 */
	Boolean isPassWord(String Pwd,String password);
	/**
	 * 
			* @Title: getPublicKey 
			* @Description: 得到publicKey
			* @param @param email
			* @param @return    入参
			* @return String    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月6日 上午10:25:40 
			* @version V1.0   
	 */
	String getUserPwd(String email);
	String getRole(String email);
	String getUserName(String email);
}
