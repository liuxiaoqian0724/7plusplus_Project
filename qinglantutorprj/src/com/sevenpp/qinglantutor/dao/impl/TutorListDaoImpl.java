
		package com.sevenpp.qinglantutor.dao.impl;

		import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TutorListDao;
import com.sevenpp.qinglantutor.entity.UserInfo;

		/**
 		*	
		*项目名称：qinglantutorprj
		* 类名称：ConditionsDaoImpl
		* 类描述：用于家教库页查询各种条件
		* 创建人：cuishan
		* 创建时间：2018年12月5日 下午3:19:55
		* 修改人：cuishan
		* 修改时间：2018年12月5日 下午3:19:55
		* 修改备注：
		* @version
		*
		*/
		@Repository
		public class TutorListDaoImpl implements TutorListDao {
			@Resource
			private SessionFactory sessionFactory;
			
			@Override
			/**
			 * 
			 * @Title: grades 
			 * @Description: 查询所有年级
			 * @param @return
			 * @return List<Grade>  
			 * @author cuishan
			 * @throws
			 * @date 2018年12月5日 下午3:25:17 
			 * @version V1.0   
			 */
			public List<Object[]> findAllGrades(){
				Session session = this.sessionFactory.getCurrentSession();
				Query q = session.createQuery("select gid,gname from Grade where schooltype != '大学' ");
//				q.setFirstResult(0).setMaxResults(9);
				return q.list();
			}
			
			@Override
			/**
			 * 
			 * @Title: courses 
			 * @Description: 查询所有课程 
			 * @param @return 
			 * @return List<Course>
			 * @author （作者） 
			 * @throws	
			 * @date 2018年12月5日 下午3:30:44 
			 * @version V1.0   
			 */
			public List<Object[]> findAllCourses(){
				Session session = this.sessionFactory.getCurrentSession();
				Query q = session.createQuery("select cid,cname from Course");
				q.setFirstResult(0).setMaxResults(9);
				return q.list();
			}

			@Override
			/**
			 * 
			 * @Title: gradesBySchoolType 
			 * @Description: 根据传参的年级类型显示年级
			 * @param @param schoolType
			 * @param @return  
			 * @return List<Grade>
			 * @author cuishan 
			 * @throws
			 * @date 2018年12月5日 下午4:48:55 
			 * @version V1.0   
			 */
			public List<Object[]> findGradesBySchoolType(String schoolType) {
				Session session=this.sessionFactory.getCurrentSession();
				Query q=null;
				if(schoolType.equals("小学")) {	//显示小学的年级
					q=session.createQuery("select gid,gname from Grade where schooltype=:schooltype");
					q.setString("schooltype", "小学");
				}else if(schoolType.equals("初中")) {	//显示初中的年级
					q=session.createQuery("select gid,gname from Grade where schooltype=:schooltype");
					q.setString("schooltype", "初中");
				}else if(schoolType.equals("高中")) {		//显示高中的年级
					q=session.createQuery("select gid,gname from Grade where schooltype=:schooltype");
					q.setString("schooltype", "高中");
				}
				q.setFirstResult(0).setMaxResults(9);
				return q.list();	
			}
}
	