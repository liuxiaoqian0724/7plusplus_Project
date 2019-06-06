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
				System.out.println(strJson);
				com.alibaba.fastjson.JSONObject jsonObject=JSON.parseObject(strJson);
				com.alibaba.fastjson.JSONObject items= (com.alibaba.fastjson.JSONObject) response.get("items");//获取json对象中的items数组
				TrendReview tr=new TrendReview();
				
				
				//初始化reviewTrend对象
//				tr.setTeacherId(reviewList.get(i).getTeacherId());
//				tr.setReviewUserName(reviewList.get(i).getReviewUserName());
//				tr.setReivewUserImg(reviewList.get(i).getReivewUserImg());
//				tr.setReivewContent(reviewList.get(i).getReivewContent());
//				tr.setReviewDateTime(reviewList.get(i).getReviewDateTime());
//				//josn数组中获取值赋给对象
//				tr.setProp(JSON.toJSONString(items.get("prop")));
//				tr.setProp(JSON.toJSONString(items.get("adj")));
//				tr.setProp(JSON.toJSONString(items.get("sentiment")));
//				tr.setProp(JSON.toJSONString(items.get("begin_pos")));
//				tr.setProp(JSON.toJSONString(items.get("end_pos")));
//				tr.setProp(JSON.toJSONString(items.get("abstractWord")));
//				System.out.println("trrrrr"+tr.toString());
//				reviewListTrend.add(tr);
			}
			return null;	
		}
}
