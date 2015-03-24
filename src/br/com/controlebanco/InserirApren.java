package br.com.controlebanco;

import java.util.ArrayList;

import android.content.Context;
import br.com.banco.ApresentacoesDAO;
import br.com.entidades.Apresentacao;
import br.com.refac.ViewStatica;

public class InserirApren {

	private Context context;

	public InserirApren(Context context) {
		this.context = context;
	}
	
	public void inserirApre(String descricao){
		Apresentacao apresentacao = new Apresentacao();
		apresentacao.setDescricao(descricao);
		ApresentacoesDAO db = new ApresentacoesDAO(context);
		db.inserirDados(apresentacao);
		Apresentacao apre = db.getApre(descricao);
		ViewStatica.saveObjets(apre.getIdApresentacao());
	}
	
	public ArrayList<Apresentacao> getAllApre(){
		return new ApresentacoesDAO(context).getAllApre();
	}
	
}
