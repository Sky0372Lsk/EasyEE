package cn.easyproject.easyee.sm.building.dao;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.building.entity.Building;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
public interface BuildingDAO {
	
	public void save(Building building);

	public void delete(Serializable buildingid);

	public void update(Building building);

	public Building get(Integer buildingid);

	@SuppressWarnings("rawtypes")
	public List pagination(PageBean pageBean);

	public List<Building> findAll();
	
	public int findMaxRow();
}
