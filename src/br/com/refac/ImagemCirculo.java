package br.com.refac;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.OnClickListener;

@SuppressLint("DrawAllocation")
public class ImagemCirculo extends CustomImgView implements OnClickListener {

	public ImagemCirculo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}

	public ImagemCirculo(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ImagemCirculo(Activity context) {
		super(context);
	}

	@Override
	public boolean isInEditMode() {
		return super.isInEditMode();
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		float radius = 90.0f;
		Path clipPath = new Path();
		RectF rect = new RectF(0,0,this.getWidth(),this.getHeight());
		clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
		canvas.clipPath(clipPath);
		super.onDraw(canvas);
	}

		

}
