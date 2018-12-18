package com.sevenpp.qinglantutor.controller.sendmessage;

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

import com.sevenpp.qinglantutor.service.impl.SendMessageServiceImpl;
import com.sevenpp.qinglantutor.util.cookie.CookieUtils;

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
* @version 创建时间：2018年12月11日 下午5:27:14
* 类说明
*/
@Controller
@Scope("prototype")
@RequestMapping("/sendMessage")
@ResponseBody
public class SendMessageController {
	@Resource
	private SendMessageServiceImpl sendMessageServiceImpl;
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public void send(@RequestBody Map<String,String>map,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String EMAIL = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		if (SESSIONID==""||SESSIONID==null||EMAIL==""||EMAIL==null) {
			PrintWriter writer = null;
			try {
				writer = response.getWriter();
				writer.write("logout");
				writer.flush();
				writer.close();
			} catch (IOException e) {
			}
		}else {
			if (sendMessageServiceImpl.sendMessage(map,EMAIL)) {
				PrintWriter writer = null;
				try {
					writer = response.getWriter();
					writer.write("ok");
					writer.flush();
					writer.close();
				} catch (IOException e) {
				}
			}else {
				PrintWriter writer = null;
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
}
