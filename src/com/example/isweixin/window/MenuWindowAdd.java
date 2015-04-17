package com.example.isweixin.window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.isweixin.R;
import com.michael.popupwindowdemo.MainActivity;

import android.util.DisplayMetrics;
import android.widget.PopupWindow;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.SimpleAdapter;
import android.graphics.drawable.ColorDrawable;


public class MenuWindowAdd extends PopupWindow {
	public MenuWindowAdd(final Activity context) {
		
		Log.e("MOTADOU", "1");
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Log.e("MOTADOU", "2");
		View view = inflater.inflate(R.layout.activity_add, null);
		Log.e("MOTADOU", "3");
		this.setContentView(view);
		Log.e("MOTADOU", "4");
		this.update();
		Log.e("MOTADOU", "5");
				
		//设置按钮监听
		
		
		//设置SelectPicPopupWindow弹出窗体的宽
		
		//设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		//设置SelectPicPopupWindow弹出窗体动画效果
		//this.setAnimationStyle(R.style.mystyle);
		//实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0000000000);
		//设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);
        
        ListView lvPopupList = (ListView) view.findViewById(R.id.lv_popup_list);
        
        List<Map<String, String>> moreList;
		moreList = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		map = new HashMap<String, String>();
		map.put("share_key", "复制");
		moreList.add(map);
		map = new HashMap<String, String>();
		map.put("share_key", "删除");
		moreList.add(map);
		map = new HashMap<String, String>();
		map.put("share_key", "修改");
		moreList.add(map);

		lvPopupList.setAdapter(new SimpleAdapter(MainActivity.this, 
				moreList,
				R.layout.list_item_popupwindow, 
				new String[] { "share_key" },
				new int[]    { R.id.tv_list_item }));
		
		Log.e("MOTADOU", "5dfdfdfdfd");
	}

	public void showPopupWindow(View anchor, int xoff, int yoff) {
		this.showAsDropDown(anchor, xoff, yoff);
	}
}
