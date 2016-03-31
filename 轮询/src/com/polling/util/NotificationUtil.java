package com.polling.util;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;

import com.polling.bean.NotifyBean;
import com.polling.bean.SimpleNotifyBean;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class NotificationUtil {

	public static void sendSimpleNotify(Context context, int notifyID,
			SimpleNotifyBean bean, PendingIntent contentIntent) {
		NotifyBean notifyBean = new NotifyBean();
		notifyBean.setSmallIcon(bean.getSmallIcon());
		notifyBean.setTicker(bean.getTicker());
		notifyBean.setWhen(System.currentTimeMillis());
		notifyBean.setContentTitle(bean.getContentTitle());
		notifyBean.setContentText(bean.getContentText());
		notifyBean.setLargeIcon(bean.getLargeIcon());
		notifyBean.setDefaults(Notification.DEFAULT_SOUND
				| Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
		notifyBean.setSound(RingtoneManager
				.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
		notifyBean.setArgb(Color.RED);
		notifyBean.setOnMs(2000);
		notifyBean.setOffMs(3000);
		notifyBean
				.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000, 1000 });
		notifyBean.setAutoCancel(true);
		notifyBean.setContentIntent(contentIntent);

		notifyBean.addSet(NotifyBean.SET_SMALL_ICON);
		notifyBean.addSet(NotifyBean.SET_TICKER);
		notifyBean.addSet(NotifyBean.SET_WHEN);
		notifyBean.addSet(NotifyBean.SET_NUMBER);
		notifyBean.addSet(NotifyBean.SET_CONTENT_TITLE);
		notifyBean.addSet(NotifyBean.SET_CONTENT_TEXT);
		notifyBean.addSet(NotifyBean.SET_LARGE_ICON);
		notifyBean.addSet(NotifyBean.SET_DEFAULTS);
		notifyBean.addSet(NotifyBean.SET_SOUND);
		notifyBean.addSet(NotifyBean.SET_LIGHTS);
		notifyBean.addSet(NotifyBean.SET_VIBRATE);
		notifyBean.addSet(NotifyBean.SET_AUTO_CANCEL);
		notifyBean.addSet(NotifyBean.SET_CONTENT_INTENT);

		sendNotify(context, notifyID, notifyBean);
	}

	@SuppressLint("NewApi")
	public static void sendNotify(Context context, int notifyID, NotifyBean bean) {
		Notification.Builder builder = new Notification.Builder(context);
		ArrayList<Integer> setList = bean.getSetList();
		for (Integer set : setList) {
			if (set == NotifyBean.SET_SMALL_ICON)
				builder.setSmallIcon(bean.getSmallIcon());
			else if (set == NotifyBean.SET_TICKER)
				builder.setTicker(bean.getTicker());
			else if (set == NotifyBean.SET_WHEN)
				builder.setWhen(bean.getWhen());
			else if (set == NotifyBean.SET_NUMBER)
				builder.setNumber(bean.getNumber());
			else if (set == NotifyBean.SET_CONTENT)
				builder.setContent(bean.getContent());
			else if (set == NotifyBean.SET_CONTENT_TITLE)
				builder.setContentTitle(bean.getContentTitle());
			else if (set == NotifyBean.SET_CONTENT_TEXT)
				builder.setContentText(bean.getContentText());
			else if (set == NotifyBean.SET_CONTENT_INFO)
				builder.setContentInfo(bean.getContentInfo());
			else if (set == NotifyBean.SET_LARGE_ICON)
				builder.setLargeIcon(bean.getLargeIcon());
			else if (set == NotifyBean.SET_PROGRESS)
				builder.setProgress(bean.getMax(), bean.getProgress(),
						bean.isIndeterminate());
			else if (set == NotifyBean.SET_DEFAULTS)
				builder.setDefaults(bean.getDefaults());
			else if (set == NotifyBean.SET_SOUND)
				builder.setSound(bean.getSound());
			else if (set == NotifyBean.SET_LIGHTS)
				builder.setLights(bean.getArgb(), bean.getOnMs(),
						bean.getOffMs());
			else if (set == NotifyBean.SET_VIBRATE)
				builder.setVibrate(bean.getVibrate());
			else if (set == NotifyBean.SET_ONGOING)
				builder.setOngoing(bean.isOngoing());
			else if (set == NotifyBean.SET_AUTO_CANCEL)
				builder.setAutoCancel(bean.isAutoCancel());
			else if (set == NotifyBean.SET_CONTENT_INTENT)
				builder.setContentIntent(bean.getContentIntent());
			else if (set == NotifyBean.SET_DELETE_INTENT)
				builder.setDeleteIntent(bean.getDeleteIntent());
		}
		Notification notification = builder.build();
		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(notifyID, notification);
	}

	public static void cancelNotify(Context context, int notifyID) {
		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancel(notifyID);
	}

	public static void cancelAllNotifies(Context context) {
		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancelAll();
	}

}
