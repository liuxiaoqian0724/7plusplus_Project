/**   
		* @Title: TutorDetailDaoImpl.java 
		* @Package com.sevenpp.qinglantutor.dao.impl 
		* @Description: 查询家教基本信息
		* @author lxq
		* @date 2018年12月5日 下午4:18:05 
		* @version V1.0   
		*/

package com.sevenpp.qinglantutor.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TutorDetailDao;
import com.sevenpp.qinglantutor.entity.Msg;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;

/**
*
* 项目名称：qinglantutorprj
* 类名称：TutorDetailDaoImpl
* 类描述：
* 创建人：lxq
* 创建时间：2018年12月5日 下午4:18:05
* 修改人：rain
* 修改时间：2018年12月5日 下午4:18:05
* 修改备注：
* @version
*
*/
/**
 *  
 * 
 * @ClassName: TutorDetailDaoImpl 
 * @Description: 查询家教相关信息
 * @author lxq 
 * @date 2018年12月5日 下午4:18:05 
 * @version V1.0 
 */
@Repository
public class TutorDetailDaoImpl implements TutorDetailDao {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * findTutorDetail根据id获取家教详情页家教基本
	 * 
	 * @param 用户id
	 * @param      @return 设定文件
	 * @return String DOM对象
	 * @Exception 异常对象
	 * @since CodingExample Ver(编码范例查看) 1.1
	 */
	@Override
	public User findTutorDetail(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;
		
	}
	/**
	 * 
			* @Title: findTutorReviewCount 
			* @Description: 获取家教的评论条数
			* @param @param id 用户id
			* @param @return    入参
			* @return Integer    返回类型
			* @author lxq
			* @throws
			* @date 2018年12月18日 下午3:17:13 
			* @version V1.0   
	 */
	public Integer findTutorReviewCount(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		String sql="select * from tbl_review where crid in(\r\n" + 
				"	select crid from tbl_classrelation where trid in(\r\n" + 
				"		select trid from tbl_teach where tid=:id))";
		Query query =session.createSQLQuery(sql);
		query.setInteger("id", id);
		List<Review> list = query.list();
        return list.size();
	}
	
	/**
	 * 
			* @Title: findUserByEmail 
			* @Description: 通过用户email查找用户
			* @param @param email
			* @param @return    入参
			* @return User    返回类型
			* @author lxq
			* @throws
			* @date 2018年12月26日 下午2:27:46 
			* @version V1.0   
	 */
	public User findUserByEmail(String email) {
		Session session=this.sessionFactory.getCurrentSession();
		//Query q=session.createQuery("from User u where u.email=:var1");
		Query q=session.createQuery("from User u where u.email=?");
//		q.setString(1, email);
		q.setParameter(0, email);
		List<User> uList=q.list();
		return uList.get(0);
	}
	
	/**
	 * 
			* @Title: addInquireMsg 
			* @Description: 向数据库插入用户向家教咨询的用户ID和所选择的的科目
			* @param @param id 发送请求的用户id
			* @param @param chosenGrade 用户所选择的咨询科目
			* @param @return    入参
			* @return boolean    是否向数据库更新成功
			* @author lxq
			* @throws
			* @date 2018年12月13日 上午10:40:18 
			* @version V1.0   
	 */
	public void addInquireMsg(Integer id,Integer inquireId,String grade) {
		Session session=this.sessionFactory.getCurrentSession();
		User tutorUser=session.get(User.class, id);
		User inquireUser=session.get(User.class, inquireId);
		Timestamp t = new Timestamp(new Date().getTime()); 
		String inquireMsg="<h4>敬爱的"+tutorUser.getEmail()+"您好：</h4>"+"<p>用户"+inquireUser.getEmail()+
				"于"+t.getTime()+"预约了您的"+grade+"课程，请选择是否同意自己联系方式发送给ta。</p>";
		String tutorIsAgree="<h3>请选择您是否成为了"+inquireUser.getEmail()+"的家教：</h3>";
		String iquireIsAgree="<h3>请选择"+tutorUser.getEmail()+"是否成为了您的家教：</h3>";
		Msg tutorMsg=new Msg();
		tutorMsg.setContent(inquireMsg);
		tutorMsg.setSendId(inquireId);
		tutorMsg.setStatus(0);
		tutorMsg.setSendTime(t);
		
		Msg inquireTutorMsg=new Msg();
		inquireTutorMsg.setContent(iquireIsAgree);
		inquireTutorMsg.setSendId(id);
		inquireTutorMsg.setStatus(0);
		inquireTutorMsg.setSendTime(t);
		
		Msg tutorInquireMsg=new Msg();
		tutorInquireMsg.setContent(tutorIsAgree);
		tutorInquireMsg.setSendId(inquireId);
		tutorInquireMsg.setStatus(0);
		tutorInquireMsg.setSendTime(t);
		
		session.save(tutorMsg);
		session.save(inquireTutorMsg);
		session.save(tutorInquireMsg);
		
	}

}
