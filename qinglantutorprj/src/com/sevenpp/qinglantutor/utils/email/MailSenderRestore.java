package com.sevenpp.qinglantutor.utils.email;
import javax.servlet.http.HttpSession;

/**
 * 
		* @ClassName: MailSenderRestore 
		* @Description: 密码重置验证码发送器
		* @author Mr.Ren
		* @date 2018年12月3日 上午8:53:09 
		* @version V1.0 
 */
public class MailSenderRestore implements Runnable {
	private HttpSession session;
	private String email;
	/**
	 * 
			* @Title:  
			* @Description: 构造方法  
			* @param @param email
			* @param @param session    入参   
	 */
	public MailSenderRestore(String email, HttpSession session) {
		this.session = session;
		this.email = email;
	}

	@Override
    public void run() {
		new EmailUtil().sendForResetPassword(email, session);
    }


}
