package com.sevenpp.qinglantutor.dao.impl;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：presonalDao
		* 类描述：个人中心上方简介信息DAO
		* 创建人：rain
		* 创建时间：2018年12月6日 上午10:57:17
		* 修改人：rain
		* 修改时间：2018年12月6日 上午10:57:17
		* 修改备注：
		* @version
		*
		*/
@Repository
public class personalDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
		
	/**方法需获得id参数 以Id查询User表获得List*/
	public List<User> findAll(int id){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User us where us.id = :id");
		q.setParameter("id", id);
		
		
		return q.list();
		
	}
	/**以Email查询User表获得ID*/
	public User finduridByemail(String email){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User ur where ur.email=:email");
		q.setParameter("email", email);
		List<User> list=q.list();
		User user=list.get(0);
		return user;
	}
	/**以Email查询User表获得int类型的ID*/
	public int findINTuridByemail(String email){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User ur where ur.email=:email");
		q.setParameter("email", email);
		List<User> list=q.list();
		int userid=list.get(0).getId();
		return userid;
	}
	/**获得用户平均分方法*/
	public double getUserAVGstar() {
		return 0;
		
	}
	/* 评价部分借用方法，这些方法原本在reviewdao里使用，查看方法信息请到reviewdao
	 */
	public User findurid(int urid){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User ur where ur.id=:id");
		q.setParameter("id", urid);
		List<User> list=q.list();
		User user=list.get(0);
		return user;
	}
	public List<TeachRelation> findtridByTid(User user){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from TeachRelation tr where tr.user=:user");
		q.setParameter("user", user);
		List<TeachRelation> list=q.list();
		/*List<Integer> trids=list.stream().map(TeachRelation::getTrid).collect(Collectors.toList());*/
		return list;
	}
	public List<Review> findAll(ClassRelation cr){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Review re where re.classRelation=:cr");
		q.setParameter("cr", cr);
		
		return q.list();
	}
	
	/*本方法原在reviewService里*/
	public List<String> getReviewStar(int reviewstar){
		
		int finalstar1;
		List<String>starfulllist=new ArrayList<String>();
		for (finalstar1=reviewstar;finalstar1>0;finalstar1--) {
			starfulllist.add("fill-star");
		}
		double finalstar2;
		for(finalstar2=5-reviewstar;finalstar2>0;finalstar2--) {
			starfulllist.add("empty-star");
		}
		
		return starfulllist;
	}

}

	