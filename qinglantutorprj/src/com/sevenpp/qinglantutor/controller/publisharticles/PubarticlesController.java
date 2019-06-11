package com.sevenpp.qinglantutor.controller.publisharticles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	@RequestMapping(value="/pubarticles")
	public String publisharticles(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ModelAndView m=new ModelAndView();
		Cookie[]cookies = request.getCookies();
		String email=CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String content=request.getParameter("content");
		String content1=content;
		String title=request.getParameter("title");
		
		//过滤html标签
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(content); 
        content=m_script.replaceAll(""); //过滤  
        
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(content); 
        content=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(content); 
        content=m_html.replaceAll(""); //过滤html标签 

		CheckTextAPI checkTextAPI=new CheckTextAPI();
		boolean istitleright=true;
		istitleright=checkTextAPI.check(title);
		boolean iscontentright=checkTextAPI.check(content);
		if(istitleright && iscontentright) {
			request.setAttribute("isright", 1);
			pasi.setArticle(title, content1, email);
			return "articlestatus";
		}else {
			request.setAttribute("isright", 0);
			return "publisharticles";
		}
	}
}	