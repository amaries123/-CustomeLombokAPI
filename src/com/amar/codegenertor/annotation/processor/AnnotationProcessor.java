package com.amar.codegenertor.annotation.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URISyntaxException;

import com.amar.codegenertor.annotation.Getter;
import com.amar.codegenertor.annotation.Setter;
import com.amar.codegenertor.annotation.ToString;
import com.amar.codegenertor.annotation.processor.utill.FileUtill;

public class AnnotationProcessor {

	public static <T> void processAnnotion(Class<?> clazz ) {
		StringBuffer generatedCode=new StringBuffer();
		String fullyQualifiedClassName=clazz.getName();
		String javaPackage=clazz.getPackage().getName();
		String fileName=fullyQualifiedClassName.substring(fullyQualifiedClassName.lastIndexOf(".")+1,fullyQualifiedClassName.length());
		String filePath=javaPackage.replace(".", "/");
		System.out.println(fullyQualifiedClassName);
		System.out.println(fileName);
		System.out.println(filePath);
		//s.getName().ge;
		System.out.println(javaPackage);
		//String existingCode= 
		
		/*Annotation[] anotations= clazz.getDeclaredAnnotations();
		
		for(Annotation anotaion :anotations) {
			System.out.println("anota"+ anotaion.getClass().getName());
		}*/	
		String sourceContent ="";
				try {
				 sourceContent =FileUtill.readSourceFile(fileName.concat(".java"),filePath);
					System.out.println("sou"+sourceContent);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		if (clazz.isAnnotationPresent(Setter.class)) {
			//generete setter and write to className.java file under same package
		} else if (clazz.isAnnotationPresent(Getter.class)) {

		} else if (clazz.isAnnotationPresent(ToString.class)) {
			/*@Override
			public String toString() {
				return "TestUseSetterAnnotation [id=" + id + "]";
			}*/
			String toStringMethod="@Override public String toString() { return ";
			Field[] fields= clazz.getDeclaredFields();
			String fielddvalue="[";
			for (Field field : fields) {
				fielddvalue=fielddvalue+field.getName()+"= "+"+ "+field.getName();
			}
			System.out.println(fielddvalue);
			toStringMethod=toStringMethod+fileName+fielddvalue+" ] }}";
			System.out.println(toStringMethod);
			
			String generatedSourceCode=sourceContent+toStringMethod;
			
			System.out.println("final generated data "+generatedSourceCode);
			
			

			
		}
	}

}
