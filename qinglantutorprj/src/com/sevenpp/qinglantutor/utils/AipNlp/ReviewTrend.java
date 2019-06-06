package com.sevenpp.qinglantutor.utils.AipNlp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;
import com.sevenpp.qinglantutor.entity.ReviewInf;
import com.sevenpp.qinglantutor.entity.TrendReview;

public class ReviewTrend {

		public static HashMap<ReviewInf, JSONObject>  getReviewTrend(AipNlp client,List<ReviewInf> reviewList) {
			// 传入可选参数调用接口
			HashMap<String, Object> options = new HashMap<String, Object>();
			//评论，评论返回请求json对象
			HashMap<ReviewInf, JSONObject> reviewListTrend = new HashMap<ReviewInf,JSONObject>();
			for(int i=0;i<reviewList.size();i++) {
				JSONObject response = client.commentTag(reviewList.get(i).getReivewContent(), ESimnetType.EDU,options);
				HashMap<String,TrendReview> nameMap = 
						JSON.parseObject(response,new TypeReference<HashMap<String,TrendReview>>() {});
				System.out.println("respose"+response);
				String str=JSON.toJSONString(response);
				System.out.println("reviewTrend"+str);
				reviewListTrend.put(reviewList.get(i),response);
				System.out.println(reviewListTrend.get(reviewList.get(i)));
			}
			return reviewListTrend;	
		}
}
