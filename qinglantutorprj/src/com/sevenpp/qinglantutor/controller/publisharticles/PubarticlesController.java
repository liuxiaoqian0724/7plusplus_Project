package com.sevenpp.qinglantutor.controller.publisharticles;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sevenpp.qinglantutor.service.impl.PubarticlesServiceImpl;
import com.sevenpp.qinglantutor.utils.AipNlp.CheckTextAPI;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

@Controller
public class PubarticlesController {
	@Resource
	private PubarticlesServiceImpl pasi;
	
	@RequestMapping(value="/pubarticles",method=RequestMethod.GET)
	public String publisharticles(HttpServletRequest request,HttpServletResponse response,@RequestParam("title") String title,
			@RequestParam("content") String content) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView m=new ModelAndView();
		Cookie[]cookies = request.getCookies();
		String email=CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		CheckTextAPI checkTextAPI=new CheckTextAPI();
		boolean istitleright=true;
		istitleright=checkTextAPI.check(title);
		boolean iscontentright=checkTextAPI.check(content);
		if(istitleright && iscontentright) {
			request.setAttribute("isright", 1);
			pasi.setArticle(title, content, email);
			return "articlestatus";
		}else {
			request.setAttribute("isright", 0);
			return "publisharticles";
		}
	}
}	