
		package com.sevenpp.qinglantutor.dao.impl;

		import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：ConditionsDaoImpl
		* 类描述：查询符合条件的家教老师
		* 创建人：rain
		* 创建时间：2018年12月10日 下午4:52:46
		* 修改人：rain
		* 修改时间：2018年12月10日 下午4:52:46
		* 修改备注：
		* @version
		*
		*/
		@Repository
		public class ConditionsDaoImpl {
			@Resource
			private SessionFactory sessionFactory;
			
			public String findHql(int grade,int subject,String department,String sex,String major) {
				String sql="select a.id,username,stuimg,introduce,price,teacherage from tbl_user a,tbl_myjob b,tbl_myjobgrade c,tbl_myjobcourse d "
						+ "where a.id=b.tid and b.jid=c.jid and b.jid=d.jid";
				if(grade!=0)
					sql+="and c.gid='+grade+'";
				if(subject!=0)
					sql+="and d.cid='+subject+'";
				if(!department.equals("0"))
					sql+="and a.address='+department+'";
				if(!sex.equals("0"))
					sql+="and a.sex='+sex+'";
				if(!major.equals("0"))
					sql+="and a.major='+major+'";
				return sql;
			}
			
			/**
			 * 
			 * @Title: findReviewStarById 
			 * @Description: TODO 根据老师id查询评价星级 
			 * @param @param id
			 * @param @return    入参
			 * @return int    返回类型
			 * @author cuishan
			 * @throws
			 * @date 2018年12月12日 上午10:52:04 
			 * @version V1.0   
			 */
			public int findReviewStarById(int id) {
				String Hql="select avg(reviewStar) from Review where crid in("
						+ "select crid from ClassRelation where trid in("
						+ "select trid from TeachRelation where tid=1))";
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createQuery(Hql);
				int star=((Number)q.uniqueResult()).intValue();
				return star;
			}
			/**
			 * 
			 * @Title: findGidByGname 
			 * @Description: 根据年级名查询出对应的年级id
			 * @param @param gname
			 * @param @return    入参
			 * @return int    返回类型
			 * @author cuishan
			 * @throws
			 * @date 2018年12月11日 下午5:07:31 
			 * @version V1.0   
			 */
			public int findGidByGname(String gname) {
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createQuery("select gid from Grade where gname=?");
				q.setParameter(0, gname);
				int gid=((Number)q.uniqueResult()).intValue();
				return gid;
			}
			
			/**
			 * 
			 * @Title: findCidByCname 
			 * @Description: TODO(这里用一句话描述这个方法的作用) 
			 * @param @param cname
			 * @param @return    入参
			 * @return int    返回类型
			 * @author cuishan
			 * @throws
			 * @date 2018年12月11日 下午5:10:48 
			 * @version V1.0   
			 */
			public int findCidByCname(String cname) {
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createQuery("select cid from Course where cname=?");
				q.setParameter(0, cname);
				int cid=((Number)q.uniqueResult()).intValue();
				return cid;
			}
			
			/**
			 * 
			 * @Title: findTutorByConditions 
			 * @Description: TODO 查询符合条件的老师的user表中的相应信息
			 * @param @param grade
			 * @param @param subject
			 * @param @param department
			 * @param @param sex
			 * @param @param major
			 * @param @return    入参
			 * @return List<Object[]>    返回类型
			 * @author （作者） 
			 * @throws
			 * @date 2018年12月12日 上午11:05:50 
			 * @version V1.0   
			 */
			public List<Object[]> findTutorOnUserByConditions(int grade,int subject,String department,String sex,String major){
				Session session=this.sessionFactory.getCurrentSession();
				String Hql=this.findHql(grade, subject, department, sex, major);
				Query q=session.createQuery(Hql);
				return q.list();
			}
			
			/**
			 * 
			 * @Title: findTutorOnMyJobByConditions 
			 * @Description: TODO 查询符合条件的老师的Myjob表中的相应信息()
			 * @param @param id
			 * @param @return    入参
			 * @return List<Object[]>    返回类型
			 * @author cuishan
			 * @throws
			 * @date 2018年12月12日 下午2:46:33 
			 * @version V1.0   
			 */
//			public List<Object[]> findTutorOnMyJobByConditions(int id){
//				
//			}
			
}
