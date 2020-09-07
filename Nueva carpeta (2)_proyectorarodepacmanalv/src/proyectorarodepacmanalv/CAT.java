package proyectorarodepacmanalv;

import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class CAT {
    private int x_axis, y_axis;
    private int posx, posy;
    private int vel;
    private KeyManager k;
    public CAT(){
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
    public int getX_axis() {
        return x_axis;
    }
    public int getY_axis() {
        return y_axis;
    }
    public int getPosx() {
        return posx;
    }
    public int getPosy() {
        return posy;
    }
    public int getVel() {
        return vel;
    }
    public KeyManager getK() {
        return k;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }
    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }
    public void setPosx(int posx) {
        this.posx = posx;
    }
    public void setPosy(int posy) {
        this.posy = posy;
    }
    public void setVel(int vel) {
        this.vel = vel;
    }
    public void setK(KeyManager k) {
        this.k = k;
    }
    
    
    class KeyManager extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    setX_axis(-1);
                    setY_axis(0);
                    x_axis = -1;
                    y_axis = 0;
                } else if (key == KeyEvent.VK_RIGHT) {
                    setX_axis(1);
                    setY_axis(0);
                    x_axis = 1;
                    y_axis = 0;
                } else if (key == KeyEvent.VK_UP) {
                    setX_axis(0);
                    setY_axis(-1);
                    x_axis = 0;
                    y_axis = -1;
                } else if (key == KeyEvent.VK_DOWN) {
                    setX_axis(0);
                    setY_axis(1);
                    x_axis = 0;
                    y_axis = 1;
                } else if (key == KeyEvent.VK_ESCAPE) {
                    
                }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {

            }
        }
    }
}
