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
import com.thinkgem.jeesite.modules.debug.entity.adr.DictCities;
import com.thinkgem.jeesite.modules.debug.service.adr.DictCitiesService;

/**
 * 市级地址信息Controller
 * @author copy4dev
 * @version 2016-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/debug/adr/dictCities")
public class DictCitiesController extends BaseController {

	@Autowired
	private DictCitiesService dictCitiesService;
	
	@ModelAttribute
	public DictCities get(@RequestParam(required=false) String id) {
		DictCities entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictCitiesService.get(id);
		}
		if (entity == null){
			entity = new DictCities();
		}
		return entity;
	}
	
	@RequiresPermissions("debug:adr:dictCities:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictCities dictCities, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictCities> page = dictCitiesService.findPage(new Page<DictCities>(request, response), dictCities); 
		model.addAttribute("page", page);
		return "modules/debug/adr/dictCitiesList";
	}

	@RequiresPermissions("debug:adr:dictCities:view")
	@RequestMapping(value = "form")
	public String form(DictCities dictCities, Model model) {
		model.addAttribute("dictCities", dictCities);
		return "modules/debug/adr/dictCitiesForm";
	}

	@RequiresPermissions("debug:adr:dictCities:edit")
	@RequestMapping(value = "save")
	public String save(DictCities dictCities, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictCities)){
			return form(dictCities, model);
		}
		dictCitiesService.save(dictCities);
		addMessage(redirectAttributes, "保存市级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictCities/?repage";
	}
	
	@RequiresPermissions("debug:adr:dictCities:edit")
	@RequestMapping(value = "delete")
	public String delete(DictCities dictCities, RedirectAttributes redirectAttributes) {
		dictCitiesService.delete(dictCities);
		addMessage(redirectAttributes, "删除市级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictCities/?repage";
	}

}