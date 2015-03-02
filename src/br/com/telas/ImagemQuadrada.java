package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class ImagemQuadrada extends View implements OnClickListener {

	public ImagemQuadrada(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.setOnClickListener(this);
	}

	public ImagemQuadrada(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOnClickListener(this);
	}

	public ImagemQuadrada(Activity context) {
		super(context);
		this.setOnClickListener(this);
	}

	@Override
	public boolean performClick() {
		return super.performClick();
	}
	
	@Override
	public boolean isInEditMode() {
		return super.isInEditMode();
	}

	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onClick(View v) {
		this.setOnClickListener(this);
		CustomRl.touch = this;
		this.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				int x = (int) event.getX();
				int y = (int) event.getY();

				int velocidade = 0;

				int velocidadeY = 0;
				if (x > 0) {
					velocidade = (x - (v.getWidth() / 2));
				} else {v.performClick();
					velocidade *= -1;
				}
				if (y > 0) {
					velocidadeY = (y - (v.getHeight() / 2));
				} else {
					velocidadeY *= -1;
				}

				if (x > v.getWidth() / 2) {
					v.setX(v.getX() + velocidade);
				}
				if (x < v.getWidth() / 2) {
					v.setX(v.getX() - (-velocidade));
				}

				if (y > v.getHeight() / 2) {
					v.setY(v.getY() + velocidadeY);
				}

				if (y < v.getHeight() / 2) {
					v.setY(v.getY() - (-velocidadeY));
				}
				
				v.performClick();
				return false;
			}
		});
		
	}

	
	public boolean onLongClick(View v) {
		Toast.makeText(getContext(), "long", Toast.LENGTH_LONG).show();
		return false;
	}

}
