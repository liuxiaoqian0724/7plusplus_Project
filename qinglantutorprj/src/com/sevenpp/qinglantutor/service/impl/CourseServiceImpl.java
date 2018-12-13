package com.sevenpp.qinglantutor.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.CourseDaoImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.CourseService;


/**
*
* 项目名称：qinglantutorprj
* 类名称：StuCourseServiceImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月10日 下午2:56:09
* 修改人：rain
* 修改时间：2018年12月10日 下午2:56:09
* 修改备注：
* @version
*
*/
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
		@Resource
		private  CourseDaoImpl courseDaoImpl;
		
		public List<CourseInformation> getCourseInfor(String email) {			
			/**
			 * getCourseInfor	把从数据库中查找出来的信息组成集合传给前端 
			 * @param name
			 * @param @return 设定文件
			 * @return String DOM对象
			 * @Exception 异常对象
			 * @since CodingExample Ver(编码范例查看) 1.1
			 */
			User user = this.courseDaoImpl.getUserByEmail(email);
			List<CourseInformation> list = new ArrayList<CourseInformation>();
			/**
			 * 如果身份是学生的话，则执行学生的课程信息页面
			 */
			if(user.getRole().startsWith("学生")) {
					List<ClassRelation> classRelationList = user.getClassRelation();
					ClassRelation classRelation = null;
					List<HomeWork> homeWork = new ArrayList<HomeWork>();
					Course course = null;
					User teacher = null;
					TeachRelation teachRelation = null;
					List<String> homework = new ArrayList<String>();
					for(int i = 0;i<classRelationList.size();i++) {
						/**
						 * 从数据库中查找的各个数据
						 */
						CourseInformation courseInformation = new CourseInformation();
						classRelation = classRelationList.get(i);
						teachRelation = classRelation.getTeachRelation();
						teacher = teachRelation.getUser();
						course = teachRelation.getCourse();
						homeWork = classRelation.getHomeWorks();
						for(int j=0;j< homeWork.size();j++) {
							SimpleDateFormat format = new SimpleDateFormat("MM-dd");
							homework.add(format.format(homeWork.get(j).getTstartTime()));
						}
						
						/**
						 * 处理数据存入集合中，方便后台使用
						 */
						courseInformation.setCrid(classRelation.getCrid());
						courseInformation.setSubject(course.getCname());
						courseInformation.setImg(teacher.getUserImg());
						courseInformation.setName(teacher.getUserName());
						courseInformation.setHomework(homework);				
						courseInformation.setStartTime(teachRelation.getStartTime());
						courseInformation.setEndTime(teachRelation.getEndTime());
						
						list.add(courseInformation);
					}
			}
			/**
			 * 如果身份是老师的话，则执行老师的我的课程信息页面
			 */
			else {
					List<TeachRelation> teachRelationList = user.getTeachRelations();
					TeachRelation teachRelation = null;
					Course course = null;
					User student = null;
					List<HomeWork> homeWork = new ArrayList<HomeWork>();
					List<ClassRelation> classRelationList = new ArrayList<ClassRelation>();
					for(int i=0;i<teachRelationList.size();i++) {
						teachRelation = teachRelationList.get(i);
						course = teachRelation.getCourse();
						classRelationList = teachRelation.getClassRelation();
						for(int j=0;j<classRelationList.size();j++) {
							List<String> homework = new ArrayList<String>();
							student = classRelationList.get(j).getUser();
							homeWork = classRelationList.get(j).getHomeWorks();
							for(int m=0;m<homeWork.size();m++) {
								SimpleDateFormat format = new SimpleDateFormat("MM-dd");
								homework.add(format.format(homeWork.get(j).getTstartTime()));
							}
							
							CourseInformation courseInformation = new CourseInformation();
							courseInformation.setCrid(classRelationList.get(j).getCrid());
							courseInformation.setSubject(course.getCname());
							courseInformation.setImg(student.getUserImg());
							courseInformation.setName(student.getRealName());
							courseInformation.setHomework(homework);
							courseInformation.setStartTime(teachRelation.getStartTime());
							courseInformation.setEndTime(teachRelation.getEndTime());
							
							list.add(courseInformation);
						}
					}
			}
			
			return list;
		}
		
		public void  insertReview(Date reviewTime, String reviewContent, Integer reviewStar, Integer classRelationId) {
			/**
			 * @Title: insertReview 
			 * @Description: 插入评论
			 * @param @param reviewTime
			 * @param @param reviewContent
			 * @param @param reviewStar
			 * @param @param classRelation    入参
			 * @return void    返回类型
			 * @author （作者） 
			 * @throws
			 * @date 2018年12月12日 上午10:28:59 
			 * @version V1.0   
			 */
			ClassRelation classRelation = this.courseDaoImpl.getClassRelationByCrid(classRelationId);
			this.courseDaoImpl.insertReview(reviewTime, reviewContent, reviewStar, classRelation);
		}

		public String getRoleByEmail(String email) {
			/**
			* getRoleByEmail	得到登录用户的身份，区别是学生还是老师网页
			* @param name
			* @param @return 设定文件
			* @return String DOM对象
			* @Exception 异常对象
			* @since CodingExample Ver(编码范例查看) 1.1
			*/
			return this.courseDaoImpl.getUserByEmail(email).getRole();
				
		}

		public void changeCourseTime(String startTime, String endTime, Integer crid) {
			/**
			* changeCourseTime	修改课程的时间
			* @param name
			* @param @return 设定文件
			* @return String DOM对象
			* @Exception 异常对象
			* @since CodingExample Ver(编码范例查看) 1.1
			*/
			ClassRelation classRelation = this.courseDaoImpl.getClassRelationByCrid(crid);
			this.courseDaoImpl.changeCourseTime(startTime, endTime, classRelation.getTeachRelation().getTrid());
		}

		public void insertHomework(Integer crid, String content, String time) {
			/**
			* insertHomework 	插入作业表数据
			* @param name
			* @param @return 设定文件
			* @return String DOM对象
			* @Exception 异常对象
			* @since CodingExample Ver(编码范例查看) 1.1
			*/
			ClassRelation classRelation = this.courseDaoImpl.getClassRelationByCrid(crid);
			SimpleDateFormat format = new SimpleDateFormat("MM-dd");
			Date deadlineTime = new Date();
			try {
				deadlineTime = format.parse(time);
			} catch (ParseException e) {
						e.printStackTrace();
			}
			this.courseDaoImpl.insertHomework(deadlineTime, content, classRelation,classRelation.getTeachRelation());
		}


}	