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
import br.tcc.auve.comple.ViewGestory;


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
		View imagemQuadrada = null;
		
		imagemQuadrada = new ViewGestory(getContext());
		
		
		imagemQuadrada.setLayoutParams(new LayoutParams(200, 200));
		imagemQuadrada.setX(this.getX());
		imagemQuadrada.setY(this.getY());
		imagemQuadrada.setBackground(this.getBackground());
		
		( (ViewGroup) ((Activity) getContext()).findViewById(R.id.tela)).
		addView(imagemQuadrada);
		ActMove.mDrawerLayout.closeDrawers();
	}
	
	
}
