package PJS;

import java.awt.Image;
import javax.swing.ImageIcon;

public class VERDE extends Fantasma{

    public VERDE(int[][] grid) {
        super(grid);
        dirActual = 3;
        active = true;
        posX = 800;
        posY = 700;
    }


    @Override
    public void usePower(CAT c) {
        c.setPuntos(c.getPuntos() - 10);
        c.affect(2, 5000);
        active = false;
        timeInactive = 10000;
    }
    @Override
    public Image getImage(){
        if(x_axis == -1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Verde_IZQUIERDA.png")).getImage();
        }else if(x_axis==1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Verde_DERECHA.png")).getImage();
        }else if(y_axis==-1){
            return new ImageIcon(getClass().getResource("../Personajes/1x/Verde_ARRIBA.png")).getImage();
        }else{
            return new ImageIcon(getClass().getResource("../Personajes/1x/Verde_ABAJO.png")).getImage();
        }
    }
}
