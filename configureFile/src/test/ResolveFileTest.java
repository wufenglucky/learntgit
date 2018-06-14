package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import entity.NodeAc;
import entity.NodeConfig;
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
			for(NodeConfig config : handler.getNodeConfigList()) {
				System.out.println("config的acNum属性值为：" + config.getAcNum());
				System.out.println("该config的policy策略共有：" + config.policy.size() + " 个，分别为：");
				int i = 1;
				for(NodePolicy policy : config.policy) {
					System.out.println("	" + "该config的第  " + i + " 个policy策略为:");
					System.out.println("	" + "policy的name属性值为：" + policy.getName());
					System.out.println("	" + "policy的desc属性值为：" + policy.getDesc());
					i ++;
					System.out.println("	" + "该policy的AC配置共有：" + policy.ac.size() + " 个，分别为：");
					int j = 1;
					for(NodeAc ac : policy.ac) {
						System.out.println("		" + "该policy的第  " + j + " 个AC配置为：");
						System.out.println("		" + "AC的name属性值为：" + ac.getName());
						System.out.println("		" + "AC的startTemp属性值为：" + ac.getStartTemp());
						System.out.println("		" + "AC的shutdownTemp属性值为：" + ac.getShutdownTemp());
						System.out.println("		" + "AC的settingTemp属性值为：" + ac.getSettingTemp());
						j ++;
					}
				}
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
