package com.sevenpp.qinglantutor.controller.homework;


import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeworkShowController {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	
	
//	作业和老师展示
	@RequestMapping("/HomeWorkShow")
	public String show(HttpServletRequest request,HttpServletResponse response) {
		
	
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
//		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String page1=request.getParameter("page");
		
		Map<String,Object> em=this.homeworkSelectServiceImpl.getPersonalDetail(email);
		request.setAttribute("map", em);
		User user=homeworkSelectServiceImpl.getUserByEmail(email);
		List<HomeWork> list=this.homeworkSelectServiceImpl.HomeworkShow();
		String role=user.getRole();
		List<HomeWork> list3= new ArrayList();
		if(role.startsWith("家长")) {
			
			List<User> timg=new ArrayList();
			List<HomeWork> show=new ArrayList();
			for (HomeWork h : list) {
				if(h.getClassRelation().getUser().getId()==user.getId()) {
					show.add(h);
					timg.add(h.getTeachRelation().getUser());
				}
			}
			
			
			
//			得到总页数
			int i=0;
			
			for (HomeWork h : show) {
				i++;
			}
			int totalpagenum=0;
			if(i%3==0) {
				totalpagenum=i/3;
			}
			else {
				totalpagenum=(i/3)+1;
			}
			String page;
			if(page1==null) {
				page="1";
			
			}else {page=page1;}
//			根据页数分页查数据
			int num=Integer.parseInt(page);
			if(num==totalpagenum) {
				for(int j=0;j<i-(num-1)*3;j++) {
					list3.add(show.get((num-1)*3+j));
				}
			}else {
				for(int j=(num-1)*3;j<(num-1)*3+3;j++) {
					list3.add(show.get(j));
				}
			}
			
			
			request.setAttribute("page", page);
			request.setAttribute("pagenum", totalpagenum);
			request.setAttribute("homework", list3);
			request.setAttribute("teachers", timg);	
			return "student-personal-center-homework";
			}
		else  {
			List<HomeWork> list1=new ArrayList();
			List<User> list2= new ArrayList();
			
			for (HomeWork h : list) {
				if(h.getTeachRelation().getUser().getId()==user.getId()) {
					list1.add(h);
					list2.add(h.getClassRelation().getUser());
				}
			}
			
//			分页
			String page;
			if(page1==null) {
				page="1";
				
			}else {
				page=page1;
			}
			
			int i=0;
			for (HomeWork h : list1) {
				i++;
			}
			int totalpagenum=0;
			if(i==0) {totalpagenum=1;}
			else if(i%3==0&&i!=0) {
				totalpagenum=i/3;
			}
			else {
				totalpagenum=(i/3)+1;
			}
			int num=Integer.parseInt(page);
			
			if(num==totalpagenum) {
				for(int j=0;j<i-(num-1)*3;j++) {
					list3.add(list1.get((num-1)*3+j));
				}
				
			}else {
				for(int j=(num-1)*3;j<(num-1)*3+3;j++) {
					list3.add(list1.get(j));
				}
			}
			
			request.setAttribute("page", page);
			request.setAttribute("pagenum", totalpagenum);
			request.setAttribute("homework",  list3);
			request.setAttribute("students", list2);
			
			return "teacher-personal-center-homework";
		}		
	};
}
