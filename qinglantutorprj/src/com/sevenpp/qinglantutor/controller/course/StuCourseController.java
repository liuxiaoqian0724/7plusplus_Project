package com.sevenpp.qinglantutor.controller.course;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.StuCourseServiceImpl;

/**
*
* 项目名称：qinglantutorprj
* 类名称：StuCourseController
* 类描述：
* 创建人：rain
* 创建时间：2018年12月10日 下午3:28:57
* 修改人：rain
* 修改时间：2018年12月10日 下午3:28:57
* 修改备注：
* @version
*
*/
@Controller
public class StuCourseController {
	
	@Resource
	private StuCourseServiceImpl stuCourseServiceImpl;
	
	@RequestMapping("/courseInformation")
	public String stuCourse(HttpServletRequest request) {
		String email = new String("wangwu@qq.com");
		List<CourseInformation> list = this.stuCourseServiceImpl.getCourseInfor(email);
		request.setAttribute("courseDetailList", list);
		return "student-personal-center-mycourse";
	}
	
	@RequestMapping("courseReview")
	@ResponseBody
	public String stuCourseReview(@RequestParam(value="classRelationId")Integer classRelationId
			,@RequestParam(value="reviewContent")String reviewContent,@RequestParam(value="reviewStar")Integer reviewStar) {
		Date reviewTime = new Date();
		this.stuCourseServiceImpl.insertReview(reviewTime, reviewContent, reviewStar, classRelationId);
		return "反馈成功";
	}
}

	