package br.tcc.auve.comple;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;
import br.com.telas.R;
import br.tcc.auve.regras.LoadComponent;

public class ListViewPreviewFolder extends BaseAdapter {

	private ArrayList<String> caminhos;
	private Context context;
	private ViewGroup group;

	public ListViewPreviewFolder(Context context, ArrayList<String> caminhos,
			ViewGroup group) {
		this.context = context;
		this.caminhos = caminhos;
		this.group = group;

	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public Object getItem(int position) {
		return caminhos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View lista = convertView;
		if (convertView == null) {
			lista = inflater.inflate(R.layout.list_imagens, null);
		}
		LinearLayout la = (LinearLayout) lista.findViewById(R.id.img_list_pre);

		for (int i = 0; i < caminhos.size(); i++) {
			View img = null;
			final int temp = i;
			if (caminhos.get(i).contains(".png")
					|| caminhos.get(i).contains(".PNG")
					|| caminhos.get(i).contains(".JPG")
					|| caminhos.get(i).contains(".jpg")
					|| caminhos.get(i).contains(".JPEG")
					|| caminhos.get(i).contains(".jpeg")) {
				img = new ImageView(context);

				Bitmap mBitmap = BitmapFactory.decodeFile(caminhos.get(i));
				mBitmap = Bitmap.createScaledBitmap(mBitmap, 300, 300, true);
				((ImageView) img).setImageBitmap(mBitmap);
				img.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						new LoadComponent(group).component(caminhos.get(temp));

					}
				});
				la.addView(img);

			} else if (caminhos.get(i).contains(".mp4")
					|| caminhos.get(i).contains(".MP4")) {
				img = new ImageView(context);
				Bitmap bMap = ThumbnailUtils
						.createVideoThumbnail(caminhos.get(i),
								MediaStore.Video.Thumbnails.MINI_KIND);
				((ImageView) img).setImageBitmap(bMap);
				img.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						new LoadComponent(group).component(caminhos.get(temp));

					}
				});

				la.addView(img);
			}

		}

		return lista;
	}

}
