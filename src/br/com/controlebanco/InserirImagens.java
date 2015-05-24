package br.com.controlebanco;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.RelativeLayout;
import br.com.banco.ContApresDao;
import br.com.entidades.Conteudo;
import br.com.viewhierarchy.BaseAdapter;

public class InserirImagens {

	private ContApresDao db;

	public void inserirRegistros(ViewGroup group, int idApres) {
		List<Conteudo> imagens = new ArrayList<Conteudo>();
		for (int ch = 0; ch < group.getChildCount(); ch++) {
			Conteudo imagem = new Conteudo();

			/*
			 * Itens a serem obtidos os valores estavam mapeados aos objetos
			 * errados.
			 */
			imagem.setPath(group.getChildAt(ch).getTag().toString());
			imagem.setClassName(group.getChildAt(ch).getClass().getName());
			imagem.setHeight((int) (group.getChildAt(ch).getLayoutParams().height * group
					.getChildAt(ch).getScaleY()));
			imagem.setWidth((int) (group.getChildAt(ch).getLayoutParams().width * group
					.getChildAt(ch).getScaleX()));
			imagem.setY(group.getChildAt(ch).getY());
			imagem.setX(group.getChildAt(ch).getX());
			imagem.setIdApreds(idApres);
			imagens.add(imagem);

		}

		db = new ContApresDao(group.getContext());
		db.saveChamados(imagens);

	}

	public ViewGroup painel(Context context) {
		db = new ContApresDao(context);
		List<Conteudo> itens = db.getItens();
		RelativeLayout layout = new RelativeLayout(context);
		layout.setLayoutParams(new LayoutParams(-1, -1));
		for (int itPai = 0; itPai < itens.size(); itPai++) {
			Conteudo img = new Conteudo();
			img.setHeight(itens.get(itPai).getHeight());
			img.setWidth(itens.get(itPai).getWidth());
			img.setX(itens.get(itPai).getX());
			img.setY(itens.get(itPai).getY());
			img.setPath(itens.get(itPai).getPath());
			img.setClassName(itens.get(itPai).getClassName());
			layout.addView(img.getComponent(context));
		}
		return layout;
	}

	public ViewGroup painel(Context context, int idApre) {
		db = new ContApresDao(context);
		List<Conteudo> itens = db.getItens(idApre);

		GridView layout = new GridView(context);
		layout.setGravity(Gravity.CENTER);
		layout.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		layout.setNumColumns(5);
	
		BaseAdapter adapter = new BaseAdapter(context, itens);
		
		layout.setAdapter(adapter);
		layout.requestLayout();
		return layout;
	}

}
