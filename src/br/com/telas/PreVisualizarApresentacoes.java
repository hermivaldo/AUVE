package br.com.telas;

import br.com.controlebanco.InserirImagens;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class PreVisualizarApresentacoes extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewGroup group = (ViewGroup) findViewById(android.R.id.content);

		group.addView(new InserirImagens().painel(getApplicationContext()));
	}
}
