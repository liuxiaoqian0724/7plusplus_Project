package com.sevenpp.qinglantutor.controller.course;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenpp.qinglantutor.service.impl.TeachPlanServiceImpl;

/**
*
* 项目名称：qinglantutorprj
* 类名称：TeachPlanController
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午7:22:29
* 修改人：rain
* 修改时间：2018年12月14日 下午7:22:29
* 修改备注：
* @version
*
*/
@Controller
public class TeachPlanController {
	
	@Resource
	private TeachPlanServiceImpl  teachPlanServiceImpl;
	
	@RequestMapping("teachPlanInformation")
	public String getTeachPlanInformation(HttpServletRequest request) {
		String email = new String("lisi@qq.com");
		List<Object> list = this.teachPlanServiceImpl.getTeachPlanInfor(email);
		request.setAttribute("teachPlanInformationList", list);
		
		if(this.teachPlanServiceImpl.getRoleByEmail(email).getRole().startsWith("老师")) {
			return "teacher-personal-center-plan";
		}else {
			return "student-personal-center-plan";
		}
		
	}
	
	@RequestMapping("teachPlanEdit")
	@ResponseBody
	public String teachPlanEdit(@RequestParam(value="id")Integer id ,@RequestParam(value="content")String content
			,@RequestParam(value="time")String time) {
		this.teachPlanServiceImpl.editTeachPlan(content, time, id);
		return "反馈成功";
	}
	
	@RequestMapping("teachPlanDelete")
	@ResponseBody
	public String teachPlanDelete(@RequestParam(value="id")Integer id) {
		this.teachPlanServiceImpl.deleteTeachPlan(id);
		return "反馈成功";
	}
	
	@RequestMapping("teachPlanAdd")
	@ResponseBody
	public int teachPlanAdd(@RequestParam(value="trid")Integer trid ,@RequestParam(value="content")String content
			,@RequestParam(value="time")String time) {
		int i = this.teachPlanServiceImpl.addTeachPlan(trid, content, time);
		return i;
	}
}

	