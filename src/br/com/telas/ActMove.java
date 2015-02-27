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
		
	}

	

}
