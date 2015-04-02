package br.com.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class CustomVideoView extends VideoView {

	public CustomVideoView(Context context) {
		super(context);

	}

	public CustomVideoView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CustomVideoView(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

	}

	@Override
	public boolean performClick() {
		Log.d("tag 2", "estou aqui");
		return super.performClick();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d("tag 2", "estou aqui");
			}
		});
		
		int x = (int) ev.getX();
		int y = (int) ev.getY();

		int velocidade = 0;

		int velocidadeY = 0;
		if (x > 0) {
			velocidade = (x - (this.getWidth() / 2));
		} else {
			/*
			 */
			// v.performClick();
			velocidade *= -1;
		}
		if (y > 0) {
			velocidadeY = (y - (this.getHeight() / 2));
		} else {
			velocidadeY *= -1;
		}

		if (x > this.getWidth() / 2) {
			this.setTranslationX(this.getX() + velocidade);
			// v.setX(v.getX() + velocidade);
		}
		if (x < this.getWidth() / 2) {
			this.setTranslationX(this.getX() - (-velocidade));
			// v.setX(v.getX() - (-velocidade));
		}

		if (y > this.getHeight() / 2) {
			this.setTranslationY(this.getY() + velocidadeY);
			// v.setY(v.getY() + velocidadeY);
		}

		if (y < this.getHeight() / 2) {
			this.setTranslationY(this.getY() - (-velocidadeY));
			// v.setY(v.getY() - (-velocidadeY));
		}

		/*
		 * Removido por causar estralos em processadores Intel.
		 */
		// v.performClick();
//		onTouchEvent(ev);
		return super.onTouchEvent(ev);
	}

}
