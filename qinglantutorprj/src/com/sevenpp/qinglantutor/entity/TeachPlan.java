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
 * @ClassName:  TblTeachplan   
 * @Description:教案表实体
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午2:57:46   
 *
 */
@Entity
@Table(name="tbl_teachplan")
public class TeachPlan  implements java.io.Serializable {


     /** 
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
			*/
		
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String content;	//教案内容
     private Date time;
     
     private TeachRelation teachRelation=new TeachRelation();	//教案表和教课关系表是双向多对一的关系	

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 public Integer getId() {
		 return id;
	 }

	 public void setId(Integer id) {
		 this.id = id;
	 }

	 public String getContent() {
		 return content;
	 }

	 public void setContent(String content) {
	 	this.content = content;
	 }

	 public Date getTime() {
	 	return time;
	 }
 
	 public void setTime(Date time) {
	  	this.time = time;
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


