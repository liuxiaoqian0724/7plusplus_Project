
		package com.sevenpp.qinglantutor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.ConditionsDaoImpl;

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
			public String findHql(int grade,int subject,String department,String sex,String major) {
				return this.conditionsDaoImpl.findHql(grade, subject, department, sex, major);
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
}

	