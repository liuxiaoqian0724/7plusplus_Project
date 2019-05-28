package com.sevenpp.qinglantutor.utils.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 
		* @ClassName: EmailTemplet 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author Mr.Ren  
		* @date 2018年12月3日 上午8:41:54 
		* @version V1.0 
 */
public class EmailTemplet {
	/**
	 * 
			* @Title: getHtml 
			* @Description: 从模板生成html邮件
			* @param @param title
			* @param @param userName
			* @param @param type
			* @param @param captcha
			* @param @return    入参
			* @return String    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月3日 上午8:42:13 
			* @version V1.0   
	 */
    public static String getHtml(String title,String userName,String type,String captcha) {
    	initEmailTemplet();
        String emailTemplet = System.getProperty("mailPage");
        emailTemplet = emailTemplet.replace("$(title)", title);
        emailTemplet = emailTemplet.replace("$(userName)", userName);
        emailTemplet = emailTemplet.replace("$(type)", type);
        emailTemplet = emailTemplet.replace("$(captcha)", captcha);
        return emailTemplet;
    }

    /**
     * 
    		* @Title: initEmailTemplet 
    		* @Description: 导入模板
    		* @param     入参
    		* @return void    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:42:42 
    		* @version V1.0   
     */
    public static void initEmailTemplet() {
        String url =EmailTemplet.class.getResource("mailPage.html").getFile();
        url = url.substring(1, url.length());
        try {
            String encoding = "UTF-8";
            File file = new File(url);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                StringBuilder sb = new StringBuilder();
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    sb.append(lineTxt);
                }
                System.setProperty("mailPage", sb.toString());
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}