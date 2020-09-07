package PJS;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class AZUL extends Fantasma{

    public AZUL(int[][] grid) {
        
        super(grid);
        
        active = true;
        posX = 50;
        posY = 650;
    }



    @Override
    public Image getImage(){
        if(x_axis == -1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Azul_IZQUIERDA.png")).getImage();
        }else if(x_axis==1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Azul_DERECHA.png")).getImage();
        }else if(y_axis==-1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Azul_ARRIBA.png")).getImage();
        }else{
            return new ImageIcon(getClass().getResource("../Personajes/1x/Azul_ABAJO.png")).getImage();
        }
    }

    @Override
    public void usePower(CAT c) {
        if(active){
            c.setStunned(true);
            c.affect(0, 2000);
            active = false;
            timeInactive = 10000;
        }
        
    }

    



}
