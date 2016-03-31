package com.polling.bean;

import android.graphics.Bitmap;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class SimpleNotifyBean {

	private int smallIcon = 0;
	private String ticker = null;
	private String contentTitle = null;
	private String contentText = null;
	private Bitmap largeIcon = null;

	public SimpleNotifyBean(int smallIcon, String ticker, String contentTitle,
			String contentText, Bitmap largeIcon) {
		this.smallIcon = smallIcon;
		this.ticker = ticker;
		this.contentTitle = contentTitle;
		this.contentText = contentText;
		this.largeIcon = largeIcon;
	}

	public int getSmallIcon() {
		return smallIcon;
	}

	public void setSmallIcon(int smallIcon) {
		this.smallIcon = smallIcon;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public Bitmap getLargeIcon() {
		return largeIcon;
	}

	public void setLargeIcon(Bitmap largeIcon) {
		this.largeIcon = largeIcon;
	}

}
