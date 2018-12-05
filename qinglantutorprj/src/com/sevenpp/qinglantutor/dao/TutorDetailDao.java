/**   
		* @Title: tutordetailDao.java 
		* @Package com.sevenpp.qinglantutor.dao 
		* @Description: 家教详情页dao
		* @author lxq
		* @date 2018年12月5日 下午3:13:38 
		* @version V1.0   
		*/

		package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutordetailDao
		* 类描述：家教详情页daoimpl
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午3:13:38
		* 修改人：rain
		* 修改时间：2018年12月5日 下午3:13:38
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: tutordetailDao 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月5日 下午3:13:38 
		* @version V1.0 
		*/
		public interface TutorDetailDao {

			/**
			 * 
					* @Title: findTutorDetail 
					* @Description: 获取家教基本信息
					* @param @return    入参
					* @return User    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月5日 下午3:57:42 
					* @version V1.0   
			 */
			public  User findTutorDetail(int id);
			
}

	