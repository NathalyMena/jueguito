package PJS;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class CAT {
    private int x_axis, y_axis, posx, posy, puntos, vidas;
    private int[] affected = new int[4];
    private double vel;
    private boolean stunned,slowed,inverted,boosted;
    private KeyManager k;
    public CAT(){
        puntos = 0;
        vidas = 3;
        k = new KeyManager();
        posx = 50;
        posy = 50;
        vel = 10;
        x_axis = 0;
        y_axis = 0;
    }
    public Image getImage(){
        if(x_axis == -1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Gato_IZQUIERDA.png")).getImage();
        }else if(x_axis==1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Gato_DERECHA.png")).getImage();
        }else if(y_axis==-1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Gato_ARRIBA.png")).getImage();
        }else{
            return new ImageIcon(getClass().getResource("../Personajes/1x/Gato_ABAJO.png")).getImage();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Getters"> 
    public int getX_axis() {
        if(inverted)
            return x_axis*-1;
        return x_axis;
    }
    public int getY_axis() {       
        if(inverted)
            return y_axis*-1;
        return y_axis;    
    }
    public int getPosx() {        return posx;    }
    public int getPosy() {        return posy;    }
    public double getVel() {
        if(isSlowed())
            return vel/2;
        if(isBoosted())
            return vel*2;
        return vel;
    }
    public KeyManager getK() {        return k;    }
    public boolean isStunned() {
        return stunned;    
    }
    public int getPuntos() {
        return puntos;
    }
    public int getVidas() {
        return vidas;
    }
    public boolean isSlowed() {
        return slowed;
    }
    public boolean isInverted() {
        return inverted;
    }  
    public int[] getAffected() {        
        return affected;    
    }
    public boolean isBoosted() {
        return boosted;
    } 
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setters"> 
    public void setX_axis(int x_axis) {        this.x_axis = x_axis;    }
    public void setY_axis(int y_axis) {        this.y_axis = y_axis;    }
    public void setPosx(int posx) {        this.posx = posx;    }
    public void setPosy(int posy) {        this.posy = posy;    }
    public void setVel(double vel) {        this.vel = vel;    }
    public void setK(KeyManager k) {        this.k = k;    }
    public void setStunned(boolean stunned) {this.stunned = stunned;    }
    public void setAffected(int[] affected) {        this.affected = affected;    }
    public void setPuntos(int puntos) {
        this.puntos = Math.max(0, puntos);
    }
    public void setVidas(int vidas) {
        this.vidas = Math.min(3 , vidas);
    }
    public void setSlowed(boolean slowed) {
        this.slowed = slowed;
    }
    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }
    public void setBoosted(boolean boosted) {
        this.boosted = boosted;
    }
    
    // </editor-fold>
    
    public void move(int[][]map2, int x, int y){
        recovering();
        if(!isStunned()){
            System.out.println(getVel());
            int nPosx= ((getPosx()+(int)(getX_axis()*getVel())+x)%x);
            int nPosy = (getPosy()+(int)(getY_axis()*getVel())+y)%y;
            int c1x, c2x;
            int c1y, c2y;
            c1x = Math.min((nPosx+10)/50, map2[0].length - 1);
            c2x = Math.min((nPosx+40)/50, map2[0].length - 1);
            c1y = Math.min((nPosy+10)/50, map2.length - 1);
            c2y = Math.min((nPosy+40 )/50, map2.length - 1);

            if(map2[c1y][c1x]< 8 && map2[c1y][c2x]< 8 && map2[c2y][c1x]< 8 && map2[c2y][c2x]< 8 ){
                posx = nPosx;
                posy= nPosy;
            }
        }else{
            x_axis=y_axis=0;
            
            
        }
    }
    public void recovering(){
        for(int i = 0 ; i < 4 ; ++i){
            if(affected[i]>0){
                affected[i]-=50;
            }
        }
        if(getAffected()[0] <=0){
                setStunned(false);
            }
            if(getAffected()[1] <=0){
                setSlowed(false);
            }
            if(getAffected()[2] <=0){
                setInverted(false);
            }
            if(getAffected()[3] <=0){
                setBoosted(false);
            }
    }
    public void affect(int i, int time){
        affected[i] = time;
    }
    
    class KeyManager extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(stunned){
                x_axis = y_axis = 0;
                return;
            }
            switch (key) {
                case KeyEvent.VK_LEFT:
                    x_axis = -1;
                    y_axis = 0;
                    break;
                case KeyEvent.VK_RIGHT:
                    x_axis = 1;
                    y_axis = 0;
                    break;
                case KeyEvent.VK_UP:
                    x_axis = 0;
                    y_axis = -1;
                    break;
                case KeyEvent.VK_DOWN:
                    x_axis = 0;
                    y_axis = 1;
                    break;
            
                case KeyEvent.VK_ESCAPE:
                    break;
                default:
                    break;
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    }
}
