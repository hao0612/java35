package cn.itxdi.server;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import cn.itxdl.bean.Question;


public class ServerQuestionDao {
	
	public List<Question> questionList;
	public ServerQuestionDao(List<Question> questionList) {
		this.questionList = questionList; 
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Question> readQuestionFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File tf = new File("./question.txt");
		
		if(tf.exists() && tf.length()>0) {
		
		
			ObjectInputStream ois = new 
					ObjectInputStream(new FileInputStream("./question.txt"));
			questionList = (List<Question>) ois.readObject();
			ois.close();
			
		}
		return questionList;
	}
	
	public void writeQuestionFile() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./question.txt"));
		oos.writeObject(questionList);
		oos.close();
	}
	
	
}
