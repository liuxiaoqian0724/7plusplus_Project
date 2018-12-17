package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import com.sevenpp.qinglantutor.service.impl.WorkCompleteServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkCompleteController {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	@Resource WorkCompleteServiceImpl workCompleteServiceImpl;
	
//	作业完成页面作业查询
	@RequestMapping("/WorkComplete")
	public String WorkComplete(HttpServletRequest request) {
		
		String id="2";
		int hid=Integer.parseInt(id);
		List<HomeWork> list=homeworkSelectServiceImpl.HomeworkShow();
		List<HomeWork> list1=new ArrayList();
		List<String> list2=new ArrayList();
		for (HomeWork h : list) {
			if(hid==h.getHid()){
				list1.add(h);
			}
		}
		for (HomeWork h : list) {
			if(h.getHid()==hid) {
				String sstatus=h.getSstatus();
				list2.add(sstatus);
				request.setAttribute("sstatus",list2);
			}
		}
		
		
		request.setAttribute("homework", list1);
		return "work-complete";
	}
	
	
//	更改作业数据库
	@RequestMapping("/Update")
	public String WorkUpdate(HttpServletRequest request) {
//		String hid=request.getParameter("hid");
		int hid=3;
		String question=request.getParameter("question");
		List<HomeWork> list=homeworkSelectServiceImpl.HomeworkShow();
		
		String scontent=request.getParameter("content");
		Boolean isTrue=workCompleteServiceImpl.HomeworkInsert(scontent, hid,question);
		
		if(isTrue==true) {
			System.out.println("success");
		}else {
			System.out.println("fail");
		}
		return "index";
	}
}
