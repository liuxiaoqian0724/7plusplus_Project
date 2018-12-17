
		package com.sevenpp.qinglantutor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.personalDaoImpl;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：personalServiceaImpl
		* 类描述：个人中心整体Service
		* 创建人：刘杼滨
		* 创建时间：2018年12月10日 上午8:27:26
		* 修改人：
		* 修改时间：2018年12月10日 上午8:27:26
		* 修改备注：
		* @version
		*
		*/
@Service
@Transactional(readOnly=true)
public class personalServiceImpl {
	@Resource
	private personalDaoImpl personalDaoImpl;
		
		public List<User> list(int id) {
			return this.personalDaoImpl.findAll(id);
			
		}
		/**以Email查询User表获得ID*/
		public User finduridByemail(String email) {
			return this.personalDaoImpl.finduridByemail(email);
			
		}

	

}

	