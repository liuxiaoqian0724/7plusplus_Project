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
 * @ClassName:  TblMsg   
 * @Description：消息表实体 
 * @author: liuxiaoqian
 * @date:   2018年11月30日 下午3:02:32   
 *
 */
@Entity
@Table(name="tbl_msg")
public class Msg  implements java.io.Serializable {


     private Integer mid;	//消息id
//     private Integer receiveId;	//收件人id
//     private Integer sendid;	//发件人id
     private String content;	//内容
     private Date sendTime;
     private Integer status;	//收件人的消息状态，同意还是拒绝
     private User receiveUser;	//收件人
     private User sendUser;		//消息表和用户表是双向多对一的关系（发件人）

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@ManyToOne()
	@JoinColumn(name="receiveid")
	@NotFound(action=NotFoundAction.IGNORE)
	public User getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(User receiveUser) {
		this.receiveUser = receiveUser;
	}

	@ManyToOne()
	@JoinColumn(name="sendid")
	@NotFound(action=NotFoundAction.IGNORE)
	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	
     
     
    

    


}


