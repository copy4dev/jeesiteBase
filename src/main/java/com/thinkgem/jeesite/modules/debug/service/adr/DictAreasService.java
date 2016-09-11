/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.service.adr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.debug.dao.adr.DictAreasDao;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictAreas;

/**
 * 区县级地址信息Service
 * @author copy4dev
 * @version 2016-09-08
 */
@Service
@Transactional(readOnly = true)
public class DictAreasService extends CrudService<DictAreasDao, DictAreas> {

	public DictAreas get(String id) {
		return super.get(id);
	}

	public List<DictAreas> findList(DictAreas dictAreas) {
		return super.findList(dictAreas);
	}

	public Page<DictAreas> findPage(Page<DictAreas> page, DictAreas dictAreas) {
		return super.findPage(page, dictAreas);
	}

	@Transactional(readOnly = false)
	public void save(DictAreas dictAreas) {
		super.save(dictAreas);
	}

	@Transactional(readOnly = false)
	public void delete(DictAreas dictAreas) {
		super.delete(dictAreas);
	}

	// --------- user define -----------

	@Autowired
	private DictAreasDao dictAreasDao;

	/**
	 * 根据区县名字进行模糊查询
	 * @param str
	 * @return
	 */
	public DictAreas findByName(String str) {
		return dictAreasDao.findByName(str);
	}

}