package com.liunian.service;
import org.apache.http.client.CookieStore;

import com.liunian.bean.BookInfo;
import com.liunian.bean.UserInfo;
public interface MainMethod {
	/**
	 * @param USerinfo
	 * @return 用户登陆凭证(cookie)
	 */
	public CookieStore Login(UserInfo Userinfo);
	/**
	 * 
	 * @param cookie 登陆凭证
	 * @return 书籍列表源码
	 */
	public String getHtml(CookieStore cookie);
	/**
	 * 获取支付地址
	 * @param cookie
	 * @return 支付url
	 */
	public String getPayUrl(CookieStore cookie);
	/**
	 * 花费支付
	 */
	public String payN(CookieStore cookie);
	
}
