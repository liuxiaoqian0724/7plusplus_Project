package com.sevenpp.qinglantutor.dao;


import java.util.List;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;

public interface StudentDetailDao {
	abstract public List<Article> AtricleShow() ;
	abstract public List<ArticleReview> AtricleReview() ;
}

	