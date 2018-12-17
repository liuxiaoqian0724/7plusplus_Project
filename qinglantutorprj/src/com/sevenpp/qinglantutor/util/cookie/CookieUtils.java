package com.sevenpp.qinglantutor.util.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 

		* @ClassName: CookieUtils 
		* @Description: cookie的工具类
		* @author (作者)  
		* @date 2018年12月6日 上午10:06:17 
		* @version V1.0 
 */
public class CookieUtils {
    /**
     * 
    		* @Title: getCookieFromCookies 
    		* @Description: 从cookie数组中获取指定key的cookie
    		* @param @param cookies
    		* @param @param target
    		* @param @return    入参
    		* @return Cookie    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月6日 上午10:06:43 
    		* @version V1.0   
     */
    public static Cookie getCookieFromCookies(Cookie[] cookies,String target){
        Cookie cookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getName().equals(target)){
                cookie = cookies[i];
            }
        }

        return cookie;
    }
    /**
     * 
    		* @Title: removeAllCookies 
    		* @Description: 根据cookie名称移除cookie
    		* @param @param req
    		* @param @param resp    入参
    		* @return void    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月6日 上午10:07:20 
    		* @version V1.0   
     */
    public static void removeAllCookies(HttpServletRequest req,HttpServletResponse resp){
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie: cookies){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                resp.addCookie(cookie);
            }
    }
   /**
    * 
   		* @Title: removeCookieByName 
   		* @Description: 根据cookie名称移除cookie
   		* @param @param cookie_name
   		* @param @param request
   		* @param @param resp    入参
   		* @return void    返回类型
   		* @author Mr.Ren 
   		* @throws
   		* @date 2018年12月6日 上午10:07:07 
   		* @version V1.0   
    */
    public static void removeCookieByName(String cookie_name,HttpServletRequest request,HttpServletResponse resp){
        Cookie cookie = null;
           Cookie[] cookies = null;
           // 获取当前域名下的cookies，是一个数组
           cookies = request.getCookies();
           if( cookies != null ){
              for (int i = 0; i < cookies.length; i++){
                 cookie = cookies[i];
                 if((cookie.getName()).compareTo(cookie_name) == 0 ){
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                 }
              }
           }
    }

}