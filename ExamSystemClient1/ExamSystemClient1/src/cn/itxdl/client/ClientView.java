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
			System.out.println("\n\n\t    兄弟连在线考试系统");
			System.out.println("--------------");
			System.out.print("[1] 学员系统");
			System.out.println("    [2] 管理员系统");
			System.out.println("[0] 退出系统");
			System.out.println("------------");
			System.out.println("请选择要进入的系统");
			System.out.println("-----------------");
		
			int choose = ClientScanner.getSc().nextInt();
			switch(choose){
		//	case 1 : System.out.println("正在进入学员系统");break;
				case 1: studentMangerLogin();break;
				case 2: clientMangerLogin();break;
				case 0: clientExit();return;
				default: System.out.println("输入错误,请重新输入");
		    }
		}
	}
	

	

	private void studentMangerLogin() throws ClassNotFoundException, InterruptedException, IOException {
		System.out.println("请输入学员账号");
		 String StrUser = ClientScanner.getSc().next();
		//.提示用户输入输入学员的密码信息
		 System.out.println("请输入学员密码");
		 String strPass = ClientScanner.getSc().next();
		// 将用户名和密码以及业务的类型打包成一个完整对象
		 UserMessage tum = new UserMessage("managerCheck",new User(StrUser,strPass));
		 // 使用对象输出流将上述对象发送给服务器
		 cic.getOos().writeObject(tum);
		 System.out.println("客户端发送学员账户信息成功");
		// 接收服务器发来的校验结果并给出对应的提示
		 tum = (UserMessage)cic.getOis().readObject();
		 if("success".equals(tum.getType())) {
	     	 System.out.println("登陆成功,欢迎使用");
	     	 cmv.studentMainpage();
			 }else {
				 System.out.println("用户名或密码错误,请重新输入");
			 }
		
	}

	public void clientExit() throws IOException {
		// 1.客户端在退出之前应该向服务器发送一个退出的消息
		UserMessage tum = new UserMessage("clientExit", null);
		cic.getOos().writeObject(tum);
		// 2.客户端应该将所有需要善后的工作全部处理完毕
		// 3.调用成员方法进行关闭
		cic.clientClose();
		// 6.关闭客户端共用的扫描器
		ClientScanner.cioseSc();
		System.out.println("谢谢使用，下次再见！");
	}
	public void clientMangerLogin() throws IOException, ClassNotFoundException, InterruptedException {
		// 1.提示用户输入输入管理员的用户名信息
		 System.out.println("请输入管理员账号");
		 String StrUser = ClientScanner.getSc().next();
		// 2.提示用户输入输入管理员的密码信息
		 System.out.println("请输入管理员密码");
		 String strPass = ClientScanner.getSc().next();
		// 3.将用户名和密码以及业务的类型打包成一个完整对象
		 UserMessage tum = new UserMessage("managerCheck",new User(StrUser,strPass));
		 // 4.使用对象输出流将上述对象发送给服务器
		 cic.getOos().writeObject(tum);
		 System.out.println("客户端发送管理员账户信息成功");
		// 5.接收服务器发来的校验结果并给出对应的提示
		 tum = (UserMessage)cic.getOis().readObject();
		 if("success".equals(tum.getType())) {
	     	 System.out.println("登陆成功,欢迎使用");
	     	 cmv.clientMainpage();
	     	 
			 }else {
				 System.out.println("用户名或密码错误,请重新输入");
			 }
	 
	}
}	


