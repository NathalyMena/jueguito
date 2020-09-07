package PJS;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ROSA extends Fantasma{

    public ROSA(int[][] grid) {
        super(grid);
        dirActual = 2;
        active = true;
        posX = 850;
        posY = 650;
    }

    @Override
    public void usePower(CAT c) {
        c.setSlowed(true);
        c.affect(1, 5000);
        active = false;
        timeInactive = 10000;
    }
    
    @Override
    public Image getImage(){
        if(x_axis == -1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Rosa_IZQUIERDA.png")).getImage();
        }else if(x_axis==1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Rosa_DERECHA.png")).getImage();
        }else if(y_axis==-1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Rosa_ARRIBA.png")).getImage();
        }else{
            return new ImageIcon(getClass().getResource("../Personajes/1x/Rosa_ABAJO.png")).getImage();
        }
    }




}
