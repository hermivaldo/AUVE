package br.com.entidades;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.VideoView;
import br.com.slide.ActivityFragment;
import br.com.telas.R;

import com.squareup.picasso.Picasso;

public class Conteudo {

	private int idApreds;
	private int width;
	private int height;
	private float y;
	private float x;
	private byte[] background;
	private String path;
	private String className;

	static View selectedView;

	public String getPath() {
		return path;

	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getIdApreds() {
		return idApreds;
	}

	public void setIdApreds(int idApreds) {
		this.idApreds = idApreds;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public byte[] getBackground() {
		return background;
	}

	public void setBackground(byte[] background) {
		this.background = background;
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	public View getComponent(Context context) {

		View result = null;

		if (path.contains(".jpg") || path.contains(".png")
				|| path.contains(".PNG") || path.contains(".JPEG")
				|| path.contains(".jpeg") || path.contains(".JPG")
				|| path.contains(".bmp") || path.contains(".BMP")) {
			final ImageView quadrado = new ImageView(context);
			Picasso.with(context).load("file:///" + path).resize(300, 300)
					.into(quadrado);

			quadrado.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					ImageView view = new ImageView(quadrado.getContext());
					view.setImageBitmap(BitmapFactory.decodeFile(path));
					ActivityFragment.preso.setContentView(view);
					ActivityFragment.preso.show();
				}
			});
			return quadrado;

		} else if (path.contains(".3gp") || path.contains(".mp4")) {
			final ImageView img = new ImageView(context);

			Bitmap bMap = ThumbnailUtils.createVideoThumbnail(path,
					MediaStore.Video.Thumbnails.MINI_KIND);
			img.setImageResource(R.drawable.mp_logo);
			
			img.setBackground(new BitmapDrawable(context.getResources(), bMap));
			Picasso.with(context).load("file:///" + path).resize(300, 300)
			.into(img);
			
			result = img;
			img.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					VideoView vd = new VideoView(img.getContext());
					vd.setVideoPath(path);
					vd.start();
					ActivityFragment.preso.setContentView(vd);
					ActivityFragment.preso.show();
				}
			});

		}

		return result;

	}

}
