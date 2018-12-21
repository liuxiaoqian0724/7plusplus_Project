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
 * @ClassName: ClassRelation 
 * @Description: 上课关系表
 * @author cuishan
 * @date 2018年12月3日 下午9:45:59 
 *
 */

@Entity
@Table(name="tbl_classrelation")
public class ClassRelation {
	
	private Integer crid;	//上课关系id
	private List<Review> reviews= new ArrayList<Review>();	//上课关系表和评价表是双向一对多的关系
	private List<HomeWork> homeWorks = new ArrayList<HomeWork>();	//上课关系表和作业表是双向一对多的关系
	private User user;	//上课关系表和用户表是多对一的关系
	private TeachRelation teachRelation;	//上课关系表和教课关系表是多对一的关系
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCrid() {
		return crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	@OneToMany(mappedBy="classRelation",
			targetEntity=Review.class,
			cascade= {CascadeType.REMOVE})
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(mappedBy="classRelation",
			targetEntity=HomeWork.class,
			cascade= {CascadeType.REMOVE})
	public List<HomeWork> getHomeWorks() {
		return homeWorks;
	}

	public void setHomeWorks(List<HomeWork> homeWorks) {
		this.homeWorks = homeWorks;
	}

	@ManyToOne()
	@JoinColumn(name="sid")	//学生id（sid）是外键
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	
	
}

	