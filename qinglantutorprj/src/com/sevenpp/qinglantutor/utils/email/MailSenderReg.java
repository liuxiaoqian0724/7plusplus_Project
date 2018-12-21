package com.sevenpp.qinglantutor.utils.email;
import javax.servlet.http.HttpSession;

/**
 * 
		* @ClassName: MailSenderReg 
		* @Description: 注册验证码发送器 
		* @author (作者)  
		* @date 2018年12月3日 上午8:51:11 
		* @version V1.0 
 */
public class MailSenderReg implements Runnable {
	private HttpSession session;
	private String email;
	/**
	 * 
			* @Title:  
			* @Description: 发送注册验证码 
			* @param @param email
			* @param @param session    入参   
	 */
	public MailSenderReg(String email, HttpSession session) {
		this.session = session;
		this.email = email;
	}
	@Override
    public void run() {
		new EmailUtil().sendForReg(email, session);
    }


}
