package test.interfaces;

import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String fruitName = "水果名称";
		String fruitColor = "水果颜色";
		String fruitProvicer = "供应商信息";

		// 获取所有声明的属性
		Field[] fields = clazz.getDeclaredFields();

		// 循环所有属性
		for (Field field : fields) {
			// 判断该属性上是否包含指定类型的注解
			if (field.isAnnotationPresent(FruitName.class)) {
				// 返回程序元素上存在的指定类型的追 如果类型注解不存在 返回null
				FruitName fruitName2 = field.getAnnotation(FruitName.class);
				// 获取注解的属性值
				fruitName = fruitName + ":" + fruitName2.value();
				System.out.println(fruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor annotation = field.getAnnotation(FruitColor.class);
				String string = fruitColor + ":" + annotation.fruitColor().toString();
				System.out.println(string);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider abc = field.getAnnotation(FruitProvider.class);
				String aString = fruitProvicer + ":" + abc.name() + "," + abc.address();
				System.out.println(aString);
			}
		}
	}

	public static void main(String[] args) {
		FruitInfoUtil.getFruitInfo(Apple.class);
	}
}
