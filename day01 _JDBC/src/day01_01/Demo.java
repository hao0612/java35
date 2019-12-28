package day01_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 //1 �������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		//2 .ͨ������������,��ȡ���Ӷ���
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/java15", "root", "123456");
		//3.ͨ�����Ӷ���, ����SQL���ִ�л���
		Statement state = conn.createStatement();
		//4.ִ��SQL���
		ResultSet result = state.executeQuery("select * from user15");
		//5.���������
		while(result.next()) {
			int id = result.getInt("id");
			String username = result.getString("username");
			String passwoke = result.getString("passwork");
			System.out.println("id="+id+"\tusername="+username+"\tpasswork="+passwoke);
		}
		//6.�ͷ���Դ
		result.close();
		state.close();
		conn.close();
		
    }
	
	
}

