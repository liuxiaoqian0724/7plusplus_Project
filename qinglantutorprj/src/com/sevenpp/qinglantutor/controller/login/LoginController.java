package com.sevenpp.qinglantutor.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sevenpp.qinglantutor.service.impl.LoginServiceImpl;

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
* @version 创建时间：2018年12月5日 上午9:03:57
* 类说明
*/

@Controller
/**
 * 
	spring 默认为singleton模式即单例模式，设置成这个可以避免线程安全问题
 */
@Scope("prototype")
/**
 * @CrossOrigin 跨域请求开启
 */
@RequestMapping("/user")
@CrossOrigin
@SessionAttributes("errorMsg")
@ResponseBody
public class LoginController {
	@Resource
	private LoginServiceImpl loginServiceImpl;
	private PrintWriter writer;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void login(@RequestBody Map<String,String>map,HttpServletResponse response,HttpServletRequest request) {
		/**
		 * 设置跨域请求
		 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (loginServiceImpl.isPassword(map.get("email"),map.get("password"))) {
			String JSESSIONID = request.getRequestedSessionId();
			Cookie jessionid = new Cookie("JESSIONID",JSESSIONID);
			Cookie EMAIL = new Cookie("EMAIL",map.get("email"));
			Cookie USERNAME = new Cookie("USERNAME",loginServiceImpl.getUserName(map.get("email")));
			Cookie ROLE = new Cookie("ROLE",loginServiceImpl.getRole(map.get("email")));
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
				writer.close();
			}
		}else {
			try {
				writer = response.getWriter();
				writer.write("error");
				writer.flush();
				writer.close();
			} catch (IOException e) {
				writer.close();
			}
		}
	}
}
