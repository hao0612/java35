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
		System.out.println("\n\n\t    欢迎进入管理员系统");
		System.out.println("--------------");
		System.out.print("[1] 学员管理");
		System.out.println("    [2] 考题管理");
		System.out.println("[0] 退出系统");
		System.out.println("------------");
		System.out.println("请选择要进行的业务");
		System.out.println("-----------------");
		int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientUserMainpage();break;
				case 2: clientQuestionMainpage();break;
				case 0: System.out.println("正在返回上一级菜单");
				Thread.sleep(2000);
				return;
				default: System.out.println("输入错误,请重新输入");
		    }
		}
	}
	public void clientUserMainpage() throws  InterruptedException, IOException, ClassNotFoundException{
		while(true) {
		System.out.println("\n\n\t    欢迎进入学员管理子系统");
		System.out.println("--------------");
		System.out.print("[1] 增加学员");
		System.out.println("    [2] 删除学员");
		System.out.print("[3] 修改学员");
		System.out.println("    [4] 查找学员");
		System.out.println("[0] 退出系统");
		System.out.println("------------");
		System.out.println("请选择要进行的业务");
		System.out.println("-----------------");
		int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientAddUser();break;
				case 2: clientdelUser();break;
				case 3: clientmodifyUser();break;
				case 4: clientfindUser();break;
				case 0: System.out.println("正在返回上一级菜单");
				Thread.sleep(1000);
				return;
				default: System.out.println("输入错误,请重新输入");
		    }
		}
	}
	
	
	 private void clientmodifyUser() throws IOException, ClassNotFoundException {
		  System.out.println("请输入需要修改的学员姓名：");
		  String strName = ClientScanner.getSc().next();
		  System.out.println("请输入需要修改的学员密码：");
		  String strPass = ClientScanner.getSc().next();
		  UserMessage tum = new UserMessage(
		    "modifyUser", new User(strName, strPass));
		  cic.getOos().writeObject(tum);
		  System.out.println("客户端发送修改学员信息完成！"); 
		  tum = (UserMessage) cic.getOis().readObject();
			if("fail".equals(tum.getType())) {
				System.out.println("修改学员失败");
			}else{
				System.out.println("修改学员成功");
				return;
			}
				
		}
	public void clientAddUser() throws IOException, ClassNotFoundException {
		System.out.println("请输入要增加学员的用户名：");
		String strName = ClientScanner.getSc().next();
		System.out.println("请输入要增加学员的密码：");
		String strPass = ClientScanner.getSc().next();
		
		UserMessage tum = new UserMessage
				("addUser", new User(strName, strPass));
		cic.getOos().writeObject(tum);
		System.out.println("客户端发送增加学员信息成功");
		
		tum = (UserMessage) cic.getOis().readObject();
		if("fail".equals(tum.getType())) {
			System.out.println("增加学员失败");
		}else{
			System.out.println("增加学员成功");
			return;
		}
			
	}
	
	public void clientdelUser() throws IOException, ClassNotFoundException {
		System.out.println("请输入要删除的学员信息");
		String strName = ClientScanner.getSc().next();
		UserMessage tum = new UserMessage
				("delUser", new User(strName, null));
		cic.getOos().writeObject(tum);
		System.out.println("客户端发送删除学员信息成功");
	
	tum = (UserMessage) cic.getOis().readObject();
	if("fail".equals(tum.getType())) {
		System.out.println("删除学员失败");
	}else{
		System.out.println("删除学员成功");
		return;
	}
	
	}
	
		private void clientfindUser() throws IOException, ClassNotFoundException {
			  System.out.println("请输入需要查找的学员姓名：");
			  String strName = ClientScanner.getSc().next();
			  UserMessage tum = new UserMessage(
			    "findUser", new User(strName, null));
			  cic.getOos().writeObject(tum);
			  System.out.println("客户端发送查找学员信息完成！"); 
			 
			  tum = (UserMessage) cic.getOis().readObject();
				if("fail".equals(tum.getType())) {
					System.out.println("查找学员失败");
				}else{
					System.out.println("查找学员成功");
					 Object o = cic.getOis().readObject();
					 System.out.println(o);
					return;
					
				}
					
			}


			
	
	
		
		
	public void clientQuestionMainpage() throws  InterruptedException, ClassNotFoundException, IOException{
		while(true) {
			System.out.println("\n\n\t    欢迎进入考题管理子系统");
			System.out.println("--------------");
			System.out.print("[1] 增加考题");
			System.out.println("    [2] 删除考题");
			System.out.print("[3] 修改考题");
			System.out.println("    [4] 查找考题");	
			System.out.println("[0] 退出系统");
			System.out.println("------------");
			System.out.println("请选择要进行的业务");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
			switch(choose){
				case 1: clientAddktQuestion();break;
				case 2: clientdelktQuestion();break;
				case 3: clientmodifyktQuestion();break;
				case 4: clientfindktQuestion();break;
				case 0: System.out.println("正在返回上一级菜单");
				Thread.sleep(2000);
				return;
				default: System.out.println("输入错误,请重新输入");
		    }
		}
	}
	public void clientfindktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("请输入需要查找的考题：");
		String strTitle = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage(
			    "findQuestion", new Question(strTitle, strTitle, strTitle, strTitle, strTitle, strTitle));
		  cic.getOos().writeObject(tqm);
		  System.out.println("客户端发送查找考题信息完成！"); 
		 
		  tqm = (QuestionMessage) cic.getOis().readObject();
			if("fail".equals(tqm.getType())) {
				System.out.println("查找考题失败");
			}else{
				System.out.println("查找考题成功");
				 Object o = cic.getOis().readObject();
				 System.out.println(o);
				return;
				
			}
				
		}


		
	

	public void clientmodifyktQuestion() throws ClassNotFoundException, IOException {
		System.out.println("请输入需要修改的考题：");
		String strTitle = ClientScanner.getSc().next();
		System.out.println("请输入需要修改的考题A选项：");
		String strAbswerA = ClientScanner.getSc().next();
		System.out.println("请输入需要修改的考题B选项：");
		String strAbswerB = ClientScanner.getSc().next();
		System.out.println("请输入需要修改的考题C选项：");
		String strAbswerC = ClientScanner.getSc().next();
		System.out.println("请输入需要修改的考题D选项：");
		String strAbswerD = ClientScanner.getSc().next();
		System.out.println("请输入需要修改的正确答案：");
		String strAbswer = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage(
		    "modifyQuestion", new Question(strTitle,
		    		strAbswerA,strAbswerB,strAbswerC,strAbswerD,strAbswer));
		cic.getOos().writeObject(tqm);
		System.out.println("客户端发送修改考题信息完成！"); 
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("修改考题失败");
		}else{
			System.out.println("修改考题成功");
				
			}
				
		
		
	}

	public void clientdelktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("请输入要删除的考题信息");
		String strTitle = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage
				("delQuestio", new Question(strTitle, strTitle, strTitle, strTitle, strTitle, strTitle));
		cic.getOos().writeObject(tqm);
		System.out.println("客户端发送删除考题信息成功");
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("删除考题失败");
		}else{
			System.out.println("删除考题成功");
			return;
		}
			
	}
		


	public void clientAddktQuestion() throws IOException, ClassNotFoundException {
		System.out.println("请输入要增加考题名：");
		String strTitle = ClientScanner.getSc().next();
		System.out.println("请输入考题的A选项：");
		String strAbswerA = ClientScanner.getSc().next();
		System.out.println("请输入考题的B选项：");
		String strAbswerB = ClientScanner.getSc().next();
		System.out.println("请输入考题的C选项：");
		String strAbswerC = ClientScanner.getSc().next();
		System.out.println("请输入考题的D选项：");
		String strAbswerD = ClientScanner.getSc().next();
		System.out.println("请输入考题的正确选项：");
		String strAbswer = ClientScanner.getSc().next();
		QuestionMessage tqm = new QuestionMessage
				("addQuestio", new Question
		(strTitle,strAbswerA, strAbswerB, 
				strAbswerC, strAbswerD, strAbswer));
		cic.getOos().writeObject(tqm);
		System.out.println("客户端发送增加考题成功");
		
		tqm = (QuestionMessage) cic.getOis().readObject();
		if("fail".equals(tqm.getType())) {
			System.out.println("增加考题失败");
		}else{
			System.out.println("增加考题成功");
			return;
		}
			
	}

	public void studentMainpage() throws InterruptedException {
		while(true) {
			System.out.println("\n\n\t    欢迎进入学员系统");
			System.out.println("--------------");
			System.out.print("[1] 用户模块");
			System.out.println("      [2] 考试模块");
			System.out.println("[0] 退出系统");
			System.out.println("------------");
			System.out.println("请选择要进行的业务");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
				switch(choose){
					case 1: studentUserMainpage();break;
					case 2: studentexamMainpage();break;
					case 0: System.out.println("正在返回上一级菜单");
					Thread.sleep(1000);
					return;
					default: System.out.println("输入错误,请重新输入");
			    }
			}
		}
	public void studentexamMainpage() throws InterruptedException {
			while(true) {
				System.out.println("\n\n\t    欢迎进入学员考试子系统");
				System.out.println("--------------");
				System.out.print("[1] 开始考试");
				System.out.println("            [2] 查看本次考试成绩");
				System.out.print("[3] 查看所有考试成绩");
				System.out.println("    [0] 退出系统");
				System.out.println("------------");
				System.out.println("请选择要进行的业务");
				System.out.println("-----------------");
				int choose = ClientScanner.getSc().nextInt();
					switch(choose){
						case 1: System.out.println("正在进入考试系统,请稍后...");;break;
						case 2: System.out.println("正在查看本次考试成绩,请稍后...");break;
						case 3: System.out.println("正在查看所有考试成绩,请稍后...");break;
						case 0: System.out.println("正在返回上一级菜单");
						Thread.sleep(1000);
						return;
						default: System.out.println("输入错误,请重新输入");
				    }
				}
			
			
		
		}

	public void studentUserMainpage() throws InterruptedException {
		while(true) {
			System.out.println("\n\n\t    欢迎进入学员修改密码子系统");
			System.out.println("--------------");
			System.out.print("[1] 修改密码");
			System.out.println("[0] 退出系统");
			System.out.println("------------");
			System.out.println("请选择要进行的业务");
			System.out.println("-----------------");
			int choose = ClientScanner.getSc().nextInt();
				switch(choose){
					case 1: System.out.println("正在修改密码,请稍后...");break;
					case 0: System.out.println("正在返回上一级菜单");
					Thread.sleep(1000);
					return;
					default: System.out.println("输入错误,请重新输入");
			    }
			}
		
		
	
	}
	
}
