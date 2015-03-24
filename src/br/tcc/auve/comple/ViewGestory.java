package br.tcc.auve.comple;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;

public class ViewGestory extends View implements OnTouchListener,
		OnScaleGestureListener {

	private View view;
	private float scaleFactor = 1f;
	private ScaleGestureDetector mDetector;


	public ViewGestory(Context context) {
		super(context);
		mDetector = new ScaleGestureDetector(context, this);
	
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.setOnTouchListener(this);
		mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		this.view = v;
		mDetector.onTouchEvent(event);
		

		int x = (int) event.getX();
		int y = (int) event.getY();

		if (event.getAction() == MotionEvent.ACTION_MOVE){
			
			int velocidade = 0;
			int velocidadeY = 0;
			if (x > 0) {
				velocidade = (x - (getWidth() / 2));
			} else {
				/*
				 */
				// v.performClick();
				velocidade *= -1;
			}
			if (y > 0) {
				velocidadeY = (y - (getHeight() / 2));
			} else {
				velocidadeY *= -1;
			}
			
			if (x > getWidth() / 2) {
				setTranslationX(getX() + velocidade);
				// v.setX(v.getX() + velocidade);
			}
			if (x < getWidth() / 2) {
				setTranslationX(getX() - (-velocidade));
				// v.setX(v.getX() - (-velocidade));
			}
			
			if (y > getHeight() / 2) {
				setTranslationY(getY() + velocidadeY);
				// v.setY(v.getY() + velocidadeY);
			}
			
			if (y < getHeight() / 2) {
				setTranslationY(getY() - (-velocidadeY));
				// v.setY(v.getY() - (-velocidadeY));
			}
			
		}
		return true;
	}

	
	
	@Override
	public boolean onScale(ScaleGestureDetector detector) {
		scaleFactor *= detector.getScaleFactor();
		scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 10.0f));
//		scaleFactor = (scaleFactor < 1 ? 1 : scaleFactor);
//		scaleFactor = ((float) ((int) (scaleFactor * 100))) / 100;

		view.setScaleX(scaleFactor);
		view.setScaleY(scaleFactor);
		
		return true;
	}

	@Override
	public boolean onScaleBegin(ScaleGestureDetector detector) {
		return true;
	}

	@Override
	public void onScaleEnd(ScaleGestureDetector detector) {
		Log.d("VALOR", scaleFactor + "");
		
	}

}
