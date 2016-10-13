package com.thinkgem.jeesite.modules.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务示例
 * 
 * @author copy4dev
 * @date 2016年9月3日
 *
 */
@Component
public class TimerJob {

	@Scheduled(cron = "*/10 * * * * *")
	public void test() {

	}
}
