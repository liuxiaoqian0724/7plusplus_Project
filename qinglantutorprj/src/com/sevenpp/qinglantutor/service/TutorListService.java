
		package com.sevenpp.qinglantutor.service;

		import java.util.List;

import javax.annotation.Resource;

		import org.springframework.stereotype.Service;

		import com.sevenpp.qinglantutor.dao.impl.ConditionsDaoImpl;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.Grade;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorListService
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月5日 下午4:35:48
		* 修改人：rain
		* 修改时间：2018年12月5日 下午4:35:48
		* 修改备注：
		* @version
		*
		*/
		public interface TutorListService {
			
			public List<Grade> grades();
			
			public List<Grade> gradesBySchoolType(String schoolType);
			
			public List<Course> courses();
			
}

	