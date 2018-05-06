package test.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.jxc.pojo.Dept;

public class fanshe {

	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Test
	public void a() throws IllegalArgumentException, IllegalAccessException {
		Dept dept = new Dept(1, "财务", "管理");
		Class<? extends Dept> a = dept.getClass();
		Field[] declaredFields = a.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			String name = declaredFields[i].getName();
			System.out.print(name + "\t");
			String value=(String) fanshe.getFieldValueByName(name, dept);
			System.out.println(value);
		}
		// Object object = dept;
		// System.out.println(a.getName());
		// System.out.println(object.getClass().getName());
		// Class<? extends Class> b = a.getClass();
		// System.out.println(b.getName());
	}

	@Test
	public void b() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
		// 预先生成一个p1对象
		Person p1 = new Person();
		p1.setName("Jefferson");
		p1.setAge(23);
		p1.setSex("male");

		// 使用反射技术完成对象属性的输出
		Class<?> c = null;
		c = Class.forName("test.fanshe.Person");
		Field[] fields = c.getDeclaredFields();

		for (Field f : fields) {
			//设置可访问
			f.setAccessible(true);
		}
		// 输出p1的所有属性
		System.out.println("=============About p1===============");
		for (Field f : fields) {
			String field = f.toString().substring(f.toString().lastIndexOf(".") + 1); // 取出属性名称
			System.out.println(f.toString());
			System.out.println("p1." + field + " --> " + f.get(p1));
		}

	}

}
