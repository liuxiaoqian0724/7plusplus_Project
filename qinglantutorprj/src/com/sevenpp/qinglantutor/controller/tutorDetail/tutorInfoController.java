/**   
		* @Title: tutorInfoController.java 
		* @Package com.sevenpp.qinglantutor.controller.tutorDetail 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月5日 下午5:02:37 
		* @version V1.0   
		*/
package com.sevenpp.qinglantutor.controller.tutorDetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sevenpp.qinglantutor.entity.ReviewInf;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutorInfoController
		* 类描述：家教详情页基本信息展示
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午5:02:37
		* 修改人：rain
		* 修改时间：2018年12月5日 下午5:02:37
		* 修改备注：
		* @version
		*
		*/
/**
 *  
 * 
 * @ClassName: tutorInfoController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lxq
 * @date 2018年12月5日 下午5:02:37 
 * @version V1.0 
 */
@Controller
@RequestMapping(value = "/tutorDetail")
public class tutorInfoController {
	@Resource
	private TutorDetailServiceImpl tutorDetailServiceImpl;

	/**
	 * 
	 * @Title: showTutorDetail 
	 * @Description: 根据请求显示相应家教的基本信息
	 * @param @return    入参
	 * @return String    返回类型
	 * @author lxq
	 * @throws @date 2018年12月5日 下午5:29:09 
	 * @version V1.0   
	 */
	@RequestMapping(value = "/showtutorDetail/{id}")
	public String showTutorDetail(HttpServletRequest request, HttpServletResponse response, @PathVariable Integer id) {
		/**
		 * 设置跨域请求
		 */
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("textml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies, "JSESSIONID").getValue();
		String EMAIL = CookieUtils.getCookieFromCookies(cookies, "EMAIL").getValue();
		System.out.println("---------"+EMAIL);
		if(EMAIL==null||EMAIL.equals("")) {
			return "index";
		}else {
			User user = tutorDetailServiceImpl.getTutorDetail(id);
			Integer reviewCount = tutorDetailServiceImpl.getTutorReviewCount(id);
			request.setAttribute("user", user);
			// request.setAttribute("classRelation", classRelation);
			request.setAttribute("reviewCount", reviewCount);
			return "tutordetailed";
		}
	}

	@RequestMapping(value = "/tutorReviewPager")
	public void tutorReviewPager(HttpServletRequest request, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("textml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String tid = request.getParameter("tid");
		Integer id = Integer.parseInt(tid);
		List<ReviewInf> reviewInfList = this.tutorDetailServiceImpl.getTutorReivew(id);
		String str = JSON.toJSONString(reviewInfList, SerializerFeature.DisableCircularReferenceDetect);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @Title: sendMsgToTutor 
	 * @Description: ajax家长点击按钮后系统给家教发送提醒信息
	 * @param @return    入参
	 * @return boolean    返回类型
	 * @author lxq
	 * @throws @date 2018年12月12日 上午9:58:57 
	 * @version V1.0   
	 */
	@RequestMapping(value = "/inquire", method = RequestMethod.POST)
	public void sendMsgToTutor(@RequestBody Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("textml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String EMAIL = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		Integer inquireId=this.tutorDetailServiceImpl.findUser(EMAIL);
		System.out.println("email:"+EMAIL);
		Integer tutorId = Integer.parseInt(map.get("userId"));
		this.tutorDetailServiceImpl.sendMsgToTutor(tutorId, inquireId, map.get("gradeChosen"));
		String str = JSON.toJSONString("klsdfj");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
