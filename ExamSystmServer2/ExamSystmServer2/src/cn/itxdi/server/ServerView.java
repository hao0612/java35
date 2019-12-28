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
			// 1.使用对象输入流来接收客户端发来的对象
			System.out.println("服务器等待数据的到来...");
			 Object obj = sic.getOis().readObject();
			// 2.打印接收到的对象
			System.out.println("服务器接收到的对象是：" + obj);
			if(obj instanceof UserMessage) {
				UserMessage tum = (UserMessage)obj;
			
			// 针对不同的业务类型来实现真正的功能处理
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
			System.out.println("服务器发送查找考题信息的校验结果成功" );
			return tqm;
		}
		
	}
	
		tqm.setType("fail");
		sic.getOos().writeObject(tqm);
		System.out.println("服务器发送查找考题的处理结果成功");
		
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
			System.out.println("考题信息初始化成功！");
			return;		
		}		
		
		
	    
	}
	tqm.setType("fail");
	sic.getOos().writeObject(tqm);
	System.out.println("服务器修改考题信息的校验结果成功！");
}
		
	


public void serverdelQuestionr(QuestionMessage tqm) throws IOException {
		
		for(Question tq : questionList) {
			if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
				questionList.remove(tq);
				tqm.setType("success");
				sic.getOos().writeObject(tqm);
				System.out.println("服务器发送删除考题的处理结果成功");
				return;
				
			}
		}
		
		
		tqm.setType("fail");
		sic.getOos().writeObject(tqm);
		System.out.println("服务器发送删除考题的处理结果成功");
	}	
		
		
	


public void serverAddQuestionr(QuestionMessage tqm) throws IOException {
		
		for(Question tq : questionList) {
			if(tq.getTitle().equals(tqm.getQmQuestrion().getTitle())) {
				tqm.setType("fail");
				sic.getOos().writeObject(tqm);
				System.out.println("服务器发送增加考题的处理结果成功");
				return;
				
			}
		}
		
		questionList.add(tqm.getQmQuestrion());
		tqm.setType("success");
		sic.getOos().writeObject(tqm);
		System.out.println("服务器发送增加考题的处理结果成功");
	}

public void serverAddUser(UserMessage tum) throws IOException {
		
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				tum.setType("fail");
				sic.getOos().writeObject(tum);
				System.out.println("服务器发送增加学员的处理结果成功");
				return;
				
			}
		}
		
		userList.add(tum.getUmUser());
		tum.setType("success");
		sic.getOos().writeObject(tum);
		System.out.println("服务器发送增加学员的处理结果成功");
	}
	public void serverdelUser(UserMessage tum) throws IOException {
		
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				userList.remove(tu);
				tum.setType("success");
				sic.getOos().writeObject(tum);
				System.out.println("服务器发送删除学员的处理结果成功");
				return;
				
			}
		}
		
		
		tum.setType("fail");
		sic.getOos().writeObject(tum);
		System.out.println("服务器发送删除学员的处理结果成功");
	}
	
	public void servermodifyUser(UserMessage tum) throws IOException {
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				userList.remove(tu);
				userList.add(tum.getUmUser());
				tum.setType("success");
				sic.getOos().writeObject(tum);
				System.out.println("学员信息初始化成功！");
				return;		
			}		
			
			tum.setType("fail");
			sic.getOos().writeObject(tum);
			System.out.println("服务器修改学员信息的校验结果成功！");
		    
		}
	}
	
	public UserMessage serverfindUser(UserMessage tum) throws IOException {
		for(User tu : userList) {
			if(tu.getUserName().equals(tum.getUmUser().getUserName())) {
				tum.setType("success");
				sic.getOos().writeObject(tum);
				sic.getOos().writeObject(tu);
				System.out.println("服务器发送查找学员信息的校验结果成功" );
				return tum;
			}
			
		}
		
		tum.setType("fail");
		
		sic.getOos().writeObject(tum);
		System.out.println("服务器发送查找学员的处理结果成功");
		return tum ;
	}
				
	




	public void serverExit() throws IOException {
		// 3.调用成员方法进行关闭
		sic.serverClose();
		
	}
	
	
	public void serverManagerLogin(UserMessage tum) throws IOException {
		// 对接收到的用户名和密码进行检验，根据校验结果修改类型后
		if ("admin".equalsIgnoreCase(tum.getUmUser().getUserName()) 
				&& "123456".equals(tum.getUmUser().getPassWord())) {
			tum.setType("success");
		} else {
			tum.setType("fail");
		}
		// 将校验的结果通过对象输出流发送给客户端
		sic.getOos().writeObject(tum);
		System.out.println("服务器发送校验结果成功！");
	}
}
