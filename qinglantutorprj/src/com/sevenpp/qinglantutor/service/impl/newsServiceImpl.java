
package com.sevenpp.qinglantutor.service.impl;

import java.util.List;

import javax.annotation.Resource;
import com.sevenpp.qinglantutor.dao.newsDaoImpl;
import com.sevenpp.qinglantutor.entity.Msg;
import com.sevenpp.qinglantutor.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsServiceImpl
		* 类描述：个人中心消息部分的Service
		* 创建人：rain
		* 创建时间：2018年12月11日 下午5:02:38
		* 修改人：rain
		* 修改时间：2018年12月11日 下午5:02:38
		* 修改备注：
		* @version
		*
		*/
@Service
@Transactional(readOnly=true)
public class newsServiceImpl {
	@Resource
	private newsDaoImpl newsDaoImpl;
	/**
	 * 查询MSG表返回整msg表的list，本方法需要User类user，需要与personalServiceImpl的finduridByemail方法组合使用
	 * */
	public List<Msg> findMsg(User user){
		return this.newsDaoImpl.findMsgByid(user);
	}

}

	