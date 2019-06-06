package com.sevenpp.qinglantutor.service.impl;

import com.sevenpp.qinglantutor.dao.impl.StudentDetailDaoImpl;
import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.ArticleReview;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.StudentDetailService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly=true)
public class StudentDetailServiceImpl implements StudentDetailService {
	@Resource StudentDetailDaoImpl studentdetaildaoimpl;
	
	@Override
	public List<Article> AtricleShow() {
		// TODO Auto-generated method stub
		return this.studentdetaildaoimpl.AtricleShow();
	}

	@Override
	public List<ArticleReview> AtricleReview() {
		// TODO Auto-generated method stub
		return this.studentdetaildaoimpl.AtricleReview();

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
		User user = this.studentdetaildaoimpl.getUserByEmail(email);
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
		
		map.put("user", user);
		map.put("grade", grade);
		
		return map;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
				return this.studentdetaildaoimpl.getUserByEmail(email);
			
	}

}

	