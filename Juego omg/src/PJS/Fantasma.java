package PJS;

import PJS.CAT;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;

public abstract class Fantasma {
    private static ArrayList<Integer>[] g;
    private static int I, J;
    protected boolean active;
    protected int timeInactive, posX,posY;
    protected double spd = 5;
    protected int x_axis, y_axis, dirActual;
    private static int[]xMove = {1,-1,0,0};
    private static int[]yMove = {0,0,-1,1};
    private static int[][]grid;
    public Fantasma(int[][]grid){

        this.grid = grid;
        I = grid.length;
        J = grid[0].length;
    }
    public abstract void usePower(CAT c);
    public abstract Image getImage();

    public void isInactive(){
        timeInactive+=50;
        if(timeInactive>= 500){
            timeInactive = 0;
            active = true;
        }
    }
    public void move(){
        if(!active){
            timeInactive-=50;
            if(timeInactive<=0)
                active = true;
            return;
        }
            
        int x = (J*50) + 10;
        int y = (I*50) + 30;
        if(dirActual== -1){
            dirActual = (int) (Math.random()*4) % 4;
            move();
        }else{
            int nPosx= ((posX+(int)(xMove[dirActual]*spd)+x)%x);
            int nPosy = (posY+(int)(yMove[dirActual]*spd)+y)%y;
            if(validMove(nPosx,nPosy)){
                posX = nPosx;
                posY = nPosy;
            }else{
                dirActual = -1;
                move();
            }
        }



    }
    public boolean validMove(int pX, int pY){
        int c1x, c2x;
            int c1y, c2y;
            c1x = Math.min((pX+10)/50, J - 1);
            c2x = Math.min((pX+40)/50, J - 1);
            c1y = Math.min((pY+10)/50, I - 1);
            c2y = Math.min((pY+40 )/50, I - 1);
            return grid[c1y][c1x]< 8 && grid[c1y][c2x]< 8 && grid[c2y][c1x]< 8 && grid[c2y][c2x]< 8 ;
    }

    public static ArrayList<Integer>[] getG() {
        return g;
    }
    public static int getI() {
        return I;
    }
    public static int getJ() {
        return J;
    }
    public boolean isActive() {
        return active;
    }
    public int getTimeInactive() {
        return timeInactive;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public double getSpd() {
        return spd;
    }
    public int getX_axis() {
        return x_axis;
    }
    public int getY_axis() {
        return y_axis;
    }
    public int getDirActual() {
        return dirActual;
    }
    public static int[] getxMove() {
        return xMove;
    }
    public static int[] getyMove() {
        return yMove;
    }
    public static int[][] getGrid() {
        return grid;
    }
    
   
}
