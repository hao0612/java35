package cn.itxdl.client;

import java.io.IOException;

import cn.itxdl.bean.Question;
import cn.itxdl.bean.QuestionMessage;
import cn.itxdl.bean.User;
import cn.itxdl.bean.UserMessage;

public class ClielntMangeView {
	
	
	private ClientInitClose cic;
	@SuppressWarnings("unused")
	private String strName;
	
	
	
	public ClielntMangeView(ClientInitClose cic,String strName) {
		this.cic = cic;
		this.strName = strName;
	}
	
	public void clientMainpage() throws  InterruptedException, IOException, ClassNotFoundException{
		while(true) {
		System.out.println("\n\n\t    ��ӭ�������Աϵͳ");
		System.out.println("--------------");
		System.out.print("[1] ѧԱ����");
		System.out.println("    [2] �������");
		System.out.println("[0] �˳�ϵͳ");
		System.out.println("------------");
		System.out.println("��ѡ��Ҫ���е�ҵ��");
		System.out.println("-----------------");
		int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientUserMainpage();break;
				case 2: clientQuestionMainpage();break;
				case 0: System.out.println("���ڷ�����һ���˵�");
				Thread.sleep(2000);
				return;
				default: System.out.println("�������,����������");
		    }
		}
	}
	public void clientUserMainpage() throws  InterruptedException, IOException, ClassNotFoundException{
		while(true) {
		System.out.println("\n\n\t    ��ӭ����ѧԱ������ϵͳ");
		System.out.println("--------------");
		System.out.print("[1] ����ѧԱ");
		System.out.println("    [2] ɾ��ѧԱ");
		System.out.print("[3] �޸�ѧԱ");
		System.out.println("    [4] ����ѧԱ");
		System.out.println("[0] �˳�ϵͳ");
		System.out.println("------------");
		System.out.println("��ѡ��Ҫ���е�ҵ��");
		System.out.println("-----------------");
		int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientAddUser();break;
				case 2: clientdelUser();break;
				case 3: clientmodifyUser();break;
				case 4: clientfindUser();break;
				case 0: System.out.println("���ڷ�����һ���˵�");
				Thread.sleep(1000);
				return;
				default: System.out.println("�������,����������");
		    }
		}
	}
	
	
	 private void clientmodifyUser() throws IOException, ClassNotFoundException {
		  System.out.println("��������Ҫ�޸ĵ�ѧԱ������");
		  String strName = ClientScanner.getSc().next();
		  System.out.println("��������Ҫ�޸ĵ�ѧԱ���룺");
		  String strPass = ClientScanner.getSc().next();
		  UserMessage tum = new UserMessage(
		    "modifyUser", new User(strName, strPass));
		  cic.getOos().writeObject(tum);
		  System.out.println("�ͻ��˷����޸�ѧԱ��Ϣ��ɣ�"); 
		  tum = (UserMessage) cic.getOis().readObject();
			if("fail".equals(tum.getType())) {
				System.out.println("�޸�ѧԱʧ��");
			}else{
				System.out.println("�޸�ѧԱ�ɹ�");
				return;
			}
				
		}
	public void clientAddUser() throws IOException, ClassNotFoundException {
		System.out.println("������Ҫ����ѧԱ���û�����");
		String strName = ClientScanner.getSc().next();
		System.out.println("������Ҫ����ѧԱ�����룺");
		String strPass = ClientScanner.getSc().next();
		
		UserMessage tum = new UserMessage
				("addUser", new User(strName, strPass));
		cic.getOos().writeObject(tum);
		System.out.println("�ͻ��˷�������ѧԱ��Ϣ�ɹ�");
		
		tum = (UserMessage) cic.getOis().readObject();
		if("fail".equals(tum.getType())) {
			System.out.println("����ѧԱʧ��");
		}else{
			System.out.println("����ѧԱ�ɹ�");
			return;
		}
			
	}
	
	public void clientdelUser() throws IOException, ClassNotFoundException {
		System.out.println("������Ҫɾ����ѧԱ��Ϣ");
		String strName = ClientScanner.getSc().next();
		UserMessage tum = new UserMessage
				("delUser", new User(strName, null));
		cic.getOos().writeObject(tum);
		System.out.println("�ͻ��˷���ɾ��ѧԱ��Ϣ�ɹ�");
	
	tum = (UserMessage) cic.getOis().readObject();
	if("fail".equals(tum.getType())) {
		System.out.println("ɾ��ѧԱʧ��");
	}else{
		System.out.println("ɾ��ѧԱ�ɹ�");
		return;
	}
	
	}
	
		private void clientfindUser() throws IOException, ClassNotFoundException {
			  System.out.println("��������Ҫ���ҵ�ѧԱ������");
			  String strName = ClientScanner.getSc().next();
			  UserMessage tum = new UserMessage(
			    "findUser", new User(strName, null));
			  cic.getOos().writeObject(tum);
			  System.out.println("�ͻ��˷��Ͳ���ѧԱ��Ϣ��ɣ�"); 
			 
			  tum = (UserMessage) cic.getOis().readObject();
				if("fail".equals(tum.getType())) {
					System.out.println("����ѧԱʧ��");
				}else{
					System.out.println("����ѧԱ�ɹ�");
					 Object o = cic.getOis().readObject();
					 System.out.println(o);
					return;
					
				}
					
			}


			
	
	
		
		
	public void clientQuestionMainpage() throws  InterruptedException, ClassNotFoundException, IOException{
		while(true) {
			System.out.println("\n\n\t    ��ӭ���뿼�������ϵͳ");
			System.out.println("--------------");
			System.out.print("[1] ���ӿ���");
			System.out.println("    [2] ɾ������");
			System.out.print("[3] �޸Ŀ���");
			System.out.println("    [4] ���ҿ���");	
			System.out.println("[0] �˳�ϵͳ");
			System.out.println("------------");
			System.out.println("��ѡ��Ҫ���е�ҵ��");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientAddktQuestion();break;
				case 2: clientdelktQuestion();break;
				case 3: clientmodifyktQuestion();break;
				case 4: clientfindktQuestion();break;
				case 0: System.out.println("���ڷ�����һ���˵�");
				Thread.sleep(2000);
				return;
				default: System.out.println("�������,����������");
		    }
		}
	}
	public void clientfindktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("��������Ҫ���ҵĿ��⣺");
		String strTitle = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage(
			    "findQuestion", new Question(strTitle, strTitle, strTitle, strTitle, strTitle, strTitle));
		  cic.getOos().writeObject(tqm);
		  System.out.println("�ͻ��˷��Ͳ��ҿ�����Ϣ��ɣ�"); 
		 
		  tqm = (QuestionMessage) cic.getOis().readObject();
			if("fail".equals(tqm.getType())) {
				System.out.println("���ҿ���ʧ��");
			}else{
				System.out.println("���ҿ���ɹ�");
				 Object o = cic.getOis().readObject();
				 System.out.println(o);
				return;
				
			}
				
		}


		
	

	public void clientmodifyktQuestion() throws ClassNotFoundException, IOException {
		System.out.println("��������Ҫ�޸ĵĿ��⣺");
		String strTitle = ClientScanner.getSc().next();
		System.out.println("��������Ҫ�޸ĵĿ���Aѡ�");
		String strAbswerA = ClientScanner.getSc().next();
		System.out.println("��������Ҫ�޸ĵĿ���Bѡ�");
		String strAbswerB = ClientScanner.getSc().next();
		System.out.println("��������Ҫ�޸ĵĿ���Cѡ�");
		String strAbswerC = ClientScanner.getSc().next();
		System.out.println("��������Ҫ�޸ĵĿ���Dѡ�");
		String strAbswerD = ClientScanner.getSc().next();
		System.out.println("��������Ҫ�޸ĵ���ȷ�𰸣�");
		String strAbswer = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage(
		    "modifyQuestion", new Question(strTitle,
		    		strAbswerA,strAbswerB,strAbswerC,strAbswerD,strAbswer));
		cic.getOos().writeObject(tqm);
		System.out.println("�ͻ��˷����޸Ŀ�����Ϣ��ɣ�"); 
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("�޸Ŀ���ʧ��");
		}else{
			System.out.println("�޸Ŀ���ɹ�");
				
			}
				
		
		
	}

	public void clientdelktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("������Ҫɾ���Ŀ�����Ϣ");
		String strTitle = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage
				("delQuestio", new Question(strTitle, strTitle, strTitle, strTitle, strTitle, strTitle));
		cic.getOos().writeObject(tqm);
		System.out.println("�ͻ��˷���ɾ��������Ϣ�ɹ�");
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("ɾ������ʧ��");
		}else{
			System.out.println("ɾ������ɹ�");
			return;
		}
			
	}
		


	public void clientAddktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("������Ҫ���ӿ�������");
		String strTitle = ClientScanner.getSc().next();
		System.out.println("�����뿼���Aѡ�");
		String strAbswerA = ClientScanner.getSc().next();
		System.out.println("�����뿼���Bѡ�");
		String strAbswerB = ClientScanner.getSc().next();
		System.out.println("�����뿼���Cѡ�");
		String strAbswerC = ClientScanner.getSc().next();
		System.out.println("�����뿼���Dѡ�");
		String strAbswerD = ClientScanner.getSc().next();
		System.out.println("�����뿼�����ȷѡ�");
		String strAbswer = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage
				("addQuestio", new Question
		(strTitle,strAbswerA, strAbswerB, 
				strAbswerC, strAbswerD, strAbswer));
		cic.getOos().writeObject(tqm);
		System.out.println("�ͻ��˷������ӿ���ɹ�");
		
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("���ӿ���ʧ��");
		}else{
			System.out.println("���ӿ���ɹ�");
			return;
		}
			
	}

	public void studentMainpage() throws InterruptedException {
		while(true) {
			System.out.println("\n\n\t    ��ӭ����ѧԱϵͳ");
			System.out.println("--------------");
			System.out.print("[1] �û�ģ��");
			System.out.println("      [2] ����ģ��");
			System.out.println("[0] �˳�ϵͳ");
			System.out.println("------------");
			System.out.println("��ѡ��Ҫ���е�ҵ��");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
				switch(choose){
					case 1: studentUserMainpage();break;
					case 2: studentexamMainpage();break;
					case 0: System.out.println("���ڷ�����һ���˵�");
					Thread.sleep(1000);
					return;
					default: System.out.println("�������,����������");
			    }
			}
		}
	public void studentexamMainpage() throws InterruptedException {
			while(true) {
				System.out.println("\n\n\t    ��ӭ����ѧԱ������ϵͳ");
				System.out.println("--------------");
				System.out.print("[1] ��ʼ����");
				System.out.println("            [2] �鿴���ο��Գɼ�");
				System.out.print("[3] �鿴���п��Գɼ�");
				System.out.println("    [0] �˳�ϵͳ");
				System.out.println("------------");
				System.out.println("��ѡ��Ҫ���е�ҵ��");
				System.out.println("-----------------");
				int choose = ClientScanner.getSc().nextInt();
					switch(choose){
						case 1: System.out.println("���ڽ��뿼��ϵͳ,���Ժ�...");;break;
						case 2: System.out.println("���ڲ鿴���ο��Գɼ�,���Ժ�...");break;
						case 3: System.out.println("���ڲ鿴���п��Գɼ�,���Ժ�...");break;
						case 0: System.out.println("���ڷ�����һ���˵�");
						Thread.sleep(1000);
						return;
						default: System.out.println("�������,����������");
				    }
				}
			
			
		
		}

	public void studentUserMainpage() throws InterruptedException {
		while(true) {
			System.out.println("\n\n\t    ��ӭ����ѧԱ�޸�������ϵͳ");
			System.out.println("--------------");
			System.out.print("[1] �޸�����");
			System.out.println("[0] �˳�ϵͳ");
			System.out.println("------------");
			System.out.println("��ѡ��Ҫ���е�ҵ��");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
				switch(choose){
					case 1: System.out.println("�����޸�����,���Ժ�...");break;
					case 0: System.out.println("���ڷ�����һ���˵�");
					Thread.sleep(1000);
					return;
					default: System.out.println("�������,����������");
			    }
			}
		
		
	
	}
	
}
