package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Deno {
	 public static void main (String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎进入嘻嘻哈哈系统");
        System.out.println("请注册会员");
        System.out.println("请输入用户名");
        String username = input.nextLine();
        System.out.println("请输入密码");
        String passwork = input.nextLine();
		 //1 加载数据库驱动
		 Class.forName("com.mysql.jdbc.Driver");
		 //2 .通过驱动管理器,获取连接对象
		 Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/java15","root","123456");
		//3.通过连接对象, 创建SQL语句执行环境
		 Statement state = conn.createStatement();
		//4.通过控制台,创建SQL语句执行环境
		 state.execute("insert into user15(username, passwork) values"
		 		+ " ('"+username+"' ,'"+passwork+"')");
		//5释放资源
		 conn.close();
		 state.close();
		 System.out.println("注册完成, 不知道,成功没有");
	 } 
}
