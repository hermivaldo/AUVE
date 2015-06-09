package br.com.telas;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.banco.TutorialDAO;
import br.com.controlebanco.InserirApren;
import br.com.entidades.Configuracao;
import br.com.fileexplorer.FileChoose;
import br.com.refac.ViewStatica;
import br.com.tutorial.TutorialActMove;
import br.tcc.auve.comple.ListViewPreviewFolder;
import br.tcc.auve.regras.Alert;
import br.tcc.auve.regras.LoadComponent;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity {

	public static final int REQUEST_PATH = 1;
	
	public static View mViewSelected;

	public static DrawerLayout mDrawerLayout;
	private Menu menu;

	private String identApresent = "";

	TutorialDAO tdDAO;
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle) Adicionar objetos
	 * dinamicamente na tela do dispositivo
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.la_actmove);
		tdDAO = new TutorialDAO(this);
		
		if (tdDAO.getStatus().size() == 0){
			new TutorialActMove(this);
		}
		
	}

	@Override
	protected void onResume() {

		super.onResume();
	
		if (ViewStatica.getViewGroup() instanceof ViewGroup) {
			ViewGroup pai = (ViewGroup) findViewById(R.id.reP);
			pai.addView(ViewStatica.getViewOri());
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		this.menu = menu;
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.adicionar:
			Intent intent1 = new Intent(this, FileChoose.class);
			startActivityForResult(intent1, REQUEST_PATH);

			break;
		case R.id.remover:
			if (mViewSelected instanceof View) {
				ViewGroup parent = (ViewGroup) mViewSelected.getParent();
				parent.removeView(mViewSelected);
				mViewSelected = null;
			}
			break;
		case R.id.salvar:
			/*
			 * Alterado para dentro da classe responsável pela confirmação de
			 * salvar para evitar que o conteúdo venha a mudar caso o processo
			 * seje cancelado.
			 */

			alertSalvar(item);
			break;
		case R.id.atualizar:
			new Alert().alerta(this, "Salvar Apresentação",
					"A apresentação está sendo " + "salva no dispositivo.");
			alertSalvar(item);
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_PATH) {
			if (resultCode == RESULT_OK) {

				ArrayList<String> caminhos = new LoadComponent()
						.createList(data.getStringExtra("GetFileName"));

				ListViewPreviewFolder baseList = new ListViewPreviewFolder(
						this, caminhos, (ViewGroup) findViewById(R.id.tela));

				ListView lista = (ListView) findViewById(R.id.lista_img_pre);
				lista.setAdapter(baseList);

			}
		}
	}

	private void alertSalvar(final MenuItem item) {
		final EditText text = new EditText(getBaseContext());
		if (((ViewGroup) findViewById(R.id.tela)).getChildCount() == 0) {
			Toast.makeText(
					getApplicationContext(),
					"Não é possível salvar"
							+ " apresentação, pois não existe conteúdo para armazenar..",
					Toast.LENGTH_LONG).show();
		} else if (identApresent.isEmpty()) {

			new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK)
					.setTitle("Salvar Apresentação")
					.setMessage("Informe o nome da apresentação que foi criada")
					.setView(text)
					.setPositiveButton("Salvar", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

							ViewStatica
									.setViewGroup((ViewGroup) findViewById(R.id.tela));
							InserirApren inserAp = new InserirApren(
									ActMove.this);
							// Definir o nome da apresentação para ser
							// localizada,
							// depois
							// para poder realizar o Update da apresentação.
							identApresent = text.getText().toString();
							inserAp.inserirApre(identApresent);
							// Remove e adiciona o conteúdo apenas se salvo
							// no
							// sistema.
							item.setVisible(false);
							menu.getItem(3).setVisible(true);
							
							/*
							 * Controle de menu, após salvar a primeira vez, 
							 * o sistema deixa de apresentar o sistema de menu
							 */
							TutorialDAO dao = new TutorialDAO(ActMove.this);
							dao.insetConfig(new Configuracao("1"));

						}
					}).setNegativeButton("Cancelar", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					}).show();
		} else {
			ViewStatica.setViewGroup((ViewGroup) findViewById(R.id.tela));
			InserirApren inserAp = new InserirApren(ActMove.this);
			inserAp.inserirApre(identApresent);
		}

	}

	@Override
	public void onBackPressed() {
		((ViewGroup) findViewById(R.id.tela)).removeAllViews();
		super.onBackPressed();
	}
	
}
