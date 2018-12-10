/**   
		* @Title: IndexDao.java 
		* @Package com.sevenpp.qinglantutor.dao 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 下午7:27:33 
		* @version V1.0   
		*/
	
package com.sevenpp.qinglantutor.dao;

import java.util.List;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexDao
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 下午7:27:33
		* 修改人：rain
		* 修改时间：2018年12月7日 下午7:27:33
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexDao 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月7日 下午7:27:33 
		* @version V1.0 
		*/
	
public interface IndexDao {
	public List<User> findAll(int startIndex, int pageSize);
	public List<User> queryAll();
}

	