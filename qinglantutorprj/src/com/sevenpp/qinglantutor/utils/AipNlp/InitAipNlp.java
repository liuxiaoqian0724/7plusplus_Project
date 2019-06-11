package com.sevenpp.qinglantutor.utils.AipNlp;

import com.baidu.aip.nlp.AipNlp;

public class InitAipNlp {
	private static final String APP_ID = "16240655";
    private static final String API_KEY = "aaf7f2dbb6a2407b965e337e82331085";
    private static final String SECRET_KEY = "d2caf871ca33432494fc929728972d1f";
    
    // 初始化一个AipNlp
    public static AipNlp getAipNlp() {
     AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
     return client;
    }
    
    
}
