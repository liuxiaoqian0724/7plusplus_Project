package com.sevenpp.qinglantutor.controller.regist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.service.impl.RegistServiceImpl;

/**
*code is far away from bug with the animal protecting
*  ┏┓　　　┏┓
*┏┛┻━━━┛┻┓
*┃　　　　　　　┃ 　
*┃　　　━　　　┃
*┃　┳┛　┗┳　┃
*┃　　　　　　　┃
*┃　　　┻　　　┃
*┃　　　　　　　┃
*┗━┓　　　┏━┛
*　　┃　　　┃神兽保佑
*　　┃　　　┃代码无BUG！
*　　┃　　　┗━━━┓
*　　┃　　　　　　　┣┓
*　　┃　　　　　　　┏┛
*　　┗┓┓┏━┳┓┏┛
*　　　┃┫┫　┃┫┫
*　　　┗┻┛　┗┻┛ 
*　　　
* @author 作者 :Mr.Ren
* @version 创建时间：2018年12月9日 下午12:58:37
* 类说明
*/
@Controller
@Scope("prototype")
@RequestMapping("/user")
@ResponseBody
public class RegistController {
	@Resource
	private RegistServiceImpl RegistServiceImpl;
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public void regist(@RequestBody Map<String, String>map,HttpServletResponse response,HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer;
		if (RegistServiceImpl.regist(map)) {
			String JSESSIONID = request.getRequestedSessionId();
			Cookie jessionid = new Cookie("JESSIONID",JSESSIONID);
			Cookie EMAIL = new Cookie("EMAIL",map.get("email"));
			Cookie USERNAME = new Cookie("USERNAME",map.get("username"));
			Cookie ROLE = new Cookie("ROLE",map.get("role"));
			jessionid.setPath(request.getContextPath()+"/");
			EMAIL.setPath(request.getContextPath()+"/");
			USERNAME.setPath(request.getContextPath()+"/");
			ROLE.setPath(request.getContextPath()+"/");
			jessionid.setMaxAge(24*60*60);
			EMAIL.setMaxAge(24*60*60);
			USERNAME.setMaxAge(24*60*60);
			ROLE.setMaxAge(24*60*60);
			response.addCookie(jessionid);
			response.addCookie(EMAIL);
			response.addCookie(USERNAME);
			response.addCookie(ROLE);
			try {
				writer = response.getWriter();
				writer.write("ok");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				
			}
			
		}else {
			try {
				writer = response.getWriter();
				writer.write("error");
				writer.flush();
				writer.close();
			} catch (IOException e) {
					
			}
		}
	}
	
}
