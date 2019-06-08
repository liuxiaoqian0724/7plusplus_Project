
package com.sevenpp.qinglantutor.utils.AipNlp;

import java.util.HashMap;

import java.util.Map;


import net.sf.json.JSONObject;

/**

 * @作者: tjx

 * @描述: 文本审核API

 * @创建时间: 创建于17:19 2018/9/7

 **/

public class CheckTextAPI {

    private static final String URL = "https://aip.baidubce.com/rest/2.0/antispam/v2/spam";

    /**

     * @param content 需要审核的文本

     *

     * @return true 通过 false 失败

     */

    public boolean check(String content){
        //获取access_token

        String access_token = AuthService1.getAuth();

        Map<String,String> parameters = new HashMap<>();

        //添加调用参数

        parameters.put("access_token",access_token);

        parameters.put("content",content);

        //调用文本审核接口

        String result = HttpUtil.doPost(URL, parameters);

        // JSON转换

        JSONObject jsonObj = JSONObject.fromObject(result);

        Map<String, Class> classMap = new HashMap<String, Class>();

        classMap.put("result",Result.class);

        classMap.put("pass",Pass.class);

        classMap.put("bass",CheckTextResult.class);

        CheckTextResult bean = (CheckTextResult)JSONObject.toBean(jsonObj, CheckTextResult.class, classMap);

        //根据API返回内容处理业务逻辑 （这里简单模拟,）
        if(bean.getResult().getReject().size() + bean.getResult().getReview().size() > 0){
            return false;
        }
        return true;
    }
}
