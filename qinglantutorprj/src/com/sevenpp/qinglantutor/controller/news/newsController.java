package com.sevenpp.qinglantutor.controller.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Msg;
import com.sevenpp.qinglantutor.entity.NewsPage;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.impl.personalServiceImpl;
import com.sevenpp.qinglantutor.dao.impl.reviewDaoImpl;
import com.sevenpp.qinglantutor.dao.impl.newsDaoImpl;
import com.sevenpp.qinglantutor.service.impl.newsServiceImpl;
import com.sevenpp.qinglantutor.service.impl.reviewServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：newsController
		* 类描述：个人中心消息部分controller
		* 创建人：rain
		* 创建时间：2018年12月11日 下午4:06:53
		* 修改人：rain
		* 修改时间：2018年12月11日 下午4:06:53
		* 修改备注：
		* @version
		*
		*/
@Controller
public class newsController {
	@Resource
	private personalServiceImpl personalServiceImpl;
	@Resource
	private newsServiceImpl newsServiceImpl;
	@Resource
	private reviewDaoImpl reviewDaoImpl;
	@Resource
	private newsDaoImpl newsDaoImpl;
	@Resource
	private reviewServiceImpl reviewServiceImpl;
	private String role;
	private String teacher;
	@RequestMapping(value = "/jumptoNews",produces = "text/html; charset=utf-8")
	public String Msg(String email,String pagenow,HttpServletRequest request,HttpServletResponse response) {	
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
		/*个人中心top部分*/
		teacher="老师";
		/*身份判断*/
		role=this.reviewDaoImpl.getrole(email1);
		if(role.startsWith(teacher)) {
			int userid=this.personalServiceImpl.findINTuserid(email1);
			List<User> listUser =this.personalServiceImpl.list(userid);
			request.getServletContext().setAttribute("personal", listUser);
			/*个人中心星星部分*/
			String finalstarfull=this.personalServiceImpl.finalstarfull(userid);
			System.out.println("finalstarfull:");
			System.out.println(finalstarfull);
			double finalstar=Double.valueOf(finalstarfull);
			int finalstarFloor=(int) Math.floor(finalstar);
			List<String> personalstar=this.reviewServiceImpl.getReviewStar((int) finalstarFloor);
			request.getServletContext().setAttribute("finalstarfull", finalstarfull);
			request.getServletContext().setAttribute("personalstar", personalstar);	
			
			
			/*获得user*/
			User user =this.personalServiceImpl.finduridByemail(email1);
			/*获得msg list*/
			List<Msg> list=this.newsServiceImpl.findMsg(user);
			/*使用自制实体类*/
			List<NewsPage> listfinal =new ArrayList<NewsPage>();
			
			/*消息区*/
			int a=list.size();
			int i=1;
			for (i=a;i>0;i--) {
				int b=i-1;
				int sendid=list.get(b).getSendId();
				List<User> listsend=this.personalServiceImpl.list(sendid);
				String cutcontent=list.get(b).getContent();
				String cutcontent1;
				if (cutcontent.length()>10) {
					cutcontent1=cutcontent.substring(0, 10);
				}
				else {
					cutcontent1=cutcontent;
				}
				/*此处使用自制实体newspage将msg内容与user内容组合为一个list方便前端输出*/
				NewsPage newspage =new NewsPage();
				newspage.setSid(sendid);
				newspage.setContent(list.get(b).getContent());
				newspage.setRid(list.get(b).getUser());
				newspage.setSendtime(list.get(b).getSendTime());
				newspage.setStatus(list.get(b).getStatus());
				newspage.setUsername(listsend.get(0).getUserName());
				newspage.setUserimg(listsend.get(0).getUserImg());
				newspage.setCutContent(cutcontent1);
				newspage.setMid(list.get(b).getMid());
				listfinal.add(newspage);
			}
			/*分页部分*/
			int page;
			try {
	            //当前页数
	            page = Integer.valueOf(pagenow);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
			int totalnews =listfinal.size();
			/*System.out.print("总页数:"+totalnews);*/
			int newsperpage=3;
			int totalpage=totalnews%newsperpage ==0?totalnews/newsperpage:totalnews/ newsperpage+1;
			int beginNews=(page-1)*newsperpage;
			int endNews=beginNews+newsperpage;
			if (endNews>totalnews) {
				endNews=totalnews;
			}
			List<NewsPage> listpage =listfinal.subList(beginNews, endNews);
			request.getServletContext().setAttribute("pagenow",page);
			request.getServletContext().setAttribute("totalnews", totalnews);
			request.getServletContext().setAttribute("newsperpage", newsperpage);
			request.getServletContext().setAttribute("totalpage", totalpage);
			request.getServletContext().setAttribute("beginNews", beginNews);
			request.getServletContext().setAttribute("endNews", endNews);
			request.getServletContext().setAttribute("news", listpage);
	/*		request.getServletContext().setAttribute("newsSender", listU);*/
			return "teacher-personal-center-mynews";
		}
		
		else {
			int userid=this.personalServiceImpl.findINTuserid(email1);
			List<User> listUser =this.personalServiceImpl.list(userid);
			request.getServletContext().setAttribute("personal", listUser);
			/*个人中心星星部分*/
			String finalstarfull=this.personalServiceImpl.Studentfinalstarfull(userid);
			double finalstar=Double.valueOf(finalstarfull);
			int finalstarFloor=(int) Math.floor(finalstar);
			List<String> personalstar=this.reviewServiceImpl.getReviewStar((int) finalstarFloor);
			request.getServletContext().setAttribute("finalstarfull", finalstarfull);
			request.getServletContext().setAttribute("personalstar", personalstar);	
			
			
			/*获得user*/
			User user =this.personalServiceImpl.finduridByemail(email1);
			/*获得msg list*/
			List<Msg> list=this.newsServiceImpl.findMsg(user);
			/*使用自制实体类*/
			List<NewsPage> listfinal =new ArrayList<NewsPage>();
			
			/*消息区*/
			int a=list.size();
			int i=1;
			for (i=a;i>0;i--) {
				int b=i-1;
				int sendid=list.get(b).getSendId();
				List<User> listsend=this.personalServiceImpl.list(sendid);
				String cutcontent=list.get(b).getContent();
				String cutcontent1;
				if (cutcontent.length()>10) {
					cutcontent1=cutcontent.substring(0, 10);
				}
				else {
					cutcontent1=cutcontent;
				}
				/*此处使用自制实体newspage将msg内容与user内容组合为一个list方便前端输出*/
				NewsPage newspage =new NewsPage();
				newspage.setSid(sendid);
				newspage.setContent(list.get(b).getContent());
				newspage.setRid(list.get(b).getUser());
				newspage.setSendtime(list.get(b).getSendTime());
				newspage.setStatus(list.get(b).getStatus());
				newspage.setUsername(listsend.get(0).getUserName());
				newspage.setUserimg(listsend.get(0).getUserImg());
				newspage.setCutContent(cutcontent1);
				newspage.setMid(list.get(b).getMid());
				listfinal.add(newspage);
			}
			/*分页部分*/
			int page;
			try {
	            //当前页数
	            page = Integer.valueOf(pagenow);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
			int totalnews =listfinal.size();
			System.out.print("总页数:"+totalnews);
			int newsperpage=3;
			int totalpage=totalnews%newsperpage ==0?totalnews/newsperpage:totalnews/ newsperpage+1;
			int beginNews=(page-1)*newsperpage;
			int endNews=beginNews+newsperpage;
			if (endNews>totalnews) {
				endNews=totalnews;
			}
			List<NewsPage> listpage =listfinal.subList(beginNews, endNews);
			request.getServletContext().setAttribute("pagenow",page);
			request.getServletContext().setAttribute("totalnews", totalnews);
			request.getServletContext().setAttribute("newsperpage", newsperpage);
			request.getServletContext().setAttribute("totalpage", totalpage);
			request.getServletContext().setAttribute("beginNews", beginNews);
			request.getServletContext().setAttribute("endNews", endNews);
			request.getServletContext().setAttribute("news", listpage);
	/*		request.getServletContext().setAttribute("newsSender", listU);*/
			return "student-personal-center-mynews";
		}
		
		
	}
	@RequestMapping(value = "/changeStatus",produces = "text/html; charset=utf-8")
	public String statuschange(String status,String mid,HttpServletRequest request,HttpServletResponse response) {
		Integer midnum;
		midnum= Integer.valueOf(mid);
		Integer statusnum;
		statusnum=Integer.valueOf(status);
		String re=this.newsServiceImpl.changeststus(midnum, statusnum);
		
		/*cookies*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email1="xiaoming@qq.com";
		String pagenow="1";
		//String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		String statustest="2";/*2是同意*/
		
		int sendid=this.newsDaoImpl.getsendId(midnum);
		User rid=this.newsDaoImpl.getreId(midnum);
		User ANTIrid=this.reviewDaoImpl.findurid(sendid);
		int ANTIsid=rid.getId();
		
		if(status.startsWith(statustest)) {
			String content=this.newsDaoImpl.Getphone(rid);
			String finalstr=this.newsServiceImpl.addMsgs(ANTIrid,ANTIsid,content);
		}
		else 
		{
			String content="He refuse your message";
			String finalstr=this.newsServiceImpl.addMsgsNorepeat(ANTIrid, ANTIsid, content);
		}
			return this.Msg(email1, pagenow, request, response);
		
		
	};
	@RequestMapping(value = "/InsertTRCR",produces = "text/html; charset=utf-8")
	public String insertTRCR(String mid,HttpServletRequest request,HttpServletResponse response) {
		Integer midnum;
		midnum= Integer.valueOf(mid);
		int sendid=this.newsDaoImpl.getsendId(midnum);
		User rid=this.newsDaoImpl.getreId(midnum);
		User URsendid=this.reviewDaoImpl.findurid(sendid);
		int ANTIsid=rid.getId();
		int status=2;
		String re=this.newsServiceImpl.changeststus(midnum, status);
		String content="class Success";
		String finalstr=this.newsServiceImpl.addMsgsNorepeat(URsendid, ANTIsid, content);
		int trid=this.newsDaoImpl.InsertTeacherRelation(URsendid);
		
		TeachRelation trx=this.newsDaoImpl.findTrid(URsendid);
		String finalRe =this.newsDaoImpl.InsertClassrelation(trx, rid);
		/*cookies部分*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials","true");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String email1="xiaoming@qq.com";
		String pagenow="1";
		//String email = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();

		return this.Msg(email1, pagenow, request, response);
		
		
	}
	/*@RequestMapping(value = "/addMsg",produces = "text/html; charset=utf-8")
	public String addMsg(String rid,String sid,String content) {
		Integer urid;
		urid=Integer.valueOf(rid);
		Integer sendid;
		sendid=Integer.valueOf(sid);
		
		User userid=this.reviewDaoImpl.findurid(urid);
		String finalstr=this.newsServiceImpl.addMsgs(userid,sendid,content);
		System.out.println(finalstr);
		return "addmsgsuccess";
		
	}*/

}

	