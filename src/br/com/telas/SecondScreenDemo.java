package br.com.telas;

import com.hermivaldo.projetodraw.R;

import android.annotation.SuppressLint;
import android.app.Presentation;
import android.content.Context;
import android.view.Display;

@SuppressLint("NewApi")
public class SecondScreenDemo extends Presentation {

	public SecondScreenDemo(Context outerContext, Display display) {
		super(outerContext, display);
		setContentView(R.layout.act_draw);
	}

}
