package cn.itxdl.client;
import java.io.IOException;

import cn.itxdl.bean.User;
import cn.itxdl.bean.UserMessage;




public class ClientView {
//	private static final String UserMessage = null;
	private ClientInitClose cic;
	
	private ClielntMangeView cmv;

	@SuppressWarnings("unused")
	private Object studentMangerLogin;
	
	public ClientView(ClientInitClose cic,ClielntMangeView cmv) {
		this.cic= cic;
		this.cmv= cmv;
	}
	
	public void clientMainpage() throws IOException, ClassNotFoundException, InterruptedException{
			while(true) {
			System.out.println("\n\n\t    �ֵ������߿���ϵͳ");
			System.out.println("--------------");
			System.out.print("[1] ѧԱϵͳ");
			System.out.println("    [2] ����Աϵͳ");
			System.out.println("[0] �˳�ϵͳ");
			System.out.println("------------");
			System.out.println("��ѡ��Ҫ�����ϵͳ");
			System.out.println("-----------------");
		
			int choose = ClientScanner.getSc().nextInt();
			switch(choose){
		//	case 1 : System.out.println("���ڽ���ѧԱϵͳ");break;
				case 1: studentMangerLogin();break;
				case 2: clientMangerLogin();break;
				case 0: clientExit();return;
				default: System.out.println("�������,����������");
		    }
		}
	}
	

	

	private void studentMangerLogin() throws ClassNotFoundException, InterruptedException, IOException {
		System.out.println("������ѧԱ�˺�");
		 String StrUser = ClientScanner.getSc().next();
		//.��ʾ�û���������ѧԱ��������Ϣ
		 System.out.println("������ѧԱ����");
		 String strPass = ClientScanner.getSc().next();
		// ���û����������Լ�ҵ������ʹ����һ����������
		 UserMessage tum = new UserMessage("managerCheck",new User(StrUser,strPass));
		 // ʹ�ö�������������������͸�������
		 cic.getOos().writeObject(tum);
		 System.out.println("�ͻ��˷���ѧԱ�˻���Ϣ�ɹ�");
		// ���շ�����������У������������Ӧ����ʾ
		 tum = (UserMessage)cic.getOis().readObject();
		 if("success".equals(tum.getType())) {
	     	 System.out.println("��½�ɹ�,��ӭʹ��");
	     	 cmv.studentMainpage();
			 }else {
				 System.out.println("�û������������,����������");
			 }
		
	}

	public void clientExit() throws IOException {
		// 1.�ͻ������˳�֮ǰӦ�������������һ���˳�����Ϣ
		UserMessage tum = new UserMessage("clientExit", null);
		cic.getOos().writeObject(tum);
		// 2.�ͻ���Ӧ�ý�������Ҫ�ƺ�Ĺ���ȫ���������
		// 3.���ó�Ա�������йر�
		cic.clientClose();
		// 6.�رտͻ��˹��õ�ɨ����
		ClientScanner.cioseSc();
		System.out.println("ллʹ�ã��´��ټ���");
	}
	public void clientMangerLogin() throws IOException, ClassNotFoundException, InterruptedException {
		// 1.��ʾ�û������������Ա���û�����Ϣ
		 System.out.println("���������Ա�˺�");
		 String StrUser = ClientScanner.getSc().next();
		// 2.��ʾ�û������������Ա��������Ϣ
		 System.out.println("���������Ա����");
		 String strPass = ClientScanner.getSc().next();
		// 3.���û����������Լ�ҵ������ʹ����һ����������
		 UserMessage tum = new UserMessage("managerCheck",new User(StrUser,strPass));
		 // 4.ʹ�ö�������������������͸�������
		 cic.getOos().writeObject(tum);
		 System.out.println("�ͻ��˷��͹���Ա�˻���Ϣ�ɹ�");
		// 5.���շ�����������У������������Ӧ����ʾ
		 tum = (UserMessage)cic.getOis().readObject();
		 if("success".equals(tum.getType())) {
	     	 System.out.println("��½�ɹ�,��ӭʹ��");
	     	 cmv.clientMainpage();
	     	 
			 }else {
				 System.out.println("�û������������,����������");
			 }
	 
	}
}	


