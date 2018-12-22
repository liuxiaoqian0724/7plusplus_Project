package com.sevenpp.qinglantutor.utils.email;
import java.util.Random;
/*
 * 
 * @ClassName: CaptchaUtils 
 * @Description: 验证码生成
 * @author: Mr.Ren
 * @date: 2018年12月3日 上午8:14:34
 */
public class CaptchaUtils {
	/**
	 * 
			* @Title: creatCaptcha 
			* @Description: Constructor
			* @param @return   
			* @return String    返回类型
			* @author Mr.ren 
			* @throws
			* @date 2018年12月3日 上午8:23:40 
			* @version V1.0   
	 */
    public static String creatCaptcha(){
        String captcha = captcha(6);
        return captcha;
    }
    /**
     * 
    		* @Title: captcha 
    		* @Description: 生成0-10以内的随机数
    		* @param @param charCount
    		* @param @return    int
    		* @return String    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:29:35 
    		* @version V1.0   
     */
    public static String captcha(int charCount){
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }
    /**
     * 
    		* @Title: randomInt 
    		* @Description: 生成from-to的随机数
    		* @param @param from
    		* @param @param to
    		* @param @return    入参
    		* @return int    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:30:57 
    		* @version V1.0   
     */
    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
}
