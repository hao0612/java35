package cn.itxdl.main;

import cn.itxdl.client.ClielntMangeView;
import cn.itxdl.client.ClientInitClose;
import cn.itxdl.client.ClientView;


public class ClientMain {

	public static void main(String[] args) {
		
		try {
			// 1.����ClientInitClose���͵�����ָ������͵Ķ���
			ClientInitClose cic = new ClientInitClose();
			// 2.���ó�Ա�������г�ʼ��
			cic.clientInit();
			//6.����ClielntMangeView���͵�����ָ������͵Ķ���
			ClielntMangeView cmv = new ClielntMangeView(cic, null);
			// 4.����ClientView���͵�����ָ������͵Ķ���
			ClientView cv = new ClientView(cic,cmv);
			// 5.���ó�Ա��������������Ļ���
			cv.clientMainpage();
			
		} catch(Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
