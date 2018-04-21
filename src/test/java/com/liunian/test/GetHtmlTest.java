package com.liunian.test;

import com.liunian.bean.BookInfo;
import com.liunian.bean.UserInfo;
import com.liunian.service.impl.ServiceImpl;

public class GetHtmlTest {
	/**
	 * 测试是否获取到页面
	 * @param args
	 */
	public static void main(String[] args) {
		//构造信息
		UserInfo ui=new UserInfo();
		ui.setUsername("17319329356");
		ui.setPassword("a12345678");
		ServiceImpl si=new ServiceImpl();
		String html=si.getHtml(si.Login(ui));
		System.out.println(html);
		
	}

}
