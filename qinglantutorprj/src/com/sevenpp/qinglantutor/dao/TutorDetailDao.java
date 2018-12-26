/**   
		* @Title: tutordetailDao.java 
		* @Package com.sevenpp.qinglantutor.dao 
		* @Description: 家教详情页dao
		* @author lxq
		* @date 2018年12月5日 下午3:13:38 
		* @version V1.0   
		*/

package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：tutordetailDao
		* 类描述：家教详情页daoimpl
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午3:13:38
		* 修改人：rain
		* 修改时间：2018年12月5日 下午3:13:38
		* 修改备注：
		* @version
		*
		*/
/**
 *  
 * 
 * @ClassName: tutordetailDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author (作者)  
 * @date 2018年12月5日 下午3:13:38 
 * @version V1.0 
 */
public interface TutorDetailDao {

	/**
	 * 
	 * @Title: findTutorDetail 
	 * @Description: 根据id获取家教基本信息
	 * @param @return    入参
	 * @return User    返回类型
	 * @author lxq
	 * @throws @date 2018年12月5日 下午3:57:42 
	 * @version V1.0   
	 */
	public User findTutorDetail(Integer id);
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
	public void addInquireMsg(Integer id,Integer inquireId,String grade);

	/**
	 * 
			* @Title: findTeacherReview 
			* @Description: 获取老师教课学生的评论
			* @param @param id 用户id
			* @param @return    入参
			* @return ClassRelation    返回类型
			* @author lxq 
			* @throws
			* @date 2018年12月18日 下午3:00:56 
			* @version V1.0   
	 */
	public Integer findTutorReviewCount(Integer id);
}
