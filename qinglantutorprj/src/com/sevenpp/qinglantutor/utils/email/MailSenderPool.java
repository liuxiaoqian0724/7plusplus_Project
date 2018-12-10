package com.sevenpp.qinglantutor.utils.email;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
		* @ClassName: MailSenderPool 
		* @Description: 邮件发送线程池 
		* @author (作者)  
		* @date 2018年12月3日 上午8:52:36 
		* @version V1.0 
 */
public class MailSenderPool {

    /**
     * 邮件发送器线程数量
     */
    private static int SENDER_TOTAL = 10;

    /**
     * 线程工厂（生产环境中建议使用带命名参数的线程工厂）
     */
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    /**
     * 线程池执行器（采用了Spring提供的CustomizableThreadFactory，如果不需要请使用默认线程工厂）
     */
    private static ExecutorService executor = new ThreadPoolExecutor(SENDER_TOTAL, 200,
            0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), threadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    /**
     * 内部静态实例
     */
    private static class Inner {
        private static MailSenderPool instance = new MailSenderPool();
    }

    /**
     * 获取实例
     *
     * @return 返回邮件发送线程池实例
     */
    public static MailSenderPool getInstance() {
        return Inner.instance;
    }

    /**
     * 
    		* @Title: sendByThread 
    		* @Description: 通过线程发送
    		* @param @param mailSenderRestore
    		* @param @return    入参
    		* @return MailSenderPool    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:50:14 
    		* @version V1.0   
     */
    public MailSenderPool sendByThread(MailSenderRestore mailSenderRestore) {
        executor.execute(mailSenderRestore);
        return getInstance();
    }
    /**
     * 
    		* @Title: sendByThread 
    		* @Description: 发送的线程池
    		* @param @param mailSenderReg
    		* @param @return    入参
    		* @return MailSenderPool    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:50:31 
    		* @version V1.0   
     */
    public MailSenderPool sendByThread(MailSenderReg mailSenderReg) {
        executor.execute(mailSenderReg);
        return getInstance();
    }
    /**
     * 
    		* @Title: shutDown 
    		* @Description: 关闭线程池
    		* @param     入参
    		* @return void    返回类型
    		* @author Mr.Ren 
    		* @throws
    		* @date 2018年12月3日 上午8:50:49 
    		* @version V1.0   
     */
    public void shutDown() {
        executor.shutdown();
    }

}
