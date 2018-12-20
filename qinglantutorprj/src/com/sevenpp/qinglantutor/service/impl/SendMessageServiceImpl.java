package com.sevenpp.qinglantutor.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.SendMessageDaoImpl;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.Grade;
import com.sevenpp.qinglantutor.entity.MyJob;
import com.sevenpp.qinglantutor.entity.Time;
import com.sevenpp.qinglantutor.service.SendMessageService;

/**
*code is far away from bug with the animal protecting
*  ┏┓　　　┏┓
*┏┛┻━━━┛┻┓
*┃　　　　　　　┃ 　
*┃　　　━　　　┃
*┃　┳┛　┗┳　┃
*┃　　　　　　　┃
*┃　　　┻　　　┃
*┃　　　　　　　┃
*┗━┓　　　┏━┛
*　　┃　　　┃神兽保佑
*　　┃　　　┃代码无BUG！
*　　┃　　　┗━━━┓
*　　┃　　　　　　　┣┓
*　　┃　　　　　　　┏┛
*　　┗┓┓┏━┳┓┏┛
*　　　┃┫┫　┃┫┫
*　　　┗┻┛　┗┻┛ 
*　　　
* @author 作者 :Mr.Ren
* @version 创建时间：2018年12月11日 下午7:19:57
* 类说明
*/
@Service
@Transactional
public class SendMessageServiceImpl implements SendMessageService {
	@Resource
	private SendMessageDaoImpl sendMessageDaoImpl;
	private Set<Course> courses = new HashSet<Course>() ;
	private Set<Grade> grades  = new HashSet<Grade>();
	private Set<Time> times  = new HashSet<Time>();
	@Override
	public Boolean sendMessage(Map<String, String>map,String email) {
				/**
				* sendMessage(发布求职信息)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
		MyJob myJob = new MyJob();
		myJob.setPrice(Integer.parseInt(map.get("price")));
		myJob.setTeacherAge(map.get("teacherAge"));
		myJob.setAddress(map.get("address"));
		String course = map.get("course");
		String[] myCourses = course.substring(0,course.length()).split(";");
		for (int i = 0; i < myCourses.length; i++) {
			Course course2 = new Course();
			course2.setCname(myCourses[i]);
			courses.add(course2);
			
		}
		myJob.setCourses(courses);
		String grade = map.get("grade");
		String[] myGrades = grade.substring(0,grade.length()).split(";");
		for (int i = 0; i < myGrades.length; i++) {
			Grade grade2 = new Grade();
			grade2.setGname(myGrades[i]);
			grades.add(grade2);
		}
		myJob.setGrades(grades);
		myJob.setMyExperience(map.get("experience"));
		myJob.setSuccess(map.get("successCase"));
		String time = map.get("times");
		String[] myTimes = time.substring(0,time.length()).split(",");
		for (int i = 0; i < myTimes.length; i++) {
			Time time2= new Time();
			time2.setTid(Integer.parseInt(myTimes[i]));
			times.add(time2);
		}
		int id = sendMessageDaoImpl.findId(email);
		myJob.getUser().setId(id);
		return sendMessageDaoImpl.sendMessage(myJob);
	}

}
