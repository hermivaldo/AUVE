package br.tcc.auve.regras;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import br.com.telas.ActMove;

public class LoadComponent {

	private ViewGroup group;

	public LoadComponent(ViewGroup group) {
		this.group = group;
	}
	
	
	public void component(String comp){
		if (comp.contains(".jpg") || comp.contains(".pgn")){
			ImageView view = (ImageView) ActMove.mViewSelected;
			
			view.setBackground(null);
			view.setTag(comp);
			Bitmap mBitmap = BitmapFactory.decodeFile(comp);
			mBitmap = Bitmap.createScaledBitmap(mBitmap, 300, 300, true);
			view.setImageBitmap(mBitmap);
			
		}
		else if (comp.contains(".3gp") || comp.contains(".mp4")){
			VideoView video = new VideoView(group.getContext());
			MediaController controller = new MediaController(ActMove.mViewSelected.getContext());
			video.setMediaController(controller);
			controller.setAnchorView(video);
			video.setLayoutParams(new LayoutParams(ActMove.mViewSelected.getLayoutParams().width, 
					ActMove.mViewSelected.getLayoutParams().height));
			video.setVideoPath(comp);
			video.setY(ActMove.mViewSelected.getY());
			video.setX(ActMove.mViewSelected.getX());
			
			video.setTag(comp);
			((ViewGroup) ActMove.mViewSelected.getParent()).removeView(ActMove.mViewSelected);
			
			group.addView(video);
		}
	}
	
}
