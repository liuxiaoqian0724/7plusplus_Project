package com.sevenpp.qinglantutor.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_article")
public class Article {
	private Integer aId;
//	private Integer id;
	private String title;
	private String content;
	private Timestamp sendTime;
	private Integer likeCount;
	private Set<ArticleReview> userReviewSet=new HashSet<ArticleReview>();//文章评论表
	private User user=new User();//用户信息
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	
	@ManyToOne
	@JoinColumn(name="id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="article",targetEntity=ArticleReview.class,cascade=CascadeType.REMOVE)
	public Set<ArticleReview> getUserReviewSet() {
		return userReviewSet;
	}
	public void setUserReviewSet(Set<ArticleReview> userReviewSet) {
		this.userReviewSet = userReviewSet;
	}
	@Override
	public String toString() {
		return "Article [aId=" + aId + " , title=" + title + ", content=" + content + ", sendTime="
				+ sendTime + ", likeCount=" + likeCount + "]";
	}
	
	
	
}
