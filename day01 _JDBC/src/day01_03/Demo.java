package day01_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ��¼����������");
		System.out.println("�����û���");
		String username = input.nextLine();
		System.out.println("��������");
		String passwork = input.nextLine();
		//1 �������ݿ�����                                                                          
		Class.forName("com.mysql.jdbc.Driver");
		//2 .ͨ������������,��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java15","root","123456");
		//3.ͨ�����Ӷ���, ����SQL���ִ�л���
		PreparedStatement state = conn.prepareStatement
				("select id from user15 where username = ? and passwork=?");
		//4. ������
		state.setString(1 ,username);
		state.setString(2, passwork);
		//5. ִ��SQL��䣬�õ������
		ResultSet result = state.executeQuery();
		//6.	�ж��α��Ƿ��������ƶ�
		if(result.next()) {
			System.out.println("��½�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
}
