package com.sevenpp.qinglantutor.utils.message;
import java.io.IOException;

import javax.xml.ws.http.HTTPException;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.sevenpp.qinglantutor.common.MessageConstant;
/**
*code is far away from bug with the animal protecting
*  ┏┓　　　┏┓
*┏┛┻━━━┛┻┓
*┃　　　　　　　┃ 　
*┃　　　━　　　┃
*┃　┳┛　┗┳　┃
*┃　　　　　　　┃
*┃　　　┻　　　┃
*┃　　　　　　　┃
*┗━┓　　　┏━┛
*　　┃　　　┃神兽保佑
*　　┃　　　┃代码无BUG！
*　　┃　　　┗━━━┓
*　　┃　　　　　　　┣┓
*　　┃　　　　　　　┏┛
*　　┗┓┓┏━┳┓┏┛
*　　　┃┫┫　┃┫┫
*　　　┗┻┛　┗┻┛ 
*　　　
* @author 作者 :Mr.Ren
* @version 创建时间：2018年12月19日 上午10:28:35
* 类说明
*/
public class SendMessage {
	/**
	 * 
	 * @Title: send 
	 * @Description: 发送信息
	 * @param @param params 收信人的姓名，和收信人的手机号
	 * @return void    返回类型
	 * @author Mr.Ren 
	 * @throws @date 2018年12月19日 上午10:31:27 
	 * @version V1.0   
	 */
	public static void send(String[] username, String[] phoneNumbers) {
		try {
			SmsMultiSender msender = new SmsMultiSender(MessageConstant.APPID, MessageConstant.APPKEY);
			SmsMultiSenderResult result = msender.sendWithParam("86", phoneNumbers, MessageConstant.TEMPLATEID,
					username, MessageConstant.SMSSIGN, "", ""); // 签名参数未提供或者为空时，会使用默认签名发送短信
			System.out.print(result);
		} catch (HTTPException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (com.github.qcloudsms.httpclient.HTTPException e) {
			e.printStackTrace();
		}

	}
}
	