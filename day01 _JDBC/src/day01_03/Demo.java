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
		System.out.println("欢迎登录嘻嘻嘻哈哈");
		System.out.println("输入用户名");
		String username = input.nextLine();
		System.out.println("输入密码");
		String passwork = input.nextLine();
		//1 加载数据库驱动                                                                          
		Class.forName("com.mysql.jdbc.Driver");
		//2 .通过驱动管理器,获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java15","root","123456");
		//3.通过连接对象, 创建SQL语句执行环境
		PreparedStatement state = conn.prepareStatement
				("select id from user15 where username = ? and passwork=?");
		//4. 填充参数
		state.setString(1 ,username);
		state.setString(2, passwork);
		//5. 执行SQL语句，得到结果集
		ResultSet result = state.executeQuery();
		//6.	判断游标是否能向下移动
		if(result.next()) {
			System.out.println("登陆成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
}
