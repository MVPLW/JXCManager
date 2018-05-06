package cn.jxc.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excelע�ⶨ��
 * 
 * @author lxq 5.6
 *
 */
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {

	/**
	 * �����ֶ�����Ĭ�ϵ��õ�ǰ�ֶεġ�get����������ָ�������ֶ�Ϊ��������д��������.�������ԡ���������area.name������office.name����
	 */
	String value() default "";

	/**
	 * �����ֶα��⣨��Ҫ�����ע���á�**���ָ�������**��ע�����Ե���ģ����Ч��
	 */
	String title();

	/**
	 * �ֶ����ͣ�0���������룻1����������2�������룩
	 */
	int type() default 0;

	/**
	 * �����ֶζ��뷽ʽ��0���Զ���1������2�����У�3�����ң�
	 */
	int align() default 0;

	/**
	 * �����ֶ��ֶ���������
	 */
	int sort() default 0;

	/**
	 * ������ֵ����ͣ��������ֵ��typeֵ
	 */
	String dictType() default "";

	/**
	 * ��������
	 */
	Class<?> fieldType() default Class.class;

	/**
	 * �ֶι����飨���ݷ��鵼�����룩
	 */
	int[] groups() default {};

}
