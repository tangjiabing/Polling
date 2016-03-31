package com.polling.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.polling.R;

public class DialogActivity extends Activity {

	private TextView mTextView = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// QQ锁屏弹窗：
		// 1）android:theme="@android:style/Theme.Wallpaper"
		// 2）getWindow().addFlags：锁屏状态下显示，解锁，保持屏幕长亮，打开屏幕
		getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
						| WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
						| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
						| WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		setContentView(R.layout.activity_dialog);
		mTextView = (TextView) findViewById(R.id.textView);
		test();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		test();
	}

	private void test() {
		Intent intent = getIntent();
		mTextView.setText("" + intent.getIntExtra("count", -1));
	}

}
