package cn.test.service;

import java.util.Set;

import cn.jxc.pojo.Employee;

public interface EmployeeService {
	public Employee createUser(Employee user); // �����˻�

	public void changePassword(int userId, String newPassword);// �޸�����

	public void correlationRoles(int userId, int... roleIds); // ����û�-��ɫ��ϵ

	public void uncorrelationRoles(int userId, int... roleIds);// �Ƴ��û�-��ɫ��ϵ

	public Employee findByUsername(String username);// �����û��������û�

	public Set<String> findRoles(String username);// �����û����������ɫ

	public Set<String> findPermissions(String username); // �����û���������Ȩ��
}
