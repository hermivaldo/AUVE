package br.tcc.auve.regras;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class Alert {

	public void alerta(Context context, String titulo, String mensagem) {
		new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_DARK)
				.setTitle(titulo).setMessage(mensagem)
				.setPositiveButton("Ok", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {

					}

				}).show();
	}
}
