package br.com.entidades;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class Imagens {
	private int width;
	private int height;
	private float y;
	private float x;
	private byte[] background;

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
	
	public ImageView getImagem(Context context){
		ImageView view = new ImageView(context);
		view.setX(getX());
		view.setY(getY());
		
		view.setLayoutParams(new LayoutParams(width, height));
		Bitmap bitmap = BitmapFactory.decodeByteArray(background, 0, background.length);
		view.setImageBitmap(bitmap);
		return view;
	}
}
