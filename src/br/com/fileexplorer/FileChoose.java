package br.com.fileexplorer;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import br.com.telas.R;
import br.tcc.auve.regras.Alert;
import br.tcc.auve.regras.LoadComponent;

public class FileChoose extends ListActivity {
	private File currentDir;
	private FileAdapter adapter;
	/*
	 * Adicionada para simulação de erros que podem acontecer utilizando a
	 * activity.
	 */
	private static FileChoose actFile;

	@SuppressLint("SdCardPath")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		currentDir = new File("/sdcard/");
		fill(currentDir);
		actFile = this;
	}

	public static FileChoose getInstance() {
		return actFile;
	}

	private void fill(File f) {
		File[] dirs = f.listFiles();
		this.setTitle("Current Dir: " + f.getName());
		List<Item> dir = new ArrayList<Item>();
		List<Item> fls = new ArrayList<Item>();
		try {
			for (File ff : dirs) {
				Date lastModDate = new Date(ff.lastModified());
				DateFormat formater = DateFormat.getDateTimeInstance();
				String date_modify = formater.format(lastModDate);
				if (ff.isDirectory()) {

					File[] fbuf = ff.listFiles();
					int buf = 0;
					if (fbuf != null) {
						buf = fbuf.length;
					} else
						buf = 0;
					String num_item = String.valueOf(buf);
					if (buf == 0)
						num_item = num_item + " item";
					else
						num_item = num_item + " items";

					// String formated = lastModDate.toString();
					dir.add(new Item(ff.getName(), num_item, date_modify, ff
							.getAbsolutePath(), "directory_icon"));
				} else {
					fls.add(new Item(ff.getName(), ff.length() + " Byte",
							date_modify, ff.getAbsolutePath(), "file_icon"));
				}
			}
		} catch (Exception e) {

		}

		dir.addAll(fls);
		if (!f.getName().equalsIgnoreCase("sdcard"))
			dir.add(0, new Item("..", "Parent Directory", "", f.getParent(),
					"directory_up"));
		adapter = new FileAdapter(FileChoose.this, R.layout.list_file, dir);
		this.setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Item o = adapter.getItem(position);
		if (o.getImage().equalsIgnoreCase("directory_icon")) {
			onFileClick(o);
		} else if (o.getImage().equalsIgnoreCase("directory_up")) {
			currentDir = new File(o.getPath());
		} else {
			new Alert().alerta(actFile, "Error de seleção",
					"O conteúdo selecionado não é uma pasta");
		}
	}

	private void onFileClick(Item o) {
		if (new LoadComponent().createList(o.getPath()).size() > 0) {
			Intent intent = new Intent();
			intent.putExtra("GetPath", currentDir.toString());
			intent.putExtra("GetFileName", o.getPath());
			setResult(RESULT_OK, intent);
			finish();
		} else {

			new Alert().alerta(actFile, "Alerta Sobre pasta selecionada",
					"A pasta selecionada não contém arquivos que possam"
							+ " ser manipulados pelo aplicativo");

		}
	}

}
