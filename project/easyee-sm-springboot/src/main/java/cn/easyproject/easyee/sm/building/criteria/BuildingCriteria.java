package cn.easyproject.easyee.sm.building.criteria;

import cn.easyproject.easyee.sm.base.pagination.EasyCriteria;
import cn.easyproject.easyee.sm.base.util.StringUtils;


/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public class BuildingCriteria extends EasyCriteria implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
 	 * 1. 条件属性
 	 */
	private String num;
	private String location;

	/*
          * 2. 构造方法
          */
	public BuildingCriteria() {
		super();
	}

	public BuildingCriteria(String num, String loc) {
		super();
		this.num = num;
		this.location = loc;
	}

	 /*
 	 * 3. 条件生成抽象方法实现
 	 */
	public String getCondition() {
		values.clear(); //清除条件数据
		StringBuffer condition = new StringBuffer();
		if (StringUtils.isNotNullAndEmpty(this.getNum())) {
			condition.append(" and num like #{num}");
			values.put("num", "%" + this.getNum() + "%");
		}
		if (StringUtils.isNotNullAndEmpty(this.getLocation())) {
			condition.append(" and loc like #{location}");
			values.put("location", "%" + this.getLocation() + "%");
		}
		return condition.toString();
	}
	 /*
 	 * 4. Setters & Getters...
 	 */
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