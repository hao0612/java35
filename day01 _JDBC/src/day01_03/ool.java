package day01_03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ool {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("hy ");
		System.out.println("yh");
		String username = input.nextLine();
		System.out.println("  mm ");
		String passwork = input.nextLine();
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java15","root","123456");
		PreparedStatement state = conn.prepareStatement
				("Select id from user15 where username = ? and passwork = ? ");
		state.setString(1 ,username);
		state.setString(2, passwork);
		ResultSet result = state.executeQuery();
		if(result.next()) {
			System.out.println("µÇÂ¼³É¹¦");
		}else {
			System.out.println("µÇÂ¼Ê§°Ü");
		}
	}

}
