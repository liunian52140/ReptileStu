package com.liunian.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.liunian.Util.Utils;
import com.liunian.bean.BookInfo;
import com.liunian.bean.UserInfo;
import com.liunian.service.MainMethod;

public class ServiceImpl implements MainMethod{
	/**
	 * 登陆接口地址
	 */
	public static final String LOGIN_URL="http://fun.migu.cn/t.do?requestid=migupassportvalidate";
	/**
	 * 书籍地址
	 */
	public static final String BOOK_List_URL="http://fun.migu.cn/t.do?requestid=booktoc_sh&gcid=50000000000462067175&channel_id=1380120801517&cpschannelid=1380120801517&pcpschannelid=1380120801517";
	/**
	 * 返回支付地址的接口
	 */
	public static final String RETURN_PAY_URL="https://mpay.migu.cn:8080/migupay-web/UnifiedPay";
	
	static HttpResponse response; 
	/**
	 * 登陆实现
	 * @return 返回cookie
	 */
	public CookieStore Login(UserInfo Userinfo) {
		CookieStore cookieStore = new BasicCookieStore();
    	HttpClient hct=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    	HttpPost post=new HttpPost(LOGIN_URL);
    	List<NameValuePair> parms = new ArrayList<NameValuePair>(); 
		parms.add(new BasicNameValuePair("msisdn", Userinfo.getUsername()));
		parms.add(new BasicNameValuePair("password", Userinfo.getPassword()));
		
		try {
			post.setEntity(new UrlEncodedFormEntity(parms));
			response = hct.execute(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return cookieStore;
	}
	/**
	 * 获取页面html源码
	 */
	public String getHtml(CookieStore cookie) {
		
		String html = null;
		try {
			HttpClient hct=HttpClients.custom().setDefaultCookieStore(cookie).build();
			HttpPost httpostt=new HttpPost(BOOK_List_URL);
			response=hct.execute(httpostt);
			html = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
}
		return html;
	}
	/**
	 * 获取支付地址
	 */
	public String getPayUrl(CookieStore cookie) {
		
		HttpClient hct=HttpClients.custom().setDefaultCookieStore(cookie).build();
		HttpPost post = new HttpPost(RETURN_PAY_URL); 
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();  
        parameters.add(new BasicNameValuePair("xml", Utils.setXmlDate()));  
        try {
			post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
			response=hct.execute(post);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("获取支付地址失败");
		}          
		return response.getFirstHeader("Location").getValue();
	}
	/**
	 * 话费支付
	 */
	public String payN(CookieStore cookie) {
		//en_info
		//eyJyZXNDaGFyZ2UiOjE1MjQxMjQ3NjQ3NjIsImVuZCI6MTUyNDEyNDc2NjIxNywic3RhcnQiOjE1MjQxMjQ3NjU4MDIsInN0YWdlIjoicGF5IiwicmVxUGF5IjoxNTI0MTI0NzY1ODEyLCJyZXNQYXkiOjE1MjQxMjQ3NjYyMTN9
		//获取enc
		//https://webpay.migu.cn:8443/migunetsdk/policy/getPolicyInfo
		//en_netpay支付
		
		// TODO Auto-generated method stub
		return null;
	}

}
