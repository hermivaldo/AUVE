package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import br.com.fileexplorer.FileChoose;

import com.hermivaldo.projetodraw.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity {

	private static final int REQUEST_PATH = 1;
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.adicionar:
			Intent intent1 = new Intent(this, FileChoose.class);
			startActivityForResult(intent1, REQUEST_PATH);
			break;
		default:
			break;
		}
	
		return super.onOptionsItemSelected(item);
	}

	
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_PATH) {
			if (resultCode == RESULT_OK) {

				Bitmap map = BitmapFactory.decodeFile(data.getStringExtra("GetFileName"));
				((ImageView) CustomRl.touch).setImageBitmap(map);
				((ImageView) CustomRl.touch).setBackground(null);
			}
		}
	}
}
