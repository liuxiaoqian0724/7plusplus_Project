		
		package com.sevenpp.qinglantutor.controller.tutorlist;

		import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.entity.Conditions;
import com.sevenpp.qinglantutor.service.impl.TutorListServiceImpl;
		
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
			
			@RequestMapping(value="/conditions/{schoolType}")
			public String showConditions(HttpServletRequest request,HttpServletResponse response,
					Model model,@PathVariable String schoolType) {
				System.out.println("conditions");
				HttpSession session=request.getSession();
//				session.invalidate();
				//乱码问题
				response.setContentType("text/html;charset=utf-8");
				response.setCharacterEncoding("utf-8");
				//添加条件
//				conditions.add(condition);
				
				//得到课程
				List<Object[]> courses=this.tutorListServiceImpl.courses();
				List<Object[]> grades=null;
				session.setAttribute("schooltype", schoolType);
				//判断schooltype有没有传值
				if(schoolType.equals("0")) {	//不分年级
					//得到所有年级
					System.out.println("schooltype=0");
					grades=this.tutorListServiceImpl.grades();
				}else {
					System.out.println("schooltype!=0");
					grades=this.tutorListServiceImpl.gradesBySchoolType(schoolType);
				}
				
				request.setAttribute("courses", courses);
				request.setAttribute("grades", grades);

				//实验
				List<Object[]> shiyan=this.tutorListServiceImpl.find();
				
				session.setAttribute("shiyan", shiyan);
				System.out.println();
				
				//创建json对象，并写入数据
//				JSONObject object = new JSONObject();
//				//设置json对象的属性
//				object.put("courses", courses);
//				object.put("grades", grades);
//				System.out.println(object.toString());
//				//把json数据返回给浏览器
//				try {
//					response.getWriter().write(object.toString());
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//						
//				}
				if(session.getAttribute("conditions")!=null) {
					System.out.println("conditions:");
					System.out.println(session.getAttribute("conditions").toString());
				}
				return "tutorlisted";
			}
}

	