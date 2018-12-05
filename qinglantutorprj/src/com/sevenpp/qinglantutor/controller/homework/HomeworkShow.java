package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeworkShow {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	
	@RequestMapping("/HomeWorkShow")
	public String show(HttpServletRequest request) {
		String t=request.getParameter("tcontent");
		List<HomeWork> list=homeworkSelectServiceImpl.HomeworkShow();
		request.setAttribute("homework", list);
			
		return "student-personal-center-homework";
		
	};
}
