package com.sevenpp.qinglantutor.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  TblReview   
 * @Description:评论表
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午2:58:40   
 *
 */
@Entity
@Table(name="tbl_review")
public class Review  implements java.io.Serializable {


     private Integer rid;	//评价id
     private Date reviewTime;	//评价时间
     private String reviewContent;	//评价时间
     private Integer reviewStar;	//评价星级	

     private ClassRelation classRelation;	//评价表和上课关系表是双向多对一的关系

     @Id
 	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Integer getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Integer reviewStar) {
		this.reviewStar = reviewStar;
	}

	@ManyToOne()
	@JoinColumn(name="crid")	//上课关系crid是外键
	public ClassRelation getClassRelation() {
		return classRelation;
	}

	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}	
     
    


}


