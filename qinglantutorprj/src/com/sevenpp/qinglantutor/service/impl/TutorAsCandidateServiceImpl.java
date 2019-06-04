
		package com.sevenpp.qinglantutor.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.TutorAsCandidateDaoImpl;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.Userinfosec;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：TutorAsCandidateServiceImpl
		* 类描述：
		* 创建人：rain
		* 创建时间：2019年5月13日 下午2:53:25
		* 修改人：rain
		* 修改时间：2019年5月13日 下午2:53:25
		* 修改备注：
		* @version
		*
		*/
		@Service
		public class TutorAsCandidateServiceImpl {
			@Resource
			private TutorAsCandidateDaoImpl tutorAsCandidateDaoImpl;
			
			/**
			 * 
					* @Title: findUsers 
					* @Description: 根据id列表获取对应的用户列表
					* @param @param digitList
					* @param @return    入参
					* @return List<User>    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月13日 下午3:00:05 
					* @version V1.0   
			 */

			/**
			 * 
					* @Title: findUserinfosec 
					* @Description: 通过User列表得到Userinfosec列表 
					* @param @param users
					* @param @return    入参
					* @return List<Userinfosec>    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 下午2:27:14 
					* @version V1.0   
			 */
			public List<Userinfosec> findUserinfosec(List<User> users){
				List<Userinfosec> userinfos=new ArrayList<Userinfosec>();
				for (User user : users) {
					Userinfosec userinfo=new Userinfosec();
					userinfo.setId(user.getId());
					userinfo.setName(user.getRealName());
					userinfo.setPrice(findPrice(user));
					userinfo.setReviewstar(findReviewStar(user));
					userinfo.setTeachage(findteachage(user));
					userinfo.setTeachsum(findteachstusum(user));
					userinfos.add(userinfo);
				}
				return userinfos;
			}
			
			/**
			 * 
					* @Title: findReviewStar 
					* @Description: 获取星级
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:19:07 
					* @version V1.0   
			 */
			public Integer findReviewStar(User user) {
				return this.tutorAsCandidateDaoImpl.findReviewStar(user);
			}
			
			/**
			 * 
					* @Title: findPrice 
					* @Description: 获取价格
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:54:39 
					* @version V1.0   
			 */
			public Integer findPrice(User user) {
				return this.tutorAsCandidateDaoImpl.findPrice(user);
			}
			
			/**
			 * 
					* @Title: findteachage 
					* @Description: 获取教龄
					* @param @param user
					* @param @return    入参
					* @return Integer    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:55:28 
					* @version V1.0   
			 */
			public Integer findteachage(User user) {
				return this.tutorAsCandidateDaoImpl.findteachage(user);
			}
			
			/**
			 * 
					* @Title: findDataIntegrity 
					* @Description: 查询资料完整度
					* @param @param user
					* @param @return    入参
					* @return double    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 上午10:56:50 
					* @version V1.0   
			 */
			public double findDataIntegrity(User user) {
				return this.tutorAsCandidateDaoImpl.findDataIntegrity(user);
			}
			
			/**
			 * 
					* @Title: findteachstusum 
					* @Description: 查询教过的学生数
					* @param @param user
					* @param @return    入参
					* @return int    返回类型
					* @author （作者） 
					* @throws
					* @date 2019年5月14日 下午2:36:42 
					* @version V1.0   
			 */
			public int findteachstusum(User user) {
				return this.tutorAsCandidateDaoImpl.findteachstrsum(user);
			}
			
}

	