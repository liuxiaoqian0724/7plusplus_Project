
		package com.sevenpp.qinglantutor.entity;

import java.util.Date;
import java.util.List;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：NewsPage
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月12日 上午10:42:49
		* 修改人：rain
		* 修改时间：2018年12月12日 上午10:42:49
		* 修改备注：
		* @version
		*
		*/
public class NewsPage {
	private User Rid;
	private int Sid;
	private String content;
	private Date sendtime;
	private int status;
	private String username;
	private String userimg;
	private String cutContent;
	private List<Review> review;
	private List<String> star;
	
	public User getRid() {
		return Rid;
	}
	public void setRid(User user) {
		Rid = user;
	}
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		Sid = sid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	public String getCutContent() {
		return cutContent;
	}
	public void setCutContent(String cutContent) {
		this.cutContent = cutContent;
	}
	public List<Review> getReview() {
		return review;
	}
	public void setReview(List<Review> review) {
		this.review = review;
	}
	public List<String> getStar() {
		return star;
	}
	public void setStar(List<String> star) {
		this.star = star;
	}
	

}

	