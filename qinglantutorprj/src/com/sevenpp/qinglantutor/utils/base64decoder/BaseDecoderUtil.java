package com.sevenpp.qinglantutor.utils.base64decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import Decoder.BASE64Decoder;

/**
*
* 项目名称：qinglantutorprj
* 类名称：BaseDecoderUtil
* 类描述：
* 创建人：rain
* 创建时间：2018年12月19日 上午8:21:46
* 修改人：rain
* 修改时间：2018年12月19日 上午8:21:46
* 修改备注：
* @version
*
*/
public class BaseDecoderUtil {
	
	public static String ifSuccess(String img,HttpServletRequest request,String path,String email,String beforeimg) {
		String header = null;
		String format = null;
		if(img.startsWith("data:image/jpeg;base64,/9j/4")) {
			header ="data:image/jpeg;base64,"; 
			format = "jpg";
		}else if(img.startsWith("data:image/png;base64,iVBORw")){
			header ="data:image/png;base64,";
			format = "png";
		}else {
			header ="data:image/gif;base64,";
			format = "gif";
		}
		String beforePath = request.getSession().getServletContext().getRealPath(beforeimg);
		File file = new File(beforePath);
		file.delete();
		
		String image = img.substring(header.length());
		String imgPath = null;
		BASE64Decoder decoder = new BASE64Decoder();  
		String storePath = request.getSession().getServletContext().getRealPath("users\\"+email);
		try {
			byte[] decodedBytes = decoder.decodeBuffer(image);
			String imgFilePath =storePath+"\\"+path+"."+format;
			FileOutputStream out = new FileOutputStream(imgFilePath);
			out.write(decodedBytes);  
			imgPath = "users\\"+email+"\\"+path+"."+format;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		return imgPath;
	}
}

	