package com.sevenpp.qinglantutor.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  TblCourse   
 * @Description:课程表  
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午3:07:01   
 *
 */
@Entity
@Table(name="tbl_course")
public class Course  implements java.io.Serializable {

	/** 
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
			*/
		
	private static final long serialVersionUID = 1L;
	private Integer cid;	//课程id
	private String cname;	//课程名
	
	private Set<MyJob> myJobs=new HashSet<MyJob>();	//课程表和求职信息表是多对多的关系
	private List<TeachRelation> teachRelations=new ArrayList<TeachRelation>();	//课程表和教课关系表是一对多的关系
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@ManyToMany(mappedBy="courses") 
	public Set<MyJob> getMyJobs() {
		return myJobs;
	}

	public void setMyJobs(Set<MyJob> myJobs) {
		this.myJobs = myJobs;
	}

	@OneToMany(mappedBy="course",
			targetEntity=TeachRelation.class,
			cascade= {CascadeType.REMOVE})
	public List<TeachRelation> getTeachRelations() {
		return teachRelations;
	}

	public void setTeachRelations(List<TeachRelation> teachRelations) {
		this.teachRelations = teachRelations;
	}

	
	
     


    


}


