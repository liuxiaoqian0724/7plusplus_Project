package com.sevenpp.qinglantutor.log;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServerImpl {
	public void logsth(Integer userId, Integer articleId) {
	
		long time= new Date().getTime()/1000;
		String key = userId.toString()+"	"+articleId.toString()+"	"+"1"+"	"+time;
		
		BufferedWriter out =null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("./logs.txt",true);
			out = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			out.write(key+"\r\n");
			out.close(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
	}
}
