		
		package com.sevenpp.qinglantutor.controller.tutorlist;

		import javax.annotation.Resource;

		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.RequestMapping;

		import com.sevenpp.qinglantutor.service.impl.TutorListServiceImpl;
		
		/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorlistControllerImpl
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月5日 下午4:18:56
		* 修改人：rain
		* 修改时间：2018年12月5日 下午4:18:56
		* 修改备注：
		* @version
		*
		*/
		
		@Controller
		@RequestMapping("/tutorlist")
		public class TutorlistController {
			
			@Resource
			private TutorListServiceImpl tutorListServiceImpl;
			
//			public String show
			
}

	