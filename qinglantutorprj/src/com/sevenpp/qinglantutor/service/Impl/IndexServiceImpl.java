/**   
		* @Title: IndexServiceImpl.java 
		* @Package com.sevenpp.qinglantutor.service.Impl 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 上午11:09:41 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.Impl.IndexDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.IndexService;
import com.sevenpp.qinglantutor.util.PageBean;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexServiceImpl
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 上午11:09:41
		* 修改人：rain
		* 修改时间：2018年12月7日 上午11:09:41
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexServiceImpl 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月7日 上午11:09:41 
		* @version V1.0 
		*/
@Service
public class IndexServiceImpl implements IndexService {
	@Resource
	private IndexDaoImpl idi;
	public PageBean<User> findAllUserWithPage(int pageNum, int pageSize){
		System.out.println("IndexServiceImpl");
		List<User> userList = idi.queryAll();
		int totalRecord = userList.size();
		PageBean<User> pb = new PageBean<User>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		pb.setList(idi.findAll(startIndex,pageSize));
		return pb;
	}

}

	