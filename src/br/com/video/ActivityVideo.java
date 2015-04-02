package br.com.video;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import br.com.fileexplorer.FileChoose;
import br.com.refac.ViewStatica;
import br.com.telas.ActMove;
import br.com.telas.R;
import br.com.telas.TelaPreView;

public class ActivityVideo extends Activity {

	private CustomVideoView video;
	private MediaController controller;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text_view);
		ViewGroup mGroup = (ViewGroup) findViewById(R.id.tempV);
		controller = new MediaController(this);
		video = new CustomVideoView(this);
		video.setLayoutParams(new LayoutParams(50, 50));
		
		mGroup.addView(video);
		
	}
//	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
////		int plano_fundo_x = (int) event.getX();
////		int plano_fundo_y = (int) event.getY();
////
////		int plano_fundo_objeto_x = (int) this.video.getX();
////		int plano_fundo_objeto_y = (int) this.video.getY();
////
////		ViewGroup mGroup = (ViewGroup) getLayoutInflater().inflate(
////				R.layout.text_view, null);
////
////		this.video = (VideoView) mGroup.findViewById(R.id.testVideo);
////
////		this.video.getLayoutParams().height = plano_fundo_y;
////		this.video.getLayoutParams().width = plano_fundo_x;
////
////		this.video.setX(plano_fundo_objeto_x);
////		this.video.setY(plano_fundo_objeto_y);
////
//
//		
//		this.video.setOnTouchListener(new OnTouchListener() {
//
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//
//				int x = (int) event.getX();
//				int y = (int) event.getY();
//
//				event.getEdgeFlags();
//
//
//				if (event.getAction() == MotionEvent.ACTION_MOVE) {
//
//					
//					
//					int velocidade = 0;
//					int velocidadeY =  0;
//					if (x > 0){
//						velocidade = (x - (ActivityVideo.this.video.getWidth() / 2 ));
//					}else{
//						velocidade *= -1 ;
//					}
//					if (y > 0){
//						velocidadeY = (y - (ActivityVideo.this.video.getHeight() / 2 ));
//					}else{
//						velocidadeY *= -1 ;
//					}
//					
//					
//					if (x > ActivityVideo.this.video.getWidth() / 2) {
//						ActivityVideo.this.video.setX(ActivityVideo.this.video
//								.getX() + velocidade);
//					}
//					if (x < ActivityVideo.this.video.getWidth() / 2) {
//						ActivityVideo.this.video.setX(ActivityVideo.this.video
//								.getX() - (-velocidade));
//					}
//					
//					if (y > ActivityVideo.this.video.getHeight() / 2) {
//						ActivityVideo.this.video.setY(ActivityVideo.this.video
//								.getY() + velocidadeY);
//					}
//					
//					if (y < ActivityVideo.this.video.getHeight() / 2) {
//						ActivityVideo.this.video.setY(ActivityVideo.this.video
//								.getY() - (-velocidadeY));
//					}
//	
//
//				}
//
//				return false;
//			}
//		});
//		;
//
////		this.setContentView(mGroup);
//		return false;
//	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.adicionar:
			Intent intent1 = new Intent(this, FileChoose.class);
			startActivityForResult(intent1, ActMove.REQUEST_PATH);
			break;
		case R.id.visu:
			ViewStatica.setViewGroup((ViewGroup) findViewById(R.id.tela));
			Intent intent = new Intent(this,TelaPreView.class);
			startActivity(intent);
//			TODO faz-se a necessidade de criar um validador
//			da entrada HDMI para utilização desse processo.
//			preso.setContentView(tela);
//			preso.show();
			break;
		case R.id.salvar:
			
//			ViewStatica.saveObjets((ViewGroup) findViewById(R.id.tela));
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// super.onActivityResult(requestCode, resultCode, data);
		
			

//				Bitmap map = BitmapFactory.decodeFile(data
//						.getStringExtra("GetFileName"));
				video.setMediaController(controller);
				video.setVideoPath(data
						.getStringExtra("GetFileName"));
				
//				map.compress(Bitmap.CompressFormat.PNG, 50, new ByteArrayOutputStream());
//				((ImageView) CustomRl.touch).setImageBitmap(map);
				//((ImageView) CustomRl.touch).setBackground(null);
			
		
	}
	
	
}
