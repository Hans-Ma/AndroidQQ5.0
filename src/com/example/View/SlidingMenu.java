package com.example.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView {
	private LinearLayout wrapper;
	private ViewGroup menu;
	private ViewGroup contect;
	private boolean once=false;
	
	private int ScreenWidth;			//屏幕宽度
	private int MenuRightPadding=50;	//menu与右侧的距离
	
	public SlidingMenu(Context context ,AttributeSet attrs) {
		super(context,attrs);
		
		/**
		 * 如果没使用自定义控件
		 * 调用以上的两个参数的构造方法，比较难理解
		 * 
		 * 自定义ViewGroup
		 * onMeasure:决定内部的子View的宽和高，以及自己的宽和高
		 * onLayout:决定子View的位置
		 * onTouchEvent:控制手指滑动状态，决定内部View的移动效果
		 * 
		 */
		
		WindowManager wManager =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();	//外观度量
		wManager.getDefaultDisplay().getMetrics(outMetrics);
		ScreenWidth=outMetrics.widthPixels;
		
		//把dp转化为px,固定的工具方法
		TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
		
	}
	/**
	 * 设置子View的宽和高
	 * 设置自己的宽和高
	 * 
	 **/
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if(!once){
			wrapper=(LinearLayout) getChildAt(0);
			menu=(ViewGroup)wrapper.getChildAt(0);
			contect=(ViewGroup) wrapper.getChildAt(1);
			menu.getLayoutParams().width=ScreenWidth-MenuRightPadding;
			contect.getLayoutParams().width=ScreenWidth;
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

//	@Override
//	protected void onLayout(boolean changed,int l,int t,int b){
//		super.onLayout(changed, l, t, r, b);
//	}
	
}
