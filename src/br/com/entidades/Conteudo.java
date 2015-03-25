package br.com.entidades;

import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import br.com.refac.CustomImgView;
import br.com.refac.ImagemCirculo;
import br.com.telas.ActMove;
import br.tcc.auve.comple.ViewGestory;

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

	public View getComponent(Context context) {

		if(path.contains(".jpg")){
			ViewGestory quadrado = new ViewGestory(context);
			quadrado.setLayoutParams(new LayoutParams(getWidth(), getHeight()));
			quadrado.setX(getX());
			quadrado.setY(getY());
			Bitmap map = BitmapFactory.decodeFile(path);
			//map.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
			quadrado.setImageBitmap(map);
			return quadrado;
			
		}else if (path.contains(".3gp")) {
			VideoView video = new VideoView(context);
			MediaController controller = new MediaController(context);
			video.setMediaController(controller);
			video.setLayoutParams(new LayoutParams(getWidth(), 
					getHeight()));
			video.setVideoPath(path);
			video.setY(getY());
			video.setX(getX());
			
			return video;
		}
		
		return null;

	}

}
