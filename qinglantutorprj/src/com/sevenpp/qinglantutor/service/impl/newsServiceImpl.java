
package com.sevenpp.qinglantutor.service.impl;

import java.util.List;

import javax.annotation.Resource;
import com.sevenpp.qinglantutor.dao.impl.newsDaoImpl;
import com.sevenpp.qinglantutor.entity.Msg;
import com.sevenpp.qinglantutor.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsServiceImpl
		* 类描述：个人中心消息部分的Service
		* 创建人：刘杼滨
		* 创建时间：2018年12月11日 下午5:02:38
		* 修改人：rain
		* 修改时间：2018年12月11日 下午5:02:38
		* 修改备注：
		* @version
		*
		*/
@Service
public class newsServiceImpl {
	@Resource
	private newsDaoImpl newsDaoImpl;
	/**
	 * 
			* @Title: findMsg 
			* @Description: TODO(这里用一句话描述这个方法的作用) 
			* @param @param user
			* @param @return    入参
			* @return List<Msg>    返回类型
			* @author 刘杼滨 
			* @throws
			* @date 2018年12月17日 下午5:21:53 
			* @version V1.0   
	 */
	public List<Msg> findMsg(User user){
		return this.newsDaoImpl.findMsgByid(user);
	}
	public String addMsgs(User rid,int sid,String content) {
		return this.newsDaoImpl.InsertMsg(rid, sid, content);
		
	}public String addMsgsNorepeat(User rid,int sid,String content) {
		return this.newsDaoImpl.InsertMsgNorepeat(rid, sid, content);
		
	}
	public String changeststus(int mid,int status) {
		
		return this.newsDaoImpl.changeStatus(mid, status);
		
	}

}

	