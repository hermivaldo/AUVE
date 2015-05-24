package br.com.banco;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.entidades.Apresentacao;

public class ApresentacoesDAO {

	private static final String TABLE = "apresentacao";
	private static String idApre = "IdAprensentacao";
	private static String descricao = "descricao";
	private Context context;
	private String[] coluns = new String[] { idApre, descricao };

	public ApresentacoesDAO(Context context) {
		this.context = context;
	}

	public static String onCreate() {
		return "CREATE TABLE IF NOT EXISTS" + " apresentacao (" + idApre
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + descricao
				+ " TEXT NOT NULL)";
	}

	public void inserirDados(Apresentacao apr) {
		if (getApre(apr.getDescricao()).getDescricao() == null
				|| getApre(apr.getDescricao()).getDescricao().isEmpty()) {
			BancoImagem db = new BancoImagem(context);
			ContentValues values = new ContentValues();
			values.put(descricao, apr.getDescricao());
			db.getWritableDatabase().insert(TABLE, null, values);
			db.close();
		}
	}

	public ArrayList<Apresentacao> getAllApre() {
		ArrayList<Apresentacao> aprens = new ArrayList<Apresentacao>();
		SQLiteDatabase db = new BancoImagem(context).getReadableDatabase();
		Cursor curso = db.query(TABLE, coluns, null, null, null, null, null);

		while (curso.moveToNext()) {
			Apresentacao apren = new Apresentacao();
			apren.setIdApresentacao(curso.getInt(0));
			apren.setDescricao(curso.getString(1));
			aprens.add(apren);
		}

		return aprens;
	}

	public Apresentacao getApre(String desc) {
		SQLiteDatabase db = new BancoImagem(context).getReadableDatabase();
		Cursor curso = db.query(TABLE, coluns, descricao + " = ?",
				new String[] { desc }, null, null, null, null);
		if (curso != null) {
			curso.moveToNext();
		}
		Apresentacao apre = new Apresentacao();

		if (curso.getCount() > 0) {
			apre.setIdApresentacao(curso.getInt(0));
			apre.setDescricao(curso.getString(1));
		}
		return apre;
	}

	public static String onUpgrade() {
		return "DROP TABLE IF EXIST apresentacao";
	}

}
