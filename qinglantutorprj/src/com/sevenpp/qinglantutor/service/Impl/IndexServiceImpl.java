/**   
		* @Title: IndexServiceImpl.java 
		* @Package com.sevenpp.qinglantutor.service.Impl 
		* @Description: TODO(用一句话描述该文件做什么) 
		* @author （作者）  
		* @date 2018年12月7日 上午11:09:41 
		* @version V1.0   
		*/
		package com.sevenpp.qinglantutor.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.Impl.IndexDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.IndexService;
import com.sevenpp.qinglantutor.util.Userinf;

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
	
	private Userinf userinf;
	@Override
	public List<Userinf> findAllUser(){
		System.out.println("IndexServiceImpl");
		List<User> userList = new ArrayList<User>();
		List<Userinf> userlist=new ArrayList<Userinf>();
		userList=idi.queryAll();
		userinf=new Userinf();
		for(int i=0;i<userList.size();i++) {
			userinf=new Userinf();
			userinf.setId(userList.get(i).getId());
			userinf.setIntroduce(userList.get(i).getIntroduce());
			userinf.setRealName(userList.get(i).getRealName());
			userinf.setSchool(userList.get(i).getSchool());
			userinf.setUserImg(userList.get(i).getUserImg());
			userlist.add(userinf);
		}
		return userlist;
	}

}
