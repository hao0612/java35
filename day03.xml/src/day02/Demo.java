package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Demo {

	

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			//1. 从连接池中获取连接对象
			conn = DBCPUtil.getConnection();
			//2. 预编译SQL执行环境
			state = conn.prepareStatement("insert into user15(username , passwork) values('shuaibing', 'dashuaaibi')");
			//3. 执行SQL语句
			int rowNum = state.executeUpdate();
			System.out.println(rowNum>0?"插入成功":"插入失败");
		} catch (Exception e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBCPUtil.close(conn,state, null);
		}

	}

}
