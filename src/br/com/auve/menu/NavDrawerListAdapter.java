package br.com.auve.menu;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import br.com.telas.R;

public class NavDrawerListAdapter extends BaseAdapter {

	private ArrayList<NavDrawItem> itens;
	private Context context;

	public NavDrawerListAdapter(Context context, ArrayList<NavDrawItem> itens) {
		this.context = context;
		this.itens = itens;
	}

	@Override
	public int getCount() {
		return itens.size();
	}

	@Override
	public Object getItem(int arg0) {
		return itens.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int postion, View convertView, ViewGroup parent) {

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		convertView = mInflater.inflate(R.layout.ui_test, null);

		
		
		return convertView;
	}

}
