package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import com.sevenpp.qinglantutor.service.impl.WorkCompleteServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkCompleteController {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	@Resource WorkCompleteServiceImpl workCompleteServiceImpl;
	
//	作业完成页面作业查询
	@RequestMapping("/WorkComplete")
	public String WorkComplete(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
//		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		//String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String id=request.getParameter("hid");
		int hid=Integer.parseInt(id);
		List<HomeWork> list=homeworkSelectServiceImpl.HomeworkShow();
		List<HomeWork> list1=new ArrayList();
		List<String> list2=new ArrayList();
		for (HomeWork h : list) {
			if(hid==h.getHid()){
				list1.add(h);
			}
		}
		List list3=new ArrayList();
		for (HomeWork h : list) {
			if(h.getHid()==hid) {
				String sstatus=h.getSstatus();
				list2.add(sstatus);
				request.setAttribute("sstatus",list2);
				if(h.getTstatus().startsWith("已评价")) {
					list3.add(h.getTstatus());
				}
			}
		}
		request.setAttribute("ts",list3);
		request.setAttribute("hid", hid);
		request.setAttribute("homework", list1);
		return "work-complete";
	}
	
	
//	更改作业数据库
	@RequestMapping("/Update")
	public String WorkUpdate(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
//		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		//String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String id=request.getParameter("hid");
		
		int hid=Integer.parseInt(id);
	
		String question=request.getParameter("question");		
		String scontent=request.getParameter("content");
		workCompleteServiceImpl.HomeworkInsert(scontent, hid,question);
		return "index";
	}
	
	
}
