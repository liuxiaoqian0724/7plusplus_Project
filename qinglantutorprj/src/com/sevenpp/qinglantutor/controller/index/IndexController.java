package com.sevenpp.qinglantutor.controller.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.Userinf;
import com.sevenpp.qinglantutor.service.impl.ArticlelistServiceImpl;
import com.sevenpp.qinglantutor.service.impl.IndexServiceImpl;

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
	public String indexSearchBox(@RequestParam("grade") String grade,Model model) {
		return "tutorlisted";
	}
	@RequestMapping("/searchsubject")
	public ModelAndView searchSubject(HttpServletRequest request) {
		String subject=request.getParameter("subject");
		System.out.println(request.getParameter("subject"));
		String subject1="0";
		if(subject.equals("语文"))
			subject1="yuwen";
		if(subject.equals("数学"))
			subject1="shuxue";
		if(subject.equals("英语"))
			subject1="yingyu";
		if(subject.equals("物理"))
			subject1="wuli";
		if(subject.equals("化学"))
			subject1="huaxue";
		if(subject.equals("生物"))
			subject1="shengwu";
		if(subject.equals("地理"))
			subject1="dili";
		if(subject.equals("政治"))
			subject1="zhengzhi";
		if(subject.equals("历史"))
			subject1="lishi";
		return new ModelAndView("redirect:/change/addconditions/0/"+subject1+"/0/0/0");
	}
	@RequestMapping("/search/{schooltype}")
	public String schoolType(@PathVariable String schooltype,Model model) {
		model.addAttribute("schooltype", schooltype);
		return "tutorlisted";
	}
	@RequestMapping("/indexfile")
	public void findAllUser(HttpServletResponse response){
		List<Userinf> list=new ArrayList<Userinf>();
		list=service.findAllUser();
		String str = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer=response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/articleinf")
	@ResponseBody
	public List<Article> articles(HttpServletResponse response) {
		List<Article> list=new ArrayList();
		list=service.findAllArticles();
		response.setCharacterEncoding("UTF-8");
		return list;
	}
}
