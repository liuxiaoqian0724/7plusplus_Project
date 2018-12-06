
package com.sevenpp.qinglantutor.service;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.dao.reviewDaoImpl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：reviewServiceImpl
		* 类描述：评价功能相关的Service层
		* 创建人：刘杼滨
		* 创建时间：2018年12月5日 下午2:35:11
		* 修改人：刘杼滨
		* 修改时间：2018年12月5日 下午2:35:11
		* 修改备注：
		* @version
		*
		*/
@Service
@Transactional(readOnly=true)
public class reviewServiceImpl {
	@Resource
	private reviewDaoImpl reviewDaoImpl;
	
	public List<Review> list() {
		
		return this.reviewDaoImpl.findAll();
	}

}

	