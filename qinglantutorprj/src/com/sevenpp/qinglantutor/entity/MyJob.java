package com.sevenpp.qinglantutor.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @ClassName:  TblMyjob   
 * @Description:求职信息表
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午3:01:57   
 *
 */
@Entity
@Table(name="tbl_myjob")
public class MyJob  implements java.io.Serializable {


     private Integer jid;	//求职信息id
//     private Integer tid;	//老师id
     private String address;
     private Integer price;
     private String teacherAge;	//教龄
     
     private User user=new User();	//求职信息表和用户表是双向一对一的关系
     private Set<Course> courses = new HashSet<Course>();	//求职信息表和课程表多对多的关系
     private Set<Grade> grades=new HashSet<Grade>();	//求职关系表和年级表多对多的关系
     private Set<Time> times=new HashSet<Time>();	//求职关系表和时间表是多对多的关系 
     
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getTeacherAge() {
		return teacherAge;
	}
	public void setTeacherAge(String teacherAge) {
		this.teacherAge = teacherAge;
	}
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name = "tid")	//tid是外键
	
	@ManyToOne()
	@JoinColumn(name="tid")	//老师id(tid)是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tbl_myjobcourse", //第三张表
		joinColumns=@JoinColumn(name="jid"),
		inverseJoinColumns=@JoinColumn(name="cid"))
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@ManyToMany
	@JoinTable(name="tbl_myjobgrade", //第三张表
		joinColumns=@JoinColumn(name="jid"),
		inverseJoinColumns=@JoinColumn(name="gid"))
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	
	@ManyToMany
	@JoinTable(name="tbl_myjobtime", //第三张表
		joinColumns=@JoinColumn(name="jid"),
		inverseJoinColumns=@JoinColumn(name="timeid"))
	public Set<Time> getTimes() {
		return times;
	}
	public void setTimes(Set<Time> times) {
		this.times = times;
	}
	public String toString() {
		return "MyJob [jid=" + jid + ", address=" + address + ", price=" + price + ", teacherAge=" + teacherAge
				+ ", user=" + user + ", courses=" + courses + ", grades=" + grades + ", times=" + times + "]";
	}
	
	
     
	
	
	
	
    


}


