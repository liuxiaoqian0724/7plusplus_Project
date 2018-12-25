/**   
		* @Title: tutordetailService.java 
		* @Package com.sevenpp.qinglantutor.service 
		* @Description:家教详情页面信息服务层
		* @author lxq
		* @date 2018年12月5日 下午3:15:09 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.service;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutordetailService
		* 类描述：家教详情页服务层
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午3:15:09
		* 修改人：rain
		* 修改时间：2018年12月5日 下午3:15:09
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: tutordetailService 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月5日 下午3:15:09 
		* @version V1.0 
		*/
		public interface TutorDetailService {
			
			public User getTutorDetail(Integer id);

}

	