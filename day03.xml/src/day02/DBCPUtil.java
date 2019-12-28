package day02;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
public class DBCPUtil {
	private static DataSource data = null;
	/**
	 * 随着类的加载而执行
	 */
	
	static {
		InputStream is = DBCPUtil.class.getClassLoader(
				).getResourceAsStream("dbcp.properties");
		Properties ppt = new Properties();
		try {
			ppt.load(is);
			data = BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用于从DBCP连接池中 获取一个连接
	 * @return DBCP连接池中的一个连接对象.
	 */
	public static Connection getConnection() {
		try { 
			return data.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	/**
	 * 用于释放连接  , 执行环境 , 结果集 等资源
	 * @param conn 要释放的连接资源
	 * @param state	要释放的执行环境资源
	 * @param result 要释放的结果集资源
	 */
	public static void close(Connection conn , Statement state ,ResultSet result) {
		if(result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			if(state != null) {
				try {
					state.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	
}
