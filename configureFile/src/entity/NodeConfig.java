package entity;

import java.util.ArrayList;

public class NodeConfig {
	private String acNum;//AC���õ�����
	public ArrayList<NodePolicy> policy = new ArrayList<NodePolicy>();//���Ե����飬���ڴ洢��ǰconfig��policy

	public String getAcNum() {
		return acNum;
	}

	public void setAcNum(String acNum) {
		this.acNum = acNum;
	}
}
