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
		//1. ��ȡ�ļ�������
		FileInputStream fis = new FileInputStream("C:\\Users\\mi\\Downloads\\java35\\day03.xml\\src\\book.xml");
		//2. ����XML��ȡ���߶���
		SAXReader sr = new SAXReader();
		//3. ͨ����ȡ����, ��ȡXML�ļ���������.���õ��ļ��Ķ���
		Document doc = sr.read(fis);
		//4. ͨ���ļ�����,��ȡ�ļ��ĸ��ڵ����
		Element root = doc.getRootElement();
		//5. ͨ�����ڵ�,��ȡ�����ӽڵ�
		List<Element> es = root.elements();
		//6. ѭ����������BOOK
		for(Element e :es) {
			//1. ��ȡid����ֵ
			String id = e.attributeValue("id");
			//2. ��ȡ�ӽڵ�name,����ȡ��������
			String name = e.element("name").getText();
			//32. ��ȡ�ӽڵ�info,����ȡ��������
			String info = e.element("info").getText();
			//4. ��ӡ
			System.out.println("id="+id+",+name="+name+",info="+info);
			}
	}

}
