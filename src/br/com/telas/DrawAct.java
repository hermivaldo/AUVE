package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hermivaldo.projetodraw.R;

public class DrawAct extends Activity implements OnClickListener {

	private ImageView mImageView;
	private TextView mTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_draw);

		this.mImageView = (ImageView) findViewById(R.id.image);

		this.mImageView.setOnClickListener(this);
		
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int X = (int) event.getX();
		int Y = (int) event.getY();
		ViewGroup mGroup = (ViewGroup) getLayoutInflater().inflate(
				R.layout.act_draw, null);
		
		int eventaction = event.getAction();
		
		this.mTextView = (TextView) mGroup.findViewById(R.id.medida);
		switch (eventaction) {

	    case MotionEvent.ACTION_DOWN:

	        this.mTextView.setText("ACTION_DOWN AT COORDS "+"X: "+X+" Y: "+Y);

	        
	        break;

	    case MotionEvent.ACTION_MOVE:

	        this.mTextView.setText( "MOVE "+"X: "+X+" Y: "+Y);

	        break;

	    case MotionEvent.ACTION_UP:

	        this.mTextView.setText("ACTION_UP "+"X: "+X+" Y: "+Y);

	        break;

	    }
		
	
		this.mImageView = (ImageView) mGroup.findViewById(R.id.image);
		
		this.mImageView.getLayoutParams().height = Y;
		this.mImageView.getLayoutParams().width = X;
		this.mImageView.setOnClickListener(this);
		
		this.mImageView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				int X = (int) event.getX();
				int Y = (int) event.getY();
				
				
				DrawAct.this.mImageView.setY(event.getY());
				DrawAct.this.mImageView.setX(event.getX());
				
				
				return false;
			}
		});;
		
		this.setContentView(mGroup);
		return false;
	}

	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onClick(View v) {
	}
}
