
		package com.sevenpp.qinglantutor.service.impl;

		import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.ConditionsDaoImpl;
import com.sevenpp.qinglantutor.entity.UserInfo;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：ConditionsServiceImpl
		* 类描述：conditionsDaoImpl的Service
		* 创建人：cuishan
		* 创建时间：2018年12月12日 上午8:35:21
		* 修改人：rain
		* 修改时间：2018年12月12日 上午8:35:21
		* 修改备注：
		* @version
		*
		*/
		
		@Service	
		public class ConditionsServiceImpl {
			@Resource
			private ConditionsDaoImpl conditionsDaoImpl;
			
			
			public List addConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				return this.conditionsDaoImpl.addConditions(conditions, grade, subject, department, sex, major);
			}

			public List deleteConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				return this.conditionsDaoImpl.deteleConditions(conditions, grade, subject, department, sex, major); 
			}
			
			
			
			/**
			 * 
			 * @Title: findHql 
			 * @Description: 用于家教库页查询各种条件
			 * @param @param grade
			 * @param @param subject
			 * @param @param department
			 * @param @param sex
			 * @param @param major
			 * @param @return    入参
			 * @return String    返回类型
			 * @author （作者） 
			 * @throws
			 * @date 2018年12月12日 上午8:43:24 
			 * @version V1.0   
			 */
			public String findSql(int grade,int subject,String department,String sex,String major,String schooltype) {
				return this.conditionsDaoImpl.findSql(grade, subject, department, sex, major,schooltype);
			}
			
			/**
			 * 
					* @Title: findReviewStarById 
					* @Description: TODO 根据id查询评级星级
					* @param @param id
					* @param @return    入参
					* @return int    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月17日 上午8:20:48 
					* @version V1.0   
			 */
			public int findReviewStarById(int id) {
				return this.conditionsDaoImpl.findReviewStarById(id);
			}
			/**
			 * 
					* @Title: findReviewSumById 
					* @Description: TODO 根据老师id查询出对他的评价总数
					* @param @param tid
					* @param @return    入参
					* @return int    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月17日 上午8:17:28 
					* @version V1.0   
			 */
			public int findReviewSumById(int tid) {
				return this.conditionsDaoImpl.findReviewSumById(tid);
			}
			
			/**
			 * 
					* @Title: findReviewContentById 
					* @Description: TODO 查询第一条评价
					* @param @param tid
					* @param @return    入参
					* @return String    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月17日 上午8:22:44 
					* @version V1.0 
			 */
			public String findReviewContentById(int tid) {
				return this.conditionsDaoImpl.findReviewContentById(tid);
			}
			
			/**
			 * 
			 * @Title: findGidByGname 
			 * @Description: TODO根据gname查询gid
			 * @param @param gname
			 * @param @return    入参
			 * @return int    返回类型
			 * @author （作者） 
			 * @throws
			 * @date 2018年12月12日 上午8:45:11 
			 * @version V1.0 
			 */
			public int findGidByGname(String gname) {
				return this.conditionsDaoImpl.findGidByGname(gname);
			}
			
			/**
			 * 
			 * @Title: findCidByCname 
			 * @Description: TODO根据cname查询cid
			 * @param @param cname
			 * @param @return    入参
			 * @return int    返回类型
			 * @author （作者） 
			 * @throws
			 * @date 2018年12月12日 上午8:46:27 
			 * @version V1.0
			 */
			public int findCidByCname(String cname) {
				return this.conditionsDaoImpl.findCidByCname(cname);
			}
			
			/**
			 * 
					* @Title: findTutorOnUserByConditions 
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
					* @date 2018年12月17日 上午8:23:45 
					* @version V1.0   
			 */
			public List<Object[]> findTutorOnUserByConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				return this.conditionsDaoImpl.findTutorOnUserByConditions(grade, subject, department, sex, major,schooltype);
			}
			
			/**
			 * 
					* @Title: findTutorOnMyJobByConditions 
					* @Description: TODO  查询符合所有条件的老师
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return    入参
					* @return List<Object[]>    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月17日 上午8:24:39 
					* @version V1.0   
			 */
			public List<UserInfo> findTutorByAllConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				List<Object[]> tutorlist=this.conditionsDaoImpl.findTutorByAllConditions(grade, subject, department, sex, major,schooltype);
				List<UserInfo> tutors=new ArrayList<UserInfo>();
				for (Object[] objects : tutorlist) {
					//得到id
					int id=(int)objects[0];
					//根据id得到星级
					int star=this.findReviewStarById(id);
					int sum=this.findReviewSumById(id);
					String content=this.findReviewContentById(id);
					Object[] objs=new Object[9];
					for(int i=0;i<6;i++) 
						objs[i]=objects[i];
					objs[6]=star;
					objs[7]=sum;
					objs[8]=content;
//					System.out.println("id:"+(int)objs[0]+"username"+objs[1].toString()+"userimg"+objs[2].toString()+"introduce:"+objs[3].toString()+"price:"+(int)objs[4]+"teacherage"+(int)objs[5]+"content:"+objs[8].toString());
					UserInfo userinfo=new UserInfo((int)objs[0],objs[1].toString(),objs[2].toString(),objs[3].toString(),(int)objs[4],objs[5].toString(),(int)objs[6],(int)objs[7],objs[8].toString());
					userinfo.setIntellgencesort();
					tutors.add(userinfo);
				}
				return tutors;
			}
			
			/**
			 * 
					* @Title: findCountByPage 
					* @Description: 得到以某种方式查询的信息总条数
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return    入参
					* @return int    返回类型
					* @author （作者） 
					* @throws
					* @date 2018年12月20日 上午9:16:10 
					* @version V1.0   
			 */
			public int findCountByPage(int grade,int subject,String department,String sex,String major,String schooltype) {
				return this.conditionsDaoImpl.findCountByPage(grade,subject, department, sex, major,schooltype);
			}
}

	