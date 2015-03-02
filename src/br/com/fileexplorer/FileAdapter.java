package br.com.fileexplorer;

import java.util.List;

import com.hermivaldo.projetodraw.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FileAdapter extends ArrayAdapter<Item>{

	private Context context;
	private int resource;
	private List<Item> objects;

	public FileAdapter(Context context, int resource, List<Item> objects) {
		super(context, resource, objects);
		this.context = context;
		this.resource = resource;
		this.objects = objects;
	}
	
	@Override
	public Item getItem(int position) {
		return objects.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null){
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(resource, null);
		}
		
		final Item ob = objects.get(position);
		if (ob != null) {
			TextView t1 = (TextView) convertView.findViewById(R.id.TextView01);
			TextView t2 = (TextView) convertView.findViewById(R.id.TextView02);
			TextView t3 = (TextView) convertView.findViewById(R.id.TextViewDate);

			if (t1 != null)
				t1.setText(ob.getName());
			if (t2 != null)
				t2.setText(ob.getData());
			if (t3 != null)
				t3.setText(ob.getDate());
		}
		
		return convertView;
	}

}
