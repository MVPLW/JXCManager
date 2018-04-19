package cn.test.service;

import cn.jxc.pojo.Role;

public interface RoleService {

	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	// ��ӽ�ɫ-Ȩ��֮���ϵ
	public void correlationPermissions(int roleId, int... permissionIds);

	// �Ƴ���ɫ-Ȩ��֮���ϵ
	public void uncorrelationPermissions(int roleId, int... permissionIds);//
}
