/**   
		* @Title: IndexController.java 
		* @Package com.sevenpp.qinglantutor.controller 
		* @Description: 控制index页面
		* @author wz 
		* @date 2018年12月6日 下午4:47:50 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.Impl.IndexServiceImpl;
import com.sevenpp.qinglantutor.util.PageBean;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexController
		* 类描述：控制首页
		* 创建人：rain
		* 创建时间：2018年12月6日 下午4:47:50
		* 修改人：rain
		* 修改时间：2018年12月6日 下午4:47:50
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexController 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月6日 下午4:47:50 
		* @version V1.0 
		*/
@Controller
public class IndexController {
	
	@Resource
	private IndexServiceImpl service;
	
	@RequestMapping("/search")
	public String indexSearchBox(@RequestParam("keyword") String keyword,Model model) {
		model.addAttribute("keyword",keyword);
		System.out.println(keyword);
		return "tutorlist";
	}
	@RequestMapping("/search/{schooltype}")
	public String schoolType(@PathVariable String schooltype,Model model) {
		model.addAttribute("schooltype", schooltype);
		System.out.println(schooltype);
		return "tutorlist";
	}
	@RequestMapping("findAllUserWithPage.do")
	public ModelAndView findAllStudentWithPage(HttpServletRequest request, HttpServletResponse response){
		System.out.println("IndexController");
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum="1";
		}
		PageBean<User> pb = service.findAllUserWithPage(Integer.parseInt(pageNum),25);
		ModelAndView model = new ModelAndView();
		model.addObject("pageBean", pb);
		System.out.println(pb.getPageSize());
		model.setViewName("index");
		return model;
	}

}

	