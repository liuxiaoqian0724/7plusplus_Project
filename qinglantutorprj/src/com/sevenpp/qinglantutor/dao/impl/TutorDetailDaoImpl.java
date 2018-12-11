/**   
		* @Title: TutorDetailDaoImpl.java 
		* @Package com.sevenpp.qinglantutor.dao.impl 
		* @Description: 查询家教基本信息
		* @author lxq
		* @date 2018年12月5日 下午4:18:05 
		* @version V1.0   
		*/

package com.sevenpp.qinglantutor.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.sevenpp.qinglantutor.dao.TutorDetailDao;
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

	@Override
	public User findTutorDetail(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		System.out.println(user.getMyJobs().get(0).getTeacherAge());
		return user;
		/**
		 * findTutorDetail根据id获取家教详情页家教基本
		 * 
		 * @param 用户id
		 * @param      @return 设定文件
		 * @return String DOM对象
		 * @Exception 异常对象
		 * @since CodingExample Ver(编码范例查看) 1.1
		 */
	}
	
	

}
