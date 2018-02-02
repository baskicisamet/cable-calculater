package application.building;

import java.awt.Graphics;

import javax.swing.JLabel;

public abstract class Building extends JLabel {
	
	
	public abstract  void move(int x,int y); // x ve y degerini set edicek
	public abstract void draw(Graphics g);
	
	public abstract int getX(); 
	public abstract int getY();
	
	public abstract void setSize(int hight,int width);
	
	public abstract int getWidth();
	public abstract int getHight();
	
	
	
	public abstract void setPanelKoordinat(int px,int py);
	public abstract void setCenter(int cx,int cy);
	
	public abstract int getCenterX();
	public abstract int getCenterY();
	
	public abstract boolean isIn(int cx,int cy);

}
