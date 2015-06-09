package br.com.telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.banco.TutorialDAO;
import br.com.slide.ActivityFragment;
import br.com.tutorial.TutorialTelaPrinc;

public class TelaPrincipal extends Activity   {
	
	TutorialDAO tdDAO;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		tdDAO = new TutorialDAO(this);
		apresentacoes();
		
	}

	private void apresentacoes() {
		if (tdDAO.getStatus().size() == 0){
			new TutorialTelaPrinc(this);
		}
	}

	public void iniciar(View view) {
		startActivity(new Intent(this, ActMove.class));
	}

	public void visulizarApre(View view) {
		startActivity(new Intent(this, ActivityFragment.class));
	}

	public void opcoes(View view){
		startActivity(new Intent(this, OptionActivity.class));
	}

}
