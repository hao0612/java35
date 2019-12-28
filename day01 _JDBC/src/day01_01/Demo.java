package day01_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 //1 加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2 .通过驱动管理器,获取连接对象
		Connection conn = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/java15", "root", "123456");
		//3.通过连接对象, 创建SQL语句执行环境
		Statement state = conn.createStatement();
		//4.执行SQL语句
		ResultSet result = state.executeQuery("select * from user15");
		//5.遍历结果集
		while(result.next()) {
			int id = result.getInt("id");
			String username = result.getString("username");
			String passwoke = result.getString("passwork");
			System.out.println("id="+id+"\tusername="+username+"\tpasswork="+passwoke);
		}
		//6.释放资源
		result.close();
		state.close();
		conn.close();
		
    }
	
	
}

