package com.sevenpp.qinglantutor.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * 
 * @ClassName: TblTeachrelation 
 * @Description: 教课关系表
 * @author cuishan  
 * @date 2018年12月3日 下午8:08:43 
 * 
 */

@Entity
@Table(name="tbl_teach")
public class TeachRelation implements java.io.Serializable {
	
	/** 
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
			*/
		
	private static final long serialVersionUID = 1L;

	private Integer trid;	//教课关系id
	
	private List<HomeWork> homeworks=new ArrayList<HomeWork>();		//教课关系表和作业表是双向一对多的关系
	private List<TeachPlan> teachPlans = new ArrayList<TeachPlan>();//教课关系表和教案表是双向一对多的关系
	private User user;	//教课关系表和用户表是多对一的关系
	private Course course;	//教课关系表和课程表是多对一的关系
	private List<ClassRelation> classRelation=new ArrayList<ClassRelation>();	//教课关系表和上课关系表是一对多的关系
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTrid() {
		return trid;
	}
	public void setTrid(Integer trid) {
		this.trid = trid;
	}
	
	@OneToMany(mappedBy="teachRelation",
			targetEntity=HomeWork.class,
			cascade= {CascadeType.REMOVE})
	public List<HomeWork> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(List<HomeWork> homeworks) {
		this.homeworks = homeworks;
	}
	
	@OneToMany(mappedBy="teachRelation",
			targetEntity=TeachPlan.class,
			cascade= {CascadeType.REMOVE})
	public List<TeachPlan> getTeachPlans() {
		return teachPlans;
	}
	public void setTeachPlans(List<TeachPlan> teachPlans) {
		this.teachPlans = teachPlans;
	}
	
	@ManyToOne()
	@JoinColumn(name="cid")	//课程id（cid）是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne()
	@JoinColumn(name="tid")	//老师id（tid）是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@OneToMany(mappedBy="teachRelation",
			targetEntity=ClassRelation.class,
			cascade= {CascadeType.REMOVE})
	public List<ClassRelation> getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(List<ClassRelation> classRelation) {
		this.classRelation = classRelation;
	}
	
	
	
}

	