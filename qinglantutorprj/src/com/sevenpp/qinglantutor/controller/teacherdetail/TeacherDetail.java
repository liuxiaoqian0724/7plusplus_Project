package com.sevenpp.qinglantutor.controller.teacherdetail;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.service.TeacherDetailService;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsController
		* 类描述：个人中心消息部分controller
		* 创建人：rain
		* 创建时间：2018年12月11日 下午4:06:53
		* 修改人：rain
		* 修改时间：2018年12月11日 下午4:06:53
		* 修改备注：
		* @version
		*
		*/
@Controller
public class TeacherDetail {
	@Resource
	private TeacherDetailService teacherdetailServiceImpl;
	
	@RequestMapping(value = "/teacherdeatil",produces = "text/html; charset=utf-8")
	public String teacherDetail(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
		/*返回文章的信息包含文章名称、内容、评论、类型*/
		this.teacherdetailServiceImpl.getArticleMessages();
		request.getServletContext().setAttribute("teachername","Dfs");
		return "teacher-detail";
		
	}

}

	