package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Deno {
	 public static void main (String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("��ӭ������������ϵͳ");
        System.out.println("��ע���Ա");
        System.out.println("�������û���");
        String username = input.nextLine();
        System.out.println("����������");
        String passwork = input.nextLine();
		 //1 �������ݿ�����
		 Class.forName("com.mysql.jdbc.Driver");
		 //2 .ͨ������������,��ȡ���Ӷ���
		 Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/java15","root","123456");
		//3.ͨ�����Ӷ���, ����SQL���ִ�л���
		 Statement state = conn.createStatement();
		//4.ͨ������̨,����SQL���ִ�л���
		 state.execute("insert into user15(username, passwork) values"
		 		+ " ('"+username+"' ,'"+passwork+"')");
		//5�ͷ���Դ
		 conn.close();
		 state.close();
		 System.out.println("ע�����, ��֪��,�ɹ�û��");
	 } 
}
