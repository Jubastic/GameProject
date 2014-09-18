package gp;

public class Map {
   private String matrix[][] = new String[8][8];
   private String matrix1[][] = new String[8][8];
   private String matrix2[][] = new String[8][8];
   
   Map(String matrix[][], String matrix1[][], String matrix2[][]){
	  this.matrix[8][8] = matrix[8][8];
	  this.matrix1[8][8] = matrix1[8][8];
	  this.matrix2[8][8] = matrix2[8][8];
   }
   
   
   public String getCenario(){	  
	   return matrix[8][8];
   }
   
   public void setCenario(String matrix[][]){
	   for(int i=0;i<matrix.length;i++){
		   for(int x=0;i<matrix.length;i++){
	   if(x==0 || i == 0 || x==7 || x ==6 && i==7 || x ==5 && i==7 || x==4 && i==7 ||x==3 && i==7 
			   || x==3 && i==6 || x==3 && i==5 || x==3 && i==4 || x==3 && i ==3 || x==3 && i ==2 
			   || x==4 && i ==2 || x==5 && i ==2 || x==5 && i==3 || x==5 && i==4 || x==5 && i == 5
			   || x==4 && i==5){
		   System.out.println("0");
	   }else 
		   System.out.println("*");
		   }
	   }
	   this.matrix[8][8] = matrix[8][8];   
   }
   public String getCenario1(){
	   return matrix1[8][8];
   }
   public void setCenario1(String matrix1[][]){
	   
	   for(int i=0; i<matrix.length; i++){
		   for(int x=0; x<matrix1.length; x++){
			   if(i==0 || x==6 && i == 1 || x==5 && i==2 || x== 4 && i==3 || x==3 && i==4 || x==2 && i==5 || x== 1 && i ==6 || x == 1 || x== i || i ==7   ){
				System.out.println("0");   
			   }else
				   System.out.println("*");
		   }
	   }
	   this.matrix1[8][8] = matrix[8][8];   
	   }
   
   public String getCenario2(){
	   return matrix2[8][8];
   }
   public void setCenario2(String matrix2[][]){
	   for(int i=0 ; i< matrix2.length; i++){
		   for(int x=0; x<matrix2.length; x++)
	   if(x==0 || i==7 || x==7){
		  System.out.println("0");
	   }else
		   System.out.println("*");
	   }
	   this.matrix2[8][8] = matrix[8][8]; 
   }
   }
