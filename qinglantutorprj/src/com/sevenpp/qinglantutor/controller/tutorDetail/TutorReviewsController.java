package com.sevenpp.qinglantutor.controller.tutorDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.sevenpp.qinglantutor.entity.ReviewInf;
import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;
import com.sevenpp.qinglantutor.utils.AipNlp.InitAipNlp;
import com.sevenpp.qinglantutor.utils.AipNlp.ReviewTrend;

@Controller
public class TutorReviewsController {
	@Resource
	private TutorDetailServiceImpl tutorDetailServiceImpl;
	
	@RequestMapping(name="/divideReviews",method=RequestMethod.POST)
	public void divideReviesByBD(HttpServletRequest request,HttpServletResponse response
			,@RequestBody Map<String, Integer> tidMap) {
		List<ReviewInf> reviewList=tutorDetailServiceImpl.getTutorReivew(tidMap.get("tid"));
		ReviewTrend.getReviewTrend(InitAipNlp.getAipNlp(), reviewList);
	                        
		String str = JSON.toJSONString("klsdfj");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
