package day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c://1.properties");
		Properties ppt = new Properties();
		ppt.load(fis);
		String url = ppt.getProperty("url");
		System.out.println(url);
		String user = ppt.getProperty("user");
		System.out.println(user);
		String passwork = ppt.getProperty("passwork");
		System.out.println(passwork);
		

	}

}
