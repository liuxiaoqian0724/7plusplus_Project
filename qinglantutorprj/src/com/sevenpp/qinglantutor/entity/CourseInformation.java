package com.sevenpp.qinglantutor.entity;

import java.util.List;

/**
*
* 项目名称：qinglantutorprj
* 类名称：CourseInformation
* 类描述：课程页面展现内容集合起来的类
* 创建人：rain
* 创建时间：2018年12月10日 下午8:04:18
* 修改人：rain
* 修改时间：2018年12月10日 下午8:04:18
* 修改备注：
* @version
*
*/
public class CourseInformation {
	private Integer crid;
	private String subject;
	private String img;
	private String name;
	private List<String> homework;
	private String startTime;
	private String endTime;
	
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getHomework() {
		return homework;
	}
	public void setHomework(List<String> homework) {
		this.homework = homework;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}

	