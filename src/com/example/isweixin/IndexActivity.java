package com.example.isweixin;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.anim;

public class IndexActivity extends Activity {
	private Timer timer;

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			timer.cancel();

			Intent intent = new Intent(IndexActivity.this, MainActivity.class);

			startActivity(intent);
			finish();

			//淡入淡出效果
			overridePendingTransition(R.anim.fade, R.anim.hold);

			//			放大淡出效果
//			overridePendingTransition(R.anim.my_scale_action,R.anim.my_alpha_action);

			//			转动淡出效果
//			overridePendingTransition(R.anim.scale_rotate,R.anim.my_alpha_action);
			//			转动淡出效果
//			overridePendingTransition(R.anim.scale_translate_rotate,R.anim.my_alpha_action);
			
			//			左上角展开淡出效果
			//			overridePendingTransition(R.anim.scale_translate,R.anim.my_alpha_action);
			
			//			压缩变小淡出效果
//			overridePendingTransition(R.anim.hyperspace_in,R.anim.hyperspace_out);
//			右往左推出效果
			//overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
//			下往上推出效果
//			overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
//			左右交错效果
			//overridePendingTransition(R.anim.slide_left,R.anim.slide_right);
//			放大淡出效果
//			overridePendingTransition(R.anim.wave_scale,R.anim.my_alpha_action);
//			缩小效果
//			overridePendingTransition(R.anim.zoom_enter,R.anim.zoom_exit);
//			上下交错效果
//			overridePendingTransition(R.anim.slide_up_in,R.anim.slide_down_out); 
			
			

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
		}, 1500, 1000);
	}
}
