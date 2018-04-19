package cn.test.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import cn.jxc.pojo.Employee;

public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	public static void encryptPassword(Employee emp) {
		emp.setEmpLoginPwd(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash("md5", emp.getEmpLoginPwd(),
				ByteSource.Util.bytes(emp.getEmpLoginPwd()), 2).toHex();
		emp.setEmpLoginPwd(newPassword);
	}
}
