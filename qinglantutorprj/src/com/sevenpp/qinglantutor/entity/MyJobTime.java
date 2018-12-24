package com.sevenpp.qinglantutor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @ClassName:  TblMyjobtime   
 * @Description:工作时间表  
 * @author: liuxiaoqian
 * @date:   2018年12月3日 下午3:01:37   
 *
 */

@Entity
@Table(name="tbl_myjobtime")
public class MyJobTime  implements java.io.Serializable {


	/** 
			* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
			*/
		
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String time;
    //private MyJob myJob;//多对一
    
    public MyJobTime() {
    }

    public MyJobTime(Integer tid, String time) {
       this.time = time;
    }
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }
   
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
   
    public void setTime(String time) {
        this.time = time;
    }
  

}


