package com.sevenpp.qinglantutor.dao.impl;

import com.sevenpp.qinglantutor.dao.WorkCompleteDao;
import com.sevenpp.qinglantutor.entity.HomeWork;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
@Repository
public class WorkCompleteDaoImpl implements WorkCompleteDao {
	@Resource
	private SessionFactory sessionFactory;
	
//	插入tcontent并判断作业是否插入成功
	public Boolean HomeworkInsert(String scontent,int hid,String question) {
		// TODO Auto-generated method stub
		String hql = "update HomeWork h set h.scontent=:st , h.question=:qt ,h.sstatus='已完成'   where h.hid=:id"; 
		Session session=this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("st", scontent);
		query.setParameter("id", hid);
		query.setParameter("qt", question);
		query.executeUpdate();
		tx.commit();
		
		return true;
		
	}
	
//	查询作业
	public List<HomeWork> HomeWorkShow() {
		// TODO Auto-generated method stub
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from HomeWork )");
		return q.list();
	}
	public Boolean CommentInsert(int hid,Integer score,String workreview) {
		// TODO Auto-generated method stub
		String hql = "update HomeWork h set h.score=:sc ,h.workReview=:wr,h.tstatus='已评价'   where h.hid=:id"; 
		Session session=this.sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(hql);
		query.setParameter("sc",score );
		query.setParameter("wr", workreview);
		query.setParameter("id", hid);
		query.executeUpdate();
		tx.commit();
		
		return true;
		
	}
}
