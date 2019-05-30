package com.sevenpp.qinglantutor.controller.articlelist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.service.impl.ArticlelistServiceImpl;

@Controller
public class ArticlelistController {
	@Resource
	private ArticlelistServiceImpl alsi;
	
	@RequestMapping("/articles")
	@ResponseBody
	public List<Article> articles(HttpServletResponse response) {
		List<Article> list=new ArrayList();
		list=alsi.findAllArticle();
		response.setCharacterEncoding("UTF-8");
		System.out.println("controller");
		return list;
	}
}	