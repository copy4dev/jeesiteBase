/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.entity.adr;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 省级地址信息Entity
 * @author copy4dev
 * @version 2016-09-08
 */
public class DictProvinces extends DataEntity<DictProvinces> {
	
	private static final long serialVersionUID = 1L;
	private String provinceid;		// 省级ID
	private String province;		// 省份名
	
	public DictProvinces() {
		super();
	}

	public DictProvinces(String id){
		super(id);
	}

	@Length(min=1, max=20, message="省级ID长度必须介于 1 和 20 之间")
	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
	@Length(min=1, max=50, message="省份名长度必须介于 1 和 50 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}