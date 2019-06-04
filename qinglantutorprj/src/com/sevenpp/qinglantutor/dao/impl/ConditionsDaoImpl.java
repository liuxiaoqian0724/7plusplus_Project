
		package com.sevenpp.qinglantutor.dao.impl;

		import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.entity.UserInfo;

/**
		*
		* 椤圭洰鍚嶇О锛歲inglantutorprj
		* 绫诲悕绉帮細ConditionsDaoImpl
		* 绫绘弿杩帮細鏌ヨ绗﹀悎鏉′欢鐨勫鏁欒�佸笀
		* 鍒涘缓浜猴細rain
		* 鍒涘缓鏃堕棿锛�2018骞�12鏈�10鏃� 涓嬪崍4:52:46
		* 淇敼浜猴細rain
		* 淇敼鏃堕棿锛�2018骞�12鏈�10鏃� 涓嬪崍4:52:46
		* 淇敼澶囨敞锛�
		* @version
		*
		*/
		@Repository
		public class ConditionsDaoImpl {
			@Resource
			private SessionFactory sessionFactory;
			
//			private static List conditions;
//			static {
//				conditions=new ArrayList();
//				conditions.add("0");
//				conditions.add("0");
//				conditions.add("0");
//				conditions.add("0");
//				conditions.add("0");
//				conditions.add("0");
//			}
			
			/**
			 * 
					* @Title: addConditions聽
					* @Description: TODO 娣诲姞鎼滅储鏉′欢聽
					* @param @param conditions
					* @param @return 聽 聽鍏ュ弬
					* @return List 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�18鏃� 涓嬪崍3:10:22聽
					* @version V1.0 聽聽
			 */
			public List addConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				if(!grade.equals("0"))
					conditions.set(1, grade);
				if(!subject.equals("0"))
					conditions.set(2, subject);
				if(!department.equals("0"))
					conditions.set(3, department);
				if(!sex.equals("0"))
					conditions.set(4, sex);
				if(!major.equals("0"))
					conditions.set(5, major);
				return conditions;
			}
			
			/**
			 * 
					* @Title: deteleConditions聽
					* @Description: TODO鍒犻櫎鎼滅储鏉′欢
					* @param @param conditions
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return 聽 聽鍏ュ弬
					* @return List 聽 聽杩斿洖绫诲瀷
					* @author cuishan
					* @throws
					* @date 2018骞�12鏈�18鏃� 涓嬪崍3:13:50聽
					* @version V1.0 聽聽
			 */
			public List deteleConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				if(grade.equals("0"))
					conditions.set(1, "0");
				if(subject.equals("0"))
					conditions.set(2, "0");
				if(department.equals("0")) 
					conditions.set(3, "0");
				if(sex.equals("0"))
					conditions.set(4, "0");
				if(major.equals("0"))
					conditions.set(5, "0");
				return conditions;
			}
			
			/**
			 * 
			 * @Title: findHql聽
			 * @Description: TODO 婊¤冻鎵�鏈夋悳绱㈡潯浠剁殑sql璇彞 鍒嗛〉鏌ヨ
			 * @param @param grade
			 * @param @param subject
			 * @param @param department
			 * @param @param sex
			 * @param @param major
			 * @param @return 聽 聽鍏ュ弬
			 * @return String 聽 聽杩斿洖绫诲瀷
			 * @author  cuishan
			 * @throws
			 * @date 2018骞�12鏈�13鏃� 涓婂崍8:53:09聽
			 * @version V1.0 聽聽
			 */
			public String findSql(int grade,int subject,String department,String sex,String major,String schooltype) {
				String sql="select distinct a.id,username,userimg,introduce,price,teacherage from tbl_user a,tbl_myjob b,tbl_myjobgrade c,tbl_myjobcourse d "
						+ "where a.id=b.tid and b.jid=c.jid and b.jid=d.jid"+" ";
				if(!schooltype.equals("0")) {
					sql+="and gid in (SELECT gid from tbl_grade where schooltype ='"+schooltype+"')";
				}
				if(grade!=0)
					sql+="and c.gid='"+grade+"'";
				if(subject!=0)
					sql+="and d.cid='"+subject+"'";
				if(!department.equals("0"))
					sql+="and a.address='"+department+"'";
				if(!sex.equals("0"))
					sql+="and a.sex='"+sex+"'";
				if(!major.equals("0"))
					sql+="and a.major='"+major+"'";
				return sql;
			}

			/**
			 * 
			 * @Title: findReviewStarById聽
			 * @Description: TODO 鏍规嵁鑰佸笀id鏌ヨ璇勪环鏄熺骇聽
			 * @param @param id
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author cuishan
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓婂崍10:52:04聽
			 * @version V1.0 聽聽
			 */
			public int findReviewStarById(int id) {
				String sql="select avg(reviewStar) from tbl_review where crid in( \r\n" + 
						"	select crid from tbl_classrelation where trid in(\r\n" + 
						"	select trid from tbl_teach where tid=?))";
				Session session=this.sessionFactory.getCurrentSession();
				SQLQuery sq=session.createSQLQuery(sql);
				sq.setParameter(0, id);
				int star1=0;
				List list=sq.list();
				for (Object object : list) {
					if(object!=null) {
						Float star=((Number)sq.uniqueResult()).floatValue();
						star1=Math.round(star);
					}
				}
//				System.out.println("sq:"+sq.list().size());
//				System.out.println("result:"+(Number)sq.uniqueResult());
//				if(sq.list().isEmpty()) {
//					star1=0;
//				}else {
//					Float star=((Number)sq.uniqueResult()).floatValue();
//					star1=Math.round(star);
//				}
				return star1;
			}
			
			/**
			 * 
			 * @Title: findReviewSumById聽
			 * @Description: TODO 鏌ヨ姝ゅ鏁欑殑璇勪环鎬绘暟聽
			 * @param @param tid
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author cuishan
			 * @throws
			 * @date 2018骞�12鏈�13鏃� 涓婂崍10:18:37聽
			 * @version V1.0 聽聽
			 */
			public int findReviewSumById(int tid) {
				Session session=this.sessionFactory.getCurrentSession();
				String sql="select count(*) from tbl_review where crid in(\r\n" + 
						"	select crid from tbl_classrelation where trid in(\r\n" + 
						"		select trid from tbl_teach where tid=?))";
				SQLQuery sq=session.createSQLQuery(sql);
				sq.setParameter(0, tid);
				int sum=((Number)sq.uniqueResult()).intValue();
				return sum;
			}

			/**
					* @Title: findReviewContentById聽
					* @Description: TODO 鏍规嵁鑰佸笀id鏌ュ嚭浠栫殑绗竴鏉¤瘎浠�
					* @param @param tid
					* @param @ret urn 聽 聽鍏ュ弬
					* @return List 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�14鏃� 涓嬪崍4:21:15聽
					* @version V1.0 聽聽
			 */
			public String findReviewContentById(int tid) {
				Session session=this.sessionFactory.getCurrentSession();
				String sql="select reviewcontent from tbl_review where crid in( \r\n" + 
						"	select crid from tbl_classrelation where trid in(\r\n" + 
						"	select trid from tbl_teach where tid=1))";
				Query q=session.createSQLQuery(sql);
				List reviewcontents=q.list();
				String content=reviewcontents.get(0).toString();
				String new_content="";
				System.out.println("content.length:"+content.length());
				if(content.length()>20) {
					new_content=content.substring(0, 20);
					return new_content;
				}else
					return content;
			}
			
			/**
			 * 
			 * @Title: findGidByGname聽
			 * @Description: 鏍规嵁骞寸骇鍚嶆煡璇㈠嚭瀵瑰簲鐨勫勾绾d
			 * @param @param gname
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author cuishan
			 * @throws
			 * @date 2018骞�12鏈�11鏃� 涓嬪崍5:07:31聽
			 * @version V1.0 聽聽
			 */
			public int findGidByGname(String gname) {
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createQuery("select gid from Grade where gname=:gname");
				q.setParameter("gname", gname);
				int gid=((Number)q.uniqueResult()).intValue();
				return gid;
			}
			
			/**
			 * 
			 * @Title: findCidByCname聽
			 * @Description: TODO 鏍规嵁璇剧▼鍚嶆煡璇㈠搴旂殑璇剧▼id
			 * @param @param cname
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author cuishan
			 * @throws
			 * @date 2018骞�12鏈�11鏃� 涓嬪崍5:10:48聽
			 * @version V1.0 聽聽
			 */
			public int findCidByCname(String cname) {
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createQuery("select cid from Course where cname=:cname");
				q.setParameter("cname", cname);
				int cid=((Number)q.uniqueResult()).intValue();
				return cid;
			}
			
			/**
			 * 
			 * @Title: findTutorByConditions聽
			 * @Description: TODO 鏌ヨ绗﹀悎鏉′欢鐨勮�佸笀鐨剈ser琛ㄤ腑鐨勭浉搴斾俊鎭�
			 * @param @param grade
			 * @param @param subject
			 * @param @param department
			 * @param @param sex
			 * @param @param major
			 * @param @return 聽 聽鍏ュ弬
			 * @return List<Object[]> 聽 聽杩斿洖绫诲瀷
			 * @author 锛堜綔鑰咃級聽
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓婂崍11:05:50聽
			 * @version V1.0 聽聽
			 */
			public List<Object[]> findTutorOnUserByConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				Session session=this.sessionFactory.getCurrentSession();
				String Hql=this.findSql(grade, subject, department, sex, major,schooltype);
				Query q=session.createQuery(Hql);
				return q.list();
			}
			
			
			
			/**
			 * 
			 * @Title: findTutorOnMyJobByConditions聽
			 * @Description: TODO 鍒嗛〉鏌ヨ绗﹀悎鎵�鏈夋潯浠剁殑鑰佸笀(椤哄簭锛歩d,username,userimg,introduce,price,teacherage,reviewstar,reviewsum,reviewcontent)
			 * @param @param id
			 * @param @return 聽 聽鍏ュ弬
			 * @return List<Object[]> 聽 聽杩斿洖绫诲瀷
			 * @author cuishan
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓嬪崍2:46:33聽
			 * @version V1.0 聽聽
			 */
			public List<Object[]> findTutorByAllConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				String sql=this.findSql(grade, subject, department, sex, major,schooltype);
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createSQLQuery(sql);
//				q.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize);
				return q.list();
			}


			/**
			 * 
					* @Title: findCountByPage聽
					* @Description: TODO 寰楀埌浠ユ煇绉嶆柟寮忔煡璇㈢殑鎬绘潯鏁�
					* @param @param list
					* @param @return 聽 聽鍏ュ弬
					* @return int 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�19鏃� 涓婂崍8:45:06聽
					* @version V1.0 聽聽
			 */
			public int findCountByPage(int grade,int subject,String department,String sex,String major,String schooltype) {
				String sql=this.findSql(grade, subject, department, sex, major,schooltype);
				Session session=this.sessionFactory.getCurrentSession();
				Query q=session.createSQLQuery(sql);
				List tutors=q.list();
				return tutors.size();
	    	}
}
