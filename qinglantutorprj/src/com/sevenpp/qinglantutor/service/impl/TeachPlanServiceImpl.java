package com.sevenpp.qinglantutor.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.TeachPlanDaoImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachPlan;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TeachPlanService;


/**
*项目名称：qinglantutorprj
* 类名称：TeachPlanServiceImpl
* 类描述：
* 创建人：rain
* 创建时间：2018年12月14日 下午4:42:39
* 修改人：rain
* 修改时间：2018年12月14日 下午4:42:39
* 修改备注：
* @version
*
*/
@Service
@Transactional
public class TeachPlanServiceImpl implements TeachPlanService {

	@Resource
	private TeachPlanDaoImpl teachPlanDaoImpl;
	
	public List<Object> getTeachPlanInfor(String email) {
		/**
		* getTeachPlanInfor		查出我的教案页面详细信息
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		List<Object> list = new ArrayList<Object>();
		User user = this.teachPlanDaoImpl.getUserByEmail(email);
		if(user.getRole().startsWith("学生")) {
			List<ClassRelation> classRelationList = user.getClassRelation();
			TeachRelation teachRelation = null;
			List<TeachPlan> teachPlans = new ArrayList<TeachPlan>();
			for(int i=0;i<classRelationList.size();i++) {
				teachRelation = classRelationList.get(i).getTeachRelation();
				teachPlans = teachRelation.getTeachPlans();
				
				List<Object> planDetailMapList = new ArrayList<>();
				for(int m=0;m<teachPlans.size();m++) {
					Map<String, Object> planDetailMap = new HashMap<String, Object>();
					planDetailMap.put("content", teachPlans.get(m).getContent());
					
					SimpleDateFormat format = new SimpleDateFormat("MM-dd");
					planDetailMap.put("time", format.format(teachPlans.get(m).getTime()));

					planDetailMapList.add(planDetailMap);
				}
				
				Map<String, Object> map = new HashMap<String,Object>();
				map.put("img", teachRelation.getUser().getUserImg());
				map.put("name", teachRelation.getUser().getRealName());
				map.put("planDetailMap",planDetailMapList);
				
				list.add(map);
			}
		}else {
			List<TeachRelation> teachRelationList = user.getTeachRelations();
			List<TeachPlan> teachPlans = new ArrayList<TeachPlan>();
			List<ClassRelation> classRelationList = new ArrayList<ClassRelation>();
			User student = null;
			for(int i=0;i<teachRelationList.size();i++) {
				teachPlans = teachRelationList.get(i).getTeachPlans();
				classRelationList = teachRelationList.get(i).getClassRelation();
				/**
				 * 将教案详细存为Map集合，在前端好展示
				 */
				List<Object> planDetailMapList = new ArrayList<>();
				for(int m=0;m<teachPlans.size();m++) {
					Map<String, Object> planDetailMap = new HashMap<String, Object>();
					planDetailMap.put("content", teachPlans.get(m).getContent());
					planDetailMap.put("planId", teachPlans.get(m).getId());
					
					SimpleDateFormat format = new SimpleDateFormat("MM-dd");
					planDetailMap.put("time", format.format(teachPlans.get(m).getTime()));

					planDetailMapList.add(planDetailMap);
				}
				/**
				 * 将每行的教案存为一个Map集合
				 */
				for(int j=0;j<classRelationList.size();j++) {
					student = classRelationList.get(j).getUser();
					
					Map<String, Object> map = new HashMap<String,Object>();
					map.put("trid", teachRelationList.get(i).getTrid());
					map.put("img", student.getUserImg());
					map.put("name", student.getRealName());
					map.put("planDetailMap", planDetailMapList);
					
					list.add(map);
				}
			}
		}
		return list;
	}
	
	public User getRoleByEmail(String email) {
		/**
		* getRoleByEmail	得到身份
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		return this.teachPlanDaoImpl.getUserByEmail(email);
	}

	public void editTeachPlan(String content, String time, Integer id) {
		/**
		* editTeachPlan		我的教案编辑
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");  
		Date date = new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			System.out.println("我的教案编辑， 时间转换错误");
			e.printStackTrace();
		}
		this.teachPlanDaoImpl.changeTeachPlan(id, content, date);
	}

	public void deleteTeachPlan(Integer id) {
		/**
		* deleteTeachPlan	删除某个教案
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		this.teachPlanDaoImpl.deleteTeachPlan(id);
	}

	public int addTeachPlan(Integer trid, String content, String time) {
		/**
		* addTeachPlan		插入某个教案
		* @param name
		* @param @return 设定文件
		* @return String DOM对象
		* @Exception 异常对象
		* @since CodingExample Ver(编码范例查看) 1.1
		*/
		TeachRelation teachRelation = this.teachPlanDaoImpl.getTeachRelationByTrid(trid);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");  
		Date date = new Date();
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			System.out.println("我的教案增加， 时间转换错误");
			e.printStackTrace();
		}
		return this.teachPlanDaoImpl.addTeachPlan(content, date, teachRelation);
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
		User user = this.teachPlanDaoImpl.getUserByEmail(email);
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


}

	