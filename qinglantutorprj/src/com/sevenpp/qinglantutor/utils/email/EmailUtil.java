package com.sevenpp.qinglantutor.utils.email;

import javax.servlet.http.HttpSession;

import com.sevenpp.qinglantutor.entity.mail.EmailMailInfo;
/**
 * 
		* @ClassName: EmailUtil 
		* @Description: 发送邮件的操作  注册   重置  比对
		* @author Mr.Ren 
		* @date 2018年12月3日 上午8:47:12 
		* @version V1.0 
 */
public class EmailUtil {
	
    public EmailUtil() {
		// TODO Auto-generated constructor stub
	}

    /**
     * 
    		* @Title: sendForReg 
    		* @Description: 发送验证码
    		* @param @param email
    		* @param @param session
    		* @param @return    入参
    		* @return String    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:48:54 
    		* @version V1.0   
     */
    public String sendForReg(String email,HttpSession session) {
        String captcha = CaptchaUtils.creatCaptcha();
        session.setAttribute("reg:"+email, captcha);
        String title = "用户注册";
        String content = EmailTemplet.getHtml(title, email, title, captcha);
        EmailMailInfo info = new EmailMailInfo();
        info.setToAddress(email);
        info.setSubject(title);
        info.setContent(content);
        try {
            // MailSendUtil.sendTextMail(info);
            EmailSendUtil.sendHtmlMail(info);
        } catch (Exception e) {
            System.out.print("'" + title + "'的邮件发送失败！");
            e.printStackTrace();
        }
        return captcha;
    }

    /**
     * 
    		* @Title: sendForResetPassword 
    		* @Description: 发送重置密码
    		* @param @param email
    		* @param @param session
    		* @param @return    入参
    		* @return String    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:49:13 
    		* @version V1.0   
     */
    public String sendForResetPassword(String email,HttpSession session) {
        String captcha = CaptchaUtils.creatCaptcha();
        session.setAttribute("restPassword:"+email, captcha);
        String title = "密码重置";
        String content = EmailTemplet.getHtml(title, email, title, captcha);
        EmailMailInfo info = new EmailMailInfo();
        info.setToAddress(email);
        info.setSubject(title);
        info.setContent(content);
        try {
            // MailSendUtil.sendTextMail(info);
            EmailSendUtil.sendHtmlMail(info);
        } catch (Exception e) {
            System.out.print("'" + title + "'的邮件发送失败！");
            e.printStackTrace();
        }
        return captcha;
    }

    /**
     * 
    		* @Title: checkCaptcha 
    		* @Description: 校验验证码
    		* @param @param email
    		* @param @param type
    		* @param @param captcha
    		* @param @param session
    		* @param @return    入参
    		* @return boolean    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:49:36 
    		* @version V1.0   
     */
    public static boolean checkCaptcha(String email,String type,String captcha,HttpSession session){
        String captchaCache = null;
        switch (type) {
            case "reg":
                captchaCache = (String) session.getAttribute("reg:"+email);
                break;
            case "restPassword":
                captchaCache = (String) session.getAttribute("restPassword:"+email);
                break;
            default:
                break;
        }
        if(captchaCache != null){
            return captchaCache.equals(captcha);
        }
        return false;
    }
}
