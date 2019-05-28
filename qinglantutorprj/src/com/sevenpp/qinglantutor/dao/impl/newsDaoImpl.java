package com.sevenpp.qinglantutor.dao.impl;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.Msg;
/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsDaoImpl
		* 类描述：个人中心页消息dao
		* 创建人：rain
		* 创建时间：2018年12月11日 下午4:20:48
		* 修改人：rain
		* 修改时间：2018年12月11日 下午4:20:48
		* 修改备注：
		* @version
		*
		*/
@Repository
public class newsDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询MSG表返回整msg表的list，本方法需要User类user，需要与personalServiceImpl的finduridByemail方法组合使用
	 * */
	public List<Msg> findMsgByid(User user){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Msg ms where ms.user = :id");
		q.setParameter("id", user);
		return q.list();
	}
	public String changeStatus(int mid,int status) {
		/*System.out.print(mid);
		System.out.print(status);*/
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		Query q=session.createQuery("update Msg msg set msg.status=:status where msg.mid=:mid");
		q.setParameter("status", status);
		q.setParameter("mid", mid);
		int ret=q.executeUpdate();
		tx.commit();
		return "CHANGE status SUCCESS";
		
	}
	public int getsendId(int mid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Msg ms where ms.mid=:mid");
		q.setParameter("mid", mid);
		List<Msg> list=q.list();
		int sendid=list.get(0).getSendId();
		return sendid;
	}
	public User getreId(int mid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Msg ms where ms.mid=:mid");
		q.setParameter("mid", mid);
		List<Msg> list=q.list();
		User rid=list.get(0).getUser();
		return rid;
		
	}
	public String Getphone(User rid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User us where us.id=:rid");
		q.setParameter("rid", rid.getId());
		List<User> list=q.list();
		String phonenum=list.get(0).getPhoneNumber();
		return phonenum;
		
	}
	public String InsertMsg(User rid,int sid,String content) {
		Date date =new Date();
		Timestamp time =new Timestamp(date.getTime());
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tran =session.beginTransaction();
		Msg msg =new Msg();
		msg.setUser(rid);
		msg.setSendId(sid);
		msg.setStatus(0);
		msg.setContent(content);
		msg.setSendTime(time);
		session.save(msg);
		tran.commit();
		return "insert msg Success";
		
	}
	public String InsertMsgNorepeat(User rid,int sid,String content) {
		Date date =new Date();
		Timestamp time =new Timestamp(date.getTime());
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tran =session.beginTransaction();
		Msg msg =new Msg();
		msg.setUser(rid);
		msg.setSendId(sid);
		msg.setStatus(2);
		msg.setContent(content);
		msg.setSendTime(time);
		session.save(msg);
		tran.commit();
		return "insert msg Success";
		
	}
	public int InsertTeacherRelation(User tid) 
	{
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tran =session.beginTransaction();
		TeachRelation tr=new TeachRelation();
		tr.setUser(tid);
		session.save(tr);
		int trid=tr.getTrid();
		tran.commit();
		
		return trid;
	}
	public TeachRelation findTrid(User user){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from TeachRelation tr where tr.user=:user");
		q.setParameter("user", user);
		List<TeachRelation> list=q.list();
		int x=list.size();
		int y=x-1;
		TeachRelation tr=list.get(y);
		return tr;
		}
	/*public List<TeachRelation> findTR(int trid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from TeachRelation tr where tr.trid=:trid");
		q.setParameter("trid", trid);
		List<TeachRelation> list=q.list();
		
		TeachRelation trx=list.get(0);
		System.out.println("TeachRelation list:");
		System.out.println(trx);
		List<ClassRelation> listCr=trx.getClassRelation();
		System.out.println("ClassRelation list:");
		System.out.println(listCr.get(0));
		TeachRelation TRtrid=listCr.get(0).getTeachRelation();
		return list;
	}*/
	public String InsertClassrelation(TeachRelation TRtrid,User cid) {
		Session session=this.sessionFactory.getCurrentSession();
		Transaction tran =session.beginTransaction();
		ClassRelation cr=new ClassRelation();
		cr.setUser(cid);
		cr.setTeachRelation(TRtrid);
		session.save(cr);
		tran.commit();
		return "insertClassrelation Success";
		
	}
	
	
}

	