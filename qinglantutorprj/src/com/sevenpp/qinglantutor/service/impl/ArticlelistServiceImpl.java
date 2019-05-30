package com.sevenpp.qinglantutor.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.ArticlelistDaoImpl;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.service.ArticlelistService;

@Service
public class ArticlelistServiceImpl implements ArticlelistService {
	@Resource
	private ArticlelistDaoImpl aldi;
	
	@Override
	public List<Article> findAllArticle(){
		List<Article> list=new ArrayList();
		list=aldi.queryArticle();
		System.out.println("service   "+list);
		return list;
	}
}