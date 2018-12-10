package com.sevenpp.qinglantutor.entity.mail;
/**
 * 
		* @ClassName: EmailMailInfo 
		* @Description: TODO(这里用一句话描述这个类的作用) 
		* @author (作者)  
		* @date 2018年12月3日 上午8:55:41 
		* @version V1.0 
 */
public class EmailMailInfo {
    //邮箱服务器 如smtp.163.com
    private String host ;
    //用户邮箱 如**@163
    private String formName ;
    //用户授权码 不是用户名密码 可以自行查看相关邮件服务器怎么查看
    private String formPassword ;
    //消息回复邮箱
    private String replyAddress ;
    //端口
    private String port;
    //协议
    private String protocol;
    
    public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	//发送地址
    private String toAddress ;
    //发送主题
    private String subject ;
    //发送内容
    private String content ;

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public String getFormName() {
        return formName;
    }
    public void setFormName(String formName) {
        this.formName = formName;
    }
    public String getFormPassword() {
        return formPassword;
    }
    public void setFormPassword(String formPassword) {
        this.formPassword = formPassword;
    }
    public String getReplyAddress() {
        return replyAddress;
    }
    public void setReplyAddress(String replyAddress) {
        this.replyAddress = replyAddress;
    }
    public String getToAddress() {
        return toAddress;
    }
    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
