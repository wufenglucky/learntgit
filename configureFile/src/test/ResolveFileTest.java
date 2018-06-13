package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import entity.NodePolicy;
import handler.ResolveFile;

public class ResolveFileTest {

	public static void main(String[] args) {
		//获取一个SAXParserFactory实例对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//通过factory的newSAXParser()方法获取一个SAXParser类的对象
		try {
			SAXParser parser = factory.newSAXParser();
			//创建ResolveFile对象
			ResolveFile handler = new ResolveFile();
			parser.parse("../configureFile/src/root.xml", handler);
			for(NodePolicy policy : handler.getNodePolicyList()) {
				System.out.println(policy.getName());
				System.out.println(policy.getDesc());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
