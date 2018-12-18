
package com.sevenpp.qinglantutor.controller.index;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sevenpp.qinglantutor.entity.Userinf;
import com.sevenpp.qinglantutor.service.Impl.IndexServiceImpl;

/**
		*
		* 椤圭洰鍚嶇О锛歲inglantutorprj
		* 绫诲悕绉帮細IndexController
		* 绫绘弿杩帮細鎺у埗棣栭〉
		* 鍒涘缓浜猴細rain
		* 鍒涘缓鏃堕棿锛�2018骞�12鏈�6鏃� 涓嬪崍4:47:50
		* 淇敼浜猴細rain
		* 淇敼鏃堕棿锛�2018骞�12鏈�6鏃� 涓嬪崍4:47:50
		* 淇敼澶囨敞锛�
		* @version
		*
		*/
		/**聽
		* @ClassName: IndexController聽
		* @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)聽
		* @author (浣滆��) 聽
		* @date 2018骞�12鏈�6鏃� 涓嬪崍4:47:50聽
		* @version V1.0聽
		*/
@Controller
public class IndexController {
	
	@Resource
	private IndexServiceImpl service;
	
	@RequestMapping("/search")
	public String indexSearchBox(@RequestParam("keyword") String keyword,Model model) {
		model.addAttribute("keyword",keyword);
		System.out.println(keyword);
		return "tutorlist";
	}
	@RequestMapping("/search/{schooltype}")
	public String schoolType(@PathVariable String schooltype,Model model) {
		model.addAttribute("schooltype", schooltype);
		System.out.println(schooltype);
		return "tutorlist";
	}
	@RequestMapping("/teacherdetail/{teacherid}")
	public String teacherDetail(@PathVariable String teacherid,Model model) {
		model.addAttribute("teacherid", teacherid);
		System.out.println(teacherid);
		return "teacherdetail";
	}
	@RequestMapping("/indexfile")
	public void findAllUser(HttpServletResponse response){
		System.out.println("IndexController");
		List<Userinf> list=new ArrayList<Userinf>();
		list=service.findAllUser();
		String str = JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer=response.getWriter();
			writer.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
		}
		
	}

}

	