package br.com.entidades;

import java.io.ByteArrayOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import br.com.refac.CustomImgView;
import br.com.refac.ImagemCirculo;

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

	public View getImagem(Context context){
		if (className.equals(ImagemCirculo.class.getName())){
			ImagemCirculo circulo = new ImagemCirculo(context);
			circulo.setLayoutParams(new LayoutParams(getWidth(),getHeight()));
			circulo.setX(getX());
			circulo.setY(getY());
			Bitmap map = BitmapFactory.decodeFile(path);
			map.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
			circulo.setImageBitmap(map);
			return circulo;
		}else if (className.equals(CustomImgView.class.getName())){
			CustomImgView quadrado = new CustomImgView(context);
			quadrado.setLayoutParams(new LayoutParams(getWidth(),getHeight()));
			quadrado.setX(getX());
			quadrado.setY(getY());
			Bitmap map = BitmapFactory.decodeFile(path);
			map.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
			quadrado.setImageBitmap(map);
			return quadrado;
		}
		
		return null;
	}
	
//	public ImageView getImagem(Context context) {
//		
//		ImageView view = new ImageView(context);
//		view.setLayoutParams(new LayoutParams(getWidth(),getHeight()));
//		view.setX(getX());
//		view.setY(getY());
//
//		//view.setLayoutParams(new LayoutParams(width, height));
//		Bitmap bitmap = BitmapFactory.decodeByteArray(background, 0,
//				background.length);
//		
//		view.setImageBitmap(bitmap);
//		return view;
//	}
}
