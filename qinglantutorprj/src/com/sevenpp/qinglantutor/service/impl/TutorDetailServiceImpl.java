/**   
		* @Title: TutorDetailServiceImpl.java 
		* @Package com.sevenpp.qinglantutor.service.impl 
		* @Description: 家教信息显示业务逻辑层
		* @author lxq
		* @date 2018年12月5日 下午3:18:13 
		* @version V1.0   
		*/

		package com.sevenpp.qinglantutor.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.impl.TutorDetailDaoImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.ReviewInf;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.service.TutorDetailService;
import com.sevenpp.qinglantutor.utils.message.SendMessage;
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorDetailServiceImpl
		* 类描述：
		* 创建人：lxq
		* 创建时间：2018年12月5日 下午3:18:13
		* 修改人：rain
		* 修改时间：2018年12月5日 下午3:18:13
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: TutorDetailServiceImpl 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月5日 下午3:18:13 
		* @version V1.0 
		*/
		@Service
		@Transactional
		public class TutorDetailServiceImpl implements TutorDetailService {
			
			@Resource
			private TutorDetailDaoImpl tutorDetailDaoImp;
			@Override
			/**
			* getTutorDetail 得到家教基本信息
			* @param 用户id
			* @param @return 设定文件
			* @return String DOM对象
			* @Exception 异常对象
			* @since CodingExample Ver(编码范例查看) 1.1
			*/
			public User getTutorDetail(Integer id) {
				return tutorDetailDaoImp.findTutorDetail(id);	
			}
			
			/**
			 * 
					* @Title: getTutorReview 
					* @Description: 获取家教评论总条数
					* @param @param id 用户id
					* @param @return    入参
					* @return Integer    返回类型
					* @author lxq 
					* @throws
					* @date 2018年12月18日 下午3:52:18 
					* @version V1.0   
			 */
			@Override
			public Integer getTutorReviewCount(Integer id){
				return tutorDetailDaoImp.findTutorReviewCount(id);
			}
			
			@Override
			/**
			 * 
					* @Title: getTutorReivew 
					* @Description: 获取家教所教过的学生的评论
					* @param @param id 用户id
					* @param @return    入参
					* @return ClassRelation    返回类型
					* @author lxq
					* @throws
					* @date 2018年12月18日 下午3:09:04 
					* @version V1.0
			 */
			public List<ReviewInf> getTutorReivew(Integer id) {
				User user=tutorDetailDaoImp.findTutorDetail(id);
				List<ReviewInf> ReviewInfList=new ArrayList<ReviewInf>();
				/**
				 * 得到上课关系集合
				 */
				List<TeachRelation> teachRelationList=user.getTeachRelations();
				for(TeachRelation tr:teachRelationList) {
					List<ClassRelation> classRelationList=tr.getClassRelation();
					ReviewInf reviewInf=new ReviewInf();
					for(ClassRelation cr:classRelationList) {
						List<Review> reviewList=cr.getReviews();
						for(Review r:reviewList) {
							reviewInf.setTeacherId(id);
							reviewInf.setReviewUserName(cr.getUser().getUserName());
							reviewInf.setReivewUserImg(cr.getUser().getUserImg());
							reviewInf.setReviewDateTime(r.getReviewTime());
							reviewInf.setReivewContent(r.getReviewContent());
							ReviewInfList.add(reviewInf);
						}
					}
				}
				return ReviewInfList;
			}
			
			/**
			 * 
					* @Title: sendMsgToTutor 
					* @Description: 系统向家教发送家长的咨询信息
					* @param @param id 老师iD
					* @param @return    
					* @return boolean    是否发送成功
					* @author lxq
					* @throws
					* @date 2018年12月24日 下午7:30:21 
					* @version V1.0   
			 */
			public void sendMsgToTutor(Integer id,Integer inquireId,String grade) {
				this.tutorDetailDaoImp.addInquireMsg(id, inquireId, grade);
				SendMessage sendMsg=new SendMessage();
				String []username=new String[1];
				username[0]=this.tutorDetailDaoImp.findTutorDetail(id).getUserName();
				String []userPhone=new String[1];
				userPhone[0]=this.tutorDetailDaoImp.findTutorDetail(id).getPhoneNumber();
				sendMsg.send(username, userPhone);
			}
}

	