package cn.jxc.test;

import java.sql.*;

import org.junit.Test;


public class testConnection {
	
	@Test
	public void abc() {
		//����Connection����
		Connection con;
		//����������
		String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���mydata
		String url = "jdbc:mysql://localhost:3306/jxcdb";
		//MySQL����ʱ���û���
		String user = "root";
		//MySQL����ʱ������
		String password = "ok";
		//������ѯ�����
		try {
			//������������
			Class.forName(driver);
			//1.getConnection()����������MySQL���ݿ⣡��
			con =  DriverManager.getConnection(url,user,password);
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			//2.����statement���������ִ��SQL��䣡��
			Statement statement = con.createStatement();
			//Ҫִ�е�SQL���
			String sql = "select * from employee";
			//3.ResultSet�࣬������Ż�ȡ�Ľ��������
			ResultSet rs = statement.executeQuery(sql);
			
			String name = null;
			String id = null;
			while(rs.next()){
				//��ȡstuname��������
				name = rs.getString("EmpLoginName");
				name = new String(name.getBytes("ISO-8859-1"),"gb2312");
				System.out.println(name);
			}
			rs.close();
			con.close();
		} catch(ClassNotFoundException e) {   
			//���ݿ��������쳣����
			System.out.println("Sorry,can`t find the Driver!");   
			e.printStackTrace();   
			} catch(SQLException e) {
			//���ݿ�����ʧ���쳣����
			e.printStackTrace();  
			}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			System.out.println("���ݿ����ݳɹ���ȡ����");
		}
	}
}
