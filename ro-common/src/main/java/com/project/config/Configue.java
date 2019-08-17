package com.project.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Configue implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * 服务器初始化
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			System.out.println("基础配置加载完毕");
		}
	}
}
