package com.sevenpp.qinglantutor.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sevenpp.qinglantutor.common.CourseTime;
/**
*
* 项目名称：qinglantutorprj
* 类名称：test
* 类描述：
* 创建人：rain
* 创建时间：2018年12月5日 下午7:31:40
* 修改人：rain
* 修改时间：2018年12月5日 下午7:31:40
* 修改备注：
* @version
*
*/




@Controller
@Scope("prototype")
public class test {
	
	@RequestMapping(value="/test", method= RequestMethod.POST)
	@ResponseBody
	public CourseTime setCourseTime(@RequestBody CourseTime courseTime) {
		System.out.println("test.java");
//		CourseTime courseTime = new CourseTime();
//		courseTime.setStartTime(startTime);
//		courseTime.setEndTime(endTime);
		
		System.out.println(courseTime.getStartTime()+"~~"+courseTime.getEndTime());
		return courseTime;
	}
}

	