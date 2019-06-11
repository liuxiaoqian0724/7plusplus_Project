package com.sevenpp.qinglantutor.utils.AipNlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
import com.sevenpp.qinglantutor.entity.ReviewInf;
import com.sevenpp.qinglantutor.entity.TrendReview;

public class ReviewTrend {

		public static List<TrendReview>  getReviewTrend(AipNlp client,List<ReviewInf> reviewList) {
			// 传入可选参数调用接口
			HashMap<String, Object> options = new HashMap<String, Object>();
			//评论，评论返回请求json对象
			List<TrendReview> reviewListTrend = new ArrayList<TrendReview>();
			for(int i=0;i<reviewList.size();i++) {
				JSONObject response = client.commentTag(reviewList.get(i).getReivewContent(), ESimnetType.EDU,options);
				String strJson=response.toString();
				com.alibaba.fastjson.JSONObject jsonObject=JSON.parseObject(strJson);
				com.alibaba.fastjson.JSONArray items= (com.alibaba.fastjson.JSONArray) jsonObject.get("items");//获取json对象中的items数组
				TrendReview tr=new TrendReview();
				for (int j = 0; j < items.size(); j++) {
					com.alibaba.fastjson.JSONObject dataBean = (com.alibaba.fastjson.JSONObject) items.get(j);//得到数组中对应下标对应的json对象
//					//josn数组中获取值赋给对象
					tr.setProp((String)dataBean.get("prop"));
					tr.setAdj((String)dataBean.get("adj"));
//					tr.setProp(JSON.toJSONString((String)dataBean.get("sentiment")));
//					tr.setProp(JSON.toJSONString((String)dataBean.get("begin_pos")));
//					tr.setProp(JSON.toJSONString((String)dataBean.get("end_pos")));
					tr.setAbstractWord((String)dataBean.get("abstractWord"));
				}
				//初始化reviewTrend对象
				tr.setTeacherId(reviewList.get(i).getTeacherId());
				tr.setReviewUserName(reviewList.get(i).getReviewUserName());
				tr.setReivewUserImg(reviewList.get(i).getReivewUserImg());
				tr.setReivewContent(reviewList.get(i).getReivewContent());
				tr.setReviewDateTime(reviewList.get(i).getReviewDateTime());
				reviewListTrend.add(tr);
			}
			return reviewListTrend;	
		}
}
