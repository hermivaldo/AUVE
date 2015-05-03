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
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.auve.menu.NavDrawItem;
import br.com.auve.menu.NavDrawerListAdapter;
import br.com.controlebanco.InserirApren;
import br.com.fileexplorer.FileChoose;
import br.com.refac.ViewStatica;
import br.tcc.auve.regras.LoadComponent;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

@SuppressWarnings("deprecation")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActMove extends Activity {

	public static final int REQUEST_PATH = 1;
	private ViewGroup mGroup;
	public static View mViewSelected;

	public static DrawerLayout mDrawerLayout;
	private ListView mList;

	private ActionBarDrawerToggle mDrawerToggle;
	private Menu menu;

	private String identApresent;
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle) Adicionar objetos
	 * dinamicamente na tela do dispositivo
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		mGroup = (ViewGroup) findViewById(android.R.id.content);

		getLayoutInflater().inflate(R.layout.la_actmove,
				mGroup);

		ViewTarget target = new ViewTarget(findViewById(R.id.left_drawer));
		new ShowcaseView.Builder(this).setTarget(target)
				.setContentTitle("Imagem e Vídeo.").setContentText("Essa opção"
						+ " permite que vídeo e imagens possam ser adicionadas à "
						+ "sua apresentação")
				.hideOnTouchOutside().build();

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mList = (ListView) findViewById(R.id.left_drawer);

		ArrayList<NavDrawItem> list = new ArrayList<NavDrawItem>();
		list.add(new NavDrawItem("Mundo"));

		NavDrawerListAdapter adapter = new NavDrawerListAdapter(this, list);

		mList.setAdapter(adapter);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_launcher, R.string.app_name, R.string.app_name) {
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mDrawerLayout.openDrawer(Gravity.START);

	}

	@Override
	protected void onResume() {

		super.onResume();
		/*
		 * Permite a verificação apenas se for uma instância de ViewGroup o
		 * elemento static não pode ser utilizado antes de alguma opção do menu
		 * ter sido chamada. O fato de utilizar dois && fazem com que se a
		 * primeira opção for falsa a não execute a próxima.
		 */
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
			if (mViewSelected instanceof View){
				Intent intent1 = new Intent(this, FileChoose.class);
				startActivityForResult(intent1, REQUEST_PATH);
			}
			break;
		case R.id.remover:
			if (mViewSelected instanceof View){
				ViewGroup parent = (ViewGroup) mViewSelected.getParent();
				parent.removeView(mViewSelected);
				mViewSelected = null;
			}		
			break;
		case R.id.salvar:
			/*
			 * Alterado para dentro da classe
			 * responsável pela confirmação de salvar
			 * para evitar que o conteúdo venha a mudar caso o 
			 * processo seje cancelado.
			 */
			
			alertSalvar(item);
			break;
		case R.id.atualizar:
			// TODO Implementar lógica para atualizar conteúdo
			Toast.makeText(this, "O nome da apresentação é : " + identApresent, Toast.LENGTH_SHORT).show();
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

				new LoadComponent((ViewGroup) findViewById(R.id.tela))
						.component(data.getStringExtra("GetFileName"));

			}
		}
	}

	private void alertSalvar(final MenuItem item) {
		final EditText text = new EditText(getBaseContext());

		new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_DARK).setTitle("Salvar Apresentação")
				.setMessage("Informe o nome da apresentação que foi criada")
				.setView(text)
				.setPositiveButton("Salvar", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						ViewStatica
								.setViewGroup((ViewGroup) findViewById(R.id.tela));
						InserirApren inserAp = new InserirApren(ActMove.this);
						// Definir o nome da apresentação para ser localizada, depois
						// para poder realizar o Update da apresentação.
						identApresent = text.getText().toString();
						inserAp.inserirApre(identApresent);
						// Remove e adiciona o conteúdo apenas se salvo no sistema.
						item.setVisible(false);
						menu.getItem(3).setVisible(true);
						
					}
				}).setNegativeButton("Cancelar", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

					}
				})
				.show();
	}

}
