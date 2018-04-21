package com.liunian.test;


import java.util.List;
import org.apache.http.cookie.Cookie;

import com.liunian.bean.UserInfo;
import com.liunian.service.impl.ServiceImpl;

public class LoginTest {
	/**
	 * 测试登陆
	 * @param args
	 */
	public static void main(String[] args) {
		UserInfo ui=new UserInfo();
		ui.setUsername("17319329356");
		ui.setPassword("a12345678");
		ServiceImpl si=new ServiceImpl();
		List<Cookie> cookies = si.Login(ui).getCookies();
		for (int i = 0; i < cookies.size(); i++) {
			System.out.println(cookies.get(i).getName()+":"+cookies.get(i).getValue());
		}	
	}

}
