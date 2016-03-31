package com.polling.util;

import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

/**
 * 
 * @author tangjiabing
 * 
 * @see 开源时间：2016年03月31日
 * 
 *      记得给我个star哦~
 * 
 */
public class WakeUpUtil {

	private static WakeUpUtil mInstance = null;
	private PowerManager mPowerManager = null;
	private KeyguardLock mKeyguardLock = null;
	private WakeLock mWakeLock = null;
	private boolean mIsCallWakeUp = false;

	private WakeUpUtil(Context context) {
		KeyguardManager keyguardManager = (KeyguardManager) context
				.getSystemService(Context.KEYGUARD_SERVICE);
		mKeyguardLock = keyguardManager.newKeyguardLock("logcat");
		mPowerManager = (PowerManager) context
				.getSystemService(Context.POWER_SERVICE);
		// 最后一个参数是LogCat里用的Tag
		mWakeLock = mPowerManager.newWakeLock(
				PowerManager.ACQUIRE_CAUSES_WAKEUP
						| PowerManager.SCREEN_DIM_WAKE_LOCK, "logcat");
	}

	public static WakeUpUtil getInstance(Context context) {
		if (mInstance != null)
			mInstance.release(); // 必须先释放之前的，否则第二次无效
		mInstance = new WakeUpUtil(context);
		return mInstance;
	}

	public static WakeUpUtil getInstance() {
		return mInstance;
	}

	public boolean isScreenOn() {
		return mPowerManager.isScreenOn();
	}

	public void wakeUpAndUnlock() {
		mKeyguardLock.disableKeyguard(); // 解锁
		mWakeLock.acquire(); // 点亮屏幕
		mIsCallWakeUp = true;
	}

	public void release() {
		if (mIsCallWakeUp == true) {
			mKeyguardLock.reenableKeyguard(); // 加锁，要与解锁成对出现，否则第二次无法解锁
			mWakeLock.release(); // 释放，之前必须调用过acquire方法，否则会抛异常
		}
		mInstance = null;
		mPowerManager = null;
		mKeyguardLock = null;
		mWakeLock = null;
	}

}
