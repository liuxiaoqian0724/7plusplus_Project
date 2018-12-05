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
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
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
     private String img1;
     private String img2;
     private String img3;
     private String img4;
     private String school;
     private String grade;
     private String phoneNumber;
     private String address;
     private String introduce;//个人简介
     private String major;
     private Integer status;//状态位，是否发布家教信息，1=发布，0未发布
     private String publickey;	//公钥
     private String privatekey;	//私钥

     private List<Msg> msgs= new ArrayList<Msg>();	//用户表和消息表是双向一对多的关系
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
	
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
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


	
	
	
}


