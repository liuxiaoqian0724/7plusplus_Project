package com.sevenpp.qinglantutor.dao;


public interface WorkCompleteDao {
	abstract public Boolean HomeworkInsert(String scontent,int hid,String question);
	abstract public Boolean CommentInsert(int hid,Integer score,String workreview);
}
