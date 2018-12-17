package com.sevenpp.qinglantutor.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @ClassName: TblTime 
 * @Description: 时间表
 * @author cuishan  
 * @date 2018年12月3日 下午8:08:43 
 * 
 */

@Entity
@Table(name="tbl_time")
public class Time implements java.io.Serializable {

	/** 
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
			*/
		
	private static final long serialVersionUID = 7300218814651534388L;
	private Integer tid;	
	private String time;
	
	private Set<MyJob> myJobs=new HashSet<MyJob>();
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@ManyToMany(mappedBy="times") 
	public Set<MyJob> getMyJobs() {
		return myJobs;
	}
	public void setMyJobs(Set<MyJob> myJobs) {
		this.myJobs = myJobs;
	}
	
	
	
}

	