package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Demo {

	

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement state = null;
		try {
			//1. �����ӳ��л�ȡ���Ӷ���
			conn = DBCPUtil.getConnection();
			//2. Ԥ����SQLִ�л���
			state = conn.prepareStatement("insert into user15(username , passwork) values('shuaibing', 'dashuaaibi')");
			//3. ִ��SQL���
			int rowNum = state.executeUpdate();
			System.out.println(rowNum>0?"����ɹ�":"����ʧ��");
		} catch (Exception e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			DBCPUtil.close(conn,state, null);
		}

	}

}
