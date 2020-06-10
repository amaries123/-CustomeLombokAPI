package com.amar.codegenertor.annotation;

import java.lang.annotation.Annotation;

import com.amar.codegenertor.annotation.processor.AnnotationProcessor;

public class AnnotaionLauncher {
public static void main(String[] args) {
	AnnotationProcessor.processAnnotion(new TestUseSetterAnnotation().getClass());
}	
}
