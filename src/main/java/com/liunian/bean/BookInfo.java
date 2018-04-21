package com.liunian.bean;

public class BookInfo {
	/**
	 * 书籍url类
	 */
	//目录
	private String Directorie;
	//data-href
	private String DataHref;
	//data-sale
	private String DataSale;
	//是否免费
	private boolean isItFree;
	public String getDirectorie() {
		return Directorie;
	}
	public void setDirectorie(String directorie) {
		Directorie = directorie;
	}
	public String getDataHref() {
		return DataHref;
	}
	public void setDataHref(String dataHref) {
		DataHref = dataHref;
	}
	public String getDataSale() {
		return DataSale;
	}
	public void setDataSale(String dataSale) {
		DataSale = dataSale;
	}
	public boolean isItFree() {
		return isItFree;
	}
	public void setItFree(boolean isItFree) {
		this.isItFree = isItFree;
	}
	
}
