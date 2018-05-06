package test.interfaces;

import test.interfaces.FruitColor.Color;

public class Apple {

	@FruitName("�����ܶ�")
	private String appleName;

	@FruitColor(fruitColor = Color.Red)
	private String appleColor;

	@FruitProvider(id = 1, name = "����", address = "����")
	private String appleProvider;

	public void display() {
		System.out.println("ˮ������:");
	}

	public String getAppleName() {
		return appleName;
	}

	public void setAppleName(String appleName) {
		this.appleName = appleName;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	public String getAppleProvider() {
		return appleProvider;
	}

	public void setAppleProvider(String appleProvider) {
		this.appleProvider = appleProvider;
	}

}
