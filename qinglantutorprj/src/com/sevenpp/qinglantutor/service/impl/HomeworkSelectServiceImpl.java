package com.sevenpp.qinglantutor.service.impl;

import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.dao.impl.HomeworkSelectDaoImpl;
import com.sevenpp.qinglantutor.entity.HomeWork;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.HomeworkSelectService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly=true)
public class HomeworkSelectServiceImpl implements HomeworkSelectService {
	@Resource HomeworkSelectDaoImpl homeworkSelectDaoImpl;
	
	@Override
	public List<HomeWork> HomeworkShow() {
		// TODO Auto-generated method stub
		
			return this.homeworkSelectDaoImpl.HomeWorkShow();
		
	}
	
	public List<ClassRelation> ClassRelation() {
		// TODO Auto-generated method stub
		
			return this.homeworkSelectDaoImpl.ClassRelation();
		
	}
	public List<TeachRelation> TeachRelation(){
		  return this.homeworkSelectDaoImpl.TeachRelation();
	}
	public Map<String, Object> getPersonalDetail(String email) {
		/**
		* getPersonalDetail		得到个人中心上方信息条的信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		Map<String, Object> map = new HashMap<>();
		User user = this.homeworkSelectDaoImpl.getUserByEmail(email);
		List<ClassRelation> classRelationList =  new ArrayList<>();
		List<Review> reviewList = new ArrayList<>();
		int starTotal = 0 , reviewTotal = 0;
		
		if(user.getRole().startsWith("老师")) {
			List<TeachRelation> teachRelationList= user.getTeachRelations();
			for(int i=0;i<teachRelationList.size();i++) {
				classRelationList = teachRelationList.get(i).getClassRelation();
				for(int j=0;j<classRelationList.size();j++) {
					reviewList = classRelationList.get(j).getReviews();
					for(int m=0;m<reviewList.size();m++) {
						starTotal = starTotal + reviewList.get(m).getReviewStar();
					}
					reviewTotal = reviewTotal + reviewList.size();
				}
			}
		}else {
			classRelationList = user.getClassRelation();
			for(int i=0;i<classRelationList.size();i++) {
				reviewList = classRelationList.get(i).getReviews();
				for(int j=0;j<reviewList.size();j++) {
					starTotal = starTotal + reviewList.get(j).getReviewStar();
				}
				reviewTotal = reviewTotal + reviewList.size();
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.0");
		String grade = new String();
		int star  = 0;
		if(reviewTotal == 0) {
			star = 0;
			grade = "0";
		}else {
			star= starTotal/reviewTotal ;	
			grade = df.format((float)starTotal/reviewTotal);
		}
		int i = 1 , j = 5-star;
		for(int m=0;m<star;m++) {
			map.put("star"+i,"fill-star");i++;
		}
		for(int m=0;m<j;m++) {
			map.put("star"+i,"empty-star");i++;
		}
		
		System.out.println(map.get("star1"));
		map.put("user", user);
		map.put("grade", grade);
		
		return map;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
				return this.homeworkSelectDaoImpl.getUserByEmail(email);
				/**
				* getUserByEmail(这里用一句话描述这个方法的作用)
				* TODO(这里描述这个方法适用条件 – 可选)
				* TODO(这里描述这个方法的执行流程 – 可选)
				* TODO(这里描述这个方法的使用方法 – 可选)
				* TODO(这里描述这个方法的注意事项 – 可选)
				* @param name
				* @param @return 设定文件
				* @return String DOM对象
				* @Exception 异常对象
				* @since CodingExample Ver(编码范例查看) 1.1
				*/
			
	}
	
}
