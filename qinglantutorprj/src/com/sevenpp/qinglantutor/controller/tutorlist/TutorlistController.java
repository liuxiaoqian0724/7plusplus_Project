		
		package com.sevenpp.qinglantutor.controller.tutorlist;

		
		import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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

import com.sevenpp.qinglantutor.entity.Page;
import com.sevenpp.qinglantutor.entity.UserInfo;
import com.sevenpp.qinglantutor.service.impl.ConditionsServiceImpl;
import com.sevenpp.qinglantutor.service.impl.TutorListServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;
		
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorlistControllerImpl
		* 类描述：
		* 创建人：cuishan
		* 创建时间：2018年12月5日 下午4:18:56
		* 修改人：rain
		* 修改时间：2018年12月5日 下午4:18:56
		* 修改备注：
		* @version
		*
		*/
		
		@Controller
		@RequestMapping("/tutorlist")
		public class TutorlistController {
			
			@Resource
			private TutorListServiceImpl tutorListServiceImpl;
			@Resource
			private ConditionsServiceImpl conditionsServiceImpl;
			private PrintWriter writer;
			
			@RequestMapping(value="/conditions/{schoolType}/{sortcondition}")
			public String showConditions(HttpServletRequest request,HttpServletResponse response,
					Model model,@PathVariable String schoolType,@PathVariable String sortcondition) {
				HttpSession session=request.getSession();
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "POST");
				response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
				response.setHeader("Access-Control-Allow-Credentials","true");
				response.setContentType("textml;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				Cookie[]cookies = request.getCookies();
				System.out.println(cookies.length);
				String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
				String EMAIL = "";
				response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				try {
					writer = response.getWriter();
				} catch (IOException e1) {

				}
//				session.invalidate();
				if (CookieUtils.getCookieFromCookies(cookies, "EMAIL") == null) {
					System.out.println("没有登录");
					writer.write("请先注册或登录");
					writer.flush();
					writer.close();
				}else {
					session.setAttribute("islogin", 1);
				}
				System.out.println("schooltype:"+schoolType+"sortcondition:"+sortcondition);
				session.setAttribute("sortcondition", sortcondition);
				session.setAttribute("schooltype", schoolType);
				List<Object[]> courses=this.tutorListServiceImpl.findAllCourses();
				List<Object[]> grades=null;
				if(schoolType.equals("0")) {	
					System.out.println("schooltype=0");
					grades=this.tutorListServiceImpl.findAllGrades();
					grades=grades.subList(0,9);
				}else {
					if(schoolType.equals("xiaoxue"))
						schoolType="小学";
					if(schoolType.equals("chuzhong"))
						schoolType="初中";
					if(schoolType.equals("gaozhong")) {
						schoolType="高中";
					}
					System.out.println("schooltype!=0");
					session.setAttribute("schooltype", schoolType);
					grades=this.tutorListServiceImpl.findGradesBySchoolType(schoolType);
				}
				System.out.println("gradesize："+grades.size());
				session.setAttribute("courses", courses);
				session.setAttribute("grades", grades);
				
				if(session.getAttribute("conditions")!=null) {
					System.out.println("conditions:");
					System.out.println(session.getAttribute("conditions").toString());
				}
				List conditions=null;
				if(session.getAttribute("conditions")!=null) {
					conditions=(List)session.getAttribute("conditions");
				}else {
					conditions=new ArrayList();
					for(int i=0;i<6;i++) {
						conditions.add("0");
					}
				}
				int gid=0;
				int cid=0;
				if(conditions!=null) {
					if(!((conditions.get(1).toString()).equals("0"))) {
						gid=this.conditionsServiceImpl.findGidByGname((String)conditions.get(1));
					}
					if(!((conditions.get(2).toString()).equals("0"))) {
						cid=this.conditionsServiceImpl.findCidByCname((String)conditions.get(2));
					}
				}
				List<UserInfo> tutors=new ArrayList<UserInfo>();
				tutors=this.conditionsServiceImpl.findTutorByAllConditions(gid, cid, (String)conditions.get(3), (String)conditions.get(4), (String)conditions.get(5),schoolType);
				System.out.println("tutors.size:"+tutors.size());
				if(sortcondition.equals("price")) 
					Collections.sort(tutors, UserInfo.Comparators.price);
				if(sortcondition.equals("reviewsum")) 
					Collections.sort(tutors, UserInfo.Comparators.reviewSum);
				if(sortcondition.equals("reviewstar"))
					Collections.sort(tutors, UserInfo.Comparators.reviewStar);
				if(sortcondition.equals("intellgence"))
					Collections.sort(tutors, UserInfo.Comparators.intellgenceSort);
				session.setAttribute("tutors", tutors);
				List<UserInfo> pageTutors=new ArrayList<UserInfo>();
				for(int i=0;i<4 && i<tutors.size();i++) {
					UserInfo userinfo=tutors.get(i);
					pageTutors.add(userinfo);
				}
				int totalcount=this.conditionsServiceImpl.findCountByPage(gid, cid, (String)conditions.get(3), (String)conditions.get(4), (String)conditions.get(5),schoolType);
				Page<UserInfo> pagetutors=new Page<UserInfo>(1,4);
				pagetutors.setList(pageTutors);
				pagetutors.setCurrentPageNum(1);
				pagetutors.setPageSize(4);
				pagetutors.setTotalCount(totalcount);
				session.setAttribute("totalcount", totalcount);
				System.out.println("totalcount:"+totalcount);
				System.out.println("tutorpage："+pagetutors.getTotalPageNum());
				model.addAttribute("pagetutors", pagetutors);
				return "tutorlisted";
			}
			

			@RequestMapping(value="/page/{pageNum}")
			public String TutorsByPage(HttpServletRequest request,Model model,@PathVariable String pageNum) {
				HttpSession session=request.getSession();
				int pagenum=Integer.parseInt(pageNum);
				List<UserInfo> tutors=(List<UserInfo>)session.getAttribute("tutors");
				List<UserInfo> pageTutors=new ArrayList<UserInfo>();
				for(int i=(pagenum-1)*4;i<pagenum*4 && i<tutors.size();i++) {
					UserInfo userinfo=tutors.get(i);
					pageTutors.add(userinfo);
				}
				int totalcount=(int)session.getAttribute("totalcount");
				Page<UserInfo> pagetutors=new Page<UserInfo>(pagenum,4);
				pagetutors.setList(pageTutors);
				pagetutors.setCurrentPageNum(pagenum);
				pagetutors.setPageSize(4);
				pagetutors.setTotalCount(totalcount);
				model.addAttribute("pagetutors", pagetutors);
				return "tutorlisted";
			}
}

