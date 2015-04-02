package br.com.slide;

import java.util.ArrayList;

import com.commonsware.cwac.preso.PresentationHelper;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import br.com.controlebanco.InserirApren;
import br.com.entidades.Apresentacao;
import br.com.telas.R;
import br.com.telas.SecondScreenDemo;

public class ActivityFragment extends FragmentActivity implements PresentationHelper.Listener{

	public static Presentation preso = null;
	PresentationHelper helper = null;
	
	public static View view ;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		setContentView(R.layout.viewpagefragment);
		ViewPager page = (ViewPager) findViewById(R.id.page);
		ArrayList<Apresentacao> lista = new InserirApren(this).getAllApre();
		PagerAdapter adapter = new FragmentAdapter(getFragmentManager(),lista);
		page.setAdapter(adapter);
		helper = new PresentationHelper(this, this);
	}

	@Override
	protected void onResume() {
		helper.onResume();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		helper.onPause();
		super.onPause();
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
		preso = new SecondScreenDemo(this, arg0);
	}
}
