package br.com.entidades;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import br.com.slide.ActivityFragment;

public class Conteudo {

	private int idApreds;
	private int width;
	private int height;
	private float y;
	private float x;
	private byte[] background;
	private String path;
	private String className;

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

		if(path.contains(".jpg")){
			final ImageView quadrado = new ImageView(context);
			quadrado.setLayoutParams(new LayoutParams(getWidth(), getHeight()));
			quadrado.setX(getX());
			quadrado.setY(getY());
			final Bitmap map = BitmapFactory.decodeFile(path);
			quadrado.setImageBitmap(map);
			
			quadrado.setOnClickListener(new OnClickListener() {
				
				
				@Override
				public void onClick(View arg0) {
					ImageView view = new ImageView(quadrado.getContext());
					view.setImageBitmap(map);
					ActivityFragment.preso.setContentView(view);
					ActivityFragment.preso.show();
				}
			});
			return quadrado;
			
		}else if (path.contains(".3gp")) {
			final VideoView video = new VideoView(context);
			final MediaController controller = new MediaController(context);
			video.setMediaController(controller);
			video.setLayoutParams(new LayoutParams(getWidth(), 
					getHeight()));
			video.setVideoPath(path);
			video.setY(getY());
			video.setX(getX());
			video.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View arg0, MotionEvent arg1) {
					VideoView vd = new VideoView(video.getContext());
					vd.setVideoPath(path);
					vd.setMediaController(controller);
					//vd.start();
					ActivityFragment.preso.setContentView(vd);
					ActivityFragment.preso.show();
					return false;
				}
			});
		
			
			return video;
		}
		
		return null;

	}

}