package entity;

import java.util.ArrayList;

public class NodePolicy {
	private String name;//������
	private String desc;//��������
	public ArrayList<NodeAc> ac = new ArrayList<NodeAc>();//AC���õ�����,���ڴ洢��ǰpolicy�µ�AC����
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
