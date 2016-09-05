/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.entity;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 一对多debugEntity
 * @author copy4dev
 * @version 2016-09-04
 */
public class DebugUser extends DataEntity<DebugUser> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 号账
	private String password;		// 码密
	private String address;		// 地址
	private List<DebugUserDetail> debugUserDetailList = Lists.newArrayList();		// 子表列表
	
	public DebugUser() {
		super();
	}

	public DebugUser(String id){
		super(id);
	}

	@Length(min=1, max=20, message="号账长度必须介于 1 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=16, message="码密长度必须介于 1 和 16 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=1, max=400, message="地址长度必须介于 1 和 400 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<DebugUserDetail> getDebugUserDetailList() {
		return debugUserDetailList;
	}

	public void setDebugUserDetailList(List<DebugUserDetail> debugUserDetailList) {
		this.debugUserDetailList = debugUserDetailList;
	}
}