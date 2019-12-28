package day04;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class Demo {

	

	public static void main(String[] args) throws IOException, DocumentException {
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎");
		System.out.println("手机号");
		String phone = input.nextLine();
		
		
		URL url = new URL("http://apis.juhe.cn/mobile/get?phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
		URLConnection conn = url.openConnection();
		InputStream is =  conn.getInputStream();
		SAXReader sr = new SAXReader();
		Document doc = sr.read(is);
		Element root = doc.getRootElement();
		String errorCode = root.elementText("error_code");
		if("0".equals(errorCode)) {
			Element result = root.element("result");
			System.out.println("如下");
			String province = result.elementText("province");
			String city = result.elementText("city");
			if(!province.equals(city))
				System.out.println("\t省份"+province);
			System.out.println("\t城市"+city);
			System.out.println("\t区号"+result.elementText("areacode"));
			System.out.println("\t 邮 "+result.elementText("zip"));
			System.out.println("\t 运营商 "+result.elementText("company"));
		}else {
			System.out.println("查询失败");
		}

	}

}
