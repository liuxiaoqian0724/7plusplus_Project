
		package com.sevenpp.qinglantutor.controller.tutorlist;
		import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sevenpp.qinglantutor.service.impl.ConditionsServiceImpl;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：ConditionsController
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月10日 下午4:28:33
		* 修改人：rain
		* 修改时间：2018年12月10日 下午4:28:33
		* 修改备注：
		* @version
		*
		*/
		@Controller
		@RequestMapping("/change")
		public class ConditionsController {
			
			@Resource
			private ConditionsServiceImpl conditionsServiceImpl;
			
			@RequestMapping(value="/addconditions/{grade}/{subject}/{department}/{sex}/{major}")
			public ModelAndView addConditions(HttpServletRequest request,HttpServletResponse response,
					Model model,@PathVariable String grade,@PathVariable String subject,
					@PathVariable String department,@PathVariable String sex,@PathVariable String major)  {
				
				System.out.println(grade+subject+department+sex+major);
				//得到session
				HttpSession session=request.getSession();
				//创建条件对象
//				Object[] conditions = null;
				List conditions=null;
				if(session.getAttribute("conditions")!=null) {
					conditions=(List) session.getAttribute("conditions");
				}else {
					conditions=new ArrayList();
					conditions.add("0");
					conditions.add("0");
					conditions.add("0");
					conditions.add("0");
					conditions.add("0");
					conditions.add("0");
				}
				//不为0就改变数组值，为0就不改变数组值
				if(!grade.equals("0"))
					conditions.set(1, grade);
				if(!subject.equals("0"))
					conditions.set(2, subject);
				if(!department.equals("0"))
					conditions.set(3, department);
				if(!sex.equals("0"))
					conditions.set(4, sex);
				if(!major.equals("0"))
					conditions.set(5, major);
				session.setAttribute("conditions", conditions);
//				System.out.println("department:"+conditions.getDepartment());
				
				//将conditions中的gname,cname换成gid,cid;
				int gid=0;
				int cid=0;
				if(!grade.equals("0")) {
					gid=this.conditionsServiceImpl.findGidByGname(grade);
				}
				if(!subject.equals("0")) {
					cid=this.conditionsServiceImpl.findCidByCname(subject);
				}
//				System.out.println("gid:"+gid);
//				System.out.println("cid:"+cid);
				
				//得到schooltype
				String schooltype=(String) session.getAttribute("schooltype");
				System.out.println("schooltype:"+schooltype);
				
				//得到符合条件的老师列表
				List tutors=new ArrayList();
				tutors=this.conditionsServiceImpl.findTutorByAllConditions(gid, cid, department, sex, major);
				session.setAttribute("tutors", tutors);
				return new ModelAndView("redirect:/tutorlist/conditions/"+schooltype);
			}
			
			@RequestMapping(value="/deleteconditions/{grade}/{subject}/{department}/{sex}/{major}")
			public ModelAndView deleteconditions(HttpServletRequest request,HttpServletResponse response,
					Model model,@PathVariable String grade,@PathVariable String subject,
					@PathVariable String department,@PathVariable String sex,@PathVariable String major) {
				//0代表要删掉，其他是1
				HttpSession session=request.getSession();
				List conditions=(List)request.getSession().getAttribute("conditions");
				if(grade.equals("0"))
					conditions.set(1, "0");
				if(subject.equals("0"))
					conditions.set(2, "0");
				if(department.equals("0")) 
					conditions.set(3, "0");
				if(sex.equals("0"))
					conditions.set(4, "0");
				if(major.equals("0"))
					conditions.set(5, "0");
				session.setAttribute("conditions", conditions);
				
				//得到schooltype
				String schooltype=(String) session.getAttribute("schooltype");
				System.out.println("schoolty:"+schooltype);
				return new ModelAndView("redirect:/tutorlist/conditions/"+schooltype);
			}
}