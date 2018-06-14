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
		//��ȡһ��SAXParserFactoryʵ������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//ͨ��factory��newSAXParser()������ȡһ��SAXParser��Ķ���
		try {
			SAXParser parser = factory.newSAXParser();
			//����ResolveFile����
			ResolveFile handler = new ResolveFile();
			parser.parse("../configureFile/src/root.xml", handler);
			for(NodeConfig config : handler.getNodeConfigList()) {
				System.out.println("config��acNum����ֵΪ��" + config.getAcNum());
				System.out.println("��config��policy���Թ��У�" + config.policy.size() + " �����ֱ�Ϊ��");
				int i = 1;
				for(NodePolicy policy : config.policy) {
					System.out.println("	" + "��config�ĵ�  " + i + " ��policy����Ϊ:");
					System.out.println("	" + "policy��name����ֵΪ��" + policy.getName());
					System.out.println("	" + "policy��desc����ֵΪ��" + policy.getDesc());
					i ++;
					System.out.println("	" + "��policy��AC���ù��У�" + policy.ac.size() + " �����ֱ�Ϊ��");
					int j = 1;
					for(NodeAc ac : policy.ac) {
						System.out.println("		" + "��policy�ĵ�  " + j + " ��AC����Ϊ��");
						System.out.println("		" + "AC��name����ֵΪ��" + ac.getName());
						System.out.println("		" + "AC��startTemp����ֵΪ��" + ac.getStartTemp());
						System.out.println("		" + "AC��shutdownTemp����ֵΪ��" + ac.getShutdownTemp());
						System.out.println("		" + "AC��settingTemp����ֵΪ��" + ac.getSettingTemp());
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
