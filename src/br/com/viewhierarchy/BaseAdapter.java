package br.com.viewhierarchy;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.entidades.Conteudo;
import br.com.telas.R;

public class BaseAdapter extends android.widget.BaseAdapter {

	private Context context;
	private final List<Conteudo> views;

	public BaseAdapter(Context context, List<Conteudo> views) {
		this.context = context;
		this.views = views;
	}

	@Override
	public int getCount() {
		return views.size();
	}

	@Override
	public Object getItem(int position) {
		return views.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View grid;

		grid = new View(context);

		grid = inflater.inflate(R.layout.layout_grid, null);

		Conteudo img = new Conteudo();
		img.setHeight(views.get(position).getHeight());
		img.setWidth(views.get(position).getWidth());
		img.setPath(views.get(position).getPath());
		img.setClassName(views.get(position).getClassName());

		((ViewGroup) grid).addView(img.getComponent(context));

		return grid;
	}

}
