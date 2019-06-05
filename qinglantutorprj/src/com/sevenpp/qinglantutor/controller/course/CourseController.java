package com.sevenpp.qinglantutor.controller.course;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.log.LogServerImpl;
import com.sevenpp.qinglantutor.service.impl.CourseServiceImpl;
import com.sevenpp.qinglantutor.service.impl.RegistServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

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
	private List<CourseInformation> list;
	
	@Resource
	private LogServerImpl logServerImpl;
	@Resource
	private RegistServiceImpl registServiceImpl;
	
	@RequestMapping("courseInformation")
	public String stuCourse(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		
		
//		logServerImpl.logsth(1, 1,"tutor");
		
//		创造用户假数据		
//		Map<String, String> map1 = new HashMap<>();
//		int m=0;
//		for(;m<500;m++) {
//			map1.put("email", m+"@qq.com");
//			map1.put("username", m+"@qq.com");
//			map1.put("password", "123456");
//			if(m%2==0) {				
//				map1.put("sex", "男");
//				map1.put("roles", "老师");
//			}else {
//				map1.put("sex", "女");
//				map1.put("roles", "老师");
//			}
//			this.registServiceImpl.regist(map1);
//		}
//		for(;m<1000;m++) {
//			map1.put("email", m+"@qq.com");
//			map1.put("username", m+"@qq.com");
//			map1.put("password", "123456");
//			if(m%2==0) {				
//				map1.put("sex", "男");
//				map1.put("roles", "家长");
//			}else {
//				map1.put("sex", "女");
//				map1.put("roles", "家长");
//			}
//			this.registServiceImpl.regist(map1);
//		}
		
		
		list = this.courseServiceImpl.getCourseInfor(email);
		List<CourseInformation> list1 = new ArrayList<>();
		int page = 1;
		int pageTotal = 1;
		if(list.size()!=0) {
			pageTotal = list.size()%3 == 0 ? list.size()/3 : list.size()/3+1;
		}
		if(list.size()>=3) {
			list1.add(list.get(0));
			list1.add(list.get(1));
			list1.add(list.get(2));
		}else {
			for(int i=0;i<list.size();i++) {
				list1.add(list.get(i));
			}
		}
		Map<String, Object> map = this.courseServiceImpl.getPersonalDetail(email);
		
		request.setAttribute("map", map);
		request.setAttribute("courseDetailList", list1);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		
		if(this.courseServiceImpl.getRoleByEmail(email).startsWith("老师")) {
			return "teacher-personal-center-mycourse";
		}else {
			return "student-personal-center-mycourse";
		}
	}
	
	@RequestMapping("/courseJump")
	public String jump(@RequestParam(value="page")int page,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		//String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		
		int pageTotal = 1;
		if(list.size()!=0) {
			pageTotal = list.size()%3 == 0 ? list.size()/3 : list.size()/3+1;
		}
		List<CourseInformation> list1 = new ArrayList<>();
		if(page == pageTotal ) {
			for(int i = (page-1)*3 ;i<list.size();i++) {
				list1.add(list.get(i));
			}
		}else {
			for(int i = (page-1)*3;i<(page-1)*3+3;i++) {
				list1.add(list.get(i));
			}
		}
		
		request.setAttribute("courseDetailList", list1);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		
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
		Timestamp time = new Timestamp(reviewTime.getTime());
		this.courseServiceImpl.insertReview(time, reviewContent, reviewStar, classRelationId);
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
	public String courseHomework(@RequestParam(value="cridHomework")Integer cridHomework,@RequestParam(value="content")String content
			,@RequestParam(value="deadlinetime")String deadlinetime) {
		this.courseServiceImpl.insertHomework(cridHomework, content, deadlinetime);
		return "{\"data\":\"添加成功\"}";
	}
}

	