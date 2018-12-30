package com.sevenpp.qinglantutor.dao.impl;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
/**
*
* 项目名称：qinglantutorprj
* 类名称：riviewDao
* 类描述：个人中心页评价系统的DAO层
* 创建人：刘杼滨
* 创建时间：2018年12月5日 下午2:13:40
* 修改人：刘杼滨
* 修改时间：2018年12月5日 下午2:13:40
* 修改备注：
* @version
*
*/
@Repository
public class reviewDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 使用urid(int)在user表查询得到Tid
	 * */
	public User findurid(int urid){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User ur where ur.id=:id");
		q.setParameter("id", urid);
		List<User> list=q.list();
		User user=list.get(0);
		return user;
	}
	/**查询教课关系表，下一步上课关系 需要user类参数*/
	public List<TeachRelation> findtridByTid(User user){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from TeachRelation tr where tr.user=:user");
		q.setParameter("user", user);
		List<TeachRelation> list=q.list();
		/*List<Integer> trids=list.stream().map(TeachRelation::getTrid).collect(Collectors.toList());*/
		return list;
	}
	/**查询评价表需要CLASSRELATION类的参数*/
	public List<Review> findAll(ClassRelation cr){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from Review re where re.classRelation=:cr");
		q.setParameter("cr", cr);
		
		return q.list();
	}
	/**
	 * 获取角色
	 */
	public String getrole(String email) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User us where us.email=:email");
		q.setParameter("email", email);
		List<User> list=q.list();
		String role=list.get(0).getRole();
		System.out.println("dao身份"+role);
		return role;
		
	}
	/*
	 * 以下是给学生的查询方法
	 */
	public List<ClassRelation> findcridByTrid(User user) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ClassRelation cr where cr.user=:user");
		q.setParameter("user", user);
		List<ClassRelation> list=q.list();
		return list;
	}
	/*过时方法
	 * public ClassRelation findCrid(TeachRelation trx){
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ClassRelation cr where cr.teachRelation=:tr");
		q.setParameter("tr", trx);
		List<ClassRelation> list=q.list();
		ClassRelation cr=list.get(0);
		return cr;
	}*/
	
	/*过时方法
	 * public List<ClassRelation> findcridByTrid(TeachRelation tr) {
		Session session=this.sessionFactory.getCurrentSession();
		Query q=session.createQuery("from ClassRelation cr where cr.teachRelation=:tr");
		q.setParameter("tr", tr);
		List<ClassRelation> list=q.list();
		List<Integer> crids=list.stream().map(ClassRelation::getCrid).collect(Collectors.toList());
		return list;
	}*/

	/*过时方法
	 * public TeachRelation findTrid(User user){
	Session session=this.sessionFactory.getCurrentSession();
	Query q=session.createQuery("from TeachRelation tr where tr.user=:user");
	q.setParameter("user", user);
	List<TeachRelation> list=q.list();
	TeachRelation tr=list.get(0);
	return tr;
}*/
}

	