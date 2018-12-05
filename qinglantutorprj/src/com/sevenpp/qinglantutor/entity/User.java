package com.sevenpp.qinglantutor.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  TblUser   
 * @Description:用户表实体  
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午2:56:10   
 *
 */
@Entity
@Table(name="tbl_user")
public class User  implements java.io.Serializable {

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;//主键
     private String userName;
     private String userPwd;
     private String email;
     private String role;
     private Date regDate;//注册时间
     private String realName;
     private String idNumber;//身份证号码
     private String sex;
     private String stuImg;	//身份证照片
     private String userImg;	//用户头像
     private String school;
     private String grade;
     private String phoneNumber;
     private String address;
     private String introduce;//个人简介
     private String major;
     private Integer status;//状态位，是否发布家教信息，1=发布，0未发布
     private String publickey;	//公钥
     private String privatekey;	//私钥
     private String img1;
     private String img2;
     private String img3;
     private String img4;
     
     private List<Msg> msgs= new ArrayList<Msg>();	//用户表和消息表是双向一对多的关系
   //  private MyJob myjob=new MyJob();	//用户表和求职信息表是双向一对一的关系
    // private MyJob myJob=null;
     private List<MyJob> myJobs=new ArrayList<MyJob>();
     private List<TeachRelation> teachRelations=new ArrayList<TeachRelation>();	//用户表和教课关系表是一对多的关系
     private List<ClassRelation> classRelation = new ArrayList<ClassRelation>();	//用户表和上课关系表是一对多的关系
     
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStuImg() {
		return stuImg;
	}
	public void setStuImg(String stuImg) {
		this.stuImg = stuImg;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPublickey() {
		return publickey;
	}
	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	@OneToMany(mappedBy="user",
			targetEntity=Msg.class,
			cascade= {CascadeType.REMOVE})
	public List<Msg> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Msg> msgs) {
		this.msgs = msgs;
	}
	
//	@OneToOne(mappedBy = "user")
//	public MyJob getMyjob() {
//		return myjob;
//	}
//	public void setMyjob(MyJob myjob) {
//		this.myjob = myjob;
//	}
	
	@OneToMany(mappedBy="user",
			targetEntity=MyJob.class,
			cascade= {CascadeType.REMOVE})
	public List<MyJob> getMyJobs() {
		return myJobs;
	}
	public void setMyJobs(List<MyJob> myJobs) {
		this.myJobs = myJobs;
	}
	@OneToMany(mappedBy="user",
			targetEntity=TeachRelation.class,
			cascade= {CascadeType.REMOVE})
	public List<TeachRelation> getTeachRelations() {
		return teachRelations;
	}
	public void setTeachRelations(List<TeachRelation> teachRelations) {
		this.teachRelations = teachRelations;
	}
	
	@OneToMany(mappedBy="user",
			targetEntity=ClassRelation.class,
			cascade= {CascadeType.REMOVE})
	public List<ClassRelation> getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(List<ClassRelation> classRelation) {
		this.classRelation = classRelation;
	}	
	
	
     
	
     
     
//     private MyJob myjob;//求职表一对一映射
//     private List<Teachplan> teachPlanList;//一对多
//     private List<Msg> msgList;//一对多
//     private List<Course> courseList;//一对多
//     private List<HomeWork> homeWorkList;//一对多
//     private List<Review> reviewList;//一对多
   
   
    //与myjob表一对一
//    @OneToOne(mappedBy="myjob",targetEntity=MyJob.class)
//	public MyJob getMyjob() {
//		return myjob;
//	}
//
//	public void setMyjob(MyJob myjob) {
//		this.myjob = myjob;
//	}

	

//	//teachPlan表一对多
//	@OneToMany(mappedBy="user",targetEntity=Teachplan.class,cascade=CascadeType.ALL)
//	public List<Teachplan> getTeachPlan() {
//		return teachPlanList;
//	}
//
//	public void setTeachPlan(List<Teachplan> teachPlan) {
//		this.teachPlanList = teachPlan;
//	}

	
//	//msg一对多
//	@OneToMany(mappedBy="user",targetEntity=Msg.class,cascade=CascadeType.ALL)
//	public List<Msg> getMsgList() {
//		return msgList;
//	}
//
//	public void setMsgList(List<Msg> msgList) {
//		this.msgList = msgList;
//	}
//	//course一对多
//	@OneToMany(mappedBy="user",targetEntity=Course.class,cascade=CascadeType.ALL)
//	public List<Course> getCourseList() {
//		return courseList;
//	}
//
//	public void setCourseList(List<Course> courseList) {
//		this.courseList = courseList;
//	}
//	//homework一对多
//	@OneToMany(mappedBy="user",targetEntity=HomeWork.class,cascade=CascadeType.ALL)
//	public List<HomeWork> getHomeWorkList() {
//		return homeWorkList;
//	}
//
//	public void setHomeWorkList(List<HomeWork> homeWorkList) {
//		this.homeWorkList = homeWorkList;
//	}
//	//review一对多
//	@OneToMany(mappedBy="user",targetEntity=Review.class,cascade=CascadeType.ALL)
//	public List<Review> getReviewList() {
//		return reviewList;
//	}
//
//	public void setReviewList(List<Review> reviewList) {
//		this.reviewList = reviewList;
//	}

	
	
	
}


