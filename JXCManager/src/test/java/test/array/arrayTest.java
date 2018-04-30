package test.array;


import org.junit.Test;

public class arrayTest {
	@Test
	public void a() {
		String a = "-2-3-4-5-6-";
		String[] split = a.split("-");
		for (int i = 1; i < split.length; i++) {
			System.out.println(split[i]);
		}
		System.out.println(split.length + "³¤¶È");
		// for (Integer b : a) {
		// System.out.println(b);
		// }
	}
}
