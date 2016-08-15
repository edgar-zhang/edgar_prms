package com.sjn_edgar.prms.service.permission;

import com.sjn_edgar.prms.domain.permission.PmsMenu;

import java.util.List;
import java.util.Map;

/**@Title:     PmsMenuService
 * @Description:  <p> 菜单service接口 </p>
 * @author         edgar【zbo@51qmz.cn】		   
 * @version        V 1.0  
 * @Date           2016/8/15 18:12 
 */
public interface PmsMenuService {

	/**
	 * 保存菜单
	 * 
	 * @param menu
	 */
	public void savaMenu(PmsMenu menu);

	/**
	 * 根据父菜单ID获取该菜单下的所有子孙菜单.<br/>
	 * 
	 * @param parentId
	 *            (如果为空，则为获取所有的菜单).<br/>
	 * @return menuList.
	 */
	@SuppressWarnings("rawtypes")
	public List getListByParent(Long parentId);

	/**
	 * 根据id删除数据
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 根据角色id串获取菜单
	 * 
	 * @param roleIdsStr
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List listByRoleIds(String roleIdsStr);

	/**
	 * 根据菜单ID查找菜单（可用于判断菜单下是否还有子菜单）.
	 * 
	 * @param parentId
	 *            .
	 * @return menuList.
	 */
	public List<PmsMenu> listByParentId(Long parentId);

	/**
	 * 根据名称和是否叶子节点查询数据
	 *  map.get("isLeaf") :是否是叶子节点
	 *  map.get("name") ：节点名称
	 * @param map
	 * @return
	 */
	public List<PmsMenu> getMenuByNameAndIsLeaf(Map<String, Object> map);

	/**
	 * 根据菜单ID获取菜单.
	 * 
	 * @param pid
	 * @return
	 */
	public PmsMenu getById(Long pid);

	/**
	 * 更新菜单.
	 * 
	 * @param menu
	 */
	public void update(PmsMenu menu);

	/**
	 * 根据角色查找角色对应的菜单ID集
	 * 
	 * @param roleId
	 * @return
	 */
	public String getMenuIdsByRoleId(Long roleId);

}
