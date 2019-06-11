package com.sevenpp.qinglantutor.service;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;
import java.util.List;

public interface StudentDetailService {
	abstract public List<Article> AtricleShow() ;
	abstract public List<ArticleReview> AtricleReview() ;
	abstract public User getUserByEmail(int id);
}

	