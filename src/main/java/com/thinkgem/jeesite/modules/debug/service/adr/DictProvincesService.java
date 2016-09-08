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
import com.thinkgem.jeesite.modules.debug.dao.adr.DictProvincesDao;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictProvinces;

/**
 * 省级地址信息Service
 * @author copy4dev
 * @version 2016-09-08
 */
@Service
@Transactional(readOnly = true)
public class DictProvincesService extends CrudService<DictProvincesDao, DictProvinces> {

	public DictProvinces get(String id) {
		return super.get(id);
	}

	public List<DictProvinces> findList(DictProvinces dictProvinces) {
		return super.findList(dictProvinces);
	}

	public Page<DictProvinces> findPage(Page<DictProvinces> page, DictProvinces dictProvinces) {
		return super.findPage(page, dictProvinces);
	}

	@Transactional(readOnly = false)
	public void save(DictProvinces dictProvinces) {
		super.save(dictProvinces);
	}

	@Transactional(readOnly = false)
	public void delete(DictProvinces dictProvinces) {
		super.delete(dictProvinces);
	}

	// --------- user define -----------

	@Autowired
	private DictProvincesDao dictProvincesDao;

	/**
	 * 根据省份名字进行模糊查询
	 * @param str
	 * @return
	 */
	public DictProvinces findByName(String str) {
		return dictProvincesDao.findByName(str);
	}

}