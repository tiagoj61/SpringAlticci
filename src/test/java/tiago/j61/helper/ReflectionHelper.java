package tiago.j61.helper;

import org.springframework.web.bind.annotation.GetMapping;

public class ReflectionHelper {

	public static String getPathFromMethod(Class clazz, int methodPosition) {
		return clazz.getMethods()[methodPosition].getAnnotation(GetMapping.class).path()[0];
	}

	public static String getAttributeName(Class clazz, int methodPosition) {
		return clazz.getDeclaredFields()[methodPosition].getName();
	}

}
