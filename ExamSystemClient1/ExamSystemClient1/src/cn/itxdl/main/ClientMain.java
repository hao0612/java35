package cn.itxdl.main;

import cn.itxdl.client.ClielntMangeView;
import cn.itxdl.client.ClientInitClose;
import cn.itxdl.client.ClientView;


public class ClientMain {

	public static void main(String[] args) {
		
		try {
			// 1.声明ClientInitClose类型的引用指向该类型的对象
			ClientInitClose cic = new ClientInitClose();
			// 2.调用成员方法进行初始化
			cic.clientInit();
			//6.声明ClielntMangeView类型的引用指向该类型的对象
			ClielntMangeView cmv = new ClielntMangeView(cic, null);
			// 4.声明ClientView类型的引用指向该类型的对象
			ClientView cv = new ClientView(cic,cmv);
			// 5.调用成员方法进行主界面的绘制
			cv.clientMainpage();
			
		} catch(Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
