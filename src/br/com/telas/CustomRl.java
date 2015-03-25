package br.com.telas;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;


public class CustomRl extends RelativeLayout {

	/*
	 * O método ser static sem um tipo de modificador de acesso permite sua
	 * leitura apenas dentro das classes que estão dentro do mesmo pacote.
	 */


	public CustomRl(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	public CustomRl(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public CustomRl(Context context) {
		super(context);

	}

	@Override
	public boolean isInEditMode() {

		return super.isInEditMode();

	}

	@Override
	public boolean performClick() {
		return super.performClick();
	}

	
	
}
