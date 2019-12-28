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
		System.out.println("欢迎登陆");
		System.out.println("请输入用户名");
		String username = input.nextLine();
		System.out.println("请输入密码");
		String passwork = input.nextLine();
		 //1 加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2 .通过驱动管理器,获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java15", "root", "123456");
		//3.通过连接对象, 创建SQL语句执行环境
		Statement state = conn.createStatement();
		//4.执行SQL语句
		ResultSet result = state.executeQuery("select * from user15 where username ='"+username+"' "+"and passwork='"+passwork+"'" );
		if(result.next()) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
		//6.释放资源
		result.close();
		state.close();
		conn.close();
		
	}
	

}
