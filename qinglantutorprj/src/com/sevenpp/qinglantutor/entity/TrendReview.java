package com.sevenpp.qinglantutor.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class TrendReview implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer teacherId;//老师id
	private String reviewUserName;//评论的用户名
	private String reivewUserImg;//评论用户头像
	private String reivewContent;//评论内容
	private Timestamp reviewDateTime;//评论时间
	
	private String prop;
	private String adj;
	private String abstractWord;
	
	public TrendReview() {}//构造方法
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getReviewUserName() {
		return reviewUserName;
	}
	public void setReviewUserName(String reviewUserName) {
		this.reviewUserName = reviewUserName;
	}
	public String getReivewUserImg() {
		return reivewUserImg;
	}
	public void setReivewUserImg(String reivewUserImg) {
		this.reivewUserImg = reivewUserImg;
	}
	public String getReivewContent() {
		return reivewContent;
	}
	public void setReivewContent(String reivewContent) {
		this.reivewContent = reivewContent;
	}
	public Timestamp getReviewDateTime() {
		return reviewDateTime;
	}
	public void setReviewDateTime(Timestamp reviewDateTime) {
		this.reviewDateTime = reviewDateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public String getAdj() {
		return adj;
	}
	public void setAdj(String adj) {
		this.adj = adj;
	}
	public String getAbstractWord() {
		return abstractWord;
	}
	public void setAbstractWord(String abstractWord) {
		this.abstractWord = abstractWord;
	}
	@Override
	public String toString() {
		return "TrendReview [teacherId=" + teacherId + ", reviewUserName=" + reviewUserName + ", reivewUserImg="
				+ reivewUserImg + ", reivewContent=" + reivewContent + ", reviewDateTime=" + reviewDateTime + ", prop="
				+ prop + ", adj=" + adj + ", abstractWord=" + abstractWord + "]";
	}
	
	
	
}


