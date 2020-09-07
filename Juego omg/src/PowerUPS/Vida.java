/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PowerUPS;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Vida {
        private int tAparition, tDissapear;
    private boolean active;
    public Vida(){
        tAparition = 400;
        tDissapear = 100;
        active = true;
    }

    public int gettAparition() {
        return tAparition;
    }
    public int gettDissapear() {
        return tDissapear;
    }
    public boolean isActive() {
        return active;
    }  
    public void settAparition(int tAparition) {
        this.tAparition = tAparition;
    }
    public void settDissapear(int tDissapear) {
        this.tDissapear = tDissapear;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void frame(){
        if(active){
            tDissapear-=1;
            if(tDissapear==0){
                active = false;
                tDissapear = 100;
            }
        }else{
            tAparition -=1;
            if(tAparition==0){
                active = true;
                tAparition = 400;
            }
        }
    }
    public void gotcha(){
        tAparition = 400;
        active = false;
    }
    public Dimension site(int X,int Y){
        int x = (int) (Math.random()*X);
        int y = (int) (Math.random()*Y);
        return new Dimension(x,y);
    }
    public Image getImage(){
        return new ImageIcon(getClass().getResource("../Personajes/1x/Recupera_vida.png")).getImage();
    }
}
