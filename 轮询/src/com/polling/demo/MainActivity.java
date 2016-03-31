package com.polling.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.polling.R;
import com.polling.util.NotificationUtil;
import com.polling.util.PollingUtil;

public class MainActivity extends Activity {

	private TextView mTextView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) { // 调用此方法就不会调用onNewIntent
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.textView);
		test();
	}

	// MainActivity的launchMode不能为standard，否则不会调用onNewIntent方法
	@Override
	protected void onNewIntent(Intent intent) { // 调用此方法就不会调用onCreate
		Log.i("My", "onNewIntent");
		super.onNewIntent(intent);
		setIntent(intent); // 赋值给Activity的Intent，否则后续的getIntent()都是得到老的Intent
		test();
	}

	private void test() {
		Intent intent = getIntent();
		mTextView.setText("" + intent.getIntExtra("count", -1));
	}

	public void startPolling(View v) {
		Bundle bundle = new Bundle();
		bundle.putInt("count", 0);
		PollingUtil.start(new PollingManager(), getApplicationContext(),
				bundle, 5 * 1000, 10 * 1000);
	}

	public void cancelPolling(View v) {
		PollingUtil.cancel(MainActivity.this);
	}

	public void cancelAllNotifies(View v) {
		NotificationUtil.cancelAllNotifies(this);
	}
}
