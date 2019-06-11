package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.StudentDetailServiceImpl;
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
public class StudentController {
	@Resource StudentDetailServiceImpl studentdetailserviceimpl;


	@RequestMapping("/ArticleShow")
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
		
		Map<String,Object> em=this.studentdetailserviceimpl.getPersonalDetail(email);
		request.setAttribute("map", em);
		User user=studentdetailserviceimpl.getUserByEmail(email);
		String role=user.getRole();
		List<Article> list=this.studentdetailserviceimpl.AtricleShow();
		List<ArticleReview> list2=this.studentdetailserviceimpl.AtricleReview();
		List<Article> list3=new ArrayList();
		
		if(role.startsWith("家长")) {
			List<User> timg=new ArrayList();
			List<Article> show=new ArrayList();
			List<ArticleReview> list4=new ArrayList();
			List<ArticleReview> list5=new ArrayList();
			List<User> usr=new ArrayList();
			usr.add(user);
			for(Article a : list) {
				if(a.getUser().getId() ==user.getId()) {
					show.add(a);
					timg.add(a.getUser());
				}
				
			}
			for(ArticleReview ar:list2) {
				if(ar.getUser().getId()==user.getId())
					list4.add(ar);
			}
			
//			得到总页数
			int i=0;
			
			for (Article a : show) {
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
			
			if(show==null) {}else {
				
				if(num==totalpagenum) {
					for(int j=0;j<i-(num-1)*3;j++) {
						list3.add(show.get((num-1)*3+j));
					}
				}else {
					for(int j=(num-1)*3;j<(num-1)*3+3;j++) {
						list3.add(show.get(j));
					}
				}
			}
			if(list4==null) {}else {
				if(num==totalpagenum) {
					for(int j=0;j<i-(num-1)*3;j++) {
						list5.add(list4.get((num-1)*3+j));
					}
				}else {
					for(int j=(num-1)*3;j<(num-1)*3+3;j++) {
						list5.add(list4.get(j));
					}
				}
			}
			
			
			request.setAttribute("page", page);
			request.setAttribute("pagenum", totalpagenum);
			request.setAttribute("article", list3);
			request.setAttribute("answer", list5);
			request.setAttribute("usr", usr);	
		}else {return"detail";}
		
		return "detail";
	}
	
}

	