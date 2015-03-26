package com.example.isweixin;

import java.lang.reflect.Field;
import android.content.Context;
/**
 * ��ȡ��Ļ,�ֱ������
 * @author 6a209
 *
 * 2011-12-14 ����10:28:41
 */
public class ScreenTools {
	private Context mCtx;
	private static ScreenTools mScreenTools;
	
	public static ScreenTools instance(Context ctx){
		if(null == mScreenTools){
			mScreenTools = new ScreenTools(ctx);
		}
		return mScreenTools;
	}
	
	private ScreenTools(Context ctx){
		mCtx = ctx.getApplicationContext();
	}
	
	public int getScreenWidth(){
		return mCtx.getResources().getDisplayMetrics().widthPixels;
	}
	public int dip2px(int dip){
		float density = getDensity(mCtx);
		return (int)(dip * density + 0.5);
	}
	
	public int px2dip(int px){
		float density = getDensity(mCtx);
		return (int)((px - 0.5) / density);
	}
	
	private  float getDensity(Context ctx){
		return ctx.getResources().getDisplayMetrics().density;
	}
	
	/**
	 * ��40 �ķֱ�������85 ��
	 * @param width����ǰ��Ļ���
	 * @return
	 */
	public int getScal(){
		 return (int)(getScreenWidth() * 100 / 480);
	}
	
	 /**
	  * ��ȫ��, ���ݵ�ǰ�ֱ��ʡ���̬��ȡ�߶� 
	  * height �ڣ�����*����������¡��ĸ߶�
	  * @return
	  */
	public int get480Height(int height480){
		 int width = getScreenWidth();
		 return (height480 * width / 480); 
	 }
	
	/**
	 * ��ȡ״̬���߶�
	 * @return
	 */
	public int getStatusBarHeight(){
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, sbar = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			sbar = mCtx.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		return sbar;
	}
	
	public int getScreenHeight(){
		return mCtx.getResources().getDisplayMetrics().heightPixels;
	}
}