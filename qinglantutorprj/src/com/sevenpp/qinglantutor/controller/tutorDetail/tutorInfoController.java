/**   
		* @Title: tutorInfoController.java 
		* @Package com.sevenpp.qinglantutor.controller.tutorDetail 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月5日 下午5:02:37 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.controller.tutorDetail;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutorInfoController
		* 类描述：家教详情页基本信息展示
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午5:02:37
		* 修改人：rain
		* 修改时间：2018年12月5日 下午5:02:37
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: tutorInfoController 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author lxq
		* @date 2018年12月5日 下午5:02:37 
		* @version V1.0 
		*/
		@Controller
		@RequestMapping(value="/tutorDetail")
		public class tutorInfoController {
			@Resource
			private TutorDetailServiceImpl tutorDetailServiceImpl;
			
			/**
			 * 
					* @Title: showTutorDetail 
					* @Description: 根据请求显示相应家教的基本信息
					* @param @return    入参
					* @return String    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月5日 下午5:29:09 
					* @version V1.0   
			 */
			@RequestMapping(value="/showtutorDetail/{id}")
			public String showTutorDetail(HttpServletRequest request,@PathVariable Integer id) {
				User user=tutorDetailServiceImpl.getTutorDetail(id);
				request.setAttribute("user",user);
				return "tutordetailed";
			}
			
			/**
			 * 
					* @Title: sendMsgToTutor 
					* @Description: 家长点击按钮后系统给家教发送提醒信息
					* @param @return    入参
					* @return boolean    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月12日 上午9:58:57 
					* @version V1.0   
			 */
//			@RequestMapping(value="/showtutorDetail/inquire",method=RequestMethod.POST)
//			public @ResponseBody String sendMsgToTutor(@RequestBody String userId,@RequestBody String gradeChosen) {
//				
//				
//				
//				
//			}
}

	