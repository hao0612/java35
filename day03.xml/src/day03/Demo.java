package day03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		//1. 获取文件输入流
		FileInputStream fis = new FileInputStream("C:\\Users\\mi\\Downloads\\java35\\day03.xml\\src\\book.xml");
		//2. 创建XML读取工具对象
		SAXReader sr = new SAXReader();
		//3. 通过读取工具, 读取XML文件的输入流.并得到文件的对象
		Document doc = sr.read(fis);
		//4. 通过文件对象,获取文件的根节点对象
		Element root = doc.getRootElement();
		//5. 通过根节点,获取所有子节点
		List<Element> es = root.elements();
		//6. 循环遍历三个BOOK
		for(Element e :es) {
			//1. 获取id属性值
			String id = e.attributeValue("id");
			//2. 获取子节点name,并获取它的内容
			String name = e.element("name").getText();
			//32. 获取子节点info,并获取它的内容
			String info = e.element("info").getText();
			//4. 打印
			System.out.println("id="+id+",+name="+name+",info="+info);
			}
	}

}
