package com.amar.codegenertor.annotation.processor;

import com.amar.codegenertor.annotation.Getter;
import com.amar.codegenertor.annotation.Setter;
import com.amar.codegenertor.annotation.ToString;

public class AnnotationProcessor {

	public static <T> void processAnnotion(T object) {
		StringBuffer generatedCode=new StringBuffer();
		Class<?> clazz = object.getClass();
		String javaPackage=clazz.getPackage().getName();
		if (clazz.isAnnotationPresent(Setter.class)) {
			//generete setter and write to className.java file under same package
		} else if (clazz.isAnnotationPresent(Getter.class)) {

		} else if (clazz.isAnnotationPresent(ToString.class)) {

		}
	}

}
