
package com.sevenpp.qinglantutor.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.IndexDaoImpl;
import com.sevenpp.qinglantutor.entity.Course;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.entity.Userinf;
import com.sevenpp.qinglantutor.service.IndexService;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexServiceImpl
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 上午11:09:41
		* 修改人：rain
		* 修改时间：2018年12月7日 上午11:09:41
		* 修改备注：
		* @version
		*
		*/
/**
 * @ClassName: IndexServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author (作者)
 * @date 2018年12月7日 上午11:09:41
 * @version V1.0
 */
@Service
public class IndexServiceImpl implements IndexService {
	@Resource
	private IndexDaoImpl idi;

	private Userinf userinf;

	@Override
	public List<Userinf> findAllUser() {
		System.out.println("IndexServiceImpl");
		List<User> userList = new ArrayList<User>();
		List<Userinf> userlist = new ArrayList<Userinf>();
		List teachagelist=new ArrayList();
		userList = idi.queryUser();
		teachagelist=idi.queryTeachage();
		userinf = new Userinf();
		for (int i = 0; i < userList.size(); i++) {
			userinf = new Userinf();
			userinf.setId(userList.get(i).getId());
			userinf.setIntroduce(userList.get(i).getIntroduce());
			userinf.setRealName(userList.get(i).getRealName());
			userinf.setSchool(userList.get(i).getSchool());
			userinf.setUserImg(userList.get(i).getUserImg());
			userlist.add(userinf);
		}
		for(int i=0;i<teachagelist.size();i++) {
			userlist.get(i).setTeachAge(teachagelist.get(i).toString());
		}
		return userlist;
	}

}
