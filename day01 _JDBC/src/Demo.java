import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
    	//1 .�������ݿ�����
    	Class.forName("com.mysql.jdbc.Driver");
    	//2. ͨ����������,��ȡ���Ӷ���
    	Connection conn = DriverManager.getConnection
    			("jdbc:mysql://localhost:3306/java15","root","123456");
    	//3.ͨ�����Ӷ���, ����SQL���ִ�л���
    	Statement state = conn.createStatement();
    	//4.ͨ��ִ�л���,����SQL���ִ�л���
    	state.execute("create table user15("
    			+ "id int primary key auto_increment,"
    			+ "username varchar(32) not null unique,"
    			+ "passwork varchar(32) not null "
    			+ ")");
    	state.execute("insert into user15 values (1, 'hao',123456)");
    			
    
    	
    	//5�ͷ���Դ
    	state.close();
    	conn.close();
    	System.out.println("����ִ�����");
    }
}