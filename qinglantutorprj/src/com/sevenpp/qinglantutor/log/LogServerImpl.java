package com.sevenpp.qinglantutor.log;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServerImpl {
	
	public static final String basePath = "D:\\file\\logs";
	
	public static void creatFile(String filePath, String fileName) {
        File folder = new File(filePath);
        //文件夹路径不存在
        if (!folder.exists() && !folder.isDirectory()) 	{folder.mkdirs();} 
        
	}
	
	public void insert_log(Integer a,Integer b,String localname) {
		long time= new Date().getTime()/1000;
		String key = a.toString()+"	"+b.toString()+"	"+"1"+"	"+time;
		
		BufferedWriter out =null;
		FileOutputStream fileOutputStream = null;
		try {
			if(localname.startsWith("article")) {
				creatFile(basePath, "article.txt");
				fileOutputStream = new FileOutputStream(basePath + "\\article.txt",true);
				out = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
				out.write(key+"\r\n");
				out.close(); 
			}else {
				creatFile(basePath, "tutor.txt");
				fileOutputStream = new FileOutputStream(basePath + "\\tutor.txt",true);
				out = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
				out.write(key+"\r\n");
				out.close(); 
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	public void article_logs(Integer userId, Integer articleId,String localname) {
		insert_log(userId, articleId, localname);
	}
	
	public void tutor_logs(Integer userId, Integer tutorId,String localname) {
		insert_log(userId, tutorId, localname);
	}
}
