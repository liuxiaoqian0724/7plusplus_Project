/**
 * @Title:TeacherDetailDao.java
 * @Package:com.sevenpp.qinglantutor.dao
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2019年6月2日
 */
package com.sevenpp.qinglantutor.dao;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;

/**
 * @ClassName:TeacherDetailDao
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2019年6月2日
 *
 */
public interface TeacherDetailDao {
	public Article findId(int articleId);
	public Article findArticleByid(int id);
	public void saveComment(ArticleReview articlereviewId) throws Exception;
	public User findUserByid(int userid);
}
