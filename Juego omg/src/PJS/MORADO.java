package PJS;

import java.awt.Image;
import javax.swing.ImageIcon;

public class MORADO extends Fantasma{

    public MORADO(int[][] grid) {
        super(grid);
        dirActual = 1;
        active = true;
        posX = 100;
        posY = 700;
    }


    @Override
    public void usePower(CAT c) {
        c.setInverted(true);
        c.affect(2, 5000);
        active = false;
        timeInactive = 10000;
    }

    @Override
    public Image getImage(){
        if(x_axis == -1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Morado_IZQUIERDA.png")).getImage();
        }else if(x_axis==1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Morado_DERECHA.png")).getImage();
        }else if(y_axis==-1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Morado_ARRIBA.png")).getImage();
        }else{
            return new ImageIcon(getClass().getResource("../Personajes/1x/Morado_ABAJO.png")).getImage();
        }
    }


}
