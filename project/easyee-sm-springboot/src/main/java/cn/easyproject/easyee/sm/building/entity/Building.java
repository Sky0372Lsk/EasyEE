package cn.easyproject.easyee.sm.building.entity;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class Building implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer buildingid;
	private String num;
	private String location;

	public Building(Integer buildingid, String num, String location) {
		this.buildingid = buildingid;
		this.num = num;
		this.location = location;
	}

	public Integer getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Integer buildingid) {
		this.buildingid = buildingid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}