/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.dao.adr;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictAreas;

/**
 * 区县级地址信息DAO接口
 * @author copy4dev
 * @version 2016-09-08
 */
@MyBatisDao
public interface DictAreasDao extends CrudDao<DictAreas> {

	/**
	 * 根据区县名字进行模糊查询
	 * @param str
	 * @return
	 */
	public DictAreas findByName(String str);

}