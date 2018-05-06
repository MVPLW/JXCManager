package test.interfaces;

import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String fruitName = "ˮ������";
		String fruitColor = "ˮ����ɫ";
		String fruitProvicer = "��Ӧ����Ϣ";

		// ��ȡ��������������
		Field[] fields = clazz.getDeclaredFields();

		// ѭ����������
		for (Field field : fields) {
			// �жϸ��������Ƿ����ָ�����͵�ע��
			if (field.isAnnotationPresent(FruitName.class)) {
				// ���س���Ԫ���ϴ��ڵ�ָ�����͵�׷ �������ע�ⲻ���� ����null
				FruitName fruitName2 = field.getAnnotation(FruitName.class);
				// ��ȡע�������ֵ
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
