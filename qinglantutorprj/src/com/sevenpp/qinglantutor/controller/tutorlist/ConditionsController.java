package com.sevenpp.qinglantutor.controller.tutorlist;

import java.io.UnsupportedEncodingException;
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
				response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				try {
					request.setCharacterEncoding("UTF-8");
				} catch (UnsupportedEncodingException e) {		
					e.printStackTrace();
				}
				HttpSession session=request.getSession();
				if(subject.equals("yuwen"))
					subject="语文";
				if(subject.equals("shuxue"))
					subject="数学";
				if(subject.equals("yingyu"))
					subject="英语";
				if(subject.equals("wuli"))
					subject="物理";
				if(subject.equals("huaxue"))
					subject="化学";
				if(subject.equals("shengwu"))
					subject="生物";
				if(subject.equals("dili"))
					subject="地理";
				if(subject.equals("zhengzhi"))
					subject="政治";
				if(subject.equals("lishi"))
					subject="历史";
				List conditions=null;
				if(session.getAttribute("conditions")!=null) {
					conditions=(List) session.getAttribute("conditions");
				}else {
					conditions=new ArrayList();
					for(int i=0;i<6;i++) 
						conditions.add("0");
				}
				conditions=this.conditionsServiceImpl.addConditions(conditions, grade, subject, department, sex, major);
				session.setAttribute("conditions", conditions);
				String sortcondition="0";
				if(session.getAttribute("sortcondition")!=null) 
					sortcondition=(String) session.getAttribute("sortcondition");
				String schooltype="0";
				if(session.getAttribute("schooltype")!=null) 
					schooltype=(String) session.getAttribute("schooltype");
				String schoolType="0";
				if(schooltype.equals("小学"))
					schoolType="xiaoxue";
				if(schooltype.equals("初中"))
					schoolType="chuzhong";
				if(schooltype.equals("高中"))
					schoolType="gaozhong";
				return new ModelAndView("redirect:/tutorlist/conditions/"+schoolType+"/"+sortcondition);
			}
			
			@RequestMapping(value="/deleteconditions/{grade}/{subject}/{department}/{sex}/{major}")
			public ModelAndView deleteconditions(HttpServletRequest request,HttpServletResponse response,
					Model model,@PathVariable String grade,@PathVariable String subject,
					@PathVariable String department,@PathVariable String sex,@PathVariable String major) {
				HttpSession session=request.getSession();
				List conditions=(List)request.getSession().getAttribute("conditions");
				conditions=this.conditionsServiceImpl.deleteConditions(conditions, grade, subject, department, sex, major);
				session.setAttribute("conditions", conditions);
				String sortcondition=(String) session.getAttribute("sortcondition");
				String schooltype=(String) session.getAttribute("schooltype");
				String schoolType="0";
				if(schooltype.equals("小学"))
					schoolType="xiaoxue";
				if(schooltype.equals("初中"))
					schoolType="chuzhong";
				if(schooltype.equals("高中"))
					schoolType="gaozhong";
				return new ModelAndView("redirect:/tutorlist/conditions/"+schoolType+"/"+sortcondition);
			}
}