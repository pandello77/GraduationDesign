package com.ccnu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class TraceEntity {
	public static boolean displayStackTraceInformation(Throwable ex,boolean displayAll) {
		if (null == ex) {
			System.out.println("Null stack trace reference! Bailing...");
			return false;
		}
		System.out.println("The stack according to printStackTrace(): ");
		System.out.println("");
		StackTraceElement[] stackElements = ex.getStackTrace();
		
		if (displayAll) {
			System.out.println("The " + stackElements.length + " element"+ ((stackElements.length == 1) ? "" : "s")+ " of the stack trace: ");
		} else {
			System.out.println("The top element of a " + stackElements.length+ " element stack trace: ");
		}
		
		for (int lcv = 0; lcv < stackElements.length; lcv++) {
			System.out.println("Filename: " + stackElements[lcv].getFileName());
			System.out.println("Line number: "+ stackElements[lcv].getLineNumber());
			String className = stackElements[lcv].getClassName();
			String packageName = extractPackageName(className);
			String simpleClassName = className;//extractSimpleClassName
			
			System.out.println("Package name: "
					+ ("".equals(packageName) ? "[default package]"
							: packageName));
			System.out.println("Full class name: " + className);
			System.out.println("Simple class name: " + simpleClassName);
			System.out.println("Unmunged class name: "
					+ simpleClassName);//
			System.out.println("Direct class name: "
					+ simpleClassName);//

			System.out.println("Method name: "
					+ stackElements[lcv].getMethodName());
			System.out.println("Native method?: "
					+ stackElements[lcv].isNativeMethod());

			System.out.println("toString(): " + stackElements[lcv].toString());
			System.out.println("");

			if (!displayAll)
				return true;
		}
		System.out.println("");

		return true;
	}

	public static String extractPackageName(String fullClassName) {
		if ((null == fullClassName) || ("".equals(fullClassName)))
			return "";

		int lastDot = fullClassName.lastIndexOf('.');

		if (0 >= lastDot)
			return "";

		return fullClassName.substring(0, lastDot);
	}
 
	static public void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		GoodsInfo g= (GoodsInfo) context.getBean("goods");
		double val = 12.03456;
		System.out.println("  result:  "+ g.round(val, 2));
		
	}

}
