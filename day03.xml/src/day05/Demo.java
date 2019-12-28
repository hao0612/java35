package day05;

import com.thoughtworks.xstream.XStream;

public class Demo {

	public static void main(String[] args) {
		person p = new person(101, "ºÂÓî", "ÄÐ");
		XStream x = new XStream();
		x.alias("haha", person.class);
		String xml = x.toXML(p);
		System.out.println(xml);
	}

	
}


