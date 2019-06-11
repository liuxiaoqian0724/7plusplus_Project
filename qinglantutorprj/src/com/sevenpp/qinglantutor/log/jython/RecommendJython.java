package com.sevenpp.qinglantutor.log.jython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service
public class RecommendJython {
	
	public static final String basePath = "D:\\file\\logs";
	
	public List<Integer> recommend(Integer id) {
		PythonInterpreter interpreter = new PythonInterpreter();
		String path = "";
		try {
			path = RecommendJython.class.getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		interpreter.execfile(path+"recommend.py");
		
		// 第一个参数为期望获得的函数（变量）的名字，第二个参数为期望返回的对象类型
		PyFunction pyFunction = interpreter.get("tutor", PyFunction.class);
		//调用函数，如果函数需要参数，在Java中必须先将参数转化为对应的“Python类型” new PyInteger(a), new PyInteger(b)
		
		String ddd = id.toString();
		
		PyObject pyobj = pyFunction.__call__(new PyString(ddd),new PyString(basePath)); 

		List<Integer> list= (List<Integer>) pyobj.__tojava__(List.class);
		
		return list;
	}
}