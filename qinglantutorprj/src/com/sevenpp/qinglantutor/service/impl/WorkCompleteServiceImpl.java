package com.sevenpp.qinglantutor.service.impl;

import com.sevenpp.qinglantutor.dao.impl.WorkCompleteDaoImpl;
import com.sevenpp.qinglantutor.service.WorkCompleteService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly=false)
public class WorkCompleteServiceImpl implements WorkCompleteService {
	@Resource WorkCompleteDaoImpl workCompleteDaoImpl;
	
	@Override
	public Boolean HomeworkInsert(String scontent, int hid,String question) {
		// TODO Auto-generated method stub
		return this.workCompleteDaoImpl.HomeworkInsert(scontent, hid,question);
	}
	public Boolean CommentInsert(int hid,Integer score,String workreview) {
		return this.workCompleteDaoImpl.CommentInsert(hid,score, workreview);
	}
}
