package com.polling.bean;

import java.util.ArrayList;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class NotifyBean {

	public static final int SET_SMALL_ICON = 0;
	public static final int SET_TICKER = 1;
	public static final int SET_WHEN = 2;
	public static final int SET_NUMBER = 3;
	public static final int SET_CONTENT = 4;
	public static final int SET_CONTENT_TITLE = 5;
	public static final int SET_CONTENT_TEXT = 6;
	public static final int SET_CONTENT_INFO = 7;
	public static final int SET_LARGE_ICON = 8;
	public static final int SET_PROGRESS = 9;
	public static final int SET_DEFAULTS = 10;
	public static final int SET_SOUND = 11;
	public static final int SET_LIGHTS = 12;
	public static final int SET_VIBRATE = 13;
	public static final int SET_ONGOING = 14;
	public static final int SET_AUTO_CANCEL = 15;
	public static final int SET_CONTENT_INTENT = 16;
	public static final int SET_DELETE_INTENT = 17;

	private int smallIcon = 0;
	private String ticker = null;
	private long when = 0;
	private int number = 0;
	private RemoteViews content = null;
	private String contentTitle = null;
	private String contentText = null;
	private String contentInfo = null;
	private Bitmap largeIcon = null;
	private int max = 0;
	private int progress = 0;
	private boolean indeterminate = false;
	private int defaults = 0;
	private Uri sound = null;
	private int argb = 0;
	private int onMs = 0;
	private int offMs = 0;
	private long[] vibrate = null;
	private boolean ongoing = false;
	private boolean autoCancel = false;
	private PendingIntent contentIntent = null;
	private PendingIntent deleteIntent = null;

	private ArrayList<Integer> setList = null;

	public NotifyBean() {
		setList = new ArrayList<Integer>();
	}

	public void addSet(int set) {
		setList.add(set);
	}

	public ArrayList<Integer> getSetList() {
		return setList;
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

	public long getWhen() {
		return when;
	}

	public void setWhen(long when) {
		this.when = when;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public RemoteViews getContent() {
		return content;
	}

	public void setContent(RemoteViews content) {
		this.content = content;
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

	public String getContentInfo() {
		return contentInfo;
	}

	public void setContentInfo(String contentInfo) {
		this.contentInfo = contentInfo;
	}

	public Bitmap getLargeIcon() {
		return largeIcon;
	}

	public void setLargeIcon(Bitmap largeIcon) {
		this.largeIcon = largeIcon;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public boolean isIndeterminate() {
		return indeterminate;
	}

	public void setIndeterminate(boolean indeterminate) {
		this.indeterminate = indeterminate;
	}

	public int getDefaults() {
		return defaults;
	}

	public void setDefaults(int defaults) {
		this.defaults = defaults;
	}

	public Uri getSound() {
		return sound;
	}

	public void setSound(Uri sound) {
		this.sound = sound;
	}

	public int getArgb() {
		return argb;
	}

	public void setArgb(int argb) {
		this.argb = argb;
	}

	public int getOnMs() {
		return onMs;
	}

	public void setOnMs(int onMs) {
		this.onMs = onMs;
	}

	public int getOffMs() {
		return offMs;
	}

	public void setOffMs(int offMs) {
		this.offMs = offMs;
	}

	public long[] getVibrate() {
		return vibrate;
	}

	public void setVibrate(long[] vibrate) {
		this.vibrate = vibrate;
	}

	public boolean isOngoing() {
		return ongoing;
	}

	public void setOngoing(boolean ongoing) {
		this.ongoing = ongoing;
	}

	public boolean isAutoCancel() {
		return autoCancel;
	}

	public void setAutoCancel(boolean autoCancel) {
		this.autoCancel = autoCancel;
	}

	public PendingIntent getContentIntent() {
		return contentIntent;
	}

	public void setContentIntent(PendingIntent contentIntent) {
		this.contentIntent = contentIntent;
	}

	public PendingIntent getDeleteIntent() {
		return deleteIntent;
	}

	public void setDeleteIntent(PendingIntent deleteIntent) {
		this.deleteIntent = deleteIntent;
	}

}
