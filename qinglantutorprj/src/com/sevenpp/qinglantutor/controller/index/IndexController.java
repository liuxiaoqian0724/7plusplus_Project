package com.sevenpp.qinglantutor.controller.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sevenpp.qinglantutor.entity.Userinf;
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
	@RequestMapping("/teacherdetail/{teacherid}")
	public String teacherDetail(@PathVariable String teacherid,Model model) {
		model.addAttribute("teacherid", teacherid);
		System.out.println(teacherid);
		return "teacherdetail";
	}
	@RequestMapping("/indexfile")
	public void findAllUser(HttpServletResponse response){
		System.out.println("IndexController");
		List<Userinf> list=new ArrayList<Userinf>();
		list=service.findAllUser();
		String str = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer=response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
		}
		
	}

}
