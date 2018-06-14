package entity;

import java.util.ArrayList;

public class NodeConfig {
	private String acNum;//AC配置的数量
	public ArrayList<NodePolicy> policy = new ArrayList<NodePolicy>();//策略的数组，用于存储当前config的policy

	public String getAcNum() {
		return acNum;
	}

	public void setAcNum(String acNum) {
		this.acNum = acNum;
	}
}
