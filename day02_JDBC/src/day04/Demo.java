package day04;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Demo {
	

	public static void main(String [] args) throws Exception {
		//1.	获取配置文件的输入流
		InputStream is = Demo.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		//2.	创建Properties对象
		Properties ppt = new Properties();
		//3.	将流指向的文件中的键值对 加载到ppt中
		ppt.load(is);
		//4.	通过连接池的工厂类, 创建连接池对象
		DataSource ds= BasicDataSourceFactory.createDataSource(ppt);
		//5.	通过连接池 获取一个连接
		Connection conn = ds.getConnection();
		//6.	预编译SQL
		PreparedStatement state = conn.prepareStatement("create table user15_6(id int)");
		state.execute();
		System.out.println("执行完成");
		
	}
}
