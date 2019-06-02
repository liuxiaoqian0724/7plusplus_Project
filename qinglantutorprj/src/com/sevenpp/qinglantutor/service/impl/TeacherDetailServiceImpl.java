/**
 * @Title:TeacherDetailServiceImpl.java
 * @Package:com.sevenpp.qinglantutor.service.impl
 * @Description:TODO(用一句话描述该文件做什么)
 * @Author:吕凝慧
 * @Date:2019年6月2日
 */
package com.sevenpp.qinglantutor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.TeacherDetailDaoImpl;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TeacherDetailService;

/**
 * @ClassName:TeacherDetailServiceImpl
 * @Description:TODO（用一句话描述这个类的作用）
 * @Author 吕凝慧
 * @Date:2019年6月2日
 *
 */
@Service
@Transactional(readOnly=true)
public class TeacherDetailServiceImpl implements TeacherDetailService {
		@Resource
		private TeacherDetailDaoImpl teacherdetailDaoImpl;
	
		public Article getArticleMessages(int articleId) {
			
			return this.teacherdetailDaoImpl.findId(articleId);
		}
		public Article findArticleByid(int id) {
			return this.teacherdetailDaoImpl.findArticleByid(id);
		}
		public	void saveComment(ArticleReview articlereviewId) {
			try {
				this.teacherdetailDaoImpl.saveComment(articlereviewId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public User findUserByid(int userid) {
			return this.teacherdetailDaoImpl.findUserByid(userid);
		}
}
