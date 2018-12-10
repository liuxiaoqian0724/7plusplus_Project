package com.sevenpp.qinglantutor.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@CrossOrigin
@RequestMapping("/user")
@SessionAttributes("errorMsg")
public class LoginController {
	@Resource
	private LoginServiceImpl loginServiceImpl;
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,HttpServletResponse response,HttpServletRequest request) {
		/**
		 * 设置跨域请求
		 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		if (loginServiceImpl.isPassword(email, password)) {
			String JSESSIONID = request.getRequestedSessionId();
			Cookie jessionid = new Cookie("JESSIONID",JSESSIONID);
			Cookie EMAIL = new Cookie("EMAIL",email);
			jessionid.setMaxAge(3600);
			response.addCookie(jessionid);
			response.addCookie(EMAIL);
			request.setAttribute("errorMsg","");
			return "student-personal-center-evaluation";
		}else {
			request.setAttribute("errorMsg","账户或者密码不正确");
			return "index";
		}
	}
}
