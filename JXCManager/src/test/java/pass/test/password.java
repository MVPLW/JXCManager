package pass.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class password {

	@Test
	public void a() throws NoSuchAlgorithmException {
		String str = "123";
		String a = new Md5Hash(str).toString();
		System.out.println(a);
		
		MessageDigest mm=MessageDigest.getInstance("MD5");
		mm.update("123".getBytes());
		String string = new BigInteger(1,mm.digest()).toString(16);
		System.out.println(string);
	}
	
	//@Test
	public void b() {
		String algorithmName = "md5";  
		String username = "liu";
		String password = "123";
		String salt1 = username;
		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		String a = new SimpleHash(algorithmName, password, salt1 + salt2, 2).toHex(); //2--重叠两次运算  
		System.out.println(a);
	}

	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}
}
