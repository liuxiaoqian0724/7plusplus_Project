package com.sevenpp.qinglantutor.controller.teacherdetail;

import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.log.LogServerImpl;
import com.sevenpp.qinglantutor.service.TeacherDetailService;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;


@Controller
public class TeacherDetailController {
	@Resource
	private TeacherDetailService teacherdetailServiceImpl;
	@Resource
	private LogServerImpl logServerImpl;
	
	int aid;
	@RequestMapping("/teacherdetail")
	public String teacherDetail(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
		int id = Integer.valueOf(request.getParameter("artid"));
		this.aid=id;
		HttpSession session = request.getSession();
		Article article=this.teacherdetailServiceImpl.findArticleByid(id);
		request.setAttribute("article", article);
		
		//Find ArticleReview By Article
		Set<ArticleReview> articlereview = article.getUserReviewSet();
		
		/*cookies获取email*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email1 = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		//根据email来获取User对象
		User user = this.teacherdetailServiceImpl.FindUserByEmail(email1);
		request.setAttribute("user", user);
		
//		将用户浏览文章详情页历史记录存入日志文件中
		logServerImpl.tutor_logs(user.getId(), id, "article");
		
		return "teacher-detail";
		
	}
	@RequestMapping("/teacherdetails")
	public String saveMessage(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
//		int id = Integer.valueOf(request.getParameter("artid"));
		int id=this.aid;
		/*cookies获取email*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email1 = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		//根据email来获取User对象
		User user = this.teacherdetailServiceImpl.FindUserByEmail(email1);
		request.setAttribute("user", user);
		User nuser=new User();
		nuser.setId(user.getId());
		
		//add ArticleReview
		ArticleReview articlereview=new ArticleReview();
		
		//change articlereview.Content
		String articlecontent = request.getParameter("articlecontent");
		articlereview.setrContent(articlecontent);
		
		//标准化时间
		articlereview.setrTime(new Date());
		
		//change articlereview.article
		Article article=this.teacherdetailServiceImpl.findArticleByid(id);
		Article narticle=new Article();
		narticle.setaId(article.getaId());
		articlereview.setArticle(narticle);
		
		//change articlereview.user
		articlereview.setUser(user);
		
		this.teacherdetailServiceImpl.saveComment(articlereview);

		return "forward:teacherdetail?artid="+id;
		
	}

}
	