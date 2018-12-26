package com.sevenpp.qinglantutor.controller.news;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenpp.qinglantutor.entity.Msg;
import com.sevenpp.qinglantutor.entity.NewsPage;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.dao.reviewDaoImpl;
import com.sevenpp.qinglantutor.service.impl.newsServiceImpl;
import com.sevenpp.qinglantutor.service.impl.personalServiceImpl;
import com.sevenpp.qinglantutor.service.impl.reviewServiceImpl;

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
	private reviewServiceImpl reviewServiceImpl;
	
	@RequestMapping(value = "/jumptoNews",produces = "text/html; charset=utf-8")
	public String Msg(String email,HttpServletRequest request) {
		
		/*个人中心top部分*/
		int userid=this.personalServiceImpl.findINTuserid(email);
		List<User> listUser =this.personalServiceImpl.list(userid);
		request.getServletContext().setAttribute("personal", listUser);
		/*个人中心星星部分*/
		double finalstarfull=this.personalServiceImpl.finalstarfull(userid);
		int finalstar=(int) finalstarfull;
		List<String> personalstar=this.reviewServiceImpl.getReviewStar((int) finalstar);
		request.getServletContext().setAttribute("finalstarfull", finalstarfull);
		request.getServletContext().setAttribute("personalstar", personalstar);
		
		
		/*获得user*/
		User user =this.personalServiceImpl.finduridByemail(email);
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
			String cutcontent1=cutcontent.substring(0, 10);
			
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
			listfinal.add(newspage);
		}
		request.getServletContext().setAttribute("news", listfinal);
/*		request.getServletContext().setAttribute("newsSender", listU);*/
		
		
		return "student-personal-center-mynews";
		
	}

}

	