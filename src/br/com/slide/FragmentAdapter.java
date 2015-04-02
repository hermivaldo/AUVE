package br.com.slide;

import java.util.ArrayList;

import br.com.entidades.Apresentacao;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;


public class FragmentAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Apresentacao> apre;

	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public FragmentAdapter(FragmentManager fm, ArrayList<Apresentacao> apre) {
		super(fm);
		this.apre = apre;
	}

	@Override
	public Fragment getItem(int position) {
		return ScreenSlidePageFragment.create(this.apre.get(position).getIdApresentacao());
	}

	@Override
	public int getCount() {
		return apre.size();
	}

}
