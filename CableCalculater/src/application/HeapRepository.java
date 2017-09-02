package application;

import java.util.HashMap;

public class HeapRepository {
	
	
	private double[] three; 
	private int size; // o anki ekli olan eleman sayisi
	private int capacity;
	private HashMap hash;
	private double min =9999;
	
	public HeapRepository(int capacity){
		
		hash = new HashMap();
		three = new double[capacity];
		this.capacity = capacity;
		size =0;
		
		//
		
	}
	
	
	
	
	public void add(double d, int index){
		
		if(size == 0){
			three[size] = d;
			size++;
		}
		else if (size > 0 && size < capacity){
			three[size] = d;
			
			
			heapfy(size); // yeni eklenen eleman icin bottom-up
			
			size++;
			
		}else{
			System.out.println("capacity fail");
		}
		
		hash.put(d, index); // heapten aldgimiz kucuk verinin index'ini almak icin
		
	}
	
	
	
	
	
	
	public void heapfy(int i){
		
		double temp;
		int ebeveyn = (i-1)/2;
		if(i ==0){
			return;
		}
		
		if(three[i] < three[ebeveyn]){
			
			temp = three[ebeveyn];
			three[ebeveyn] = three[i];
			three[i] = temp;
			
			heapfy(ebeveyn); // ayn� durumu uste tasindiktan sonra da konrol ediyoruz, cunku dahada yukari cikabilir(botton-up)
			
			
		}else{ // heap e uygunsa
			return;
		}
		
	}
	
	
	
	
	
	public double getMin(){
		return three[0]; //en ustteki eleman en kucuk elemandir
	}
	
	public int getMinIndex(){
		
		return (int)hash.get((double)three[0]);
	}
	

}
