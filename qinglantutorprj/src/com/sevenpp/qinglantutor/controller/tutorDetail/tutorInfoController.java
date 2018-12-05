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
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutorInfoController
		* 类描述：
		* 创建人：rain
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
		* @author (作者)  
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
					* @Description: TODO(这里用一句话描述这个方法的作用) 
					* @param @return    入参
					* @return String    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月5日 下午5:29:09 
					* @version V1.0   
			 */
			@RequestMapping(value="/showtutorDetail")
			public String showTutorDetail(HttpServletRequest request) {
				/**
				 * 获取request中id信息
				 */
				String id=request.getParameter("id");
				if(id!=null) {
					
				}
				
				
				return "tutordetailed";
			}
}

	