package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.hermivaldo.projetodraw.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity{

	private ViewGroup mView;
	public static View touch;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * Adicionar objetos dinamicamente na tela do dispositivo
	 */
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		ViewGroup mGroup = (ViewGroup) getLayoutInflater().inflate(
				R.layout.act_draw, null);
		this.setContentView(R.layout.la_actmove);
	
		mView = (ViewGroup) findViewById(R.id.tela);

		
		mView.addView(new ImagemQuadrada(this, R.drawable.circle_shape, new LayoutParams(50, 50)));
		mView.addView(new ImagemQuadrada(this, R.drawable.shape_border, new LayoutParams(70, 80)));
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int plano_fundo_x = (int) event.getX();
		int plano_fundo_y = (int) event.getY();

		int plano_fundo_objeto_x = (int) touch.getX();
		int plano_fundo_objeto_y = (int) touch.getY();

		touch.getLayoutParams().height = plano_fundo_y;
		touch.getLayoutParams().width = plano_fundo_x;

		touch.setX(plano_fundo_objeto_x);
		touch.setY(plano_fundo_objeto_y);
		this.mView.invalidate();
		setContentView(mView);
		return super.onTouchEvent(event);
	}
	
	
}
