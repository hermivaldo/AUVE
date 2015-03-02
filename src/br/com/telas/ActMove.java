package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;

import com.hermivaldo.projetodraw.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity {

	private ViewGroup mView;
	private ViewGroup mGroup;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle) Adicionar objetos
	 * dinamicamente na tela do dispositivo
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		mGroup = (ViewGroup) findViewById(android.R.id.content);
		
		mView = (ViewGroup) getLayoutInflater().inflate(R.layout.la_actmove, null);
		
		
		
		mGroup.addView(mView);
		/*
		 * Trexo removido para a classe CustomOptionView.
		 * Agora todo o conteúdo pode ser manipulado diretamente dentro
		 * da classe. Não existe a necessidade de recriar mais objetos,
		 * pois todo o conteúdo será manipulado pelo XML.
		 */
//		final ViewGroup mGrouRa = (ViewGroup) findViewById(R.id.reP);
//		
//		final ImageView circulo = (ImageView) findViewById(R.id.circulo);
//		
//		circulo.setOnClickListener(new OnClickListener() {
//			
//			@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//			@Override
//			public void onClick(View v) {
//				ImagemQuadrada imagemQuadrada = new ImagemQuadrada(ActMove.this);
//				int hei = circulo.getLayoutParams().height;
//				int wid = circulo.getLayoutParams().width;
//				imagemQuadrada.setLayoutParams(new LayoutParams(wid, hei));
//				imagemQuadrada.setX(circulo.getX());
//				imagemQuadrada.setY(circulo.getY());
//				imagemQuadrada.setBackground(circulo.getBackground());
//				mGrouRa.addView(imagemQuadrada);
//			}
//		});
		
	}

	

}
