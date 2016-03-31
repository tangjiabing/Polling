package com.polling;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.polling.bean.SimpleNotifyBean;
import com.polling.global.PollingGlobal;
import com.polling.helper.PollingManagerHelper;
import com.polling.util.NotificationUtil;
import com.polling.util.WakeUpUtil;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class PollingService extends IntentService {

	public PollingService() {
		super("PollingService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		Context appContext = getApplicationContext();
		PollingManagerHelper helper = (PollingManagerHelper) intent
				.getSerializableExtra(PollingGlobal.KEY_POLLING_MANAGER_HELPER);
		Bundle oldBundle = intent.getExtras();
		Bundle newBundle = helper.requestNetworkData(oldBundle);
		if (newBundle != null) {
			WakeUpUtil wakeUpUtil = WakeUpUtil.getInstance(appContext);
			boolean isHandle = false;
			if (wakeUpUtil.isScreenOn())
				isHandle = helper.handleScreenOn(appContext, newBundle);
			else {
				wakeUpUtil.wakeUpAndUnlock();
				isHandle = helper.handleWakeUpAndUnlock(appContext, newBundle);
			}
			if (isHandle == false) {
				Intent realIntent = helper.targetActivityByClickNotify(
						appContext, newBundle);
				Intent clickIntent = new Intent(appContext,
						ClickBroadcastReceiver.class);
				clickIntent.putExtra("realIntent", realIntent);
				clickIntent.putExtra(PollingGlobal.KEY_POLLING_MANAGER_HELPER,
						helper);
				PendingIntent contentIntent = PendingIntent.getBroadcast(
						appContext, PollingGlobal.REQUEST_CODE, clickIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
				SimpleNotifyBean bean = helper.getSimpleNotifyBean(
						getResources(), newBundle);
				NotificationUtil.sendSimpleNotify(appContext,
						PollingGlobal.NOTIFY_ID, bean, contentIntent);
			}
			newBundle.clear();
		}
		oldBundle.clear();
		helper.updatePolling(appContext);

	}

}
