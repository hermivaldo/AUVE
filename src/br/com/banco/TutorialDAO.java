package br.com.banco;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.entidades.Configuracao;

public class TutorialDAO {

	private static String status = "status";
	private Context context;

	public TutorialDAO(Context context) {
		this.context = context;
	}

	public static String onCreate() {
		return "CREATE TABLE IF NOT EXISTS tutorial( " + status + " INTEGER)";
	}

	public static String onUpgrade(){
		return "DROP IF EXISTS tutorial";
	}
	
	public void deleteConf(){
		new BancoImagem(context).getWritableDatabase().delete("tutorial", null, null);
	}
	
	public List<Configuracao> getStatus(){
		List<Configuracao> configs = new ArrayList<Configuracao>();
		String[] columns = {status};
		SQLiteDatabase bd = new BancoImagem(context).getReadableDatabase();
		
		Cursor curso = bd.query("tutorial", columns, null, null, null, null, null);
		while (curso.moveToNext()){
			Configuracao config = new Configuracao();
			config.setStatus(curso.getColumnName(0));
			configs.add(config);
		}
		curso.close();
		bd.close();
		return configs;
	}
	
	public void insetConfig(Configuracao conf){
		BancoImagem db = new BancoImagem(context);
		ContentValues values = new ContentValues();
		values.put(status, conf.getStatus());
		db.getWritableDatabase().insert("tutorial", null, values);
		db.close();
	}

}
