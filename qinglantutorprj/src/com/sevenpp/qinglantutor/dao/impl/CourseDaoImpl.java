package com.sevenpp.qinglantutor.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.CourseDao;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;

/**
*
* 项目名称：qinglantutorprj
* 类名称：StuCourseDaoImpl
* 类描述：学生课程的dao接口类的实现
* 创建人：rain
* 创建时间：2018年12月10日 上午11:15:45
* 修改人：rain
* 修改时间：2018年12月10日 上午11:15:45
* 修改备注：
* @version
*
*/
@Repository
public class CourseDaoImpl implements CourseDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public User getUserByEmail(String email) {
		/**
		* getUserByEmail    根据cookie中的邮箱查找用户表信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where email = ?");
		query.setString(0, email);
		List<User> list =  query.list();
		return list.get(0);
	}


	public void insertReview(Date reviewTime, String reviewContent, Integer reviewStar, ClassRelation classRelation) {
		/**
		* insertReview	插入评论
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		Review review = new Review();
		review.setReviewTime(reviewTime);
		review.setReviewContent(reviewContent);
		review.setReviewStar(reviewStar);
		review.setClassRelation(classRelation);
		session.save(review);
	}


	public ClassRelation getClassRelationByCrid(Integer crid) {
		/**
		* getClassRelationByCrid	查询上课关系表
		* TODO(这里描述这个方法适用条件 – 可选)
		* TODO(这里描述这个方法的执行流程 – 可选)
		* TODO(这里描述这个方法的使用方法 – 可选)
		* TODO(这里描述这个方法的注意事项 – 可选)
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ClassRelation where crid = ?");
		query.setInteger(0, crid);
		List<ClassRelation> list = query.list();
		return list.get(0);
	}
	
}

	