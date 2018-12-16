package com.sevenpp.qinglantutor.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.common.CourseTime;
import com.sevenpp.qinglantutor.entity.CourseInformation;

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
	public String setCourseTime(@RequestBody CourseTime courseTime) {
		System.out.println(courseTime.toString());
		
		return "{\"coursetime\":\"123\"}";
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("bbbb");
		
		map.put("a", "aaa");
		map.put("b", list);
		
		System.out.println(list.get(0));
	}
}

	