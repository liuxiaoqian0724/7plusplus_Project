package com.sevenpp.qinglantutor.controller.homework;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.HomeworkSelectServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeworkShow {
	@Resource HomeworkSelectServiceImpl homeworkSelectServiceImpl;
	
	
//	作业和老师展示
	@RequestMapping("/HomeWorkShow")
	public String show(HttpServletRequest request) {
//		String sid=request.getParameter("id");
//		String role=request.getParameter("role");
		String sid="4";
		String role="学生";
		int id=Integer.parseInt(sid);
		if(role=="学生") {
//			导入需要的DAO
			List<ClassRelation> relation =homeworkSelectServiceImpl.ClassRelation();
			List<HomeWork> list=homeworkSelectServiceImpl.HomeworkShow();
			List<User> user=homeworkSelectServiceImpl.TeacherShow();
			List<TeachRelation> trelation=homeworkSelectServiceImpl.TeachRelation();
			List<HomeWork> show=new ArrayList();
			List<User> timg=new ArrayList();
			List<TeachRelation> list1=new ArrayList();
			//判断学生的id查找对应的homework
			for (ClassRelation  c : relation) {
				if(id==c.getUser().getId()) {
					for (HomeWork h : list) {
						if(h.getTeachRelation().getTrid()==c.getTeachRelation().getTrid()) {
							show.add(h);
							for (TeachRelation  t : trelation) {
								if(t.getTrid()==h.getTeachRelation().getTrid())
									for (User u : user) {
										if(t.getUser().getId()-1==u.getId()) {
											timg.add(u);
											
											
									}
								}	
							}		
						}
					}
				}
			}
			for (TeachRelation teachRelation : list1) {
				list1.add(teachRelation);
			}
//			设置el初始值
			request.setAttribute("relation", list1);
			request.setAttribute("homework", show);
			request.setAttribute("teachers", timg);	
			return "student-personal-center-homework";}
		else {
			return "";
		}
		   	
			
	};
}
