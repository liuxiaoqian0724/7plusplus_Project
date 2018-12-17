package com.sevenpp.qinglantutor.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.sevenpp.qinglantutor.entity.CourseInformation;

/**
*
* 项目名称：qinglantutorprj
* 类名称：StuCourseService
* 类描述：
* 创建人：rain
* 创建时间：2018年12月10日 下午2:23:47
* 修改人：rain
* 修改时间：2018年12月10日 下午2:23:47
* 修改备注：
* @version
*
*/
public interface CourseService {
	/**
	 * 
			* @Title: getCourseInfor 
			* @Description: 查找出老师，我的课程  所需要的数据
			* @param @param email
			* @param @return    入参
			* @return List<CourseInformation>    返回类型
			* @author （作者） 
			* @throws
			* @date 2018年12月12日 下午2:37:31 
			* @version V1.0   
	 */
	 public List<CourseInformation> getCourseInfor(String email);
	 
	 /**
	  * 
	 		* @Title: getRoleByEmail 
	 		* @Description: 登录后由cookie得到的邮箱，得知身份是谁
	 		* @param @param email
	 		* @param @return    入参
	 		* @return String    返回类型
	 		* @author （作者） 
	 		* @throws
	 		* @date 2018年12月12日 下午3:51:49 
	 		* @version V1.0   
	  */
	 public String getRoleByEmail(String email);
	 
	 /**
	  * 
	 		* @Title: insertReview 
	 		* @Description: 学生，我的课程， 作评价完后插入操作
	 		* @param @param reviewTime
	 		* @param @param reviewContent
	 		* @param @param reviewStar
	 		* @param @param classRelationId    入参
	 		* @return void    返回类型
	 		* @author （作者） 
	 		* @throws
	 		* @date 2018年12月12日 下午2:38:18 
	 		* @version V1.0   
	  */
	 public void  insertReview(Timestamp reviewTime, String reviewContent, Integer reviewStar, Integer id);
	 
	 /**
	  * 
	 		* @Title: changeCourseTime 
	 		* @Description: 修改课程时间
	 		* @param @param startTime
	 		* @param @param endTime
	 		* @param @param crid    入参
	 		* @return void    返回类型
	 		* @author （作者） 
	 		* @throws
	 		* @date 2018年12月12日 下午6:24:25 
	 		* @version V1.0   
	  */
	 public void changeCourseTime(String startTime,String endTime,Integer crid);
	 
	 /**
	  * 
	 		* @Title: insertHomework 
	 		* @Description: 	插入作业
	 		* @param @param crid
	 		* @param @param content
	 		* @param @param time    入参
	 		* @return void    返回类型
	 		* @author （作者） 
	 		* @throws
	 		* @date 2018年12月13日 下午8:48:14 
	 		* @version V1.0   
	  */
	 public void insertHomework(Integer crid,String content,String time);
}

	