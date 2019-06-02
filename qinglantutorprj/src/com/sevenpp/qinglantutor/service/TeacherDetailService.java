/**
 * @Title:TeacherDetailService.java
 * @Package:com.sevenpp.qinglantutor.service
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2019年6月2日
 */
package com.sevenpp.qinglantutor.service;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;

/**
 * @ClassName:TeacherDetailService
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2019年6月2日
 *
 */
public interface TeacherDetailService {



	/**
	* @Title: getArticleMessages  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param: (参数)
	* @return:void(返回类型)
	*
	 */
	Article getArticleMessages(int articleId);

	/**
	* @Title: findArticleByid  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param id
	* @param:@return (参数)
	* @return:Article(返回类型)
	*
	 * @param id
	 * @return
	 */
	Article findArticleByid(int id);

	/**
	* @param articlereview 
	 * @Title: saveComment  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@return (参数)
	* @return:Article(返回类型)
	*
	 * @return
	 */
	 saveComment(ArticleReview articlereview);

	/**
	* @Title: getOneUser  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@param id
	* @param:@return (参数)
	* @return:User(返回类型)
	*
	 * @param id
	 * @return
	 */
	 User findUserByid(int userid);
	
		
}
