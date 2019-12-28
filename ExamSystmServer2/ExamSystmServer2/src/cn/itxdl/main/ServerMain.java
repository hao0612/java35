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
		
			// 6.����Ŀ����ʱ�����ļ��е�����ѧԱ�˻���Ϣ��ȡ��������ӡ
			List<User> userList = new LinkedList<User>();
			ServerUserDao sud = new ServerUserDao(userList);
			userList = sud.readUserFile();
			System.out.println("�ļ��е�ѧԱ�˻���Ϣ�У�");
			for(User tu : userList) {
				System.out.println(tu);
			}
			// 8.����Ŀ����ʱ�����ļ��е����п�����Ϣ��ȡ��������ӡ
			List<Question> questionList = new LinkedList<Question>();
			ServerQuestionDao sqd = new ServerQuestionDao(questionList);
			questionList = sqd.readQuestionFile();
			System.out.println("�ļ��еĿ�����Ϣ�У�");
			for(Question tq : questionList) {
				System.out.println(tq);
			}
			
			
			
			
			// 1.����ServerInitClose���͵�����ָ������͵Ķ���
			ServerInitClose sic = new ServerInitClose();
			// 2.���ó�Ա�������г�ʼ��
			sic.serverInit();
			
			// 4.����ServerView���͵�����ָ������͵Ķ���
			ServerView sv = new ServerView(sic,userList,questionList);
			// 5.���ó�Ա���������տͻ��˷�������Ϣ
			sv.serverReceiveMessage();
			
			// 7.����Ŀ�˳�ʱ���������е�����ѧԱ�˻���Ϣ����д�뵽�ļ���
			sud.writeUserFile();
			// 9.����Ŀ�˳�ʱ���������е����п�����Ϣ����д�뵽�ļ���
			sqd.writeQuestionFile();
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
