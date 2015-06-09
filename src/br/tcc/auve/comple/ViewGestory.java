package br.tcc.auve.comple;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import br.com.telas.ActMove;
import br.com.telas.R;

public class ViewGestory extends ImageView implements OnTouchListener,
		OnScaleGestureListener, OnLongClickListener {

	private View view;

	private ScaleGestureDetector mDetector;

	public ViewGestory(Context context) {
		super(context);
		mDetector = new ScaleGestureDetector(context, this);
		this.setOnLongClickListener(this);
	}
	
	@Override
	public boolean performClick() {
		
		return super.performClick();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		performClick();
		setOnTouchListener(this);

		mDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	

	@Override
	public boolean isSelected() {
		if (ActMove.mViewSelected != null
				&& ActMove.mViewSelected == this){
			if (ActMove.mViewSelected.getTag() == null){
				ActMove.mViewSelected.setTag(this.getBackground());
			}
			this.setBackgroundResource(R.drawable.shapeborder);
		}else if (ActMove.mViewSelected != null) {
			if (ActMove.mViewSelected.getTag() instanceof Drawable){
				ActMove.mViewSelected.setBackground((Drawable) ActMove.mViewSelected.getTag());
			}else {
				ActMove.mViewSelected.setBackground(null);
			}
			
		}
		return super.isSelected();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		if (ActMove.mViewSelected != this){
			isSelected();
			ActMove.mViewSelected = this;
			
		}
		isSelected();
		this.view = v;
		mDetector.onTouchEvent(event);
		performClick();


		return true;
	}



	@Override
	public boolean onScale(ScaleGestureDetector detector) {

		return true;
	}

	@Override
	public boolean onScaleBegin(ScaleGestureDetector detector) {
		return true;
	}

	@Override
	public void onScaleEnd(ScaleGestureDetector detector) {

	}

	@Override
	public boolean onLongClick(View v) {
		return false;
	}

}
