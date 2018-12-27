package com.sevenpp.qinglantutor.service;

public interface WorkCompleteService {
	abstract public Boolean HomeworkInsert(String scontent,int hid,String question);
	abstract public Boolean CommentInsert(int hid,Integer score,String workreview);
}
