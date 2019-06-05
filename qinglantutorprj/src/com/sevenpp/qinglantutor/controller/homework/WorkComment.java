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
/**
*
* 项目名称：qinglantutorprj
* 类名称：WorkComment
* 类描述：作业评价页面控制器
* 创建人：董世轩
* 创建时间：2018年12月19日 上午9:35:07
* 修改人：rain
* 修改时间：2018年12月19日 上午9:35:07
* 修改备注：
* @version
*
*/
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class WorkComment {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	@Resource WorkCompleteServiceImpl workCompleteServiceImpl;
	
	
	@RequestMapping("/WorkComment")
	public String Comment(HttpServletRequest request,HttpServletResponse response) {
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
		List list3=new ArrayList();
		for (HomeWork h : list) {
			if(h.getHid()==hid) {
				list1.add(h);
				if(h.getTstatus().startsWith("已评价")) {
					list3.add(h.getTstatus());
				}
			}
		}
		request.setAttribute("hid", hid);
		request.setAttribute("ts", list3);
		request.setAttribute("homework", list1);
		return "work-comment";
	}
	@RequestMapping("/Upload")
	public String CommentInsert(HttpServletRequest request,HttpServletResponse response) {
//		String id=request.getParameter("hid");
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
		String score1=request.getParameter("score");		
		String workreview=request.getParameter("comment");
		Integer score=Integer.parseInt(score1);
		workCompleteServiceImpl.CommentInsert(hid, score, workreview);
		return "index";
	}
	
	
}

	