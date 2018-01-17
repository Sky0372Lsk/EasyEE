package cn.easyproject.easyee.sm.building.controller;


import java.util.Map;

import javax.annotation.Resource;

import cn.easyproject.easyee.sm.building.criteria.BuildingCriteria;
import cn.easyproject.easyee.sm.building.entity.Building;
import cn.easyproject.easyee.sm.building.service.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cn.easyproject.easyee.sm.base.controller.BaseController;
import cn.easyproject.easyee.sm.base.pagination.PageBean;
import cn.easyproject.easyee.sm.base.util.StatusCode;
/**
 * 所有Controller处理类统一继承BaseController
 * 
 * BaseController中定义了一下内容：s
 * - request, application Servlet API 
 * - 请求响应相关的JSON参数（EasyUI框架请求都是通过JSON响应） 
 * - 初始化JSON响应数据的方法（setJsonMap，setJsonMsgMap，setJsonPaginationMap(PageBean, Object...)） 
 * - 获得分页对象：super.getPageBean() 
 * 
 * 
 * @author easyproject.cn
 * @version 1.0
 *
 */
@RestController
@RequestMapping("SysBuilding")
public class BuildingController extends BaseController {
	public static Logger logger = LoggerFactory.getLogger(BuildingController.class);
	
	@Resource
	private BuildingService buildingService;
	
	/**
	 * 转向显示页面
	 * @return
	 */
	@RequestMapping("page")
	public ModelAndView page(ModelAndView mv){
		mv.setViewName("main/building/sysBuilding");
		return mv;
	}
	/**
	 * CRUD
	 * @return
	 */
	@RequestMapping("save")
	public Map<Object,Object> save(Building building){
		// 保存
		try {
			buildingService.save(building);
			// 处理成功 消息
			super.setMsgKey("msg.saveSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.saveFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		/*
		 * Ajax响应信息
		 * statusCode: 响应状态码;  
		 * msg: 响应消息;   
		 * callback: 执行回调函数,
		 * locationUrl: 跳转页面
		 */
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息
		// super.setJsonMsgMap();
		
		
		// 添加数据后，使用rowData信息更新行的内容
		// 返回JSON
		return super.setJsonMsgMap("rowData", building);
		
		// 如果需要刷新，跳转到最后一页
//		int page = buildingService.findMaxPage(rows);
//		return super.setJsonMsgMap("rowData", building, "page", page);
	}
	
	/**
	 * 分页
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("list")
	public Map<Object,Object> list(BuildingCriteria buildingCriteria){
		PageBean pb = super.getPageBean(); // 获得分页对
		buildingService.findByPage(pb,buildingCriteria);
		// EasyUI框架响应结果都是JSON
		// JSON数据初始化，包含EasySSH Ajax响应信息和分页信息
		return super.setJsonPaginationMap(pb);
	}

	@RequestMapping("delete")
	public Map<Object,Object> delete(Building building){
		try {
			buildingService.delete(building.getBuildingid());
		} catch (Exception e) {
			e.printStackTrace();
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		return super.setJsonMsgMap();
	}
	
	@RequestMapping("update")
	public Map<Object,Object> update(Building building){
		try {
			buildingService.update(building);
			super.setMsgKey("msg.updateSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			super.setMsgKey("msg.updateFail");
			super.setStatusCode(StatusCode.ERROR); //默认为OK
		}
		
		return super.setJsonMsgMap();
	}
}
