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
 * @ClassName:  TblGrade   
 * @Description:年级表  
 * @author:liuxiaoqian
 * @date:   2018年11月30日 下午3:03:50   
 *
 */
@Entity
@Table(name="tbl_grade")
public class Grade  implements java.io.Serializable {


     private Integer gid;	//年级id
     private String gname;	//年级名
     private String schooltype;
     
     private Set<MyJob> myJobs=new HashSet<MyJob>();

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@ManyToMany(mappedBy="grades") 
	public Set<MyJob> getMyJobs() {
		return myJobs;
	}
	public void setMyJobs(Set<MyJob> myJobs) {
		this.myJobs = myJobs;
	}
	public String getSchooltype() {
		return schooltype;
	}
	public void setSchooltype(String schooltype) {
		this.schooltype = schooltype;
	}
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", schooltype=" + schooltype + ", myJobs=" + myJobs + "]";
	}	
    
	
     
	
    
   
    
    
    
//    @ManyToOne
//    @JoinColumn(name="tId")
//	public MyJob getMyJob() {
//		return myJob;
//	}
//
//	public void setMyJob(MyJob myJob) {
//		this.myJob = myJob;
//	}


	
  


}


