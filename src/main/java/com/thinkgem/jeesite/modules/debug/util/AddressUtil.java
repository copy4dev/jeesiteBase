package com.thinkgem.jeesite.modules.debug.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.debug.service.adr.DictProvincesService;

/**
 * @author copy4dev
 * @version 2016年9月8日
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class AddressUtil {

	@Autowired
	private DictProvincesService dictProvincesService;

	private String adrString = "北京昌平六环以内沙河工业园松兰堡北海特光电院内西侧二层";

	/**
	 * 大致思路：<br/>
	 * 1.在传来的字符串上提取开头两个字符<br/>
	 * 2.用提取到的字符去查询数据库<br/>
	 * 3.根据查询结果对原来的字符串进行切割
	 */

	@Test
	public void testAdr() {
		System.out.println(" --- start --- ");
//		DictProvinces dictProvinces=dictProvincesService.findByName("广东");
//		System.out.println(dictProvinces.getProvince());
//		String temp = StringUtils.
		System.out.println(" ---  end  --- ");
	}

}
