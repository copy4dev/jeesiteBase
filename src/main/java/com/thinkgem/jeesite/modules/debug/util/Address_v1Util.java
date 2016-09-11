package com.thinkgem.jeesite.modules.debug.util;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.modules.debug.entity.adr.DictAreas;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictCities;
import com.thinkgem.jeesite.modules.debug.entity.adr.DictProvinces;
import com.thinkgem.jeesite.modules.debug.service.adr.DictAreasService;
import com.thinkgem.jeesite.modules.debug.service.adr.DictCitiesService;
import com.thinkgem.jeesite.modules.debug.service.adr.DictProvincesService;

/**
 * 耦合度太高
 * @author copy4dev
 * @version 2016年9月8日
 * 
 */
public class Address_v1Util {

	@Autowired
	private DictProvincesService dictProvincesService;

	@Autowired
	private DictCitiesService dictCitiesService;

	@Autowired
	private DictAreasService dictAreasService;

	private String adrString = "广东省广州海珠区六环以内沙河工业园松兰堡北海特光电院内西侧二层";

	/**
	 * 大致思路：<br/>
	 * 1.在传来的字符串上提取开头两个字符<br/>
	 * 2.用提取到的字符去查询数据库<br/>
	 * 3.根据查询结果对原来的字符串进行切割
	 */
	public void testAdr() {
		System.out.println(" --- start --- ");

		HashMap<String, String> adrMap = new HashMap<String, String>();
		String temp = null;
		String resultStr = null;

		System.out.println(adrString);

		// 省
		temp = adrString.substring(0, 2);
		DictProvinces dictProvinces = dictProvincesService.findByName(temp);
		resultStr = dictProvinces.getProvince();

		adrMap.put("province", temp);
		temp = adrString.substring(0, resultStr.length());
		if (resultStr.equals(temp)) {
			adrString = adrString.substring(resultStr.length() - 1);
			adrMap.put("province", resultStr);
		} else {
			adrString = adrString.substring(temp.length() - 1);
		}

		// 市
		temp = adrString.substring(0, 2);
		DictCities dictCities = dictCitiesService.findByName(temp);
		resultStr = dictCities.getCity();

		adrMap.put("city", temp);
		temp = adrString.substring(0, resultStr.length());
		if (resultStr.equals(temp)) {
			adrString = adrString.substring(resultStr.length());
			adrMap.put("city", resultStr);
		} else {
			adrString = adrString.substring(temp.length() - 1);
		}

		// 区
		temp = adrString.substring(0, 2);
		DictAreas dictAreas = dictAreasService.findByName(temp);
		resultStr = dictAreas.getArea();

		adrMap.put("area", temp);
		temp = adrString.substring(0, resultStr.length());
		if (resultStr.equals(temp)) {
			adrString = adrString.substring(resultStr.length());
			adrMap.put("area", resultStr);
		} else {
			adrString = adrString.substring(temp.length() - 1);
		}

		// 明细
		adrMap.put("address", adrString);

		System.out.println("province: " + adrMap.get("province"));
		System.out.println("city: " + adrMap.get("city"));
		System.out.println("area: " + adrMap.get("area"));
		System.out.println(" ---  end  --- ");
	}

}
