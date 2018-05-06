package test.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

	/**
	 * ��ɫö��
	 * 
	 * @author Administrator
	 *
	 */
	enum Color {
		Blue, Red, Green
	};
	
	/**
	 * ��ɫ����
	 * 
	 * @return
	 */
	Color fruitColor() default Color.Green;
}
