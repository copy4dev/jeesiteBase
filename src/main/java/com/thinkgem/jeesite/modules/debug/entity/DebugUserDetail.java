/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 一对多debugEntity
 * @author copy4dev
 * @version 2016-09-04
 */
public class DebugUserDetail extends DataEntity<DebugUserDetail> {
	
	private static final long serialVersionUID = 1L;
	private DebugUser debugUser;		// 账号id 父类
	private String height;		// 身高
	private Date birthday;		// 生日
	
	public DebugUserDetail() {
		super();
	}

	public DebugUserDetail(String id){
		super(id);
	}

	public DebugUserDetail(DebugUser debugUser){
		this.debugUser = debugUser;
	}

	@NotNull(message="账号id不能为空")
	public DebugUser getDebugUser() {
		return debugUser;
	}

	public void setDebugUser(DebugUser debugUser) {
		this.debugUser = debugUser;
	}
	
	@Length(min=0, max=10, message="身高长度必须介于 0 和 10 之间")
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}