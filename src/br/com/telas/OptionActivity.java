package br.com.telas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import br.com.banco.TutorialDAO;
import br.com.entidades.Configuracao;

public class OptionActivity extends Activity {

	TutorialDAO tdDAO ;
	private CheckBox box;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_options);
		box = (CheckBox) findViewById(R.id.check_salvar);
		tdDAO = new TutorialDAO(this);
		if (tdDAO.getStatus().size() == 0){
			box.setChecked(false);
		}
	
	}

	public void salvar(View view) {
		if (box.isChecked()){
			tdDAO.deleteConf();
			
		}else if (!box.isChecked()){
			tdDAO.insetConfig(new Configuracao("1"));
		}
		onBackPressed();
	}
}
