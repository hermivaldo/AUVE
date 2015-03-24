package br.com.banco;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.entidades.Conteudo;

public class ContApresDao {

	/*
	 * Colunas
	 */

	private static final String WIDTH = "WIDTH";
	private static final String HEIGHT = "HEIGHT";
	private static final String BACKGROUND = "BACKGROUND";
	private static final String Y = "Y";
	private static final String X = "X";
	private static final String ID = "id";
	private static final String IDAPRESENT = "idApre";
	private static final String CLASSNAME = "className";
	private static final String PATH = "path";
	private Context context;

	public ContApresDao(Context context) {
		this.context = context;

	}

	public static String onCreate() {
		return "CREATE TABLE IF NOT EXISTS imagens(" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + HEIGHT + " REAL,"
				+ WIDTH + " REAL,  " + Y + " REAL," + X
				+ " REAL ," + IDAPRESENT + " INTEGER, " + CLASSNAME  +" TEXT, "
					+ PATH	+ " TEXT, FOREIGN KEY( "
				+ IDAPRESENT + ") REFERENCES" + " apresentacao(idApre))";
	}

	/*
	 * Salva os chamados no banco de dados e fecha a conexão.
	 */
	public void saveChamados(List<Conteudo> imagens) {
		ContentValues values = new ContentValues();
		try {
			for (int im = 0; im < imagens.size(); im++) {

				values.put(HEIGHT, imagens.get(im).getHeight());
				values.put(WIDTH, imagens.get(im).getWidth());
				//values.put(BACKGROUND, imagens.get(im).getBackground());
				values.put(Y, imagens.get(im).getY());
				values.put(X, imagens.get(im).getX());
				values.put(IDAPRESENT, imagens.get(im).getIdApreds());
				values.put(CLASSNAME, imagens.get(im).getClassName());
				values.put(PATH, imagens.get(im).getPath());
				
				BancoImagem db = new BancoImagem(context);
				db.getWritableDatabase().insert("imagens", null, values);
				db.close();
			}
		} catch (Exception e) {
			Log.e("ERRO SQLLITE", e.toString());
		}

	}

	public static String onUpgrade() {
		return "DROP TABLE IF EXISTS imagens";
	}

	/*
	 * Retorna todos os itens registrados dentro do banco de dados.
	 */
	public List<Conteudo> getItens() {
		List<Conteudo> itens = new ArrayList<Conteudo>();
		String[] values = { HEIGHT, WIDTH, X, Y, PATH, CLASSNAME };
		SQLiteDatabase db = new BancoImagem(context).getReadableDatabase();
		Cursor curso = db
				.query("imagens", values, null, null, null, null, null);

		while (curso.moveToNext()) {
			Conteudo imagem = new Conteudo();

			imagem.setHeight(curso.getInt(0));
			imagem.setWidth(curso.getInt(1));
			//imagem.setBackground(curso.getBlob(2));
			imagem.setX(curso.getFloat(2));
			imagem.setY(curso.getFloat(3));
			imagem.setPath(curso.getString(4));
			imagem.setClassName(curso.getString(5));
			itens.add(imagem);
		}
		curso.close();
		db.close();
		return itens;
	}

	public List<Conteudo> getItens(int idApre) {
		List<Conteudo> itens = new ArrayList<Conteudo>();
		String[] values = { HEIGHT, WIDTH, X, Y , PATH, CLASSNAME };
		SQLiteDatabase db = new BancoImagem(context).getReadableDatabase();
		Cursor curso = db
				.query("imagens", values, IDAPRESENT +" =?", new String[]{String.valueOf(idApre)},
						null, null, null);

		while (curso.moveToNext()) {
			Conteudo imagem = new Conteudo();
			imagem.setHeight(curso.getInt(0));
			imagem.setWidth(curso.getInt(1));
			//imagem.setBackground(curso.getBlob(2));
			imagem.setX(curso.getFloat(2));
			imagem.setY(curso.getFloat(3));
			imagem.setPath(curso.getString(4));
			imagem.setClassName(curso.getString(5));
			itens.add(imagem);
		}
		curso.close();
		db.close();
		return itens;
	}

}
