/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.entity.adr;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 区县级地址信息Entity
 * @author copy4dev
 * @version 2016-09-08
 */
public class DictAreas extends DataEntity<DictAreas> {
	
	private static final long serialVersionUID = 1L;
	private String areaid;		// 区县级ID
	private String area;		// 区县名
	private String cityid;		// 市级ID
	
	public DictAreas() {
		super();
	}

	public DictAreas(String id){
		super(id);
	}

	@Length(min=1, max=20, message="区县级ID长度必须介于 1 和 20 之间")
	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	
	@Length(min=1, max=50, message="区县名长度必须介于 1 和 50 之间")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=1, max=20, message="市级ID长度必须介于 1 和 20 之间")
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
}