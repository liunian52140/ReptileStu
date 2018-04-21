package com.liunian.test;

import java.util.List;

import com.liunian.Util.Utils;
import com.liunian.bean.BookInfo;
import com.liunian.bean.UserInfo;
import com.liunian.service.impl.ServiceImpl;

public class GetBookDirectoriesTest {
	/**
	 * 获取文章列表和点击测试
	 * @param args
	 */
	public static void main(String[] args) {
		UserInfo ui=new UserInfo();
		ui.setUsername("17319329356");
		ui.setPassword("a12345678");
		ServiceImpl si=new ServiceImpl();
		String html=si.getHtml(si.Login(ui));
		List<BookInfo> ls= Utils.getBookList(html);
		//遍历
		for (BookInfo bio : ls) {
			System.out.println("目录:"+bio.getDirectorie()+"地址1:"+bio.getDataHref()+"地址2:"+bio.getDataSale()+"是否免费:"+bio.isItFree());
		}
		
	}

}
