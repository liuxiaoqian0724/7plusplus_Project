package com.sevenpp.qinglantutor.service.impl;

import com.sevenpp.qinglantutor.dao.impl.HomeworkSelectDaoImpl;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.service.HomeworkSelectService;
import java.util.List;
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

}
