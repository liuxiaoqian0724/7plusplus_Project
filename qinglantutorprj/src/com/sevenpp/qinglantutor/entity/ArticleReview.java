package com.sevenpp.qinglantutor.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="tbl_articlereview")
public class ArticleReview {

	private Integer arId;
//	private Integer id;
//	private Integer aid;
	private String rContent;
	private Date rTime;
	private User user;
	private Article article;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getArId() {
		return arId;
	}
	public void setArId(Integer arId) {
		this.arId = arId;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Date getrTime() {
		return rTime;
	}
	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}
	@ManyToOne()
	@JoinColumn(name="id")
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne()
	@JoinColumn(name="aid")
	@NotFound(action=NotFoundAction.IGNORE)
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public String toString() {
		return "ArticleReview [arId=" + arId + ", rContent=" + rContent + ", rTime=" + rTime + ", user=" + user
				+ ", article=" + article + "]";
	}
	
	} 
	

