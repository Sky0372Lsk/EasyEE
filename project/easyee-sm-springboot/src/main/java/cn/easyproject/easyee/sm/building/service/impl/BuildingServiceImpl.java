package cn.easyproject.easyee.sm.building.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import cn.easyproject.easyee.sm.building.criteria.BuildingCriteria;
import cn.easyproject.easyee.sm.building.dao.BuildingDAO;
import cn.easyproject.easyee.sm.building.entity.Building;
import cn.easyproject.easyee.sm.building.service.BuildingService;
import org.springframework.stereotype.Service;

import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.service.BaseService;

/**
 * 业务实现类统一继承 BaseService 类
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@Service("buildingService")
public class BuildingServiceImpl extends BaseService implements BuildingService {

	@Resource
	BuildingDAO buildingDAO;
	
	@Override
	public void save(Building building) {
		buildingDAO.save(building);
	}

	@Override
	public void delete(Serializable buildingid) {
		buildingDAO.delete(buildingid);
	}

	@Override
	public void update(Building building) {
		buildingDAO.update(building);
	}

	@Override
	public Building get(Integer buildingid) {
		return buildingDAO.get(buildingid);
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public void findByPage(PageBean pageBean, BuildingCriteria buildingCriteria) {
		pageBean.setFrom("module_building building");
		pageBean.setSelect("building.*");
		pageBean.setEasyCriteria(buildingCriteria);
		// 按条件分页查询
		buildingDAO.pagination(pageBean);
	}

	@Override
	public List<Building> findAll() {
		return buildingDAO.findAll();
	}
}
