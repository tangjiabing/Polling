package com.polling.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.polling.util.PollingUtil;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		Log.i("My", "¿ª»ú");
		Bundle bundle = new Bundle();
		bundle.putInt("count", 0);
		PollingUtil.start(new PollingManager(),
				context.getApplicationContext(), bundle, 10 * 1000, 10 * 1000);

	}

}
