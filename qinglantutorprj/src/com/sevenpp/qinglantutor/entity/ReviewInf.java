/**   
		* @Title: ReviewModle.java 
		* @Package com.sevenpp.qinglantutor.entity 
		* @Description 评论内容中存储具体信息的实体
		* @author lxq
		* @date 2018年12月19日 下午3:07:33 
		* @version V1.0   
		*/
package com.sevenpp.qinglantutor.entity;
/**
*
* 项目名称：qinglantutorprj
* 类名称：ReviewModle
* 类描述：评论内容中存储具体信息的实体
* 创建人：lxq
* 创建时间：2018年12月19日 下午3:07:33
* 修改人：rain
* 修改时间：2018年12月19日 下午3:07:33
* 修改备注：
* @version
*
*/
/** 
* @ClassName: ReviewModle 
* @Description: 评论内容中存储具体信息的实体
* @author lxq  
* @date 2018年12月19日 下午3:07:33 
* @version V1.0 
*/

import java.sql.Timestamp;

public class ReviewInf {
	private Integer teacherId;//老师id
	private String reviewUserName;//评论的用户名
	private String reivewUserImg;//评论用户头像
	private String reivewContent;//评论内容
	private Timestamp reviewDateTime;//评论时间
	
	
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
	
	

}
