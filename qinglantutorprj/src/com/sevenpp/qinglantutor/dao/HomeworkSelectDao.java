package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import java.util.List;


public interface HomeworkSelectDao {
	abstract public List<HomeWork> HomeWorkShow() ;
	abstract public List<User> TeacherShow() ;
	abstract public List<ClassRelation> ClassRelation() ;
	abstract public List<TeachRelation> TeachRelation() ;
	
}
