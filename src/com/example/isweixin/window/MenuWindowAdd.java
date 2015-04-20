package com.example.isweixin.window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.isweixin.R;
import android.util.DisplayMetrics;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.graphics.drawable.ColorDrawable;


public class MenuWindowAdd extends PopupWindow {
	View view;
	List<Map<String, String>> moreList;

	@SuppressLint("InflateParams")
	public MenuWindowAdd(final Activity context) {
		super(context);

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.activity_add, null);

		DisplayMetrics dm = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int w = dm.widthPixels;
		int h = dm.heightPixels;

		this.setContentView(view);
		//this.setWidth(w/2+50);
		
		//设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);

		//设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		
		//设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.mystyle);
		
		//实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0000000000);
		//设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);

        ListView lvPopupList = (ListView) view.findViewById(R.id.lv_popup_list);

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

		lvPopupList.setAdapter(new SimpleAdapter(context, 
			moreList,
			R.layout.list_item_popupwindow, 
			new String[] { "share_key" },
			new int[]    { R.id.tv_list_item }));

		lvPopupList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(context, moreList.get(position).get("share_key"), Toast.LENGTH_SHORT).show();
				
			}
		});

		lvPopupList.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
		this.setWidth(lvPopupList.getMeasuredWidth());
	}

	public void showPopupWindow(View anchor, int xoff, int yoff) {
		this.showAsDropDown(anchor, xoff, yoff);
	}
}
