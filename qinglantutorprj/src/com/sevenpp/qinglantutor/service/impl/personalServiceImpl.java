
		package com.sevenpp.qinglantutor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenpp.qinglantutor.dao.personalDaoImpl;
import com.sevenpp.qinglantutor.dao.reviewDaoImpl;
import com.sevenpp.qinglantutor.entity.ClassRelation;
import com.sevenpp.qinglantutor.entity.Review;
import com.sevenpp.qinglantutor.entity.TeachRelation;
import com.sevenpp.qinglantutor.entity.User;

/**
		*
		* 项目名称：qinglantutorprj
		* 类名称：personalServiceaImpl
		* 类描述：个人中心整体Service
		* 创建人：刘杼滨
		* 创建时间：2018年12月10日 上午8:27:26
		* 修改人：
		* 修改时间：2018年12月10日 上午8:27:26
		* 修改备注：
		* @version
		*
		*/
@Service
@Transactional(readOnly=true)
public class personalServiceImpl {
	@Resource
	private personalDaoImpl personalDaoImpl;
	@Resource
	private personalServiceImpl personalServiceImpl;
	@Resource
	private newsServiceImpl newsServiceImpl;
	@Resource
	private reviewServiceImpl reviewServiceImpl;
	@Resource
	private reviewDaoImpl reviewDaoImpl;
		/**以id查询User表获得list*/
		public List<User> list(int id) {
			return this.personalDaoImpl.findAll(id);
			
		}
		/**以Email查询User表获得ID*/
		public User finduridByemail(String email) {
			return this.personalDaoImpl.finduridByemail(email);
			
		}
		/**以Email查询User表获得int类型ID*/
		public int findINTuserid(String email) {
			return this.personalDaoImpl.findINTuridByemail(email);
		}
		/**个人中心星级部分打包*/
		public double finalstarfull(int id){
			User user=this.reviewDaoImpl.findurid(id);
			List<TeachRelation> listTR=this.reviewDaoImpl.findtridByTid(user);
			int i=listTR.size();
			int x=1;
			int Star=0;
			int reviewnum=0;
			for(x=i;x>0;x--) {
				int z=x-1;
				TeachRelation trx=listTR.get(z);
				List<ClassRelation> listCr=trx.getClassRelation();
					int a=listCr.size();
					int y=1;
					for (y=a;y>0;y--) {
						int b=y-1;
						ClassRelation crx=listCr.get(b);
						List<Review> list2=this.reviewServiceImpl.list(crx);
						
						int reviewstar=list2.get(0).getReviewStar();
						Star=Star+reviewstar;
						reviewnum++;
					}
			}
			double reviewfull=reviewnum;
			double starfull=Star;
			double AVGstarfull=starfull/reviewfull;
			double finalstar=Math.floor(AVGstarfull);
			List<String> personalstar=this.reviewServiceImpl.getReviewStar((int) finalstar);
			
			return AVGstarfull;
		}

	

}

	