package com.sevenpp.qinglantutor.controller;
import com.sevenpp.qinglantutor.service.reviewServiceImpl;
import com.sevenpp.qinglantutor.entity.Review;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：reviewController
		* 类描述：评价组件的controller层
		* 创建人：刘杼滨
		* 创建时间：2018年12月5日 下午2:52:12
		* 修改人：rain
		* 修改时间：2018年12月5日 下午2:52:12
		* 修改备注：
		* @version
		*
		*/
@Controller
public class reviewController {
	@Resource
	private reviewServiceImpl reviewServiceImpl;
	
	@RequestMapping("/jumptoReview")
	public String review(String userid,HttpServletRequest request) {
		List<Review> list=this.reviewServiceImpl.list();
		request.getServletContext().setAttribute("review", list);
		return "student-personal-center-evaluation";
		
	}
	

}

	