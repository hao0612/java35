package day01_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demoo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ��½");
		System.out.println("�������û���");
		String username = input.nextLine();
		System.out.println("����������");
		String passwork = input.nextLine();
		 //1 �������ݿ�����
		Class.forName("com.mysql.jdbc.Driver");
		//2 .ͨ������������,��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java15", "root", "123456");
		//3.ͨ�����Ӷ���, ����SQL���ִ�л���
		Statement state = conn.createStatement();
		//4.ִ��SQL���
		ResultSet result = state.executeQuery("select * from user15 where username ='"+username+"' "+"and passwork='"+passwork+"'" );
		if(result.next()) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
		//6.�ͷ���Դ
		result.close();
		state.close();
		conn.close();
		
	}
	

}
