package br.com.refac;

import android.view.ViewGroup;
import br.com.controlebanco.InserirImagens;

public abstract class ViewStatica {

	/*
	 * Por mais que o layout volte para a activity faz-se a necessidade de
	 * ajustar a proporção da tela, os parâmetros de altura e largura devem ser
	 * calculados para fazer com que a pré-visualização e a edição trabalhem em
	 * conjunto.
	 */
	private static ViewGroup tela;

	public static ViewGroup getViewGroup() {
		if (tela instanceof ViewGroup) {
			ViewGroup parent = (ViewGroup) tela.getParent();
			if (parent != null) {
				parent.removeView(tela);
			}
		}
		return tela;
	}

	public static void setViewGroup(ViewGroup group) {
		tela = group;
	}

	public static ViewGroup getViewOri() {
		return tela;
	}

	public static void saveObjets(ViewGroup view) {
		tela = view;
		new InserirImagens().inserirRegistros(tela);

	}

}
