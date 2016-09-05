/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.debug.entity.DebugUserDetail;

/**
 * 一对多debugDAO接口
 * @author copy4dev
 * @version 2016-09-04
 */
@MyBatisDao
public interface DebugUserDetailDao extends CrudDao<DebugUserDetail> {
	
}