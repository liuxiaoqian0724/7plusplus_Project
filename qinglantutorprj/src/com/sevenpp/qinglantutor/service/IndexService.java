/**   
		* @Title: IndexService.java 
		* @Package com.sevenpp.qinglantutor.service 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 下午8:23:27 
		* @version V1.0   
		*/

		package com.sevenpp.qinglantutor.service;

import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.util.PageBean;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexService
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 下午8:23:27
		* 修改人：rain
		* 修改时间：2018年12月7日 下午8:23:27
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexService 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月7日 下午8:23:27 
		* @version V1.0 
		*/
public interface IndexService {
	public PageBean<User> findAllUserWithPage(int pageNum, int pageSize);
}

	