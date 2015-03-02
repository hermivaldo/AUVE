package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;


public class CustomOptionView extends View implements OnClickListener{

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public CustomOptionView(Context context, AttributeSet attrs,
			int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
		setOnClickListener(this);
	}

	public CustomOptionView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		setOnClickListener(this);
	}

	public CustomOptionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		setOnClickListener(this);
	}

	public CustomOptionView(Context context) {
		super(context);
		setOnClickListener(this);
	}

	@Override
	public boolean isInEditMode() {
		return super.isInEditMode();
	}
	
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onClick(View v) {
		ImagemQuadrada imagemQuadrada = new ImagemQuadrada((Activity) getContext());
		int hei = this.getLayoutParams().height;
		int wid = this.getLayoutParams().width;
		imagemQuadrada.setLayoutParams(new LayoutParams(wid, hei));
		imagemQuadrada.setX(this.getX());
		imagemQuadrada.setY(this.getY());
		imagemQuadrada.setBackground(this.getBackground());
		((ViewGroup) getParent()).addView(imagemQuadrada);
	}
	
	
}
