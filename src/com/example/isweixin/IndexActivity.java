package com.example.isweixin;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IndexActivity extends Activity {
	private Timer timer;

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			timer.cancel();

			
			Intent intent = new Intent(IndexActivity.this, MainActivity.class);
			startActivity(intent);
			//finish();
			
			IndexActivity.this.finish();
			
			super.handleMessage(msg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.index);

		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				handler.sendEmptyMessage(0);
			}
		},1500,1000);
	}
}
