package br.com.slide;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import br.com.controlebanco.InserirApren;
import br.com.entidades.Apresentacao;
import br.com.telas.R;

public class ActivityFragment extends FragmentActivity{

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		setContentView(R.layout.viewpagefragment);
		ViewPager page = (ViewPager) findViewById(R.id.page);
		ArrayList<Apresentacao> lista = new InserirApren(this).getAllApre();
		PagerAdapter adapter = new FragmentAdapter(getFragmentManager(),lista);
		page.setAdapter(adapter);
	}
}
