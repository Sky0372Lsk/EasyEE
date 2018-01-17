package cn.easyproject.easyee.sm.building.service;

import java.io.Serializable;
import java.util.List;

import cn.easyproject.easyee.sm.building.criteria.BuildingCriteria;
import cn.easyproject.easyee.sm.building.entity.Building;
import org.springframework.transaction.annotation.Transactional;

import cn.easyproject.easyee.sm.base.pagination.PageBean;

/**
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Transactional
public interface BuildingService {
	public void save(Building building);
	public void delete(Serializable buildingid);
	public void update(Building building);
	@Transactional(readOnly=true)
	public Building get(Integer buildingid);

	@SuppressWarnings("rawtypes")
	@Transactional(readOnly=true)
	public void findByPage(PageBean pageBean, BuildingCriteria buildingCriteria);
	
	@Transactional(readOnly=true)
	public List<Building> findAll();
}
