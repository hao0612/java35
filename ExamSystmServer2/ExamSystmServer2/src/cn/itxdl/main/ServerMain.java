package cn.itxdl.main;

import java.util.LinkedList;
import java.util.List;

import cn.itxdi.server.ServerInitClose;
import cn.itxdi.server.ServerQuestionDao;
import cn.itxdi.server.ServerUserDao;
import cn.itxdi.server.ServerView;
import cn.itxdl.bean.Question;
import cn.itxdl.bean.User;

public class ServerMain {

	public static void main(String[] args) {
		
		try {
		
			// 6.当项目启动时，将文件中的所有学员账户信息读取出来并打印
			List<User> userList = new LinkedList<User>();
			ServerUserDao sud = new ServerUserDao(userList);
			userList = sud.readUserFile();
			System.out.println("文件中的学员账户信息有：");
			for(User tu : userList) {
				System.out.println(tu);
			}
			// 8.当项目启动时，将文件中的所有考题信息读取出来并打印
			List<Question> questionList = new LinkedList<Question>();
			ServerQuestionDao sqd = new ServerQuestionDao(questionList);
			questionList = sqd.readQuestionFile();
			System.out.println("文件中的考题信息有：");
			for(Question tq : questionList) {
				System.out.println(tq);
			}
			
			
			
			
			// 1.声明ServerInitClose类型的引用指向该类型的对象
			ServerInitClose sic = new ServerInitClose();
			// 2.调用成员方法进行初始化
			sic.serverInit();
			
			// 4.声明ServerView类型的引用指向该类型的对象
			ServerView sv = new ServerView(sic,userList,questionList);
			// 5.调用成员方法来接收客户端发来的消息
			sv.serverReceiveMessage();
			
			// 7.当项目退出时，将集合中的所有学员账户信息整体写入到文件中
			sud.writeUserFile();
			// 9.当项目退出时，将集合中的所有考题信息整体写入到文件中
			sqd.writeQuestionFile();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
