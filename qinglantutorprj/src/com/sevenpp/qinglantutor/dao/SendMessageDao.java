package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.MyJob;

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
* @version 创建时间：2018年12月11日 下午5:31:23
* 类说明: 发布家教信息接口类
*/
public interface SendMessageDao {
	/**
	 * 
			* @Title: sendMessage 
			* @Description: TODO(这里用一句话描述这个方法的作用) 
			* @param @return  Map(String,String)
			* @return Boolean    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月11日 下午5:33:02 
			* @version V1.0   
	 */
	Boolean sendMessage(MyJob myJob);
	int findId(String email);
}
