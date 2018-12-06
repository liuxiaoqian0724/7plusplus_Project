package com.sevenpp.qinglantutor.dao;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.sevenpp.qinglantutor.entity.Review;
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
	public List<Review> findAll(){
		Session session=this.sessionFactory.getCurrentSession();
		/*此处查询方式等待修改*/
		Query q=session.createQuery("from Review");
		System.out.println("数据库读取成功");
		return q.list();
		
	}

}

	