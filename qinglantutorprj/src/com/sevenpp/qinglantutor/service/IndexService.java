

package com.sevenpp.qinglantutor.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sevenpp.qinglantutor.entity.Article;
import com.sevenpp.qinglantutor.entity.Userinf;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：IndexService
		* 类描述：
		* 创建人：rain
		* 创建时间：2018年12月7日 下午8:23:27
		* 修改人：rain
		* 修改时间：2018年12月7日 下午8:23:27
		* 修改备注：
		* @version
		*
		*/
		/** 
		* @ClassName: IndexService 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月7日 下午8:23:27 
		* @version V1.0 
		*/
@Component
public interface IndexService {
	public List<Userinf> findAllUser();
	public List<Article> findAllArticles();
}