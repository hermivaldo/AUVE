package br.com.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CustomViewDraw extends ImageView {


	public CustomViewDraw(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}

	public CustomViewDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	public CustomViewDraw(Context context) {
		super(context);
		
	}

	@Override
	public boolean isInEditMode() {
		// TODO Auto-generated method stub
		return super.isInEditMode();
	}
	
	@Override
	public void setOnTouchListener(OnTouchListener l) {
		l = new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {

	            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) view.getLayoutParams();

	            switch (event.getAction())
	            {
	                case MotionEvent.ACTION_MOVE:
	                    params.topMargin = (int) event.getRawY() - view.getHeight();
	                    params.leftMargin = (int) event.getRawX() - (view.getWidth() / 2);
	                    view.setLayoutParams(params);
	                    break;

	                case MotionEvent.ACTION_UP:
	                    params.topMargin = (int) event.getRawY() - view.getHeight();
	                    params.leftMargin = (int) event.getRawX() - (view.getWidth() / 2);
	                    view.setLayoutParams(params);
	                    break;

	                case MotionEvent.ACTION_DOWN:
	                    view.setLayoutParams(params);
	                    break;
	            }

	            return true;
			}
		};
		super.setOnTouchListener(l);
	}


}
