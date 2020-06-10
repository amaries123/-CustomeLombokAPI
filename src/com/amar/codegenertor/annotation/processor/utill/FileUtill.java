package com.amar.codegenertor.annotation.processor.utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtill {
	public static  String readSourceFile(String fileName,String path) throws Exception{
		String resource=FileUtill.class.getClassLoader().getResource(path).getPath();
		String rootPAth=resource.substring(1,resource.lastIndexOf("bin"));
		//System.out.println("rootPath"+rootPAth+" complete path : "+rootPAth+path);
		//Path filePath = Paths.get(rootPAth+"com/"+path+"/"+fileName);
		File file = new File(rootPAth+"src/"+path+"/"+fileName);
		 String fileExistingContent="";
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	 
	    String line;
	    while((line = br.readLine()) != null)
	    {
	    	fileExistingContent=fileExistingContent+line;
	            System.out.println(fileExistingContent);
	    }
	    fileExistingContent=fileExistingContent.substring(0, fileExistingContent.lastIndexOf("}"));
	    
	    br.close();
	    fr.close();
	return fileExistingContent;
	}

}
