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
	 * ������ļ��ض�ִ��
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
	 * ���ڴ�DBCP���ӳ��� ��ȡһ������
	 * @return DBCP���ӳ��е�һ�����Ӷ���.
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
	 * �����ͷ�����  , ִ�л��� , ����� ����Դ
	 * @param conn Ҫ�ͷŵ�������Դ
	 * @param state	Ҫ�ͷŵ�ִ�л�����Դ
	 * @param result Ҫ�ͷŵĽ������Դ
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
