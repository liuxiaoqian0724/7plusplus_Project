package com.sevenpp.qinglantutor.common;

import java.io.Serializable;
import java.util.List;

/**
*
* 项目名称：qinglantutorprj
* 类名称：CourseTime
* 类描述：我的课程的，课程时间的ajax返回值类
* 创建人：hy
* 创建时间：2018年12月5日 下午8:16:10
* 修改人：rain
* 修改时间：2018年12月5日 下午8:16:10
* 修改备注：
* @version
*
*/

public class CourseTime implements Serializable {
	
	private String ed;
	private String startTime;
	private String  endTime;

	


	public String getStartTime() {
		return startTime;
	}




	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}




	public String getEndTime() {
		return endTime;
	}




	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	


	public String getEd() {
		return ed;
	}




	public void setEd(String ed) {
		this.ed = ed;
	}

	


	public String toString() {
		return "CourseTime [ed=" + ed + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}




	public CourseTime() {
		super();
	}
	
}

	