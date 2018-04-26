package cn.jxc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jxc.pojo.Role;

public interface RoleMapper {

	List<Role> getRoleAll();

	int addRole(@Param("r") Role role);

	/**
	 * ���Ա����ɫ
	 * 
	 * @param emp
	 *            Ա����¼��
	 * @param roleId
	 *            ��ɫid
	 * @return
	 */
	int addEmpRole(@Param("emp") String emp, @Param("roleId") String roleId);

	int updateRole(@Param("r") Role role);

	int delRole(Integer roleId);

	/**
	 * �����û���ɾ���û�ӵ�еĽ�ɫ
	 * 
	 * @param empLoginName
	 *            �û���
	 * @return
	 */
	int delRoleByEmp(@Param("emp") String empLoginName);

	Role findRoleById(Integer roleId);

	List<Role> findRoleByEmp(@Param("emp") String emp);

}
