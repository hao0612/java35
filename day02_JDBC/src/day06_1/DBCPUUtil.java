package day06_1;

import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import day05.Demo;

public class DBCPUUtil {

	public static void main(String[] args) {
		private static DataSource date = null;
		
				InputStream is = Demo.class.getClassLoader().getResourceAsStream("druid.properties");
			
				Properties ppt = new Properties();
				
				ppt.load(is);
			
				date = BasicDataSourceFactory.createDataSource(ppt);	
	}

	

}
