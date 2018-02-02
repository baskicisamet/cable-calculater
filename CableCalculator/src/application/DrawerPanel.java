package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;

import application.building.Building;
import application.building.Home;
import application.building.Station;


public class DrawerPanel extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * Create the panel.
	 */
	
	 int x,y;
	 int tempObjectIndex;
	 
	 private double cableLenght;
	 private int cableLenghtPixel;
	 
	 
	 boolean isButtonClick = false;
	 boolean isObjectClick = false;
	 boolean isCalculateClick = false;
	 
	 Building temp;
	 Building tempClicked;
	 
	 double result;
	
	ArrayList <Building> Buildings;
	Building[][] groupLinked; // her satirin basindaki nesne kok, digerleri dallar
	Building[][] relationship;
	ArrayList<Building> group; // 
	
	JLabel lbl_added_Buildings;
	JLabel lbl_cable_lenght;
	
	
	
	private JButton houseButton,stationButton;
	private JButton calculateButton;
	
 	
	public DrawerPanel() {
		
		Buildings = new ArrayList<Building>();
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setBackground(new Color(210, 180, 140));
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(142, 91, 91));
		panel_1.setBounds(0, 336, 722, 27);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAddedBuildings = new JLabel("Added Buildings :");
		lblAddedBuildings.setForeground(Color.LIGHT_GRAY);
		lblAddedBuildings.setBounds(191, 5, 97, 14);
		panel_1.add(lblAddedBuildings);
		
		lbl_added_Buildings = new JLabel("");
		lbl_added_Buildings.setForeground(Color.LIGHT_GRAY);
		lbl_added_Buildings.setBounds(298, 5, 46, 14);
		panel_1.add(lbl_added_Buildings);
		
		JLabel lblCable = new JLabel("Cable Lenght : ");
		lblCable.setForeground(Color.LIGHT_GRAY);
		lblCable.setBounds(377, 5, 116, 14);
		panel_1.add(lblCable);
		
		lbl_cable_lenght = new JLabel("");
		lbl_cable_lenght.setForeground(Color.LIGHT_GRAY);
		lbl_cable_lenght.setBounds(477, 5, 46, 14);
		panel_1.add(lbl_cable_lenght);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(0, 0, 107, 325);
		add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 147, 74, 2);
		panel.add(separator);
		
		JLabel lblTools = new JLabel("Tools");
		lblTools.setForeground(new Color(51, 51, 51));
		lblTools.setBounds(33, 6, 46, 14);
		panel.add(lblTools);
		
		houseButton = new JButton("");
		houseButton.setToolTipText("add house");
		houseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!isButtonClick){           // tiklanabilir iken
					
					houseButton.setBackground(new Color(142, 91, 91));   // d�zenlenecek
					temp = new Home(x,y);
					isButtonClick = true;  // butonu tiklanilmis olarak isaretle
					
				}
				
			}
		});
		houseButton.setIcon(new ImageIcon(DrawerPanel.class.getResource("/rsz_house.png")));
		houseButton.setBackground(new Color(210, 180, 140));
		houseButton.setBounds(10, 37, 74, 43);
		panel.add(houseButton);
		
		stationButton = new JButton("");
		stationButton.setToolTipText("add stattion");
		stationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!isButtonClick){           // tiklanabilir iken
					
					stationButton.setBackground(new Color(142, 91, 91));   // d�zenlenecek
					temp = new Station(x,y);
					isButtonClick = true;  // butonu tiklanilmis olarak isaretle
					
				}
			}
		});
		stationButton.setIcon(new ImageIcon(DrawerPanel.class.getResource("/rsz_1station.png")));
		stationButton.setBackground(new Color(210, 180, 140));
		stationButton.setBounds(9, 86, 75, 43);
		panel.add(stationButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(14, 22, 74, 2);
		panel.add(separator_1);
		
		calculateButton = new JButton("Calculate");
		calculateButton.setToolTipText("");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Buildings.size()>0){
					
				
				isCalculateClick = true;
				calculate();
				repaint();
				}
				
			}
		});
		calculateButton.setBackground(new Color(210,180,140));
		calculateButton.setBounds(5, 168, 90, 34);
		panel.add(calculateButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setToolTipText("");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {                  //+++++++++++++++++++++++++++ reset
				
				
				isCalculateClick = false;
				isButtonClick = false;
				isObjectClick = false;
				isCalculateClick = false;
				temp = null;
				tempClicked = null;
				tempObjectIndex = 0;
				Buildings = new ArrayList<Building>();
				repaint();
				
				
			}
		});
		btnReset.setBackground(new Color(210, 180, 140));
		btnReset.setBounds(5, 204, 90, 34);
		panel.add(btnReset);
		
		JButton btnSil = new JButton("Delete");
		btnSil.setToolTipText("If you want to delete any object on panel, firstly click an object then click this button.");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					if(Buildings.size()> 0){
						Buildings.remove(tempObjectIndex);
					}
				
					if(Buildings.size() > 1){
						calculate();
					}
					repaint();
					isObjectClick = false;
				
			}
		});
		btnSil.setBackground(new Color(210, 180, 140));
		btnSil.setBounds(4, 242, 90, 34);
		panel.add(btnSil);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(109, 323, 611, 3);
		add(separator_2);
		

	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i =0;i<Buildings.size();i++){ // eklenen verilerin cizdirilmesi
			
			Buildings.get(i).draw(g);
			
		}
		
		if(isButtonClick){
		temp.draw(g); // o an eklenmekre olan nesnenin cizdirilmesi
		}
		
		//�izgilerin �izdirilmesi
		if(isCalculateClick){
		drawLines(relationship,g);
		}
		
	}
	
	
	
	
	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(isObjectClick){ // bir nesneye tiklanilmissa o nesneyi hareket ettiricez
			
			Buildings.get(tempObjectIndex).move(e.getX()-(tempClicked.getWidth()/2), e.getY()-(tempClicked.getHight()/2)); // nesneyi hareket ettirdik simdide released eventinde nesneyi depoya eklicez
			repaint();
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(isButtonClick){ // ekle butonu aktif ise yani nesne olusturulmus ise hereket islemlerini yapicaz
			
			temp.move(e.getX()-(temp.getWidth()/2), e.getY()-(temp.getHight()/2)); //tasirken gorselin imlecin tam ortasinda cikmasi icin bu degerler ile set ediyoruz
			repaint();
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(isButtonClick){ // panale eklenecilecek nesne var ise eklenecek ve buton kullanilabilir hale gelecek
			
			Buildings.add(temp);
			isButtonClick = false;
			houseButton.setBackground(new Color(210, 180, 140));
			stationButton.setBackground(new Color(210, 180, 140));
			repaint();
			
		}else{ // buton pasif iken tiklanilan yerde herhengi bir nesnenin olup olmadigini kontrol edicez 
			   // varsa o nesneyi hereket ettirebilmek icin degiskene alicaz
			
			for(int i=0; i<Buildings.size();i++){ //hangi nesneye tikladigimizi bulabilmemiz icin butun nesnelerin koordinatlarini kontrol etmemiz lazim
				
				if(Buildings.get(i).isIn(e.getX(), e.getY())){
					
					tempClicked = Buildings.get(i); // tiklanan nesneyi aldik, simdi drag eventinde yerini degistirecez
					tempObjectIndex = i;
					isObjectClick = true;  // herhangi bir nesneye tiklandigina dair bilgiyide aldik
					
				}
				
			}
			
			
		}
		
		System.out.println("eklenen eleman sayisi : "+Buildings.size());
		lbl_added_Buildings.setText(""+Buildings.size());// test
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(isObjectClick){ // suruklenen nesne var ise kaydediyoruz ve suruklenme isleminin bittigini isaretliyoruz
			
			Buildings.set(tempObjectIndex, tempClicked);
			isObjectClick = false;
			
		}
		
	}
	
	public int getCable(){
		
		return this.cableLenghtPixel;
	}
	
	
	public void drawLines(Building[][] rs,Graphics g){
		
		int x1,x2,y1,y2;
		for(int i=0;i<rs.length;i++){
			
			x1 = rs[i][0].getCenterX();
			x2 = rs[i][1].getCenterX();
			y1 = rs[i][0].getCenterY();
			y2 = rs[i][1].getCenterY();
			
			g.setColor(new Color(142, 91, 91));
			
			g.drawLine(x1, y1, x2, y2);
			
		}
	}
	
	public int distanceCount(Building b1,Building b2){ 
		
		int x1 = b1.getCenterX();
		int x2 = b2.getCenterX();
		int y1 = b1.getCenterY();
		int y2 = b2.getCenterY();
		int distance;
		
		
		
		distance = (int)Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		
		
		return distance;
		
	}
	
	public void calculate(){
		
		cableLenghtPixel =0;
		
		relationship = new Building[Buildings.size()-1][2];
		
		HeapRepository smallHeap;
		HeapRepository bigHeap;
		
		int[] addedIndex = new int[Buildings.size()];
		int mesafe = 0;
		
		int BuildingsSize =Buildings.size();
		boolean key =false;
		
		
		groupLinked = new Building[BuildingsSize][BuildingsSize]; // hesaplanan eklenen veriler burda toplanacak
		group = new ArrayList<Building>();
		
		groupLinked[0][0]  = Buildings.get(0);// ilk elemandan baslayarak hesapliycaz
		group.add(Buildings.get(0)); 
		addedIndex[0] = 0;        // Buildings'ten eklenen elemanin index'ini de ekliyoruz
 		
		for(int i=1;i<Buildings.size();i++){ // 
			bigHeap = new HeapRepository(group.size()); // gruptaki eleman sayisi kadar heap
			
			for(int j=0; j<group.size();j++){ //guruptaki her bir nesne icin
				smallHeap = new HeapRepository(BuildingsSize-group.size()); // bosta kalan eleman sayisi kadar heap
				
				for(int k=0;k<BuildingsSize;k++){ // gruptaki bir nesnenin bostaki her bir eleman ile olculmesi
					
					
					for(int m=0;m<addedIndex.length;m++){
						if(addedIndex[m] == k){	key = false;	}
						
					}
					
					if(key == true){
						
						mesafe = distanceCount(group.get(j),Buildings.get(k)); // aradaki mesafe pixel olarak alindi
						smallHeap.add(mesafe, k);
						
						
					}
					
					key = true;
				}
				
				bigHeap.add(smallHeap.getMin(), smallHeap.getMinIndex()); // small dan gelen kucuk degerler big e aktariliyor
				 
				
				
			}
			
			
			//iliskide grouptaki nesnenin indexi
			int tempDistance =0;
			int index=0;
			for(int n=0;n<group.size();n++){
				
				tempDistance = distanceCount(group.get(n),Buildings.get(bigHeap.getMinIndex()));
				
				if(tempDistance == bigHeap.getMin()){
					
					index = n; // gruptaki ziplanilan elemanin index i
				}
				
			}
			
			
			cableLenghtPixel += bigHeap.getMin();
			
			
			group.add(Buildings.get(bigHeap.getMinIndex())); //gruba nesneyi ekleme +++++++++++++++++++++++++
			addedIndex[i] = bigHeap.getMinIndex(); // grop a eklenen elemanin index'i
			
			
			//relationship ekle
			relationship[i-1][0] = group.get(index); // cizginin baslangic adresi
			relationship[i-1][1] = Buildings.get(bigHeap.getMinIndex()); // cizginin bitis adresi
		}
		
		
		lbl_cable_lenght.setText(""+cableLenghtPixel+" px");
	}
}