package com.sevenpp.qinglantutor.service;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import java.util.List;

public interface HomeworkSelectService {
	abstract public List<HomeWork> HomeworkShow();
	abstract public List<ClassRelation> ClassRelation();
	abstract public List<TeachRelation> TeachRelation();
	abstract public User getUserByEmail(String email);
}
