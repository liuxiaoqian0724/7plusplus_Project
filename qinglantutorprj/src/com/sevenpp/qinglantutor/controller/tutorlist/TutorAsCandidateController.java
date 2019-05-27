package com.sevenpp.qinglantutor.controller.tutorlist;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.Userinfosec;
import com.sevenpp.qinglantutor.service.impl.TutorAsCandidateServiceImpl;
import com.sevenpp.qinglantutor.service.impl.TutorDetailServiceImpl;
import com.sevenpp.qinglantutor.utils.cookie.CookieUtils;

@Controller
public class TutorAsCandidateController {
	@Resource
	private TutorDetailServiceImpl tutorDetailServiceImpl;
	private TutorAsCandidateServiceImpl tutorAsCandidateServiceImpl;
	
	@RequestMapping(value="/findCandiateInfo",method=RequestMethod.GET)
	public String sendMsgToTutor(@RequestParam("arr") String arr,HttpServletRequest request,HttpServletResponse response,
								Model model,ModelAndView mv) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setContentType("textml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Cookie[]cookies = request.getCookies();
		String SESSIONID = CookieUtils.getCookieFromCookies(cookies,"JSESSIONID").getValue();
		String EMAIL = CookieUtils.getCookieFromCookies(cookies,"EMAIL").getValue();
		Integer inquireId=this.tutorDetailServiceImpl.findUser(EMAIL);
		List<String> digitList = new ArrayList<String>();
		//正则表达式取值
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(arr);
		String result = m.replaceAll("");
		for (int i = 0; i < result.length(); i++) {
			digitList.add(result.substring(i, i+1));	 
		}
		System.out.println(digitList);//候选老师的id集合
		response.setCharacterEncoding("utf-8");
		System.out.println(digitList);
		//得到User集合
		List<User> users=new ArrayList<User>();
		System.out.println(users);
		if(!digitList.isEmpty()) {
			System.out.println("not empty");
//			this.tutorAsCandidateServiceImpl.findUsers(digitList);
			int id=0;
			for (String digit : digitList) {
				id=Integer.parseInt(digit);
				System.out.println("id:"+id);
				if(this.tutorDetailServiceImpl.getTutorDetail(id)!=null)
					users.add(this.tutorDetailServiceImpl.getTutorDetail(id));
			}
			System.out.println("users.size:"+users.size());
//			if(this.tutorAsCandidateServiceImpl.findUsers(digitList)!=null) {
//				users=this.tutorAsCandidateServiceImpl.findUsers(digitList);
//			}
			//得到Userinfos集合  
			List<Userinfosec> userinfos=new ArrayList<Userinfosec>();
//			userinfos=this.tutorAsCandidateServiceImpl.findUserinfosec(users);
			for (User user : users) {
				Userinfosec userinfo=new Userinfosec();
				userinfo.setId(user.getId());
				userinfo.setName(user.getRealName());
				userinfo.setPrice(this.tutorDetailServiceImpl.findPrice(user));
				userinfo.setReviewstar(this.tutorDetailServiceImpl.findReviewStar(user));
				userinfo.setTeachage(this.tutorDetailServiceImpl.findteachage(user));
				userinfo.setTeachsum(this.tutorDetailServiceImpl.findteachstusum(user));
				userinfo.setDataintegrity(this.tutorDetailServiceImpl.findDataIntegrity(user));
				userinfos.add(userinfo);
			}
			//制作雷达图
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			String group;
			for (Userinfosec userinfosec : userinfos) {
				group=userinfosec.getName();
				dataset.addValue(userinfosec.getPrice(), group, "价格");
				dataset.addValue(userinfosec.getReviewstar(), group, "好评");
				dataset.addValue(userinfosec.getTeachage(), group, "教龄");
				dataset.addValue(userinfosec.getTeachsum(), group, "教过的学生数");
				dataset.addValue(userinfosec.getDataintegrity(), group, "资料完整度");
			}
			return "image";
//			SpiderWebPlot spiderwebplot = new SpiderWebPlot(dataset);
//			JFreeChart jfreechart = new JFreeChart("Test", TextTitle.DEFAULT_FONT, spiderwebplot, false);
//			LegendTitle legendtitle = new LegendTitle(spiderwebplot);
//			legendtitle.setPosition(RectangleEdge.TOP);
//			jfreechart.addSubtitle(legendtitle);
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			String filename = ServletUtilities.saveChartAsPNG(jfreechart, 400, 500, null);
//			String graphURL = request.getContextPath() + "/DisplayChart?filename="   + filename;
//			System.out.println(graphURL);
//			String image=  "<img src='" 
//		            + graphURL 
//		            + "' width=400 height=500 border=0 usemap='#" 
//		            + filename + "'/>"; 
//			System.out.println("success");
//			model.addAttribute("radarimage", image);
//			mv.setViewName("image");
////			return mv;
		}
		return null;
	}
}
