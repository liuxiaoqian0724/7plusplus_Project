
package com.sevenpp.qinglantutor.service.impl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.NewsPage;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;
import com.sevenpp.qinglantutor.dao.reviewDaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：reviewServiceImpl
		* 类描述：评价功能相关的Service层
		* 创建人：刘杼滨
		* 创建时间：2018年12月5日 下午2:35:11
		* 修改人：刘杼滨
		* 修改时间：2018年12月5日 下午2:35:11
		* 修改备注：
		* @version
		*
		*/
@Service
@Transactional(readOnly=true)
public class reviewServiceImpl {
	@Resource
	private reviewDaoImpl reviewDaoImpl;
	@Resource
	private reviewServiceImpl reviewServiceImpl;
	@Resource
	private personalServiceImpl personalServiceImpl;

	
	public List<Review> list(ClassRelation tr) {
		
		return this.reviewDaoImpl.findAll(tr);
	}
	
	/**获得星级方法
	 * 本方法需要获得从Review表查出的ReviewStar(int)作为参数,将返回List，为两种星星图片的名称list
	 * */
	public List<String> getReviewStar(int reviewstar){
		
		int finalstar1;
		List<String>starfulllist=new ArrayList<String>();
		for (finalstar1=reviewstar;finalstar1>0;finalstar1--) {
			starfulllist.add("fill-star");
		}
		double finalstar2;
		for(finalstar2=5-reviewstar;finalstar2>0;finalstar2--) {
			starfulllist.add("empty-star");
		}
		
		return starfulllist;
	}

}

	