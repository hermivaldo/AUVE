package br.tcc.auve.regras;

import java.io.File;
import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.VideoView;
import br.com.telas.ActMove;

public class LoadComponent implements OnClickListener{

	private ViewGroup group;
	
	public LoadComponent(ViewGroup group) {
		this.group = group;
	}

	public LoadComponent() {

	}

	public void component(String comp) {
		if (comp.contains(".jpg") || comp.contains(".pgn")
				|| comp.contains(".PNG") || comp.contains(".JPG")
				|| comp.contains(".JPEG") || comp.contains(".jpeg")
				|| comp.contains(".bmp") || comp.contains(".BMP")) {
			ImageView view = (ImageView) new ImageView(group.getContext());

			view.setTag(comp);
			view.setScaleType(ImageView.ScaleType.FIT_XY);
			Bitmap mBitmap = BitmapFactory.decodeFile(comp);
			
			mBitmap = Bitmap.createScaledBitmap(mBitmap, 300, 300, true);
			view.setImageBitmap(mBitmap);
			view.setLayoutParams(new LayoutParams(200, 200));
			view.setOnClickListener(this);
			group.addView(view);

		} else if (comp.contains(".3gp") || comp.contains(".mp4")) {
			ImageView img = new ImageView(group.getContext());
			Bitmap bMap = ThumbnailUtils
					.createVideoThumbnail(comp,
							MediaStore.Video.Thumbnails.MICRO_KIND);
			((ImageView) img).setImageBitmap(bMap);
			((ImageView) img).setTag(comp);
			group.addView(img);
		}
	}

	public ArrayList<String> createList(String path) {
		File file = new File(path);
		File[] dirs = file.listFiles();
		ArrayList<String> caminhos = new ArrayList<String>();
		try {
			for (File tmpFile : dirs) {
				if (!tmpFile.isDirectory()) {
					if (tmpFile.getPath().contains(".png")
							|| tmpFile.getPath().contains(".PNG")
							|| tmpFile.getPath().contains(".JPG")
							|| tmpFile.getPath().contains(".jpg")
							|| tmpFile.getPath().contains(".JPEG")
							|| tmpFile.getPath().contains(".jpeg")
							|| tmpFile.getPath().contains(".mp4")
							|| tmpFile.getPath().contains(".MP4")
							|| tmpFile.getPath().contains(".3gp")
							|| tmpFile.getPath().contains(".3GP")) {
						caminhos.add(tmpFile.getAbsolutePath());
					}
				}
			}
		} catch (Exception e) {
			Log.e("Falha ao abrir caminho", e.toString());
		}
		return caminhos;
	}

	@Override
	public void onClick(View v) {
		ActMove.mViewSelected = v;
	}

}
