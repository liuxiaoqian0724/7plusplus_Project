package com.sevenpp.qinglantutor.controller.regist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.dao.impl.RegistDaoImpl;
import com.sevenpp.qinglantutor.utils.email.MailSenderPool;
import com.sevenpp.qinglantutor.utils.email.MailSenderReg;

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
* @version 创建时间：2018年12月5日 上午9:06:13
* 类说明
*/
@Controller
@Scope("prototype")
@RequestMapping("/emailreg")
@ResponseBody
public class EmailRegistController {
	@Resource
	private RegistDaoImpl RegistDaoImpl;
	@RequestMapping(value="/check", method=RequestMethod.POST)
	public void checkEmail(@RequestBody Map<String,String>map,HttpServletResponse response) {
		PrintWriter writer;
		if(RegistDaoImpl.existEmail(map.get("email"))==false) {
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
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public void sendEmail(@RequestBody Map<String, String>map,HttpServletResponse response,HttpServletRequest request) {
		String email = map.get("email");
		HttpSession session = request.getSession();
		MailSenderPool pool = MailSenderPool.getInstance();
		pool.sendByThread(new MailSenderReg(email,session));
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write("ok");
		} catch (IOException e) {
				
		}
	}
}