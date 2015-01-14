package chuj;
import java.awt.font.NumericShaper;
import java.util.Random;

public class NaukaClass {

	static public void main(String[] args) throws InterruptedException{
	 int cycles=10; //iloœæ cykli ¿ycia
	 
	 GameOfLife game = new GameOfLife();
	 do {
	 cycles-=1;
	 game.lifeCycle();
	 System.out.print("\n\n\n\n"); //odstêp :P
	 Thread.sleep(300); // opóŸnienie w wypisywaniu
	 game.printTable();
	 } while (cycles>0);
	 
	}
}


class GameOfLife{
	
	private final int COL = 12;
	private final int ROW = 12;
	public boolean gameTableOfValues [][];
	public boolean gameTableOfValues2 [][];
    private Random randOfValues;
	private int numberOfPartners;

	public GameOfLife() {
				gameTableOfValues= new  boolean[ROW][COL];
				gameTableOfValues2= new boolean[ROW][COL];
			    randOfValues = new Random();
				for(int i=0;i<ROW;i++){ //WYPE£NIA TABLICE ELEMENTAMI (true,false)
						for(int j=0;j<COL;j++){
						   gameTableOfValues[5][5]=true;
						   gameTableOfValues[4][5]=true;
						   gameTableOfValues[3][5]=true;
						   gameTableOfValues[i][j]=false;
						 }
					}
		}
	
	public void lifeCycle(){
	
		for(int i =1;i<=ROW-2;i++){
			for(int j=1;j<COL-2;j++){
				if(gameTableOfValues[i][j]==true){
					
					if(numberOfPartners(i, j)==3 || numberOfPartners(i, j)==2){
						gameTableOfValues2[i][j]=true;
						//viewOfSymbol(i, j);
					}
					else if(numberOfPartners(i, j)<2){
						gameTableOfValues2[i][j]=false;
						//viewOfSymbol(i, j);
					}
					else if(numberOfPartners(i, j)>4){
						gameTableOfValues2[i][j]=false;
					    //viewOfSymbol(i, j);
					}
					
				}
				else if(gameTableOfValues[i][j]==false){
					if(numberOfPartners(i, j)==3){
						gameTableOfValues2[i][j]=true;
					   // viewOfSymbol(i, j);
					}
				}
				
			}
		}
		for(int i=0;i<ROW;i++){
			for(int j=0;j<COL;j++){
				gameTableOfValues[i][j]=gameTableOfValues2[i][j];
			}
		}
		
	}
	
	private int numberOfPartners(int x,int y){
		numberOfPartners=0;
		 if(gameTableOfValues[x-1][y-1]==true) numberOfPartners++;
         if(gameTableOfValues[x][y-1]==true) numberOfPartners++;
         if(gameTableOfValues[x+1][y-1]==true)numberOfPartners++;
         if(gameTableOfValues[x-1][y]==true) numberOfPartners++;
         if(gameTableOfValues[x+1][y]==true) numberOfPartners++;
         if(gameTableOfValues[x-1][y+1]==true) numberOfPartners++;
         if(gameTableOfValues[x][y+1]==true) numberOfPartners++;
         if(gameTableOfValues[x+1][y+1]==true)numberOfPartners++;
     	return numberOfPartners;
	}
	public void printTable()
	{
		for(int i =1;i<=ROW-2;i++){
			for(int j=1;j<COL-2;j++)
			{
				if(gameTableOfValues[i][j]==true) System.out.print("1");
				if(gameTableOfValues[i][j]==false)System.out.print("0");
			}
		System.out.println("");}
		
	}
	/*private void viewOfSymbol(int i , int j ){
		if(gameTableOfValues2[i][j]==true) System.out.print("1");
		if(gameTableOfValues2[i][j]==false)System.out.print("0");
	}*/
}