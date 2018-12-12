package com.sevenpp.qinglantutor.service;

import java.util.List;

import com.sevenpp.qinglantutor.entity.CourseInformation;

/**
*
* 项目名称：qinglantutorprj
* 类名称：StuCourseService
* 类描述：
* 创建人：rain
* 创建时间：2018年12月10日 下午2:23:47
* 修改人：rain
* 修改时间：2018年12月10日 下午2:23:47
* 修改备注：
* @version
*
*/
public interface StuCourseService {
	 public List<CourseInformation> getCourseInfor(String email);
}

	