package entity;

public class NodeAc {
	private String name;//空调名
	private String startTemp;//开启温度
	private String shutdownTemp;//关闭温度
	private String settingTemp;//环境温度
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTemp() {
		return startTemp;
	}
	public void setStartTemp(String startTemp) {
		this.startTemp = startTemp;
	}
	public String getShutdownTemp() {
		return shutdownTemp;
	}
	public void setShutdownTemp(String shutdownTemp) {
		this.shutdownTemp = shutdownTemp;
	}
	public String getSettingTemp() {
		return settingTemp;
	}
	public void setSettingTemp(String settingTemp) {
		this.settingTemp = settingTemp;
	}
	
}
