package com.sevenpp.qinglantutor.controller.teachplan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.service.impl.TeachPlanServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

/**
*
* 项目名称：qinglantutorprj
* 类名称：TeachPlanController
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午7:22:29
* 修改人：rain
* 修改时间：2018年12月14日 下午7:22:29
* 修改备注：
* @version
*
*/
@Controller
public class TeachPlanController {
	
	@Resource
	private TeachPlanServiceImpl  teachPlanServiceImpl;
	private List<Object> list;
	
	@RequestMapping("teachPlanInformation")
	public String getTeachPlanInformation(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		
		list = this.teachPlanServiceImpl.getTeachPlanInfor(email);
		List<Object> list1 = new ArrayList<>();
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
		
		Map<String, Object> map = this.teachPlanServiceImpl.getPersonalDetail(email);
		
		request.setAttribute("map", map);
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("page", page);
		request.setAttribute("teachPlanInformationList", list1);		
		
		if(this.teachPlanServiceImpl.getRoleByEmail(email).getRole().startsWith("老师")) {
			System.out.println("老师");
			return "teacher-personal-center-plan";
		}else {
			System.out.println("学生");
			return "student-personal-center-plan";
		}
		
	}
	
	@RequestMapping("/teachPlanJump")
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
		List<Object> list1 = new ArrayList<>();
		if(page == pageTotal ) {
			for(int i = (page-1)*3 ;i<list.size();i++) {
				list1.add(list.get(i));
			}
		}else {
			for(int i = (page-1)*3;i<(page-1)*3+3;i++) {
				list1.add(list.get(i));
			}
		}
		

		request.setAttribute("teachPlanInformationList", list1);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		
		if(this.teachPlanServiceImpl.getRoleByEmail(email).getRole().startsWith("老师")) {
			return "teacher-personal-center-plan";
		}else {
			return "student-personal-center-plan";
		}
	}
	
	@RequestMapping("teachPlanEdit")
	@ResponseBody
	public String teachPlanEdit(@RequestParam(value="id")Integer id ,@RequestParam(value="content")String content
			,@RequestParam(value="time")String time) {
		this.teachPlanServiceImpl.editTeachPlan(content, time, id);
		return "反馈成功";
	}
	
	@RequestMapping("teachPlanDelete")
	@ResponseBody
	public String teachPlanDelete(@RequestParam(value="id")Integer id) {
		this.teachPlanServiceImpl.deleteTeachPlan(id);
		return "反馈成功";
	}
	
	@RequestMapping("teachPlanAdd")
	@ResponseBody
	public int teachPlanAdd(@RequestParam(value="trid")Integer trid ,@RequestParam(value="content")String content
			,@RequestParam(value="time")String time) {
		int i = this.teachPlanServiceImpl.addTeachPlan(trid, content, time);
		return i;
	}
}

	