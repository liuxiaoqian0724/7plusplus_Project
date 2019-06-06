/**
 * @Title:TeacherDetailDaoImpl.java
 * @Package:com.sevenpp.qinglantutor.dao.impl
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2019年6月2日
 */
package com.sevenpp.qinglantutor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TeacherDetailDao;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;

/**
 * @ClassName:TeacherDetailDaoImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2019年6月2日
 *
 */
@Repository
public class TeacherDetailDaoImpl implements TeacherDetailDao {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Article findId(int articleId) {
				/**
				* findId(查找id)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象a
				* @since CodingExample Ver(编码范例查看) 1.1
				*/;
				return ((Article) this.getSession().createQuery(" from Article where aId=?")
						.setParameter(0, articleId).uniqueResult());
	}

	/**
	* @Title: findArticleByid  
	* @Description: 根据文章id返回<Article>对象
	* @param:@param id
	* @param:@return (参数)
	* @return:Article(返回类型)
	*
	 * @param id
	 * @return
	 */
	public Article findArticleByid(int id) {
		return ((Article) this.getSession().createQuery(" from Article where aId=?")
				.setParameter(0, id).uniqueResult());
	}	
	/**
	 * @desc 根据hql语句，查询单个实体类的对象
	 * @param hql    hql语句
	 * @param params hql语句中占位符对应的参数
	 * @return 单个实体类的对象
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Article findOne(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (Article) query.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public User findOne2(String hql, Object[] params) throws Exception {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		}
		return (User) query.uniqueResult();
	}
	/**
	* @Title: saveComment  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param articlereviewId
	* @param:@return (参数)
	* @return:Object(返回类型)
	*
	 * @param articlereviewId
	 * @return
	 */
	public void saveComment(ArticleReview articlereview) throws Exception {
		this.sessionFactory.getCurrentSession().save(articlereview);
	}

	/**
	* @Title: findUserByid  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param userid
	* @param:@return (参数)
	* @return:User(返回类型)
	*
	 * @param userid
	 * @return
	 */
	public User findUserByid(int userid) {
		String hql="from User u where u.id=?0";
		Object[] obj= {userid};
		User user=null;
		try {
			user=this.findOne2(hql,obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	* @Title: FindUserByEmail  
	* @Description: 根据email来获取User对象
	* @param:@param email1
	* @param:@return (参数)
	* @return:User(返回类型)
	*
	 * @param email1
	 * @return
	 */
	public User FindUserByEmail(String email1) {
		return ((User) this.getSession().createQuery("from User where email=?")
				.setParameter(0, email1).uniqueResult());
	}
	
}
