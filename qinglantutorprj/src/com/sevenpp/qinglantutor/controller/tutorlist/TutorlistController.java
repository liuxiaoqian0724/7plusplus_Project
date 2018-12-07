		
		package com.sevenpp.qinglantutor.controller.tutorlist;

		import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.Grade;
import com.sevenpp.qinglantutor.service.impl.TutorListServiceImpl;
		
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorlistControllerImpl
		* 类描述：
		* 创建人：rain
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
			public String showConditions(HttpServletRequest request,HttpServletResponse response,Model model,@PathVariable String schoolType) {
				//得到课程
				List<Course> courses=this.tutorListServiceImpl.courses();
				List<Grade> grades=null;
				//判断schooltype有没有传值
				if(schoolType.equals("0")) {	//不分年级
					//得到所有年级
					grades=this.tutorListServiceImpl.grades();
				}else {
					grades=this.tutorListServiceImpl.gradesBySchoolType(schoolType);
				}
				
				//创建json对象，并写入数据
				JSONObject object = new JSONObject();
				//设置json对象的属性
				object.put("courses", courses);
				object.put("grades", grades);
				System.out.println(object.toString());
				//把json数据返回给浏览器
				try {
					response.getWriter().write(object.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
						
				}
				return "tutorlisted";
			}
			
			
}

	