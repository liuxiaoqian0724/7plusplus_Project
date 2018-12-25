package com.sevenpp.qinglantutor.utils.email;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sevenpp.qinglantutor.common.EmailConstant;
import com.sevenpp.qinglantutor.entity.mail.EmailMailInfo;
import com.sun.mail.util.MailSSLSocketFactory;
/**
 * 
		* @ClassName: EmailSendUtil 
		* @Description: 邮件发送的工具类
		* @author Mr.Ren 
		* @date 2018年12月3日 上午8:31:41 
		* @version V1.0 
 */
public class EmailSendUtil {
	/**
	 * 
			* @Title: sendHtmlMail 
			* @Description: 设置发件的参数
			* @param @param info
			* @param @throws Exception    入参
			* @return void    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月3日 上午8:32:29 
			* @version V1.0   
	 */
	public static void sendHtmlMail(EmailMailInfo info) throws Exception {
		info.setHost(EmailConstant.HOST);
		info.setFormName(EmailConstant.FROMNAME);
		info.setFormPassword(EmailConstant.PASSWORD); 
		info.setReplyAddress(EmailConstant.REPLYADDRESS);
		info.setPort(EmailConstant.PORT);
		info.setProtocol(EmailConstant.PROTOCOL);
		Message message = getMessage(info);
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart html = new MimeBodyPart();
		// 设置HTML内容
		html.setContent(info.getContent(), "text/html; charset=utf-8");
		mainPart.addBodyPart(html);
		// 将MiniMultipart对象设置为邮件内容
		message.setContent(mainPart);
		Transport.send(message);
	}
	/**
	 * 
			* @ClassName: MyAuthenticator 
			* @Description: 邮件发送的认证 静态内部类
			* @author (作者)  
			* @date 2018年12月3日 上午8:32:58 
			* @version V1.0 
	 */
	static class MyAuthenticator extends Authenticator {

		/**
		 * 用户名
		 */
		String username;
		/**
		 * 密码
		 */
		String password;

		/**
		 * 构造器
		 *
		 * @param username 用户名
		 * @param password 密码
		 */
		public MyAuthenticator(String username, String password) {
			this.username = username;
			this.password = password;
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}
	/**
	 * 
			* @Title: sendTextMail 
			* @Description: 发送邮件 
			* @param @param info
			* @param @throws Exception    入参
			* @return void    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月3日 上午8:33:24 
			* @version V1.0   
	 */
	public static void sendTextMail(EmailMailInfo info) throws Exception {

		info.setHost(EmailConstant.HOST);
		info.setFormName(EmailConstant.FROMNAME);
		info.setFormPassword(EmailConstant.PASSWORD);
		info.setReplyAddress(EmailConstant.REPLYADDRESS);
		Message message = getMessage(info);
		// 消息发送的内容
		message.setText(info.getContent());

		Transport.send(message);
	}
	/**
	 * 
			* @Title: getMessage 
			* @Description: 通过模板获取邮件的内容 
			* @param @param info
			* @param @return
			* @param @throws Exception    入参
			* @return Message    返回类型
			* @author Mr.Ren 
			* @throws
			* @date 2018年12月3日 上午8:33:42 
			* @version V1.0   
	 */
	private static Message getMessage(EmailMailInfo info) throws Exception {
		// 设置邮件属性
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", info.getProtocol());
		prop.setProperty("mail.smtp.host", info.getHost());
		prop.setProperty("mail.smtp.port", info.getPort());
		prop.setProperty("mail.smtp.auth", "true");
		MailSSLSocketFactory sslSocketFactory = null;
		try {
			sslSocketFactory = new MailSSLSocketFactory();
			sslSocketFactory.setTrustAllHosts(true);
		} catch (GeneralSecurityException e1) {
			e1.printStackTrace();
		}
		if (sslSocketFactory == null) {
			System.err.println("开启 MailSSLSocketFactory 失败");
		} else {
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.ssl.socketFactory", sslSocketFactory);
			// 创建邮件会话（注意，如果要在一个进程中切换多个邮箱账号发信，应该用 Session.getInstance）
			Session session = Session.getDefaultInstance(prop,
					new MyAuthenticator(EmailConstant.FROMNAME,EmailConstant.PASSWORD));
			// 开启调试模式（生产环境中请不要开启此项）
			session.setDebug(true);
			try {
				MimeMessage mimeMessage = new MimeMessage(session);
				// 设置发件人别名（如果未设置别名就默认为发件人邮箱）
				if (info.getFormName() != null && !info.getFormName().trim().isEmpty()) {
					mimeMessage.setFrom(new InternetAddress(info.getFormName(), "小蓝"));
				}
				// 设置主题和收件人、发信时间等信息
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(info.getToAddress()));
				mimeMessage.setSubject(info.getSubject());
				mimeMessage.setSentDate(new Date());
				mimeMessage.setText(info.getContent());
//	                }
				// 开始发信
				mimeMessage.saveChanges();
//	                Transport.send(mimeMessage);
				return mimeMessage;
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
