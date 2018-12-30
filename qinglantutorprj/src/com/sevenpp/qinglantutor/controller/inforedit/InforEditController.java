package com.sevenpp.qinglantutor.controller.inforedit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.InforEditServiceImpl;
import com.sevenpp.qinglantutor.utils.base64decoder.BaseDecoderUtil;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

import Decoder.BASE64Decoder;

/**
*
* 项目名称：qinglantutorprj
* 类名称：InforEditController
* 类描述：
* 创建人：rain
* 创建时间：2018年12月18日 下午8:41:55
* 修改人：rain
* 修改时间：2018年12月18日 下午8:41:55
* 修改备注：
* @version
*
*/
@Controller
public class InforEditController {

	@Resource
	private InforEditServiceImpl inforEditServiceImpl;
	
	@RequestMapping("inforedit")
	public String inforedit(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		User u = this.inforEditServiceImpl.getUserByEmail(email);
		request.setAttribute("user", u);
		return "personal-information-edit";
	}
	
	@RequestMapping("inforchange")
	@ResponseBody
	public String inforChange(@RequestBody User u,HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();	
		u.setEmail(email);
		User user = this.inforEditServiceImpl.getUserByEmail(email);
		if(u.getUserImg().startsWith("data:image/")) {
			u.setUserImg(BaseDecoderUtil.ifSuccess(u.getUserImg(), request,"userimg",u.getEmail(),user.getUserImg()));
		}
		if(u.getStuImg().startsWith("data:image/")) {
			u.setStuImg(BaseDecoderUtil.ifSuccess(u.getStuImg(), request,"stuimg",u.getEmail(),user.getStuImg()));
		}
		if(u.getImg1()!=null && u.getImg1().startsWith("data:image/")) {
			u.setImg1(BaseDecoderUtil.ifSuccess(u.getImg1(), request,"img1",u.getEmail(),user.getImg1()));
		}
		if(u.getImg2()!=null && u.getImg2().startsWith("data:image/")) {
			u.setImg2(BaseDecoderUtil.ifSuccess(u.getImg2(), request,"img2",u.getEmail(),user.getImg2()));
		}
		if(u.getImg3()!=null && u.getImg3().startsWith("data:image/")) {
			u.setImg3(BaseDecoderUtil.ifSuccess(u.getImg3(), request,"img3",u.getEmail(),user.getImg3()));
		}
		if(u.getImg4()!=null && u.getImg4().startsWith("data:image/")) {
			u.setImg4(BaseDecoderUtil.ifSuccess(u.getImg4(), request,"img4",u.getEmail(),user.getImg4()));
		}
		this.inforEditServiceImpl.changeInforEdit(u);
		return "student-personal-center-mynews";
	}
}

	