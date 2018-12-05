/**   
		* @Title: TutorDetailServiceImpl.java 
		* @Package com.sevenpp.qinglantutor.service.impl 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月5日 下午3:18:13 
		* @version V1.0   
		*/

		package com.sevenpp.qinglantutor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.TutorDetailDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TutorDetailService;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorDetailServiceImpl
		* 类描述：
		* 创建人：rain
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
		public class TutorDetailServiceImpl implements TutorDetailService {
			
			@Resource
			private TutorDetailDaoImpl tutorDetailDaoImp;
			@Override
			public User getTutorDetail(int id) {
						return tutorDetailDaoImp.findTutorDetail(id);
						/**
						* getTutorDetail 得到家教基本信息
						* TODO(这里描述这个方法适用条件 – 可选)
						* TODO(这里描述这个方法的执行流程 – 可选)
						* TODO(这里描述这个方法的使用方法 – 可选)
						* TODO(这里描述这个方法的注意事项 – 可选)
						* @param 用户id
						* @param @return 设定文件
						* @return String DOM对象
						* @Exception 异常对象
						* @since CodingExample Ver(编码范例查看) 1.1
						*/
					
			}

}

	