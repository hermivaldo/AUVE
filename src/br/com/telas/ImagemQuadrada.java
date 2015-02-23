package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;

public class ImagemQuadrada extends View implements OnClickListener {

	public ImagemQuadrada(Activity context, int in, LayoutParams params) {
		super(context);
		
		this.setLayoutParams(params);
		this.setBackgroundResource(in);
		this.setOnClickListener(this);

	}

	@Override
	public boolean performClick() {
		return super.performClick();
	}
	

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onClick(View v) {
		this.setOnClickListener(this);
		ActMove.touch = this;
		this.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int x = (int) event.getX();
				int y = (int) event.getY();
				
				
				
				event.getEdgeFlags();

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

}
