
		package com.sevenpp.qinglantutor.dao;

		import java.util.List;
		import com.sevenpp.qinglantutor.entity.Course;
		import com.sevenpp.qinglantutor.entity.Grade;

		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorListDao
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月5日 下午4:28:58
		* 修改人：rain
		* 修改时间：2018年12月5日 下午4:28:58
		* 修改备注：
		* @version
		*
		*/
		
		public interface TutorListDao {
			/**
			 * 
			 * @Title: grades 
			 * @Description: 查询所有年级
			 * @param @return    
			 * @return List<Grade>  
			 * @author cuishan
			 * @throws
			 * @date 2018年12月5日 下午4:30:27 
			 * @version V1.0   
			 */
			public List<Object[]> findAllGrades();
			
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
			public List<Object[]> findGradesBySchoolType(String schoolType);
				
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
			public List<Object[]> findAllCourses();
			
}

	