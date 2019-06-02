package com.sevenpp.qinglantutor.controller.teacherdetail;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.service.TeacherDetailService;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsController
		* 类描述：个人中心消息部分controller
		* 创建人：吕凝慧
		* 创建时间：2018年12月11日 下午4:06:53
		* 修改人：吕凝慧
		* 修改时间：2018年12月11日 下午4:06:53
		* 修改备注：
		* @version
		*
		*/
@Controller
public class TeacherDetailController {
	@Resource
	private TeacherDetailService teacherdetailServiceImpl;
	
	@RequestMapping(value = "/teacherdetail",produces = "text/html; charset=utf-8")
	public String teacherDetail(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
//		String id = request.getParameter("artid");
		int id = 1;
		HttpSession session = request.getSession();
		Article article=this.teacherdetailServiceImpl.findArticleByid(id);
		request.setAttribute("article", article);
		/*返回文章的信息包含文章名称、内容、评论、类型*/
	/*	System.out.println("a");
		int articleId;

		articleId=1;
		System.out.println("b");
		Article  article = this.teacherdetailServiceImpl.getArticleMessages(articleId);
		System.out.println("ok");*/
		return "teacher-detail";
		
	}
	@RequestMapping(value = "/teacherdetail",produces = "text/html; charset=utf-8")
	public String saveMessage(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
//		String id = request.getParameter("artid");
		int id = 1;
		HttpSession session = request.getSession();
		ArticleReview articlereview=new ArticleReview();
		String articlecontent = request.getParameter("articlecontent");
		articlereview.setrContent(articlecontent);
		//格式化日期类
		long time=System.currentTimeMillis();
		String stime=String.valueOf(time);
		Timestamp timestamp = Timestamp.valueOf(stime);
		
		Article article=this.teacherdetailServiceImpl.findArticleByid(id);
		int userid=Integer.parseInt(session.getId());
		com.sevenpp.qinglantutor.entity.User user=this.teacherdetailServiceImpl.findUserByid(userid);
		articlereview.setArticle(article);
		articlereview.setrTime(timestamp);
		articlereview.setUser(user);
		this.teacherdetailServiceImpl.saveComment(articlereview);

		return "teacher-detail";
		
	}
	/**
	* @Title: Date  
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param:@return (参数)
	* @return:Date(返回类型)
	*
	 * @return
	 */
	private Date Date() {
		// TODO Auto-generated method stub
		return null;
	}

}

	