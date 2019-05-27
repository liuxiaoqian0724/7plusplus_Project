package com.sevenpp.qinglantutor.controller.review;


import com.sevenpp.qinglantutor.dao.impl.reviewDaoImpl;
import com.sevenpp.qinglantutor.dao.impl.personalDaoImpl;
import com.sevenpp.qinglantutor.service.impl.reviewServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;
import com.sevenpp.qinglantutor.service.impl.personalServiceImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.NewsPage;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：reviewController
		* 类描述：评价组件的controller层
		* 创建人：刘杼滨
		* 创建时间：2018年12月5日 下午2:52:12
		* 修改人：rain
		* 修改时间：2018年12月5日 下午2:52:12
		* 修改备注：
		* @version
		*
		*/
@Controller
public class reviewController {
	@Resource
	private reviewServiceImpl reviewServiceImpl;
	@Resource
	private personalServiceImpl personalServiceImpl;
	@Resource
	private reviewDaoImpl reviewDaoImpl;
	@Resource
	private personalDaoImpl personalDaoImpl;
	
	@RequestMapping(value = "/jumptoReview",produces = "text/html; charset=utf-8")
	public String review(String userid,String email,String pagenow,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException  {
		
		/*request.setCharacterEncoding("UTF-8");*/
		
		/*Integer xid;
		xid=Integer.valueOf(userid);*/
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
		String teacher="老师";
		/*身份判断*/
		String role=this.reviewDaoImpl.getrole(email1);
		
		if(role.startsWith(teacher))
		{
			/*个人中心top部分*/
			int personalid=this.personalServiceImpl.findINTuserid(email1);
			List<User> listUser =this.personalServiceImpl.list(personalid);
			request.getServletContext().setAttribute("personal", listUser);
			/*个人中心星星部分*/
			String finalstarfull=this.personalServiceImpl.finalstarfull(personalid);
			double finalstar=Double.valueOf(finalstarfull);
			int finalstarFloor=(int) Math.floor(finalstar);
			List<String> personalstar=this.personalDaoImpl.getReviewStar((int) finalstarFloor);
			request.getServletContext().setAttribute("finalstarfull", finalstarfull);
			request.getServletContext().setAttribute("personalstar", personalstar);	
			
			
			
			/*评价部分*/
			
			User user=this.reviewDaoImpl.findurid(personalid);
			List<TeachRelation> listTR=this.reviewDaoImpl.findtridByTid(user);
			int i=listTR.size();
			int x=1;
			int Star=0;
			int reviewnum=0;
			
			List<Review> listRe = new ArrayList<Review>();
			List<NewsPage> listpage=new ArrayList<NewsPage>();
				for(x=i;x>0;x--) {
					int z=x-1;
					TeachRelation trx=listTR.get(z);
					List<ClassRelation> listCr=trx.getClassRelation();
					/*ClassRelation cr=this.reviewDaoImpl.findCrid(trx);*/
						int a=listCr.size();
						int y=1;
						for (y=a;y>0;y--) {
							int b=y-1;
							ClassRelation crx=listCr.get(b);
							List<Review> list2=this.reviewServiceImpl.list(crx);
							if (list2.isEmpty()) {}
								
							else
							{
								
								User us=crx.getUser();
								int giverid=us.getId();
								List<User> listReviewGiver=this.personalServiceImpl.list(giverid);
								String givername=listReviewGiver.get(0).getUserName();
								listRe.addAll(list2);
								int list2num=list2.size();
								int list2numx=1;
								for(list2numx=list2num;list2numx>0;list2numx--) {
									int c=list2numx-1;
									List<Review> list3=list2.subList(c,list2numx);
									if (list3.isEmpty()) {}
									else {
										int reviewstar=list3.get(0).getReviewStar();
										Star=Star+reviewstar;
										reviewnum++;
										/*获得星星的方法，将在reviewService里打包*/
										int finalstar1;
										List<String>starfulllist=new ArrayList<String>();
										for (finalstar1=reviewstar;finalstar1>0;finalstar1--) {
											starfulllist.add("fill-star");
										}
										double finalstar2;
										for(finalstar2=5-reviewstar;finalstar2>0;finalstar2--) {
											starfulllist.add("empty-star");
										}
										NewsPage newspage =new NewsPage();
										newspage.setReview(list3);
										newspage.setStar(starfulllist);
										listpage.add(newspage);
										newspage.setGivername(givername);
										
									}
									
								}
								
							}
						}
				}
				int page;
				try {
		            //当前页数
		            page = Integer.valueOf(pagenow);
		        } catch (NumberFormatException e) {
		            page = 1;
		        }
				int totalnews =listpage.size();
				int newsperpage=3;
				int totalpage=totalnews%newsperpage ==0?totalnews/newsperpage:totalnews/ newsperpage+1;
				int beginNews=(page-1)*newsperpage;
				int endNews=beginNews+newsperpage;
				if (endNews>totalnews) {
					endNews=totalnews;
				}
				if (totalpage==0) {
					totalpage=1;
				}
				List<NewsPage> listpagefinal =listpage.subList(beginNews, endNews);
			request.getServletContext().setAttribute("listpage",listpagefinal);
			request.getServletContext().setAttribute("pagenow",page);
			request.getServletContext().setAttribute("totalnews", totalnews);
			request.getServletContext().setAttribute("newsperpage", newsperpage);
			request.getServletContext().setAttribute("totalpage", totalpage);
			request.getServletContext().setAttribute("beginNews", beginNews);
			request.getServletContext().setAttribute("endNews", endNews);
			return "teacher-personal-center-evaluation";
		}
		
		else{
			/*个人中心top部分*/
			int personalid=this.personalServiceImpl.findINTuserid(email1);
			List<User> listUser =this.personalServiceImpl.list(personalid);
			request.getServletContext().setAttribute("personal", listUser);
			/*个人中心星星部分*/
			String finalstarfull=this.personalServiceImpl.Studentfinalstarfull(personalid);
			double finalstar=Double.valueOf(finalstarfull);
			int finalstarFloor=(int) Math.floor(finalstar);
			List<String> personalstar=this.personalDaoImpl.getReviewStar(finalstarFloor);
			request.getServletContext().setAttribute("finalstarfull", finalstarfull);
			request.getServletContext().setAttribute("personalstar", personalstar);	
			
			
			
			/*评价部分*/
			
			User user=this.reviewDaoImpl.findurid(personalid);
			List<TeachRelation> listTR=this.reviewDaoImpl.findtridByTid(user);
			List<ClassRelation> listCR=this.reviewDaoImpl.findcridByTrid(user);
			int i=listCR.size();
			int x=1;
			int Star=0;
			int reviewnum=0;
			
			
			/*评级以及星级部分*/
			List<Review> listRe = new ArrayList<Review>();
			List<NewsPage> listpage=new ArrayList<NewsPage>();
				for(x=i;x>0;x--) {
					int z=x-1;
					List<Review> list=listCR.get(z).getReviews();
					ClassRelation CRP=listCR.get(z);
					if (list.isEmpty()){}
					else 
					{
						ClassRelation crx=list.get(0).getClassRelation();
						List<Review> list2=this.personalDaoImpl.findAll(crx);
						if (list2.isEmpty()) {}
						else {
							/*List<ClassRelation> cr=list.get(0).getClassRelation();*/
							TeachRelation tr=CRP.getTeachRelation();
							
							User tid=tr.getUser();
							int giverid=tid.getId();
							List<User> listReviewGiver=this.personalServiceImpl.list(giverid);
							String givername=listReviewGiver.get(0).getUserName();
							
							listRe.addAll(list2);
							int list2num=list2.size();
							int list2numx=1;
								for(list2numx=list2num;list2numx>0;list2numx--) {
									int c=list2numx-1;
									List<Review> list3=list2.subList(c,list2numx);
									if (list3.isEmpty()) {}
									else {
										int reviewstar=list3.get(0).getReviewStar();
										Star=Star+reviewstar;
										reviewnum++;
										/*获得星星的方法，将在reviewService里打包*/
										int finalstar1;
										List<String>starfulllist=new ArrayList<String>();
										for (finalstar1=reviewstar;finalstar1>0;finalstar1--) {
											starfulllist.add("fill-star");
										}
										double finalstar2;
										for(finalstar2=5-reviewstar;finalstar2>0;finalstar2--) {
											starfulllist.add("empty-star");
										}
										NewsPage newspage =new NewsPage();
										newspage.setReview(list3);
										newspage.setStar(starfulllist);
										listpage.add(newspage);
										newspage.setGivername(givername);
										
									}
									
								}
							}
					}
					
					}
				/*分页部分*/
				int page;
				try {
		            //当前页数
		            page = Integer.valueOf(pagenow);
		        } catch (NumberFormatException e) {
		            page = 1;
		        }
				int totalnews =listpage.size();
				int newsperpage=3;
				int totalpage=totalnews%newsperpage ==0?totalnews/newsperpage:totalnews/ newsperpage+1;
				int beginNews=(page-1)*newsperpage;
				int endNews=beginNews+newsperpage;
				if (endNews>totalnews) {
					endNews=totalnews;
				}
				if (totalpage==0) {
					totalpage=1;
				}
				List<NewsPage> listpagefinal =listpage.subList(beginNews, endNews);
			request.getServletContext().setAttribute("listpage",listpagefinal);
			request.getServletContext().setAttribute("pagenow",page);
			request.getServletContext().setAttribute("totalnews", totalnews);
			request.getServletContext().setAttribute("newsperpage", newsperpage);
			request.getServletContext().setAttribute("totalpage", totalpage);
			request.getServletContext().setAttribute("beginNews", beginNews);
			request.getServletContext().setAttribute("endNews", endNews);
			return "student-personal-center-evaluation";
		
		}
		
		
	}
	
	

}

	