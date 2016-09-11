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
import com.thinkgem.jeesite.modules.debug.dao.adr.DictCitiesDao;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictCities;

/**
 * 市级地址信息Service
 * @author copy4dev
 * @version 2016-09-08
 */
@Service
@Transactional(readOnly = true)
public class DictCitiesService extends CrudService<DictCitiesDao, DictCities> {

	public DictCities get(String id) {
		return super.get(id);
	}

	public List<DictCities> findList(DictCities dictCities) {
		return super.findList(dictCities);
	}

	public Page<DictCities> findPage(Page<DictCities> page, DictCities dictCities) {
		return super.findPage(page, dictCities);
	}

	@Transactional(readOnly = false)
	public void save(DictCities dictCities) {
		super.save(dictCities);
	}

	@Transactional(readOnly = false)
	public void delete(DictCities dictCities) {
		super.delete(dictCities);
	}

	// --------- user define -----------

	@Autowired
	private DictCitiesDao dictCitiesDao;

	/**
	 * 根据城市名字进行模糊查询
	 * @param str
	 * @return
	 */
	public DictCities findByName(String str) {
		return dictCitiesDao.findByName(str);
	}

}