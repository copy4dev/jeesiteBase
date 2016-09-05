/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.debug.entity.DebugUser;
import com.thinkgem.jeesite.modules.debug.service.DebugUserService;

/**
 * 一对多debugController
 * @author copy4dev
 * @version 2016-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/debug/debugUser")
public class DebugUserController extends BaseController {

	@Autowired
	private DebugUserService debugUserService;
	
	@ModelAttribute
	public DebugUser get(@RequestParam(required=false) String id) {
		DebugUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = debugUserService.get(id);
		}
		if (entity == null){
			entity = new DebugUser();
		}
		return entity;
	}
	
	@RequiresPermissions("debug:debugUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(DebugUser debugUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DebugUser> page = debugUserService.findPage(new Page<DebugUser>(request, response), debugUser); 
		model.addAttribute("page", page);
		return "modules/debug/debugUserList";
	}

	@RequiresPermissions("debug:debugUser:view")
	@RequestMapping(value = "form")
	public String form(DebugUser debugUser, Model model) {
		model.addAttribute("debugUser", debugUser);
		return "modules/debug/debugUserForm";
	}

	@RequiresPermissions("debug:debugUser:edit")
	@RequestMapping(value = "save")
	public String save(DebugUser debugUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, debugUser)){
			return form(debugUser, model);
		}
		debugUserService.save(debugUser);
		addMessage(redirectAttributes, "保存debug用户成功");
		return "redirect:"+Global.getAdminPath()+"/debug/debugUser/?repage";
	}
	
	@RequiresPermissions("debug:debugUser:edit")
	@RequestMapping(value = "delete")
	public String delete(DebugUser debugUser, RedirectAttributes redirectAttributes) {
		debugUserService.delete(debugUser);
		addMessage(redirectAttributes, "删除debug用户成功");
		return "redirect:"+Global.getAdminPath()+"/debug/debugUser/?repage";
	}

}