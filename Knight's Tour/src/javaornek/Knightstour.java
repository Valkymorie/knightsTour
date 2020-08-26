/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaornek;

import java.util.Scanner;

/**
 *
 * @author EMİR
 */
public class Knightstour {
    
    private  int[][] matriksCozumu;
    private  int[] xEksen={2,1,-1,-2,-2,-1,1,2};
    private  int[] yEksen={1,2,2,1,-1,-2,-2,-1}; 
    
        public Knightstour(){
            
            this.matriksCozumu = new int[Sabit.tahta_boyutu][Sabit.tahta_boyutu];
            tahtayiBelirle();
        }
    private void tahtayiBelirle(){
        
        for(int i =0;i<Sabit.tahta_boyutu;i++)
            for(int j=0;j<Sabit.tahta_boyutu;j++)
                this.matriksCozumu[i][j]=Integer.MIN_VALUE;
        
    }
    
    public void bastir(){
        for(int i=0;i<Sabit.tahta_boyutu;i++){
            for(int j=0;j<Sabit.tahta_boyutu;j++){
                System.out.print(" "+this.matriksCozumu[i][j] +" " );
            }
            System.out.println("");
        }
        
    }
    
    public void knightsTourCoz(){
        Scanner input= new Scanner(System.in);
        System.out.println("Başlanılacak satırı girin: ");
        int satir= input.nextInt();
        input.nextLine();
        System.out.println("Başlanılacak sütunu girin: ");
        int sutun= input.nextInt();
        input.nextLine();
        this.matriksCozumu[0][0]=0;
        
        if(!problemCoz(1,satir-1,sutun-1)){
            System.out.println("yol çizilememiştir...");
        return;
        }
        
        bastir();
    }
    
    public boolean problemCoz(int adim, int x, int y){
        
        if(adim==Sabit.tahta_boyutu*Sabit.tahta_boyutu){
            return true;
        }
        
        for(int i=0;i<Sabit.tahta_boyutu;i++){
            
            int nextX= x+ xEksen[i];

            int nextY= y+ yEksen[i];
        
           if(isValidMove(nextX,nextY)){
               this.matriksCozumu[nextX][nextY]= adim;
               
               if(problemCoz(adim+1, nextX, nextY)){
                   return true;
               }
               this.matriksCozumu[nextX][nextY]=Integer.MIN_VALUE;
           }
        }
        return false;
    }
    
    public boolean isValidMove(int x, int y){
        
        if(x<0 || x>=Sabit.tahta_boyutu)
            return false;
        
        if(y<0 || y>=Sabit.tahta_boyutu)
            return false;
        
        if(this.matriksCozumu[x][y] != Integer.MIN_VALUE)
            return false;
        
        
        return true;
    }
   
    
    
    
    
}
