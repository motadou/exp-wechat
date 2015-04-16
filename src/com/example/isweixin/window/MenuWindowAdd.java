package com.example.isweixin.window;
import com.example.isweixin.R;
import android.util.DisplayMetrics;
import android.widget.PopupWindow;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MenuWindowAdd extends PopupWindow {
	public MenuWindowAdd(final Activity context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.activity_add, null);
		
		this.setContentView(view);
		this.update();

        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
        
        ListView list = (ListView) view.findViewById(R.id.lv_popup_list);
        
        
	}

	public void showPopupWindow(View anchor, int xoff, int yoff) {
		this.showAsDropDown(anchor, xoff, yoff);
	}
}
