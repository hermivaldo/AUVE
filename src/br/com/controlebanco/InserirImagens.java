package br.com.controlebanco;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import br.com.banco.ImagensDao;
import br.com.entidades.Imagem;

public class InserirImagens {

	private ImagensDao db;

	public void inserirRegistros(ViewGroup group, int idApres) {
		List<Imagem> imagens = new ArrayList<Imagem>();
		for (int ch = 0; ch < group.getChildCount(); ch++) {
			Imagem imagem = new Imagem();

			imagem.setBackground(getImage(((ImageView) group.getChildAt(ch))
					.getDrawable()));
			imagem.setHeight(group.getLayoutParams().height);
			imagem.setWidth(group.getLayoutParams().width);
			imagem.setY(group.getY());
			imagem.setX(group.getX());
			imagem.setIdApreds(idApres);
			imagens.add(imagem);
			

		}

		db = new ImagensDao(group.getContext());
		db.saveChamados(imagens);
		
	}

	private byte[] getImage(Drawable drawable) {
		BitmapDrawable draw = (BitmapDrawable) drawable;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bm = draw.getBitmap();
		bm.compress(Bitmap.CompressFormat.PNG, 50, stream);
		return stream.toByteArray();
	}

	public ViewGroup painel(Context context) {
		db = new ImagensDao(context);
		List<Imagem> itens = db.getItens();
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
		for (int itPai = 0; itPai < itens.size(); itPai++) {
			Imagem img = new Imagem();
			img.setBackground(itens.get(itPai).getBackground());
			img.setHeight(itens.get(itPai).getHeight());
			img.setWidth(itens.get(itPai).getWidth());
			img.setX(itens.get(itPai).getX());
			img.setY(itens.get(itPai).getY());
			layout.addView(img.getImagem(context));
		}
		return layout;
	}
	
	public ViewGroup painel(Context context, int idApre) {
		db = new ImagensDao(context);
		List<Imagem> itens = db.getItens(idApre);
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
		for (int itPai = 0; itPai < itens.size(); itPai++) {
			Imagem img = new Imagem();
			img.setBackground(itens.get(itPai).getBackground());
			img.setHeight(itens.get(itPai).getHeight());
			img.setWidth(itens.get(itPai).getWidth());
			img.setX(itens.get(itPai).getX());
			img.setY(itens.get(itPai).getY());
			layout.addView(img.getImagem(context));
		}
		return layout;
	}

}
