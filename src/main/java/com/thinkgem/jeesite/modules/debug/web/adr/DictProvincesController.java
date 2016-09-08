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
import com.thinkgem.jeesite.modules.debug.entity.adr.DictProvinces;
import com.thinkgem.jeesite.modules.debug.service.adr.DictProvincesService;

/**
 * 省级地址信息Controller
 * @author copy4dev
 * @version 2016-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/debug/adr/dictProvinces")
public class DictProvincesController extends BaseController {

	@Autowired
	private DictProvincesService dictProvincesService;
	
	@ModelAttribute
	public DictProvinces get(@RequestParam(required=false) String id) {
		DictProvinces entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dictProvincesService.get(id);
		}
		if (entity == null){
			entity = new DictProvinces();
		}
		return entity;
	}
	
	@RequiresPermissions("debug:adr:dictProvinces:view")
	@RequestMapping(value = {"list", ""})
	public String list(DictProvinces dictProvinces, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DictProvinces> page = dictProvincesService.findPage(new Page<DictProvinces>(request, response), dictProvinces); 
		model.addAttribute("page", page);
		return "modules/debug/adr/dictProvincesList";
	}

	@RequiresPermissions("debug:adr:dictProvinces:view")
	@RequestMapping(value = "form")
	public String form(DictProvinces dictProvinces, Model model) {
		model.addAttribute("dictProvinces", dictProvinces);
		return "modules/debug/adr/dictProvincesForm";
	}

	@RequiresPermissions("debug:adr:dictProvinces:edit")
	@RequestMapping(value = "save")
	public String save(DictProvinces dictProvinces, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dictProvinces)){
			return form(dictProvinces, model);
		}
		dictProvincesService.save(dictProvinces);
		addMessage(redirectAttributes, "保存省级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictProvinces/?repage";
	}
	
	@RequiresPermissions("debug:adr:dictProvinces:edit")
	@RequestMapping(value = "delete")
	public String delete(DictProvinces dictProvinces, RedirectAttributes redirectAttributes) {
		dictProvincesService.delete(dictProvinces);
		addMessage(redirectAttributes, "删除省级地址成功");
		return "redirect:"+Global.getAdminPath()+"/debug/adr/dictProvinces/?repage";
	}

}