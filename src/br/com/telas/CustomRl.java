package br.com.telas;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomRl extends RelativeLayout implements OnClickListener{

	static View touch;
	
	public CustomRl(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setOnClickListener(this);
	}

	public CustomRl(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnClickListener(this);
	}

	public CustomRl(Context context) {
		super(context);
		setOnClickListener(this);
	}
	
	@Override
	public boolean isInEditMode() {
		return super.isInEditMode();
	}
	
	@Override
	public boolean performClick() {
		return super.performClick();
	}
	
	@Override
	public void onClick(View v) {
		setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (touch instanceof View){
					v.performClick();
					int plano_fundo_x = (int) event.getX();
					int plano_fundo_y = (int) event.getY();

					int plano_fundo_objeto_x = (int) touch.getX();
					int plano_fundo_objeto_y = (int) touch.getY();

					touch.getLayoutParams().height = plano_fundo_y;
					touch.getLayoutParams().width = plano_fundo_x;

					touch.setX(plano_fundo_objeto_x);
					touch.setY(plano_fundo_objeto_y);
					
					touch.requestLayout();
				}
				return false;
			}
		});
		
	}
	
}
