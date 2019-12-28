package day05;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.sql.DataSource;



import com.alibaba.druid.pool.DruidDataSourceFactory;
public class Demo {

	public static void main(String[] args) throws Exception   {
		//1.	��ȡ�����ļ���������	
		InputStream is = Demo.class.getClassLoader().getResourceAsStream("druid.properties");
		//2.	����Properties����
		Properties ppt = new Properties();
		//3.	����ָ����ļ��еļ�ֵ�� ���ص�ppt��
		ppt.load(is);
		//4.	ͨ�����ӳصĹ�����, �������ӳض���
		DataSource ds = DruidDataSourceFactory.createDataSource(ppt);
		//5.	ͨ�����ӳ� ��ȡһ������
		Connection conn = ds.getConnection();
		//6.	Ԥ����SQL
		PreparedStatement state = conn.prepareStatement("create table user15_4(id int)");
		state.execute();
		System.out.println("ִ�����");
	}

}
