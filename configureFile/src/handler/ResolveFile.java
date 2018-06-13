package handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.NodeAc;
import entity.NodeConfig;
import entity.NodePolicy;

public class ResolveFile extends DefaultHandler{
	NodeConfig nodeConfig = null;
	NodePolicy nodePolicy = null;
	NodeAc nodeAc = null;
	String value = null;
	
	private ArrayList<NodeConfig> nodeConfigList = new ArrayList<NodeConfig>();
	private ArrayList<NodePolicy> nodePolicyList = new ArrayList<NodePolicy>();
	private ArrayList<NodeAc> nodeAcList = new ArrayList<NodeAc>();
	 
	public ArrayList<NodeConfig> getNodeConfigList() {
		return nodeConfigList;
	}
	
	public ArrayList<NodePolicy> getNodePolicyList() {
		return nodePolicyList;
	}
	
	public ArrayList<NodeAc> getNodeAcList() {
		return nodeAcList;
	}
	
	/*
	 * ��־������ʼ 
	 */
	 public void startDocument() throws SAXException{
		 super.startDocument();
		 System.out.println("������ʼ��");
	 } 
	 /*
	  * ��־��������
	  */
	 public void endDocument() throws SAXException{
		 super.endDocument();
		 System.out.println("����������");
	 }
	 /*
	  * ����xml�ı�ǩ������xmlԪ��
	  * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	  */
	 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
		 super.startElement(uri, localName, qName, attributes);
		 if(qName.equals("config")) {
			 nodeConfig = new NodeConfig();
			 int configNum = attributes.getLength();
			 for(int i = 0; i < configNum; i ++) {
				 System.out.print("config�ڵ�ĵ�" + (i + 1) + "���������ǣ�" + attributes.getQName(i));
				 System.out.println(" ����ֵ�ǣ�" + attributes.getValue(i));
				 if(attributes.getQName(i).equals("acNum")) {
					 nodeConfig.setAcNum(attributes.getValue(i));
				 }
			 }
		 }else if (qName.equals("policy")) {
			 nodePolicy = new NodePolicy();
			 int configNum = attributes.getLength();
			 for(int i = 0; i < configNum; i ++) {
				 System.out.print("policy�ڵ�ĵ�" + (i + 1) + "���������ǣ�" + attributes.getQName(i));
				 System.out.println(" ����ֵ�ǣ�" + attributes.getValue(i));
				 if(attributes.getQName(i).equals("name")) {
					 nodePolicy.setName(attributes.getValue(i));
				 }else if(attributes.getQName(i).equals("desc")){
					 nodePolicy.setDesc(attributes.getValue(i));
				}
			 }
		}else if (qName.equals("ac")) {
			nodeAc = new NodeAc();
			 int configNum = attributes.getLength();
			 for(int i = 0; i < configNum; i ++) {
				 System.out.print("AC�ڵ�ĵ�" + (i + 1) + "���������ǣ�" + attributes.getQName(i));
				 System.out.println(" ����ֵ�ǣ�" + attributes.getValue(i));
				 if(attributes.getQName(i).equals("name")) {
					 nodeAc.setName(attributes.getValue(i));
				 }else if(attributes.getQName(i).equals("startTemp")){
					nodeAc.setStartTemp(attributes.getValue(i));
				}else if(attributes.getQName(i).equals("shutdownTemp")){
					nodeAc.setShutdownTemp(attributes.getValue(i));
				}else if(attributes.getQName(i).equals("settingTemp")){
					nodeAc.setSettingTemp(attributes.getValue(i));
				}
			 }
		}
	 }
	 /*
	  * ����xml�Ľ�����ǩ
	  */
	 public void endElement(String uri, String localName, String qName) throws SAXException{
		 super.endElement(uri, localName, qName);
		 if(qName.equals("config")) {
			 nodeConfigList.add(nodeConfig);
			 nodeConfig = null;
		 }else if (qName.equals("policy")) {
			nodePolicyList.add(nodePolicy);
			nodePolicy = null;
		}else if (qName.equals("ac")) {
			nodeAcList.add(nodeAc);
			nodeAc = null;
		}
	 }
	 /*
	  * ��ȡ�ı�
	  * ��дcharaters()����ʱ��
	  * String(byte[] bytes,int offset,int length)�Ĺ��췽����������Ĵ���
	  * ȥ������ʱ����ո�
	  */
	 public void characters(char[] ch, int start, int length)throws SAXException {
		 super.characters(ch, start, length);
		 value = new String(ch, start, length);
//		 System.out.println(value);
//		 if(!value.trim().equals("")){
//			 System.out.println("�ڵ�ֵ�ǣ�" + value);
//		 }
	 }
	 
	 
	 
}
