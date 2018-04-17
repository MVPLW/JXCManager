package test;

import org.junit.Test;

public class testSubstring {

	
	@Test
	public void a() {
		String a="-abc-";
		String[] split = a.split("-");
		int count=0;
		for(int i=1;i<split.length;i++) {
			count++;
			System.out.println(split[i]);
		}
		System.out.println(count);
	}
	

}
