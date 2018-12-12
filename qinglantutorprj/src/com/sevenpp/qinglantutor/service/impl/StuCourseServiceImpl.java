package com.sevenpp.qinglantutor.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.StuCourseDaoImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.CourseInformation;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.StuCourseService;


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
public class StuCourseServiceImpl implements StuCourseService {
	
		@Resource
		private  StuCourseDaoImpl stuCourseDaoImpl;
		
		/**
		* getCourseInfor	把从数据库中查找出来的信息组成集合传给前端 
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		public List<CourseInformation> getCourseInfor(String email) {
			
			List<CourseInformation> list = new ArrayList<CourseInformation>();
			User student = this.stuCourseDaoImpl.getUserByEmail(email);
			List<ClassRelation> classRelationList = student.getClassRelation();
			
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
			return list;
		}
		
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
		public void  insertReview(Date reviewTime, String reviewContent, Integer reviewStar, Integer classRelationId) {
			ClassRelation classRelation = this.stuCourseDaoImpl.getClassRelationByCrid(classRelationId);
			this.stuCourseDaoImpl.insertReview(reviewTime, reviewContent, reviewStar, classRelation);
		}
}	