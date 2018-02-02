package application.building;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Home extends Building {
	
	
	private int x,y;
	private Image img;
	private int hight,width;
	    // panel uzerinde duzgun denk gelen koordinatlar 
	private int cx,cy;
	
	public Home (int x,int y){
		
		this.x = x;          // evin merkez koordinatlari
		this.y = y;
		
		this.hight = 30;
		this.width = 30;
		
		
		ImageIcon imgc = new ImageIcon(this.getClass().getResource("/rsz_house.png")); // ev resmini aliyoruz
		img = imgc.getImage();
				
		
		
	}
	
	
	
	public void move(int x,int y){
		
		this.x = x;
		this.y = y;
		
		
		// cizilen evin merkez koordinatlari
		this.cx = this.x+(this.width/2);
		this.cy = this.y+(this.hight/2);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img,x,y,width,hight,null);
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public void setSize(int hight, int width) {
		// TODO Auto-generated method stub
		
		this.hight = hight;
		this.width = width;
		
	}



	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		
		return this.width;
	}



	@Override
	public int getHight() {
		// TODO Auto-generated method stub
		return this.hight;
	}



	@Override
	public void setPanelKoordinat(int px,int py) {
		// TODO Auto-generated method stub
		
		
	}



	@Override
	public boolean isIn(int px, int py) { // panelde herhangi bir nesneye tiklanip tiklanmadigini kontrol edicek
		// TODO Auto-generated method stub  //
		
		if(px >= (this.cx-10) && (px <= cx+10)     &&    py >= (this.cy-15) && py <= (this.cy+10)  ){
			
			return true;
			
		}else{
		return false;
		}
	}



	@Override
	public void setCenter(int cx, int cy) { // move dan tureticez merkezi simdilik buna gerek yok
		// TODO Auto-generated method stub
		
		
		
	}



	@Override
	public int getCenterX() {
		// TODO Auto-generated method stub
		return this.cx;
	}



	@Override
	public int getCenterY() {
		// TODO Auto-generated method stub
		return this.cy;
	}
	

}
