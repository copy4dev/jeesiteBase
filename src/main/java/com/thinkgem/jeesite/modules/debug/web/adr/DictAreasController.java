/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.debug.web.adr;

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
import com.thinkgem.jeesite.modules.debug.entity.adr.DictAreas;
import com.thinkgem.jeesite.modules.debug.service.adr.DictAreasService;

/**
 * 区县级地址信息Controller
 * @author copy4dev
 * @version 2016-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/debug/adr/dictAreas")
public class DictAreasController extends BaseController {

	@Autowired
	private DictAreasService dictAreasService;
	
	@ModelAttribute
	public DictAreas get(@RequestParam(required=false) String id) {
		DictAreas entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictAreasService.get(id);
		}
		if (entity == null){
			entity = new DictAreas();
		}
		return entity;
	}
	
	@RequiresPermissions("debug:adr:dictAreas:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictAreas dictAreas, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictAreas> page = dictAreasService.findPage(new Page<DictAreas>(request, response), dictAreas); 
		model.addAttribute("page", page);
		return "modules/debug/adr/dictAreasList";
	}

	@RequiresPermissions("debug:adr:dictAreas:view")
	@RequestMapping(value = "form")
	public String form(DictAreas dictAreas, Model model) {
		model.addAttribute("dictAreas", dictAreas);
		return "modules/debug/adr/dictAreasForm";
	}

	@RequiresPermissions("debug:adr:dictAreas:edit")
	@RequestMapping(value = "save")
	public String save(DictAreas dictAreas, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictAreas)){
			return form(dictAreas, model);
		}
		dictAreasService.save(dictAreas);
		addMessage(redirectAttributes, "保存区县级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictAreas/?repage";
	}
	
	@RequiresPermissions("debug:adr:dictAreas:edit")
	@RequestMapping(value = "delete")
	public String delete(DictAreas dictAreas, RedirectAttributes redirectAttributes) {
		dictAreasService.delete(dictAreas);
		addMessage(redirectAttributes, "删除区县级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictAreas/?repage";
	}

}