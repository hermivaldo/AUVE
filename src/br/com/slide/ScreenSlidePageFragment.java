package br.com.slide;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.controlebanco.InserirImagens;

public class ScreenSlidePageFragment extends Fragment {

	private static final String ARG_PAGE = "apresen";
	private int numberPresentation;
	
	public static ScreenSlidePageFragment create(int page) {
		ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, page);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		numberPresentation = getArguments().getInt(ARG_PAGE);
	}
	
	public ScreenSlidePageFragment() {
	}
	
	/*
	 * Usada para carregar as apresentações do banco de dados. (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return new InserirImagens().painel(getActivity(), numberPresentation);

	}
}
