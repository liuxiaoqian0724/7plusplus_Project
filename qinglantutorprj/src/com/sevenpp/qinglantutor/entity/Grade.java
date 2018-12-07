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
 * @ClassName: TblGrade
 * @Description:年级表
 * @author:liuxiaoqian
 * @date: 2018年11月30日 下午3:03:50
 *
 */
@Entity
@Table(name = "tbl_grade")
public class Grade implements java.io.Serializable {

	/**
	 *  
	 * 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */

	private static final long serialVersionUID = 1L;
	private Integer gid; // 年级id
	private String gname; // 年级名
	private String schoolType;

	private Set<MyJob> myJobs = new HashSet<MyJob>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getSchooltype() {
		return schoolType;
	}

	public void setSchooltype(String schooltype) {
		this.schoolType = schooltype;
	}

	@ManyToMany(mappedBy = "grades")
	public Set<MyJob> getMyJobs() {
		return myJobs;
	}

	public void setMyJobs(Set<MyJob> myJobs) {
		this.myJobs = myJobs;
	}

}
