package com.sevenpp.qinglantutor.controller.review;
import com.sevenpp.qinglantutor.dao.reviewDaoImpl;
import com.sevenpp.qinglantutor.service.impl.personalServiceImpl;
import com.sevenpp.qinglantutor.service.impl.reviewServiceImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.NewsPage;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value = "/jumptoReview",produces = "text/html; charset=utf-8")
	public String review(String userid,String email,HttpServletRequest request,HttpServletRequest response) throws UnsupportedEncodingException  {
		/*request.setCharacterEncoding("UTF-8");*/
		System.out.println(request.getCharacterEncoding());
		/*Integer xid;
		xid=Integer.valueOf(userid);*/
		
		/*个人中心top部分*/
		int personalid=this.personalServiceImpl.findINTuserid(email);
		List<User> listUser =this.personalServiceImpl.list(personalid);
		request.getServletContext().setAttribute("personal", listUser);
		
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
						listRe.addAll(list2);
						
						int reviewstar=list2.get(0).getReviewStar();
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
						newspage.setReview(list2);
						newspage.setStar(starfulllist);
						listpage.add(newspage);
						
					}
			}
			/*获得平均分 每位用户只能有一个平均分*/
			double reviewfull=reviewnum;
			double starfull=Star;
			double AVGstarfull=starfull/reviewfull;
			double finalstar=Math.floor(AVGstarfull);
			List<String> personalstar=this.reviewServiceImpl.getReviewStar((int) finalstar);
		request.getServletContext().setAttribute("personalstar",personalstar);
		request.getServletContext().setAttribute("listpage",listpage);
		/*request.getServletContext().setAttribute("review", listRe);*/
		request.getServletContext().setAttribute("finalstarfull", AVGstarfull);
		request.getServletContext().setAttribute("finalstar", finalstar);
		return "student-personal-center-evaluation";
		/*TeachRelation tr=this.reviewDaoImpl.findTrid(user);
		ClassRelation cr=this.reviewDaoImpl.findCrid(tr);
		request.getServletContext().setAttribute("review", list3);*/
		
	}
	
	

}

	