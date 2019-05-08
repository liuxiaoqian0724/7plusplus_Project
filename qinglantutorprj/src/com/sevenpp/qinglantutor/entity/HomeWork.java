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

/**
 * 
 * @ClassName:  TblHomework   
 * @Description:作业表实体  
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午3:03:02   
 *
 */
@Entity
@Table(name="tbl_homework")
public class HomeWork  implements java.io.Serializable {


     private Integer hid;
     private String tcontent;	//老师留的作业内容
     private String scontent;	//学生交的作业内容
     private Date tstartTime;	//老师留作业的时间
     private Date sfinishTime;	//学生完成作业的时间
     private Integer score;	
     private String sstatus;	//学生的作业状态（已完成或未完成）
     private String tstatus;
     private String question;
     private String workReview;
     private Date deadlineTime;
     
     
     private ClassRelation classRelation=new ClassRelation();	//作业表和上课关系表是双向多对一的关系
     private TeachRelation teachRelation=new TeachRelation();	//作业表和教课关系表是双向多对一的关系
     
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getHid() {
		return hid;
	}
	public void setHid(Integer hid) {
		this.hid = hid;
	}
	public String getTcontent() {
		return tcontent;
	}
	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public Date getTstartTime() {
		return tstartTime;
	}
	public void setTstartTime(Date tstartTime) {
		this.tstartTime = tstartTime;
	}
	public Date getSfinishTime() {
		return sfinishTime;
	}
	public void setSfinishTime(Date sfinishTime) {
		this.sfinishTime = sfinishTime;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getSstatus() {
		return sstatus;
	}
	public void setSstatus(String sstatus) {
		this.sstatus = sstatus;
	}
	public String getTstatus() {
		return tstatus;
	}
	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}
	
	@ManyToOne()
	@JoinColumn(name="crid")	//上课关系id(crid)是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public ClassRelation getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}
	
	@ManyToOne()
	@JoinColumn(name="trid")	//教课关系id（trid）是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public TeachRelation getTeachRelation() {
		return teachRelation;
	}
	public void setTeachRelation(TeachRelation teachRelation) {
		this.teachRelation = teachRelation;
	}
     
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getWorkReview() {
		return workReview;
	}
	public void setWorkReview(String workReview) {
		this.workReview = workReview;
	}
	
	public Date getDeadlineTime() {
		return deadlineTime;
	}
	public void setDeadlineTime(Date deadlineTime) {
		this.deadlineTime = deadlineTime;
	}
	
     
   

    

//    @ManyToOne
//    @JoinColumn(name="tid")
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

    


}


