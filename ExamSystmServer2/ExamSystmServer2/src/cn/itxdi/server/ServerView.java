package cn.itxdi.server;

import java.io.IOException;
import java.util.List;

import cn.itxdl.bean.Question;
import cn.itxdl.bean.QuestionMessage;
import cn.itxdl.bean.User;
import cn.itxdl.bean.UserMessage;

public class ServerView {
	
	private ServerInitClose sic;
	private List<User> userList;
	private List<Question> questionList;
	
	public ServerView(ServerInitClose sic,List<User> userList,List<Question> questionList) {
		this.sic = sic;
		this.userList = userList;
		this.questionList = questionList;
	
	}

	
	public void serverReceiveMessage() throws ClassNotFoundException, IOException {
		while (true) {
			// 1.ʹ�ö��������������տͻ��˷����Ķ���
			System.out.println("�������ȴ����ݵĵ���...");
			 Object obj = sic.getOis().readObject();
			// 2.��ӡ���յ��Ķ���
			System.out.println("���������յ��Ķ����ǣ�" + obj);
			if(obj instanceof UserMessage) {
				UserMessage tum = (UserMessage)obj;
			
			// ��Բ�ͬ��ҵ��������ʵ�������Ĺ��ܴ���
			switch (tum.getType()) {
				case "managerCheck":
					serverManagerLogin(tum);
					break;
				case "clientExit":
					serverExit();
					return;
				case "addUser":serverAddUser(tum);
				break;
				
				
				case "delUser":serverdelUser(tum);
				break;
				
				
				case "modifyUser":servermodifyUser(tum);
				break;
				
				case "findUser":serverfindUser(tum);
				break;
				
				}
			}else {
				QuestionMessage tqm = (QuestionMessage)obj;
				switch(tqm.getType()) {
					
					case "addQuestio":serverAddQuestionr(tqm);
					break;	
					
					case "delQuestio":serverdelQuestionr(tqm);
					break;
					
					case "modifyQuestion":servermodifyQuestionr(tqm);
					break;
					
					case "findQuestion":serverfindQuestion(tqm);
					break;
				}
					
				}
			}
		}
	
public QuestionMessage serverfindQuestion(QuestionMessage tqm) throws IOException {
	for(Question tq : questionList) {
		if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
			tqm.setType("success");
			sic.getOos().writeObject(tqm);
			sic.getOos().writeObject(tq);
			System.out.println("���������Ͳ��ҿ�����Ϣ��У�����ɹ�" );
			return tqm;
		}
		
	}
	
		tqm.setType("fail");
		sic.getOos().writeObject(tqm);
		System.out.println("���������Ͳ��ҿ���Ĵ������ɹ�");
		
		return tqm;
		
	}
			
		
	


public void servermodifyQuestionr(QuestionMessage tqm) throws IOException {
	for(Question tq : questionList) {
		if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
			System.out.println("1");
			tqm.setType("success");
			questionList.remove(tq);
			questionList.add(tqm.getQmQuestrion());
			sic.getOos().writeObject(tqm);
			System.out.println("������Ϣ��ʼ���ɹ���");
			return;		
		}		
		
		
	    
	}
	tqm.setType("fail");
	sic.getOos().writeObject(tqm);
	System.out.println("�������޸Ŀ�����Ϣ��У�����ɹ���");
}
		
	


public void serverdelQuestionr(QuestionMessage tqm) throws IOException {
		
		for(Question tq : questionList) {
			if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
				questionList.remove(tq);
				tqm.setType("success");
				sic.getOos().writeObject(tqm);
				System.out.println("����������ɾ������Ĵ������ɹ�");
				return;
				
			}
		}
		
		
		tqm.setType("fail");
		sic.getOos().writeObject(tqm);
		System.out.println("����������ɾ������Ĵ������ɹ�");
	}	
		
		
	


public void serverAddQuestionr(QuestionMessage tqm) throws IOException {
		
		for(Question tq : questionList) {
			if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
				tqm.setType("fail");
				sic.getOos().writeObject(tqm);
				System.out.println("�������������ӿ���Ĵ������ɹ�");
				return;
				
			}
		}
		
		questionList.add(tqm.getQmQuestrion());
		tqm.setType("success");
		sic.getOos().writeObject(tqm);
		System.out.println("�������������ӿ���Ĵ������ɹ�");
	}

public void serverAddUser(UserMessage tum) throws IOException {
		
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				tum.setType("fail");
				sic.getOos().writeObject(tum);
				System.out.println("��������������ѧԱ�Ĵ������ɹ�");
				return;
				
			}
		}
		
		userList.add(tum.getUmUser());
		tum.setType("success");
		sic.getOos().writeObject(tum);
		System.out.println("��������������ѧԱ�Ĵ������ɹ�");
	}
	public void serverdelUser(UserMessage tum) throws IOException {
		
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				userList.remove(tu);
				tum.setType("success");
				sic.getOos().writeObject(tum);
				System.out.println("����������ɾ��ѧԱ�Ĵ������ɹ�");
				return;
				
			}
		}
		
		
		tum.setType("fail");
		sic.getOos().writeObject(tum);
		System.out.println("����������ɾ��ѧԱ�Ĵ������ɹ�");
	}
	
	public void servermodifyUser(UserMessage tum) throws IOException {
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				userList.remove(tu);
				userList.add(tum.getUmUser());
				tum.setType("success");
				sic.getOos().writeObject(tum);
				System.out.println("ѧԱ��Ϣ��ʼ���ɹ���");
				return;		
			}		
			
			tum.setType("fail");
			sic.getOos().writeObject(tum);
			System.out.println("�������޸�ѧԱ��Ϣ��У�����ɹ���");
		    
		}
	}
	
	public UserMessage serverfindUser(UserMessage tum) throws IOException {
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				tum.setType("success");
				sic.getOos().writeObject(tum);
				sic.getOos().writeObject(tu);
				System.out.println("���������Ͳ���ѧԱ��Ϣ��У�����ɹ�" );
				return tum;
			}
			
		}
		
		tum.setType("fail");
		
		sic.getOos().writeObject(tum);
		System.out.println("���������Ͳ���ѧԱ�Ĵ������ɹ�");
		return tum ;
	}
				
	




	public void serverExit() throws IOException {
		// 3.���ó�Ա�������йر�
		sic.serverClose();
		
	}
	
	
	public void serverManagerLogin(UserMessage tum) throws IOException {
		// �Խ��յ����û�����������м��飬����У�����޸����ͺ�
		if ("admin".equalsIgnoreCase(tum.getUmUser().getUserName()) 
				&& "123456".equals(tum.getUmUser().getPassWord())) {
			tum.setType("success");
		} else {
			tum.setType("fail");
		}
		// ��У��Ľ��ͨ��������������͸��ͻ���
		sic.getOos().writeObject(tum);
		System.out.println("����������У�����ɹ���");
	}
}
