package br.com.controlebanco;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import br.com.banco.ContApresDao;
import br.com.entidades.Conteudo;

public class InserirImagens {

	private ContApresDao db;

	public void inserirRegistros(ViewGroup group, int idApres) {
		List<Conteudo> imagens = new ArrayList<Conteudo>();
		for (int ch = 0; ch < group.getChildCount(); ch++) {
			Conteudo imagem = new Conteudo();

//			imagem.setBackground(getImage(((ImageView) group.getChildAt(ch))
//					.getDrawable()));
		/*
			 * Itens a serem obtidos os valores estavam mapeados aos objetos
			 * errados.
			 */
			imagem.setPath(group.getChildAt(ch).getTag().toString());
			imagem.setClassName(group.getChildAt(ch).getClass().getName());
			imagem.setHeight(group.getChildAt(ch).getLayoutParams().height);
			imagem.setWidth(group.getChildAt(ch).getLayoutParams().width);
			imagem.setY(group.getChildAt(ch).getY());
			imagem.setX(group.getChildAt(ch).getX());
			imagem.setIdApreds(idApres);
			imagens.add(imagem);
			

		}

		db = new ContApresDao(group.getContext());
		db.saveChamados(imagens);
		
	}

//	private byte[] getImage(Drawable drawable) {
//		BitmapDrawable draw = (BitmapDrawable) drawable;
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		Bitmap bm = draw.getBitmap();
//		bm.compress(Bitmap.CompressFormat.PNG, 50, stream);
//		return stream.toByteArray();
//	}

	public ViewGroup painel(Context context) {
		db = new ContApresDao(context);
		List<Conteudo> itens = db.getItens();
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
		for (int itPai = 0; itPai < itens.size(); itPai++) {
			Conteudo img = new Conteudo();
//			img.setBackground(itens.get(itPai).getBackground());
			img.setHeight(itens.get(itPai).getHeight());
			img.setWidth(itens.get(itPai).getWidth());
			img.setX(itens.get(itPai).getX());
			img.setY(itens.get(itPai).getY());
			img.setPath(itens.get(itPai).getPath());
			img.setClassName(itens.get(itPai).getClassName());
			layout.addView(img.getImagem(context));
		}
		return layout;
	}
	
	public ViewGroup painel(Context context, int idApre) {
		db = new ContApresDao(context);
		List<Conteudo> itens = db.getItens(idApre);
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
		for (int itPai = 0; itPai < itens.size(); itPai++) {
			Conteudo img = new Conteudo();
//			img.setBackground(itens.get(itPai).getBackground());
			img.setHeight(itens.get(itPai).getHeight());
			img.setWidth(itens.get(itPai).getWidth());
			img.setX(itens.get(itPai).getX());
			img.setY(itens.get(itPai).getY());
			img.setPath(itens.get(itPai).getPath());
			img.setClassName(itens.get(itPai).getClassName());
			layout.addView(img.getImagem(context));
		}
		return layout;
	}

}
