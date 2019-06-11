package com.sevenpp.qinglantutor.controller.teacherdetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TeacherDetailService;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

@Controller
public class TeacherDetailController {
	@Resource
	private TeacherDetailService teacherdetailServiceImpl;
	
	int aid;
	
	@RequestMapping("/teacherdetail")
	public String teacherDetail(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
		int id = Integer.valueOf(request.getParameter("artid"));
		this.aid=id;
		HttpSession session = request.getSession();
		Article article=this.teacherdetailServiceImpl.findArticleByid(id);
		request.setAttribute("article", article);
		
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
		
		List<Object> list = new ArrayList<>();
		List<ArticleReview> articleList = article.getUserReviewSet();
		for(int i=0;i<articleList.size();i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user",articleList.get(i).getUser());
			map.put("rContent",articleList.get(i).getrContent());
			map.put("rTime",articleList.get(i).getrTime());
			list.add(map);
		}
		
		
		//分页，第一页
		List<Object> list1 = new ArrayList<>();
		int page = 1;
		int pageTotal = 1;
		if(list.size()!=0) {
			pageTotal = list.size()%3 == 0 ? list.size()/3 : list.size()/3+1;
		}
		if(list.size()>=3) {
			list1.add(list.get(0));
			list1.add(list.get(1));
			list1.add(list.get(2));
		}else {
			for(int i=0;i<list.size();i++) {
				list1.add(list.get(i));
			}
		}
		//将artid传给前端
		request.setAttribute("artid",id);
		//将分页信息传给前端
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("page", page);
		request.setAttribute("teacherDetails", list1);
		
		return "teacher-detail";
		
	}
	@RequestMapping("/articleReviewJumps")
	public String jump(@RequestParam(value="page")int page,
			@RequestParam(value="artid")int artid,
			HttpServletRequest request,HttpServletResponse response) {
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

		Article article=this.teacherdetailServiceImpl.findArticleByid(artid);
		request.setAttribute("article", article);

		List<Object> list = new ArrayList<>();
		List<ArticleReview> articleList = article.getUserReviewSet();
		for(int i=0;i<articleList.size();i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user",articleList.get(i).getUser());
			map.put("rContent",articleList.get(i).getrContent());
			map.put("rTime",articleList.get(i).getrTime());
			list.add(map);
		}
		
		int pageTotal = 1;
		if(list.size()!=0) {
			pageTotal = list.size()%3 == 0 ? list.size()/3 : list.size()/3+1;
		}
		List<Object> list1 = new ArrayList<>();
		if(page == pageTotal ) {
			for(int i = (page-1)*3 ;i<list.size();i++) {
				list1.add(list.get(i));
			}
		}else {
			for(int i = (page-1)*3;i<(page-1)*3+3;i++) {
				list1.add(list.get(i));
			}
		}
		request.setAttribute("teacherDetails", list1);
		request.setAttribute("page", page);
		request.setAttribute("pageTotal", pageTotal);
		//将artid传给前端
		request.setAttribute("artid", artid);
		
		
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

	