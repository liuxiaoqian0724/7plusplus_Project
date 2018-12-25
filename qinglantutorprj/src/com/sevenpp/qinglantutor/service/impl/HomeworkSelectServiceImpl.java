package com.sevenpp.qinglantutor.service.impl;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.dao.impl.HomeworkSelectDaoImpl;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.HomeworkSelectService;
import java.util.List;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly=true)
public class HomeworkSelectServiceImpl implements HomeworkSelectService {
	@Resource HomeworkSelectDaoImpl homeworkSelectDaoImpl;
	
	@Override
	public List<HomeWork> HomeworkShow() {
		// TODO Auto-generated method stub
		
			return this.homeworkSelectDaoImpl.HomeWorkShow();
		
	}
	@Override
	public List<User> TeacherShow() {
		// TODO Auto-generated method stub
		
			return this.homeworkSelectDaoImpl.TeacherShow();
		
	}
	public List<ClassRelation> ClassRelation() {
		// TODO Auto-generated method stub
		
			return this.homeworkSelectDaoImpl.ClassRelation();
		
	}
	public List<TeachRelation> TeachRelation(){
		  return this.homeworkSelectDaoImpl.TeachRelation();
	}

}
