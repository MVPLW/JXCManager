package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Permission;

public interface PermissionMapper {
	// ��ȡ����Ȩ����Ϣ
	List<Permission> getPermissionAll();

	// ���Ȩ����Ϣ
	Integer addPermission(@Param("per") Permission permission);

	// �޸�Ȩ����Ϣ
	Integer updatePermission(@Param("per") Permission permission);

	// ����Ȩ��idɾ��Ȩ��
	Integer deletePermission(@Param("perId") int permissionId);

	// ����Ա����¼����ȡ���Ȩ��
	List<Permission> getPermissionByEmp(String empLoginName);

	// ���ݽ�ɫ��ȡ���Ȩ��
	List<Permission> getPermissionByRole(String roleId);

	/**
	 * ��ӽ�ɫȨ�޹�����ϵ
	 */
	Integer addRolePermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

	/**
	 * ���ݽ�ɫɾ����ع�����ϵ
	 */
	Integer deletePermissionByRoleId(Integer roleId);

}
