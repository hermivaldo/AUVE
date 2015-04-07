package br.tcc.auve.regras;

import br.com.telas.ActMove;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class LoadComponent {

	private ViewGroup group;

	public LoadComponent(ViewGroup group) {
		this.group = group;
	}
	
	
	public void component(String comp){
		if (comp.contains(".jpg")){
			ImageView view = (ImageView) ActMove.mViewSelected;
			
			view.setBackground(null);
			view.setTag(comp);
			view.setImageBitmap(BitmapFactory.decodeFile(comp));
			
		}
		else if (comp.contains(".3gp")){
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
