package com.catalyst.annotationdemo;

 
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.reflections.Reflections;

public class AnnotationScanningExample {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		 //prevents annoying console messages.
		Reflections.log = null;

		Reflections reflections = new Reflections("com.catalyst");
		Set<Class<?>> matchingClasses = reflections.getTypesAnnotatedWith(CustomAnnotation.class);
		for (Class<?> match : matchingClasses) { 
			CustomAnnotation annotation = match.getAnnotation(CustomAnnotation.class);
			Integer count = annotation.count();
			Object o = match.newInstance();
			for (int i = 0; i < count; i++) {
				match.getMethod("start").invoke(o);
			}
		}

	}

}
