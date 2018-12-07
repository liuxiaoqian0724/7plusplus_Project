
		package com.sevenpp.qinglantutor.service.impl;

		import java.util.List;

		import javax.annotation.Resource;

		import org.springframework.stereotype.Service;

		import com.sevenpp.qinglantutor.dao.TutorListDao;
		import com.sevenpp.qinglantutor.dao.impl.ConditionsDaoImpl;
		import com.sevenpp.qinglantutor.entity.Course;
		import com.sevenpp.qinglantutor.entity.Grade;
		import com.sevenpp.qinglantutor.service.TutorListService;


		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorListServiceImpl
		* 类描述：
		* 创建人：cuishan
		* 创建时间：2018年12月5日 下午4:23:50
		* 修改人：cuishan
		* 修改时间：2018年12月5日 下午4:23:50
		* 修改备注：
		* @version
		*
		*/
		
		@Service
		public class TutorListServiceImpl implements TutorListService {
			
			@Resource
			private ConditionsDaoImpl conditionsDaoImpl;
			
			/**
			 * 
			 * @Title: grades 
			 * @Description: 查询所有年级
			 * @param @return
			 * @return List<Grade>  
			 * @author cuishan
			 * @throws
			 * @date 2018年12月5日 下午3:25:17 
			 * @version V1.0   
			 */
			public List<Grade> grades(){
				return this.conditionsDaoImpl.findGrades();
			}
			
			/**
			 * 
			 * @Title: gradesBySchoolType 
			 * @Description: 根据传参的年级类型显示年级
			 * @param @param schoolType
			 * @param @return  
			 * @return List<Grade>
			 * @author cuishan 
			 * @throws
			 * @date 2018年12月5日 下午4:48:55 
			 * @version V1.0   
			 */
			public List<Grade> gradesBySchoolType(String schoolType){
				return this.conditionsDaoImpl.findGradesBySchoolType(schoolType);
			}
			
			/**
			 * 
			 * @Title: courses 
			 * @Description: 查询所有课程 
			 * @param @return 
			 * @return List<Course>
			 * @author cuishan
			 * @throws	
			 * @date 2018年12月5日 下午3:30:44 
			 * @version V1.0   
			 */
			public List<Course> courses(){
				return this.conditionsDaoImpl.findCourses();
			}
			
			

}

	