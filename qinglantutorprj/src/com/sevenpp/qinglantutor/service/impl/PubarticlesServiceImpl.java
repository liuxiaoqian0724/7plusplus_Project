package com.sevenpp.qinglantutor.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.PubarticlesDaoImpl;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.PubarticlesService;

@Service
public class PubarticlesServiceImpl implements PubarticlesService {
	
	@Resource
	private PubarticlesDaoImpl padi;
	
	public void setArticle(String title,String content,String email) {
		Article a=new Article();
		User u=new User();
		//获取系统当前时间
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date1);
		Timestamp sendTime=Timestamp.valueOf(str);
		a.setContent(content);
		a.setTitle(title);
		a.setLikeCount(0);
		a.setSendTime(sendTime);
		u=padi.findUser(email);
		padi.insertArticles(a, u);
	}
}