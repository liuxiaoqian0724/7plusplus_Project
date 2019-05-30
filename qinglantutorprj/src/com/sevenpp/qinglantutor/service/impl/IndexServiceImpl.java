
package com.sevenpp.qinglantutor.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sevenpp.qinglantutor.dao.impl.ArticlelistDaoImpl;
import com.sevenpp.qinglantutor.dao.impl.IndexDaoImpl;
import com.sevenpp.qinglantutor.entity.Article;
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
		List<User> userList = new ArrayList<User>();
		List<Userinf> userlist = new ArrayList<Userinf>();
		List teachagelist=new ArrayList();
		userList = idi.queryUser();
		teachagelist=idi.queryTeachage();
		for (int i = 0; i < userList.size(); i++) {
			userinf = new Userinf();
			if(userList.get(i).getId()!=null) {
				userinf.setId(userList.get(i).getId());
			}
			else {
				userinf.setId(0);
			}
			if(userList.get(i).getIntroduce()!=null) {
				userinf.setIntroduce(userList.get(i).getIntroduce());
			}
			else {
				userinf.setIntroduce("还没有简介");
			}
			if(userList.get(i).getRealName()!=null) {
				userinf.setRealName(userList.get(i).getRealName());
			}
			else {
				userinf.setRealName("名字暂时保密");
			}
			if(userList.get(i).getSchool()!=null) {
				userinf.setSchool(userList.get(i).getSchool());
			}
			else {
				userinf.setSchool("学校暂时保密");
			}
			if(userList.get(i).getUserImg()!=null) {
				userinf.setUserImg(userList.get(i).getUserImg());
			}
			else {
				userinf.setUserImg("images/default.jpg");
			}
			userlist.add(userinf);
		}
		for(int i=0;i<teachagelist.size();i++) { 
			userlist.get(i).setTeachAge(teachagelist.get(i).toString());
		}
		return userlist;
	}
	@Override
	public List<Article> findAllArticles(){
		List<Article> list=new ArrayList();
		list=idi.queryArticles();
		return list;
	}
}
