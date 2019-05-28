package com.sevenpp.qinglantutor.controller.tutorlist;

import java.util.ArrayList;
import java.util.List;
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

import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

@Controller
public class TutorAsCandidateController {
	@Resource
	private TutorDetailServiceImpl tutorDatailServiceImpl;
	
	@RequestMapping(value="/findCandiateInfo",method=RequestMethod.GET)
	public void sendMsgToTutor(@RequestParam("arr") String arr,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("textml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String EMAIL = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		Integer inquireId=this.tutorDatailServiceImpl.findUser(EMAIL);
		List<String> digitList = new ArrayList<String>();
		//正则表达式取值
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(arr);
		String result = m.replaceAll("");
		for (int i = 0; i < result.length(); i++) {
		digitList.add(result.substring(i, i+1));	 
		}
		System.out.println(digitList);//候选老师的id集合
		response.setCharacterEncoding("utf-8");
	}
}
