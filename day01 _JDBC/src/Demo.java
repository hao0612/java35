import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo {
    public static void main(String[] args) throws Exception {
    	//1 .加载数据库驱动
    	Class.forName("com.mysql.jdbc.Driver");
    	//2. 通过驱动管理,获取连接对象
    	Connection conn = DriverManager.getConnection
    			("jdbc:mysql://localhost:3306/java15","root","123456");
    	//3.通过连接对象, 创建SQL语句执行环境
    	Statement state = conn.createStatement();
    	//4.通过执行环境,创建SQL语句执行环境
    	state.execute("create table user15("
    			+ "id int primary key auto_increment,"
    			+ "username varchar(32) not null unique,"
    			+ "passwork varchar(32) not null "
    			+ ")");
    	state.execute("insert into user15 values (1, 'hao',123456)");
    			
    
    	
    	//5释放资源
    	state.close();
    	conn.close();
    	System.out.println("程序执行完成");
    }
}