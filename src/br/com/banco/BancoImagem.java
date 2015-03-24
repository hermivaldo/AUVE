package br.com.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoImagem extends SQLiteOpenHelper{

	private static String DATABASE = "IMAGEM";
	private static int VERSION = 1;
	
	public BancoImagem(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ApresentacoesDAO.onCreate());
		db.execSQL(ContApresDao.onCreate());
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL(ContApresDao.onUpgrade());
		db.execSQL(ApresentacoesDAO.onUpgrade());
	}

}
 