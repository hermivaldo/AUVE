package br.com.telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import br.com.slide.ActivityFragment;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

public class TelaPrincipal extends Activity implements OnShowcaseEventListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		apresentacoes();

	}

	private void apresentacoes() {

		ViewTarget targTouch = new ViewTarget(R.id.touch, this);
		new ShowcaseView.Builder(this)
				.setTarget(targTouch)
				.setContentTitle("Criar apresentações")
				.setStyle(R.style.Theme_Auve)
				.setContentText(
						"Aqui será possível criar qualquer aplicação utilizando"
								+ " imagens e vídeos").hideOnTouchOutside()
				.setShowcaseEventListener(this).build();

	}

	public void iniciar(View view) {
		startActivity(new Intent(this, ActMove.class));
	}

	public void visulizarApre(View view) {
		startActivity(new Intent(this, ActivityFragment.class));
	}

	@Override
	public void onShowcaseViewHide(ShowcaseView showcaseView) {
		ViewTarget targapresent = new ViewTarget(R.id.apresentacao, this);
		new ShowcaseView.Builder(this)
				.setTarget(targapresent)
				.setContentTitle("Visualizar Apresentações")
				.setStyle(R.style.Theme_Auve)
				.setContentText(
						"Após criar suas apresentações selecione essa opção para verificar"
								+ " os trabalhos que foram criados")
				.hideOnTouchOutside().build();

	}

	@Override
	public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onShowcaseViewShow(ShowcaseView showcaseView) {
		// TODO Auto-generated method stub

	}

}
