package br.com.telas;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

public class CustomRl extends GridLayout {

	/*
	 * O método ser static sem um tipo de modificador de acesso permite sua
	 * leitura apenas dentro das classes que estão dentro do mesmo pacote.
	 */

	public CustomRl(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// setColumnWidth(5);
		setColumnCount(5);

	}

	public CustomRl(Context context, AttributeSet attrs) {
		super(context, attrs);
		setColumnCount(5);
		// setColumnWidth(5);
	}

	public CustomRl(Context context) {
		super(context);
		setColumnCount(5);
		// setColumnWidth(5);
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
