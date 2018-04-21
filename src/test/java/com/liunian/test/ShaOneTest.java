package com.liunian.test;

import com.liunian.bean.UserInfo;

public class ShaOneTest {
	/**
	 * 测试是否正常注入到用户信息里面
	 * @param args
	 */
	public static void main(String[] args) {
		UserInfo user=new UserInfo();
		user.setUsername("17319329356");
		user.setPassword("a12345678");
		boolean result=user.getPassword().equals("3dd635a808ddb6dd4b6731f7c409d53dd4b14df2");
		System.out.println(result);
	}

}
