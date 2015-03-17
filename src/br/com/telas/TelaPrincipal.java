package br.com.telas;

import br.com.slide.ActivityFragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaPrincipal extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}
	
	public void iniciar(View view){
		startActivity(new Intent(this, ActMove.class));
	}
	
	public void visulizarApre(View view){
		startActivity(new Intent(this, ActivityFragment.class));
	}
	
}
