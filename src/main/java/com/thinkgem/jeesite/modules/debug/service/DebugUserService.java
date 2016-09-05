/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.debug.entity.DebugUser;
import com.thinkgem.jeesite.modules.debug.dao.DebugUserDao;
import com.thinkgem.jeesite.modules.debug.entity.DebugUserDetail;
import com.thinkgem.jeesite.modules.debug.dao.DebugUserDetailDao;

/**
 * 一对多debugService
 * @author copy4dev
 * @version 2016-09-04
 */
@Service
@Transactional(readOnly = true)
public class DebugUserService extends CrudService<DebugUserDao, DebugUser> {

	@Autowired
	private DebugUserDetailDao debugUserDetailDao;
	
	public DebugUser get(String id) {
		DebugUser debugUser = super.get(id);
		debugUser.setDebugUserDetailList(debugUserDetailDao.findList(new DebugUserDetail(debugUser)));
		return debugUser;
	}
	
	public List<DebugUser> findList(DebugUser debugUser) {
		return super.findList(debugUser);
	}
	
	public Page<DebugUser> findPage(Page<DebugUser> page, DebugUser debugUser) {
		return super.findPage(page, debugUser);
	}
	
	@Transactional(readOnly = false)
	public void save(DebugUser debugUser) {
		super.save(debugUser);
		for (DebugUserDetail debugUserDetail : debugUser.getDebugUserDetailList()){
			if (debugUserDetail.getId() == null){
				continue;
			}
			if (DebugUserDetail.DEL_FLAG_NORMAL.equals(debugUserDetail.getDelFlag())){
				if (StringUtils.isBlank(debugUserDetail.getId())){
					debugUserDetail.setDebugUser(debugUser);
					debugUserDetail.preInsert();
					debugUserDetailDao.insert(debugUserDetail);
				}else{
					debugUserDetail.preUpdate();
					debugUserDetailDao.update(debugUserDetail);
				}
			}else{
				debugUserDetailDao.delete(debugUserDetail);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(DebugUser debugUser) {
		super.delete(debugUser);
		debugUserDetailDao.delete(new DebugUserDetail(debugUser));
	}
	
}