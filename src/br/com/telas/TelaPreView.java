package br.com.telas;

import br.com.refac.ViewStatica;
import android.app.Activity;
import android.os.Bundle;

public class TelaPreView extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(ViewStatica.getViewGroup());
	}
	
}
