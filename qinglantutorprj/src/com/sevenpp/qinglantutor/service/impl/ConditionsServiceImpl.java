
		package com.sevenpp.qinglantutor.service.impl;

		import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.ConditionsDaoImpl;
import com.sevenpp.qinglantutor.entity.UserInfo;

/**
		*
		* 椤圭洰鍚嶇О锛歲inglantutorprj
		* 绫诲悕绉帮細ConditionsServiceImpl
		* 绫绘弿杩帮細conditionsDaoImpl鐨凷ervice
		* 鍒涘缓浜猴細cuishan
		* 鍒涘缓鏃堕棿锛�2018骞�12鏈�12鏃� 涓婂崍8:35:21
		* 淇敼浜猴細rain
		* 淇敼鏃堕棿锛�2018骞�12鏈�12鏃� 涓婂崍8:35:21
		* 淇敼澶囨敞锛�
		* @version
		*
		*/
		
		@Service	
		public class ConditionsServiceImpl {
			@Resource
			private ConditionsDaoImpl conditionsDaoImpl;
			
			
			public List addConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				return this.conditionsDaoImpl.addConditions(conditions, grade, subject, department, sex, major);
			}

			public List deleteConditions(List conditions,String grade,String subject,String department,String sex,String major) {
				return this.conditionsDaoImpl.deteleConditions(conditions, grade, subject, department, sex, major); 
			}
			
			
			
			/**
			 * 
			 * @Title: findHql聽
			 * @Description: 鐢ㄤ簬瀹舵暀搴撻〉鏌ヨ鍚勭鏉′欢
			 * @param @param grade
			 * @param @param subject
			 * @param @param department
			 * @param @param sex
			 * @param @param major
			 * @param @return 聽 聽鍏ュ弬
			 * @return String 聽 聽杩斿洖绫诲瀷
			 * @author 锛堜綔鑰咃級聽
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓婂崍8:43:24聽
			 * @version V1.0 聽聽
			 */
			public String findSql(int grade,int subject,String department,String sex,String major,String schooltype) {
				return this.conditionsDaoImpl.findSql(grade, subject, department, sex, major,schooltype);
			}
			
			/**
			 * 
					* @Title: findReviewStarById聽
					* @Description: TODO 鏍规嵁id鏌ヨ璇勭骇鏄熺骇
					* @param @param id
					* @param @return 聽 聽鍏ュ弬
					* @return int 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�17鏃� 涓婂崍8:20:48聽
					* @version V1.0 聽聽
			 */
			public int findReviewStarById(int id) {
				return this.conditionsDaoImpl.findReviewStarById(id);
			}
			/**
			 * 
					* @Title: findReviewSumById聽
					* @Description: TODO 鏍规嵁鑰佸笀id鏌ヨ鍑哄浠栫殑璇勪环鎬绘暟
					* @param @param tid
					* @param @return 聽 聽鍏ュ弬
					* @return int 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�17鏃� 涓婂崍8:17:28聽
					* @version V1.0 聽聽
			 */
			public int findReviewSumById(int tid) {
				return this.conditionsDaoImpl.findReviewSumById(tid);
			}
			
			/**
			 * 
					* @Title: findReviewContentById聽
					* @Description: TODO 鏌ヨ绗竴鏉¤瘎浠�
					* @param @param tid
					* @param @return 聽 聽鍏ュ弬
					* @return String 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�17鏃� 涓婂崍8:22:44聽
					* @version V1.0 聽聽
			 */
			public String findReviewContentById(int tid) {
				return this.conditionsDaoImpl.findReviewContentById(tid);
			}
			
			/**
			 * 
			 * @Title: findGidByGname聽
			 * @Description: TODO鏍规嵁gname鏌ヨgid
			 * @param @param gname
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author 锛堜綔鑰咃級聽
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓婂崍8:45:11聽
			 * @version V1.0 聽聽
			 */
			public int findGidByGname(String gname) {
				return this.conditionsDaoImpl.findGidByGname(gname);
			}
			
			/**
			 * 
			 * @Title: findCidByCname聽
			 * @Description: TODO鏍规嵁cname鏌ヨcid
			 * @param @param cname
			 * @param @return 聽 聽鍏ュ弬
			 * @return int 聽 聽杩斿洖绫诲瀷
			 * @author 锛堜綔鑰咃級聽
			 * @throws
			 * @date 2018骞�12鏈�12鏃� 涓婂崍8:46:27聽
			 * @version V1.0 聽聽
			 */
			public int findCidByCname(String cname) {
				return this.conditionsDaoImpl.findCidByCname(cname);
			}
			
			/**
			 * 
					* @Title: findTutorOnUserByConditions聽
					* @Description: TODO 鏌ヨ绗﹀悎鏉′欢鐨勮�佸笀鐨剈ser琛ㄤ腑鐨勭浉搴斾俊鎭�
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return 聽 聽鍏ュ弬
					* @return List<Object[]> 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�17鏃� 涓婂崍8:23:45聽
					* @version V1.0 聽聽
			 */
			public List<Object[]> findTutorOnUserByConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				return this.conditionsDaoImpl.findTutorOnUserByConditions(grade, subject, department, sex, major,schooltype);
			}
			
			/**
			 * 
					* @Title: findTutorOnMyJobByConditions聽
					* @Description: TODO  鏌ヨ绗﹀悎鎵�鏈夋潯浠剁殑鑰佸笀
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return 聽 聽鍏ュ弬
					* @return List<Object[]> 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�17鏃� 涓婂崍8:24:39聽
					* @version V1.0 聽聽
			 */
			public List<UserInfo> findTutorByAllConditions(int grade,int subject,String department,String sex,String major,String schooltype){
				List<Object[]> tutorlist=this.conditionsDaoImpl.findTutorByAllConditions(grade, subject, department, sex, major,schooltype);
				List<UserInfo> tutors=new ArrayList<UserInfo>();
				for (Object[] objects : tutorlist) {
					//寰楀埌id
					int id=(int)objects[0];
					//鏍规嵁id寰楀埌鏄熺骇
					int star=this.findReviewStarById(id);
					int sum=this.findReviewSumById(id);
					String content=this.findReviewContentById(id);
					Object[] objs=new Object[9];
					for(int i=0;i<6;i++) 
						objs[i]=objects[i];
					objs[6]=star;
					objs[7]=sum;
					objs[8]=content;
					UserInfo userinfo=new UserInfo((int)objs[0],objs[1].toString(),objs[2].toString(),objs[3].toString(),(int)objs[4],objs[5].toString(),(int)objs[6],(int)objs[7],objs[8].toString());
					userinfo.setIntellgencesort();
					tutors.add(userinfo);
				}
				String new_introduce="";
				for (UserInfo userInfo : tutors) {
					if(userInfo.getIntroduce().length()>30) {
//						System.out.println("introduce.length:"+userInfo.getIntroduce().length());
						new_introduce=userInfo.getIntroduce().substring(0, 40)+"...";
						userInfo.setIntroduce(new_introduce);
					}
				}
				return tutors;
			}
			
			/**
			 * 
					* @Title: findCountByPage聽
					* @Description: 寰楀埌浠ユ煇绉嶆柟寮忔煡璇㈢殑淇℃伅鎬绘潯鏁�
					* @param @param grade
					* @param @param subject
					* @param @param department
					* @param @param sex
					* @param @param major
					* @param @return 聽 聽鍏ュ弬
					* @return int 聽 聽杩斿洖绫诲瀷
					* @author 锛堜綔鑰咃級聽
					* @throws
					* @date 2018骞�12鏈�20鏃� 涓婂崍9:16:10聽
					* @version V1.0 聽聽
			 */
			public int findCountByPage(int grade,int subject,String department,String sex,String major,String schooltype) {
				return this.conditionsDaoImpl.findCountByPage(grade,subject, department, sex, major,schooltype);
			}
}

	