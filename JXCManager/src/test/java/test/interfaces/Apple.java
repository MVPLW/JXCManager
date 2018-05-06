package test.interfaces;

import test.interfaces.FruitColor.Color;

public class Apple {

	@FruitName("今天周二")
	private String appleName;

	@FruitColor(fruitColor = Color.Red)
	private String appleColor;

	@FruitProvider(id = 1, name = "张三", address = "建设")
	private String appleProvider;

	public void display() {
		System.out.println("水果名称:");
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
