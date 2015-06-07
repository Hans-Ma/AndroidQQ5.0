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
	
	private int ScreenWidth;			//��Ļ���
	private int MenuRightPadding=50;	//menu���Ҳ�ľ���
	
	public SlidingMenu(Context context ,AttributeSet attrs) {
		super(context,attrs);
		
		/**
		 * ���ûʹ���Զ���ؼ�
		 * �������ϵ����������Ĺ��췽�����Ƚ������
		 * 
		 * �Զ���ViewGroup
		 * onMeasure:�����ڲ�����View�Ŀ�͸ߣ��Լ��Լ��Ŀ�͸�
		 * onLayout:������View��λ��
		 * onTouchEvent:������ָ����״̬�������ڲ�View���ƶ�Ч��
		 * 
		 */
		
		WindowManager wManager =(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();	//��۶���
		wManager.getDefaultDisplay().getMetrics(outMetrics);
		ScreenWidth=outMetrics.widthPixels;
		
		//��dpת��Ϊpx,�̶��Ĺ��߷���
		TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics());
		
	}
	/**
	 * ������View�Ŀ�͸�
	 * �����Լ��Ŀ�͸�
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
