package br.com.tutorial;

import android.app.Activity;
import br.com.telas.R;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class TutorialTelaPrinc implements OnShowcaseEventListener{

	
	private Activity activity;

	public TutorialTelaPrinc(Activity activity) {
		this.activity = activity;
		
		new ShowcaseView.Builder(activity)
		.setTarget(new ViewTarget(R.id.touch, activity))
		.setContentTitle("Criar apresentações")
		.setStyle(R.style.Theme_Auve)
		.setContentText(
				"Aqui será possível criar qualquer aplicação utilizando"
						+ " imagens e vídeos").hideOnTouchOutside()
						.setShowcaseEventListener(this).build();
	}
	
	@Override
	public void onShowcaseViewHide(ShowcaseView showcaseView) {
		new ShowcaseView.Builder(activity)
		.setTarget(new ViewTarget(R.id.apresentacao, activity))
		.setContentTitle("Visualizar Apresentações")
		.setStyle(R.style.Theme_Auve)
		.setContentText(
				"Após criar suas apresentações selecione essa opção para verificar"
						+ " os trabalhos que foram criados")
						.hideOnTouchOutside().setShowcaseEventListener(new OnShowcaseEventListener() {
							
							@Override
							public void onShowcaseViewShow(ShowcaseView showcaseView) {
								// TODO Auto-generated method stub
								
							}
							
							@Override
							public void onShowcaseViewHide(ShowcaseView showcaseView) {
								new ShowcaseView.Builder(activity)
								.setTarget(new ViewTarget(R.id.opcoes, activity))
								.setContentTitle("Opções do aplicativo")
								.setStyle(R.style.Theme_Auve)
								.setContentText(
										"Selecione algumas opções ferentes as configurações do aplicativo.")
												.hideOnTouchOutside().build();
								
							}
							
							@Override
							public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
								// TODO Auto-generated method stub
								
							}
						}).build();
		
	}

	@Override
	public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
		
		
	}

	@Override
	public void onShowcaseViewShow(ShowcaseView showcaseView) {
		
		
	}

}
