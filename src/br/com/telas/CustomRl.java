package br.com.telas;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CustomRl extends RelativeLayout implements OnClickListener{

	/*
	 * O método ser static sem um tipo de modificador
	 * de acesso permite sua leitura apenas dentro das
	 * classes que estão dentro do mesmo pacote.
	 */
	public transient static View touch;
	
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
					// v.performClick();
					
					int plano_fundo_x = (int) event.getX();
					int plano_fundo_y = (int) event.getY();

					touch.getLayoutParams().height = plano_fundo_y;
					touch.getLayoutParams().width = plano_fundo_x;

					
					CustomRl.this.requestLayout();
					// touch.requestLayout();
				}
				return false;
			}
		});
		
	}
	
}
