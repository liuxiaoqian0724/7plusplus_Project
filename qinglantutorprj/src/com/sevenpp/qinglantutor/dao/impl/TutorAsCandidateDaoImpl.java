
		package com.sevenpp.qinglantutor.dao.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorAsCandidan
		* 类描述：
		* 创建人：rain
		* 创建时间：2019年5月13日 下午2:51:34
		* 修改人：rain
		* 修改时间：2019年5月13日 下午2:51:34
		* 修改备注：
		* @version
		*
		*/

		@Repository
		public class TutorAsCandidateDaoImpl {
			@Resource
			private SessionFactory sessionFactory;

			/**
			 * 
					* @Title: findReviewStar 
					* @Description: 查询星级
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月13日 下午3:14:04 
					* @version V1.0   
			 */
			public Integer findReviewStar(User user) {
				Session session = this.sessionFactory.getCurrentSession();
//				if(user.getTeachRelations().get(0).getClassRelation().get(0).getReviews().get(0).getReviewStar()!=null)
//					return user.getTeachRelations().get(0).getClassRelation().get(0).getReviews().get(0).getReviewStar();
				String sql="select avg(reviewStar) from tbl_review where crid in( \r\n" + 
						"	select crid from tbl_classrelation where trid in(\r\n" + 
						"	select trid from tbl_teach where tid=?))";
				SQLQuery sq=session.createSQLQuery(sql);
				sq.setParameter(0, user.getId());
				int star1=0;
				List list=sq.list();
				for (Object object : list) {
					System.out.println("content："+object);
					if(object!=null) {
						Float star=((Number)sq.uniqueResult()).floatValue();
						star1=Math.round(star);
					}
				}
				return star1;
			} 
			
			/**
			 * 
					* @Title: findPrice 
					* @Description: 查询价格 
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:26:03 
					* @version V1.0   
			 */
			public Integer findPrice(User user) {
				Session session=this.sessionFactory.getCurrentSession();
				if(user.getMyJobs().get(0).getPrice()!=null) 
					return user.getMyJobs().get(0).getPrice(); 
				return 0;
			}
			
			/**
			 * 
					* @Title: findteachage 
					* @Description: 查询教龄
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:35:04 
					* @version V1.0   
			 */
			public Integer findteachage(User user) {
				Session session=this.sessionFactory.getCurrentSession();
				String teacherage="";
				Integer teachage = 0;
				if(user.getMyJobs().get(0).getTeacherAge()!=null) {
					teacherage=user.getMyJobs().get(0).getTeacherAge();
					teachage=Integer.valueOf(teacherage.substring(0, teacherage.indexOf("-")));
				}
				return teachage;
			}
			
			/**
			 * 
					* @Title: findDataIntegrity 
					* @Description:查询资料完整度
					* @param @param user
					* @param @return    入参
					* @return double    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:37:44 
					* @version V1.0   
			 */
			public double findDataIntegrity(User user) {
				Session session=this.sessionFactory.getCurrentSession();
				Field[] fields = user.getClass().getDeclaredFields();
				int notnullsum=0;
				for (Field field : fields) {
					if(field!=null)
						notnullsum++;
				}
				return (notnullsum-3)/21;
			}
			
			/**
			 * 
					* @Title: findstudentsum 
					* @Description: 教过的学生数
					* @param @param user
					* @param @return    入参
					* @return int    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 下午2:29:17 
					* @version V1.0   
			 */
			public int findteachstrsum(User user) {
				Session session=this.sessionFactory.getCurrentSession();
				int teachstusum=0;
				teachstusum=user.getTeachRelations().size();
				return teachstusum;
			}
		}

	