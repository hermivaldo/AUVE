package br.com.telas;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Presentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import br.com.fileexplorer.FileChoose;

import com.commonsware.cwac.preso.PresentationHelper;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity implements PresentationHelper.Listener {

	private static final int REQUEST_PATH = 1;
	private ViewGroup mView;
	private ViewGroup mGroup;
	Presentation preso = null;
	PresentationHelper helper = null;

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

		mView = (ViewGroup) getLayoutInflater().inflate(R.layout.la_actmove,
				null);

		mGroup.addView(mView);

		helper = new PresentationHelper(this, this);
		/*
		 * Trexo removido para a classe CustomOptionView. Agora todo o conteúdo
		 * pode ser manipulado diretamente dentro da classe. Não existe a
		 * necessidade de recriar mais objetos, pois todo o conteúdo será
		 * manipulado pelo XML.
		 */
		// final ViewGroup mGrouRa = (ViewGroup) findViewById(R.id.reP);
		//
		// final ImageView circulo = (ImageView) findViewById(R.id.circulo);
		//
		// circulo.setOnClickListener(new OnClickListener() {
		//
		// @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
		// @Override
		// public void onClick(View v) {
		// ImagemQuadrada imagemQuadrada = new ImagemQuadrada(ActMove.this);
		// int hei = circulo.getLayoutParams().height;
		// int wid = circulo.getLayoutParams().width;
		// imagemQuadrada.setLayoutParams(new LayoutParams(wid, hei));
		// imagemQuadrada.setX(circulo.getX());
		// imagemQuadrada.setY(circulo.getY());
		// imagemQuadrada.setBackground(circulo.getBackground());
		// mGrouRa.addView(imagemQuadrada);
		// }
		// });

	}

	@Override
	protected void onResume() {
		super.onResume();
		helper.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		helper.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.adicionar:
			Intent intent1 = new Intent(this, FileChoose.class);
			startActivityForResult(intent1, REQUEST_PATH);
			break;
		case R.id.visu:
			ViewGroup tela = (ViewGroup) findViewById(R.id.tela);
			((ViewGroup) tela.getParent()).removeView(tela);
			preso.setContentView(tela);
			preso.show();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_PATH) {
			if (resultCode == RESULT_OK) {

				Bitmap map = BitmapFactory.decodeFile(data
						.getStringExtra("GetFileName"));
				((ImageView) CustomRl.touch).setImageBitmap(map);
				((ImageView) CustomRl.touch).setBackground(null);
			}
		}
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	public void clearPreso(boolean arg0) {
		if (preso != null) {
			preso.dismiss();
			preso = null;
		}
	}

	@Override
	public void showPreso(Display arg0) {
		preso= new SecondScreenDemo(this, arg0);
	}
}
