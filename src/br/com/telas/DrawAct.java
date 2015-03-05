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

@Deprecated
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

	
	/*
	 * Lembrar de quando refatorar a classe alterar o método do onclick
	 * para se chamar CachaçaDiária, pois parou com a tremedeira do objeto
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int plano_fundo_x = (int) event.getX();
		int plano_fundo_y = (int) event.getY();

		int plano_fundo_objeto_x = (int) this.mImageView.getX();
		int plano_fundo_objeto_y = (int) this.mImageView.getY();

		ViewGroup mGroup = (ViewGroup) getLayoutInflater().inflate(
				R.layout.act_draw, null);

		this.mTextView = (TextView) mGroup.findViewById(R.id.medida);

		this.mImageView = (ImageView) mGroup.findViewById(R.id.image);

		this.mImageView.getLayoutParams().height = plano_fundo_y;
		this.mImageView.getLayoutParams().width = plano_fundo_x;

		this.mImageView.setX(plano_fundo_objeto_x);
		this.mImageView.setY(plano_fundo_objeto_y);

		this.mImageView.setOnClickListener(this);

		this.mImageView.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				int x = (int) event.getX();
				int y = (int) event.getY();

				event.getEdgeFlags();


				if (event.getAction() == MotionEvent.ACTION_MOVE) {

					DrawAct.this.mTextView.setText("valor de x "+
							x + " valor da metade do objeto" + DrawAct.this.mImageView.getWidth() / 2  + 
							" distância entre objetos " + 
							(x - (DrawAct.this.mImageView.getWidth() / 2 )));
					
					int velocidade = 0;
					int velocidadeY =  0;
					if (x > 0){
						velocidade = (x - (DrawAct.this.mImageView.getWidth() / 2 ));
					}else{
						velocidade *= -1 ;
					}
					if (y > 0){
						velocidadeY = (y - (DrawAct.this.mImageView.getHeight() / 2 ));
					}else{
						velocidadeY *= -1 ;
					}
					
					
					if (x > DrawAct.this.mImageView.getWidth() / 2) {
						DrawAct.this.mImageView.setX(DrawAct.this.mImageView
								.getX() + velocidade);
					}
					if (x < DrawAct.this.mImageView.getWidth() / 2) {
						DrawAct.this.mImageView.setX(DrawAct.this.mImageView
								.getX() - (-velocidade));
					}
					
					if (y > DrawAct.this.mImageView.getHeight() / 2) {
						DrawAct.this.mImageView.setY(DrawAct.this.mImageView
								.getY() + velocidadeY);
					}
					
					if (y < DrawAct.this.mImageView.getHeight() / 2) {
						DrawAct.this.mImageView.setY(DrawAct.this.mImageView
								.getY() - (-velocidadeY));
					}
	

				}

				return false;
			}
		});
		;

		this.setContentView(mGroup);
		return false;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onClick(View v) {
	}
}
