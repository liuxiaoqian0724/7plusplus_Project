package com.sevenpp.qinglantutor.utils.AipNlp;

import com.baidu.aip.nlp.AipNlp;

public class InitAipNlp {
	private static final String APP_ID = "16240655";
    private static final String API_KEY = "RnmMs4IYe941qVz5RSVfMbPK";
    private static final String SECRET_KEY = "cboY6oo7DM8ZMMnBNWP7OxEHQiu6SWtj";
    
    // 初始化一个AipNlp
    public static AipNlp getAipNlp() {
     AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
     return client;
    }
    
    
}
