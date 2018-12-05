package com.sevenpp.qinglantutor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	 * 
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

//	@ManyToOne
//	@JoinColumn(name="teachplanId")
//	public MyJob getMyjob() {
//		return myJob;
//	}
//
//	public void setMyjob(MyJob myjob) {
//		this.myJob = myjob;
//	}

    

    


}


