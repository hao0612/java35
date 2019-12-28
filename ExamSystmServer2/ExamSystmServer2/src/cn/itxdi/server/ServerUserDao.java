package cn.itxdi.server;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import cn.itxdl.bean.User;

public class ServerUserDao {
	
	public List<User> userList;
	public ServerUserDao(List<User> userList) {
		this.userList = userList; 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> readUserFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File tf = new File("./user.txt");
		
		if(tf.exists() && tf.length()>0) {
		
		
			ObjectInputStream ois = new 
					ObjectInputStream(new FileInputStream("./user.txt"));
			userList = (List<User>) ois.readObject();
			ois.close();
			
		}
		return userList;
	}
	
	public void writeUserFile() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./user.txt"));
		oos.writeObject(userList);
		oos.close();
	}
	
	
}
