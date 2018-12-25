/**   
		* @Title: TutorDetailServiceImpl.java 
		* @Package com.sevenpp.qinglantutor.service.impl 
		* @Description: 家教信息显示业务逻辑层
		* @author （作者）  
		* @date 2018年12月5日 下午3:18:13 
		* @version V1.0   
		*/

		package com.sevenpp.qinglantutor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.TutorDetailDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TutorDetailService;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorDetailServiceImpl
		* 类描述：
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午3:18:13
		* 修改人：rain
		* 修改时间：2018年12月5日 下午3:18:13
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: TutorDetailServiceImpl 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月5日 下午3:18:13 
		* @version V1.0 
		*/
		@Service
		@Transactional
		public class TutorDetailServiceImpl implements TutorDetailService {
			
			@Resource
			private TutorDetailDaoImpl tutorDetailDaoImp;
			@Override
			public User getTutorDetail(Integer id) {
						return tutorDetailDaoImp.findTutorDetail(id);
						/**
						* getTutorDetail 得到家教基本信息
						* @param 用户id
						* @param @return 设定文件
						* @return String DOM对象
						* @Exception 异常对象
						* @since CodingExample Ver(编码范例查看) 1.1
						*/
					
			}

}

	