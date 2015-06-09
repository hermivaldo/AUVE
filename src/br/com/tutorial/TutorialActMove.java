package br.com.tutorial;

import android.app.Activity;
import br.com.telas.R;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionItemTarget;

public class TutorialActMove implements OnShowcaseEventListener{

	private Activity activity;

	public TutorialActMove(Activity activity) {
		this.activity = activity;
		
		new ShowcaseView.Builder(activity)
		.setTarget(new ActionItemTarget(activity, R.id.adicionar))		
		.setContentTitle("Adicionar itens para apresentação")
		.setStyle(R.style.Theme_Auve)
		.setContentText(
				"Através deste botão será possível especificar qual a pasta"
				+ " em que se encontra os arquivos que serão vinculados a apresentação."
				+ "").hideOnTouchOutside()
						.setShowcaseEventListener(this).build();
	}

	@Override
	public void onShowcaseViewHide(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
		new ShowcaseView.Builder(activity)
		.setTarget(new ActionItemTarget(activity,R.id.remover))
		.setContentTitle("Remoção de conteúdos")
		.setStyle(R.style.Theme_Auve)
		.setContentText(
				"Caso considere que o item não deveria está na apresetação selecione e logo"
				+ " após precione este botão.")
						.hideOnTouchOutside().setShowcaseEventListener(new OnShowcaseEventListener() {
							
							@Override
							public void onShowcaseViewShow(ShowcaseView showcaseView) {
								
								
							}
							
							@Override
							public void onShowcaseViewHide(ShowcaseView showcaseView) {
								new ShowcaseView.Builder(activity)
								.setTarget(new ActionItemTarget(activity,R.id.salvar))
								.setContentTitle("Salvar conteúdos")
								.setStyle(R.style.Theme_Auve)
								.setContentText(
										"Depois de ter adicionado todos os conteúdos necessários, de um nome"
										+ " para sua apresentação e a salve no sistema.")
												.hideOnTouchOutside().build();
								
							}
							
							@Override
							public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
								// TODO Auto-generated method stub
								
							}
						}).build();
	}

	@Override
	public void onShowcaseViewShow(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub
		
	}
}
