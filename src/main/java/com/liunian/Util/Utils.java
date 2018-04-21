package com.liunian.Util;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.liunian.bean.BookInfo;

/**
 * @version 0.99
 * @author liunian
 */
public class Utils {
	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D',  
	        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',  
	        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',  
	        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',  
	        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',  
	        '4', '5', '6', '7', '8', '9', '+', '/', };  
	  
	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1,  
	        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  
	        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  
	        -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59,  
	        60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,  
	        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,  
	        -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,  
	        38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,  
	        -1, -1 };  
	/**
	 * 
	 * @param password
	 * @return String
	 */
	public static String EncryptShaOne(String password){
		if (null == password || 0 == password.length()){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(password.getBytes("UTF-8"));
	         
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char[] buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(buf);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }		
		return null;
	};
	/**
	 * 遍历书籍信息
	 * @param html
	 */
	public static List<BookInfo> getBookList(String html){
		List<BookInfo> ls = new ArrayList<BookInfo>();
		if(html!=null&&!"".equals(html)){
			Document doc=Jsoup.parse(html);
			Elements els=doc.select("div.read_list>a");
			BookInfo boo;
			for (Element element : els) {
				boo=new BookInfo();
				boo.setDataHref(element.attr("data-href"));
				boo.setDataSale(element.attr("data-sale"));
				boo.setDirectorie(element.select("p").text());
				String iffree=element.select("span").text();
				if(iffree==null||"".equals(iffree)){
					boo.setItFree(false);
				}else{
					boo.setItFree(true);
				}
				//System.out.println("目录:"+boo.getDirectorie()+"地址1:"+boo.getDataHref()+"地址2:"+boo.getDataSale()+"是否免费:"+boo.isItFree());
				ls.add(boo);
			}
			
		}
		return ls;
		
	}
	/**
	 * 组织报文
	 * @return 一大串xml
	 */
	public static String setXmlDate(){
		 String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		 StringBuffer sb = new StringBuffer();
		 sb.append(XML_HEADER);
		 sb.append("<advPay><pubInfo><Version>1.00</Version><TransactionDate>20180419123114</TransactionDate><BusiCode>5003</BusiCode><OriginId>08</OriginId><RegionId>571</RegionId><CountyId>5713</CountyId><ReturnCode></ReturnCode><ReturnMsg></ReturnMsg><transactionId>0001804191231148529303</transactionId><VerifyCode>6bf2a9b3090ebf036a5178334e02051d0b2f5dcc306e3bef53acf2e57584a436</VerifyCode></pubInfo><busiData><accountType>5</accountType><accountName>08</accountName><payItemType>20</payItemType><payAmount>10.00</payAmount><orderId>0001804191231148529303</orderId><payNotifyPageURL>http://fun.migu.cn/returnurl/</payNotifyPageURL><payNotifyIntURL>http://172.20.30.12:8060/acms/AdvPayNotifyServlet</payNotifyIntURL><type>WAP</type><productId>001</productId><channelEXT>channelId:300000100001;contentId:50000000000462067175;VasType:0;servType:2;charpterid:0#;MSISDN:15060279723;passid:5147949595179;activeId:null</channelEXT></busiData></advPay>");
		return sb.toString();
	}
	/**
	 * form解密
	 * @param str
	 * @return
	 */
	public static byte[] decode(String str){
	    byte[] data = str.getBytes();  
	    int len = data.length;  
	    ByteArrayOutputStream buf = new ByteArrayOutputStream(len);  
	    int i = 0;  
	    int b1, b2, b3, b4;  
	  
	    while (i < len) {  
	        do {  
	            b1 = base64DecodeChars[data[i++]];  
	        } while (i < len && b1 == -1);  
	        if (b1 == -1) {  
	            break;  
	        }  
	  
	        do {  
	            b2 = base64DecodeChars[data[i++]];  
	        } while (i < len && b2 == -1);  
	        if (b2 == -1) {  
	            break;  
	        }  
	        buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));  
	  
	        do {  
	            b3 = data[i++];  
	            if (b3 == 61) {  
	                return buf.toByteArray();  
	            }  
	            b3 = base64DecodeChars[b3];  
	        } while (i < len && b3 == -1);  
	        if (b3 == -1) {  
	            break;  
	        }  
	        buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));  
	  
	        do {  
	            b4 = data[i++];  
	            if (b4 == 61) {  
	                return buf.toByteArray();  
	            }  
	            b4 = base64DecodeChars[b4];  
	        } while (i < len && b4 == -1);  
	        if (b4 == -1) {  
	            break;  
	        }  
	        buf.write((int) (((b3 & 0x03) << 6) | b4));  
	    }  
	    return buf.toByteArray();
		
	}
	
}
