package cn.itxdi.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerInitClose {
	
	private ServerSocket ss;
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	
	public ObjectInputStream getOis() {
		return ois;
	}
	public ObjectOutputStream getOos() {
		return oos;
	}	
	
	
	public void serverInit() throws IOException {
		// 1.����ServerSocket���͵Ķ����ṩ�˿ں�
		ss = new ServerSocket(6666);
		// 2.�ȴ��ͻ��˵������������accpet����
		System.out.println("�ȴ��ͻ��˵�����");
		s = ss.accept();
		System.out.println("�ͻ������ӳɹ�");
		// 3.ʹ���������������ͨ��
		// ��ʼ���������˵�������
		ois = new ObjectInputStream(s.getInputStream());
		// ��ʼ���������˵������
		oos = new ObjectOutputStream(s.getOutputStream());
		System.out.println("��������ʼ���ɹ�");
	}

	
	public void serverClose() throws IOException {
		// 4.�ر�Socket���ͷ��йص���Դ
		oos.close();
		ois.close();
		s.close();
		ss.close();
		System.out.println("�������ɹ��ر�");
	}
}
