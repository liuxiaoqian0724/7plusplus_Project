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

import org.springframework.stereotype.Component;

import com.sevenpp.qinglantutor.entity.Course;
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
@Component
public interface IndexDao {
	public List<User> queryUser();
	public List queryTeachage();
}