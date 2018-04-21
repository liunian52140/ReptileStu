package com.liunian.test;

import com.liunian.bean.UserInfo;
import com.liunian.service.impl.ServiceImpl;

public class GetPayUrlTest {
	/**
	 * 获取支付地址测试类
	 * @param args
	 */
	public static void main(String[] args) {
		UserInfo ui=new UserInfo();
		ui.setUsername("17319329356");
		ui.setPassword("a12345678");
		ServiceImpl si=new ServiceImpl();
		String headers=si.getPayUrl(si.Login(ui));
		System.out.println(headers);
		
	}
}
