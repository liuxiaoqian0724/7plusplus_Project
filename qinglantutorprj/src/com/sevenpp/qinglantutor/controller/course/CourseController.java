package com.sevenpp.qinglantutor.controller.course;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.service.impl.CourseServiceImpl;

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
public class CourseController {
	
	@Resource
	private CourseServiceImpl courseServiceImpl;
	
	
	@RequestMapping("/courseInformation")
	public String stuCourse(HttpServletRequest request) {
		String email = new String("wangwu@qq.com");
		List<CourseInformation> list = this.courseServiceImpl.getCourseInfor(email);		
		request.setAttribute("courseDetailList", list);
		
		if(this.courseServiceImpl.getRoleByEmail(email).startsWith("老师")) {
			return "teacher-personal-center-mycourse";
		}else {
			return "student-personal-center-mycourse";
		}
	}
	
	@RequestMapping("/courseReview")
	@ResponseBody
	public String stuCourseReview(@RequestParam(value="classRelationId")Integer classRelationId
			,@RequestParam(value="reviewContent")String reviewContent,@RequestParam(value="reviewStar")Integer reviewStar){
		Date reviewTime = new Date();
		this.courseServiceImpl.insertReview(reviewTime, reviewContent, reviewStar, classRelationId);
		return "反馈成功";
	}
	
	@RequestMapping("/courseTime")
	@ResponseBody
	public String courseTime(@RequestBody CourseInformation courseInformation) {
		this.courseServiceImpl.changeCourseTime(courseInformation.getStartTime(), courseInformation.getEndTime()
				, courseInformation.getCrid());
		return "添加成功";
	}
	
	@RequestMapping("/courseHomework")
	@ResponseBody
	public String courseHomeWork(@RequestParam(value="crid")Integer crid,@RequestParam(value="content")String content
			,@RequestParam(value="deadlinetime")String deadlinetime) {
		System.out.println("~~~~"+crid);
		System.out.println(content);
		//this.courseServiceImpl.insertHomework(crid, content, deadlinetime);
		return "{\"data\":\"添加成功\"}";
	}
}

	