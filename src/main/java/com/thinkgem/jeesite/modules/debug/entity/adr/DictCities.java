/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.entity.adr;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 市级地址信息Entity
 * @author copy4dev
 * @version 2016-09-08
 */
public class DictCities extends DataEntity<DictCities> {
	
	private static final long serialVersionUID = 1L;
	private String cityid;		// 市级ID
	private String city;		// 城市名
	private String provinceid;		// 省级ID
	
	public DictCities() {
		super();
	}

	public DictCities(String id){
		super(id);
	}

	@Length(min=1, max=20, message="市级ID长度必须介于 1 和 20 之间")
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	
	@Length(min=1, max=50, message="城市名长度必须介于 1 和 50 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=1, max=20, message="省级ID长度必须介于 1 和 20 之间")
	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	
}