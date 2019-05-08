/**   
		* @Title: tutordetailService.java 
		* @Package com.sevenpp.qinglantutor.service 
		* @Description:家教详情页面信息服务层
		* @author lxq
		* @date 2018年12月5日 下午3:15:09 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.service;

import java.util.List;

import com.sevenpp.qinglantutor.entity.ReviewInf;
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
			/**
			 * 
					* @Title: getTutorDetail 
					* @Description: 获取家教基本信息 
					* @param @param id 用户id
					* @param @return    入参
					* @return User    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月18日 下午3:06:55 
					* @version V1.0   
			 */
			public User getTutorDetail(Integer id);
			
			/**
			 * 
					* @Title: getTutorReview 
					* @Description: 获取家教评论总条数
					* @param @param id 用户id
					* @param @return    入参
					* @return Integer    返回类型
					* @author lxq 
					* @throws
					* @date 2018年12月18日 下午3:52:18 
					* @version V1.0   
			 */
			public Integer getTutorReviewCount(Integer id);
			
			/**
			 * 
					* @Title: getTutorReivew 
					* @Description: 获取家教所教过的学生的评论
					* @param @param id 用户id
					* @param @return    入参
					* @return ClassRelation    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月18日 下午3:09:04 
					* @version V1.0   
			 */
			public List<ReviewInf> getTutorReivew(Integer id);

			/**
			 * 
					* @Title: sendMsgToTutor 
					* @Description: 系统向家教发送家长的咨询信息
					* @param @param id 老师iD
					* @param @return    
					* @return boolean    是否发送成功
					* @author lxq
					* @throws
					* @date 2018年12月24日 下午7:30:21 
					* @version V1.0   
			 */
			public void sendMsgToTutor(Integer id,Integer inquireId,String grade);
			
			/**
			 * 
					* @Title: findUser 
					* @Description: 根据email查找用户
					* @param @param email
					* @param @return    入参
					* @return User    返回类型
					* @author lxq 
					* @throws
					* @date 2018年12月26日 下午2:41:33 
					* @version V1.0   
			 */
			public Integer findUser(String email);
}

	