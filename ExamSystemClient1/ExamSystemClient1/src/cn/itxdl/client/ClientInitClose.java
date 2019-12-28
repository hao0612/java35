package cn.itxdl.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientInitClose {
	public Socket s;
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	
	
	public ObjectOutputStream getOos() {
		return oos;
	}
	
	
	public ObjectInputStream getOis() {
		return ois;
	}
	
	public void clientInit() throws UnknownHostException, IOException {
		s = new Socket(InetAddress.getByName("192.168.11.131"),6666);
		System.out.println("���ӷ������ɹ�...");
		oos= new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
		System.out.println("�ͻ��˳�ʼ���ɹ�");
		
	}
	public void clientClose() throws IOException {
		oos.close();
		ois.close();
		s.close();
		System.out.println("�ͻ��˳ɹ��ر�");
		
	}
}
