package com.sevenpp.qinglantutor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sevenpp.qinglantutor.common.CourseTime;
import com.sevenpp.qinglantutor.entity.Course;
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

public class test {
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public String setCourseTime(@RequestParam(value="courseTime",required=false) String courseTime,
			@RequestParam(value="ab",required=false) String ad) {
		System.out.println("test.java"+"~~"+courseTime+"~"+ad);
		
		return "{\"coursetime\":\"123\"}";
	}
}

	