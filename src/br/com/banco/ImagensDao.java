package br.com.banco;

import java.util.ArrayList;
import java.util.List;

import br.com.entidades.Imagens;
import br.com.fileexplorer.Item;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ImagensDao extends SQLiteOpenHelper{

	/*
	 * Tabela e Versão
	 */
	private static final String DATABASE = "imagens";
	private static final int VERSION = 1;
	
	/*
	 * Colunas
	 */
	private final String WIDTH = "WIDTH";
	private final String HEIGHT = "HEIGHT";
	private final String BACKGROUND = "BACKGROUND";
	private final String Y = "Y";
	private final String X = "X";
	private final String ID = "id";
	
	public ImagensDao(Context context) {
		super(context, DATABASE, null, VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddl = "CREATE TABLE imagens("+ ID + "int, " + HEIGHT +" int,"
				+ WIDTH +" int,  " + BACKGROUND + " BLOB," + Y +" FLOAT,"+ X + " FLOAT)";
		db.execSQL(ddl);
	}

	/*
	 * Salva os chamados no banco de dados e fecha a conexão.
	 */
	public void saveChamados(List<Imagens> imagens){
		ContentValues values = new ContentValues();
		try {
			for (int im = 0; im < imagens.size(); im++){
				values.put(ID, 1);
				values.put(HEIGHT, imagens.get(im).getHeight());
				values.put(WIDTH, imagens.get(im).getWidth());
				values.put(BACKGROUND, imagens.get(im).getBackground());
				values.put(Y, imagens.get(im).getY());
				values.put(X, imagens.get(im).getX());
				
				
				getWritableDatabase().insert(DATABASE, null, values);
			}
		} catch (Exception e) {
			Log.e("ERRO SQLLITE", e.toString());
		}
		
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String ddl = "DROP TABLE IF EXISTS imagens";
		db.execSQL(ddl);
		onCreate(db);
	}
	
	/*
	 * Retorna todos os itens registrados dentro do banco de dados.
	 */
	public List<Imagens> getItens(){
		List<Imagens> itens = new ArrayList<Imagens>();
		String[] values = {HEIGHT,WIDTH,BACKGROUND,X,Y};
		SQLiteDatabase db = getReadableDatabase();
		Cursor curso = db.query(DATABASE, values, null, null, null, null, null);
		
		while (curso.moveToNext()) {
			Imagens imagem = new Imagens();
			
			imagem.setHeight(curso.getInt(0));
			imagem.setWidth(curso.getInt(1));
			imagem.setBackground(curso.getBlob(2));
			imagem.setX(curso.getFloat(3));
			imagem.setY(curso.getFloat(4));
			itens.add(imagem);
		}
		
		db.close();
		return itens;
	}

}
