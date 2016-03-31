package com.polling.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.polling.PollingService;
import com.polling.global.PollingGlobal;
import com.polling.helper.PollingManagerHelper;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class PollingUtil {

	private static boolean mIsStartPolling = false;

	public static void start(PollingManagerHelper helper, Context appContext,
			Bundle bundle, long triggerAtTime, long interval) {
		if (helper == null)
			throw new IllegalArgumentException(
					"PollingManagerHelper is not null");

		AlarmManager alarmManager = (AlarmManager) appContext
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(appContext, PollingService.class);
		intent.putExtra(PollingGlobal.KEY_POLLING_MANAGER_HELPER, helper);
		if (bundle != null)
			intent.putExtras(bundle);
		// helper和bundle的数据在之后的轮询过程中是不会被改变的

		// PendingIntent这个类用于处理即将发生的事情，可以看作是对Intent的包装，通常通过getActivity，
		// getBroadcast，getService来得到PendingIntent的实例，当前activity并不能马上启动它所包含的intent，
		// 而是在外部执行 pendingIntent时，调用intent的。正是由于PendingIntent中保存有当前App的Context，
		// 使得外部App可以如同当前App一样的执行PendingIntent里的 Intent，就算在执行时当前App已经不存在了，
		// 也能通过存在PendingIntent里的Context照样执行Intent。可以理解为延迟执行的Intent。

		// PendingIntent的flags有以下4种值：
		// 1）FLAG_ONE_SHOT：获取的PendingIntent只能使用一次，即使再次利用这三个方法（getActivity、getBroadcast、getService）
		// 重新获取，再使用PendingIntent也将失败。
		// 2）FLAG_NO_CREATE：如果所描述的PendingIntent已经不存在了，然后就返回null而不是创建它。
		// 3）FLAG_CANCEL_CURRENT：如果描述的PendingIntent已经存在，则在产生新的PendingIntent之前会先取消掉当前的。
		// 如果你只是想改变Intent中的额外数据的话，你可用使用它去检索新的PendingIntent，通过取消先前的PendingIntent，确保实例能够应用新的额外数据。
		// 4）FLAG_UPDATE_CURRENT：如果描述的PendingIntent已经存在，继续维持它并替换新的Intent的额外数据。如果你正在创建一个只是额外数据不同的
		// Intent时，可以使用它并且接收先前PendingIntent的实例将会应用新的额外数据。

		PendingIntent pendingIntent = PendingIntent.getService(appContext,
				PollingGlobal.REQUEST_CODE, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		// 以下是4种可用的Alarm类型：
		// 1）RTC_WAKEUP：在指定的时间唤醒设备，并激活PendingIntent。
		// 2）RTC：在指定的时间点激活PendingIntent，但是不会唤醒设备。
		// 3）ELAPSED_REALTIME：根据设备启动之后经过的时间激活PendingIntent，但是不会唤醒设备。经过的时间包含设备休眠的所有时间。
		// 4）ELAPSED_REALTIME_WAKEUP：在设备启动并经过指定的时间之后唤醒设备和激活PendingIntent

		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
				System.currentTimeMillis() + triggerAtTime, interval,
				pendingIntent);

		mIsStartPolling = true;
	}

	public static void cancel(Context appContext) {
		AlarmManager alarmManager = (AlarmManager) appContext
				.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(appContext, PollingService.class);
		PendingIntent pendingIntent = PendingIntent.getService(appContext,
				PollingGlobal.REQUEST_CODE, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);
		alarmManager.cancel(pendingIntent);

		mIsStartPolling = false;
	}

	public static boolean isStartPolling() {
		return mIsStartPolling;
	}

}
