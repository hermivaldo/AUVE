package br.com.refac;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import br.com.telas.CustomRl;

public class CustomImgView extends ImageView implements OnClickListener {

	public CustomImgView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setOnClickListener(this);
	}

	public CustomImgView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOnClickListener(this);
	}

	public CustomImgView(Context context) {
		super(context);
		setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		this.setOnClickListener(this);
		if (CustomRl.touch instanceof CustomImgView){
			CustomRl.touch.invalidate();
			synchronized (this) {
				CustomRl.touch = this;
			} 
		}else {
			CustomRl.touch = this;
		}
		
		this.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int x = (int) event.getX();
				int y = (int) event.getY();

				int velocidade = 0;

				int velocidadeY = 0;
				if (x > 0) {
					velocidade = (x - (v.getWidth() / 2));
				} else {
					/*
					 * Costuma causar ações indesejadas na aplicação, ainda não
					 * foi possível diagnosticar a razão desse problema.
					 */
					// v.performClick();
					velocidade *= -1;
				}
				if (y > 0) {
					velocidadeY = (y - (v.getHeight() / 2));
				} else {
					velocidadeY *= -1;
				}

				if (x > v.getWidth() / 2) {
					v.setTranslationX(v.getX() + velocidade);
					// v.setX(v.getX() + velocidade);
				}
				if (x < v.getWidth() / 2) {
					v.setTranslationX(v.getX() - (-velocidade));
					// v.setX(v.getX() - (-velocidade));
				}

				if (y > v.getHeight() / 2) {
					v.setTranslationY(v.getY() + velocidadeY);
					// v.setY(v.getY() + velocidadeY);
				}

				if (y < v.getHeight() / 2) {
					v.setTranslationY(v.getY() - (-velocidadeY));
					// v.setY(v.getY() - (-velocidadeY));
				}

				/*
				 * Removido por causar estralos em processadores Intel.
				 */
				// v.performClick();
				return false;
			}
		});
	}

}
