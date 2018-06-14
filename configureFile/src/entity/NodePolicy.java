package entity;

import java.util.ArrayList;

public class NodePolicy {
	private String name;//策略名
	private String desc;//策略描述
	public ArrayList<NodeAc> ac = new ArrayList<NodeAc>();//AC配置的数组,用于存储当前policy下的AC配置
	
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
