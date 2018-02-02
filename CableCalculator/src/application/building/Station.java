package application.building;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;



public class Station extends Building {
	
	private int x,y;
	private int hight,width;
	private Image img;
	private int cx,cy;
	
	public Station(int x, int y){
		
		this.x = x;
		this.y = y;
		
		this.hight = 40;
		this.width = 40;
		
		ImageIcon  imgc = new ImageIcon(this.getClass().getResource("/rsz_1station.png"));
		img = imgc.getImage();
		
		
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
		this.x = x;
		this.y = y;
		
		this.cx = x+(this.width/2); // resmi sol ust kosesinden cizmeye basladigi icin  merkez kooardinat
		this.cy = y+(this.hight/2);
		
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
	public void setPanelKoordinat(int px, int py) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCenter(int cx, int cy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIn(int cx, int cy) {
		// TODO Auto-generated method stub
		if(cx >= (this.cx-22) && (cx <= this.cx+22)     &&    cy >= (this.cy-22) && cy <= (this.cy+22)  ){
			
			return true;
			
		}else{
		return false;
		}
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