package br.com.fileexplorer;

import android.annotation.SuppressLint;

public class Item {

	private String data;
    private String date;
    private String path;
    private String image;
	private String name;
    
    public Item(String n,String d, String dt, String p, String img)
    {
            setName(n);
            setData(d);
            setDate(dt);
            setPath(p);
            setImage(img);         
    }
    
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
	 @SuppressLint("DefaultLocale")
		public int compareTo(Item o) {
	            if(this.name != null)
	                    return this.name.toLowerCase().compareTo(o.getName().toLowerCase());
	            else
	                    throw new IllegalArgumentException();
	    }
}
