
package proyectorarodepacmanalv;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CatGame extends JPanel implements ActionListener{
    int x;
    int y;
    
    private CAT pj;
    private final int[][]map2 = {   { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 },
                                    { 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8 },
                                    { 8, 1, 9, 9, 1, 9, 9, 1, 9, 9, 9, 1, 9, 9, 1, 9, 9, 1, 8 },
                                    { 8, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 8 },
                                    { 8, 1, 9, 9, 1, 9, 1, 1, 1, 1, 1, 1, 1, 9, 1, 9, 9, 1, 8 },
                                    { 8, 1, 1, 1, 1, 9, 9, 1, 9, 1, 9, 1, 9, 9, 1, 1, 1, 1, 8 },
                                    { 8, 8, 8, 8, 1, 9, 1, 1, 9, 0, 9, 1, 1, 9, 1, 8, 8, 8, 8 },
                                    { 0, 0, 1, 1, 1, 1, 1, 1, 9, 9, 9, 1, 1, 1, 1, 1, 1, 0, 0 },
                                    { 8, 8, 8, 8, 1, 9, 1, 1, 1, 1, 1, 1, 1, 9, 1, 8, 8, 8, 8 },
                                    { 8, 1, 9, 1, 1, 9, 1, 9, 9, 9, 9, 9, 1, 9, 1, 1, 9, 1, 8 },
                                    { 8, 1, 1, 1, 1, 1, 1, 1, 9, 1, 9, 1, 1, 1, 1, 1, 1, 1, 8 },
                                    { 8, 1, 9, 9, 1, 9, 9, 1, 1, 1, 1, 1, 9, 9, 1, 9, 9, 1, 8 },
                                    { 8, 1, 1, 9, 1, 1, 1, 1, 9, 1, 9, 1, 1, 1, 1, 9, 1, 1, 8 },
                                    { 8, 1, 1, 1, 1, 9, 9, 9, 9, 1, 9, 9, 9, 9, 1, 1, 1, 1, 8 },
                                    { 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8 },
                                    { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 } 
                                  };
    private Timer t;
    public CatGame(){
        pj = new CAT();
        this.x = map2[0].length*50 + 10;
        this.y = (map2.length*50)+30;
        addKeyListener(pj.getK());
        t = new Timer(50, this);
        t.start();
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(pj.getImage(),pj.getPosx(), pj.getPosy(), 50, 50, this);
        for(int i = 0 ; i < map2.length ; ++i){
            for(int j = 0 ; j< map2[0].length ; ++j){
                if(map2[i][j]>7){
                    g.drawRect(j*50, i*50, 50, 50);
                } 
            }
        }

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        modificarMovimiento();
        repaint();

    }

    private void modificarMovimiento() {

        int nPosx=(pj.getPosx()+(pj.getX_axis()*pj.getVel())+x)%x;
        int nPosy = (pj.getPosy()+(pj.getY_axis()*pj.getVel())+y)%y;
        int c1x, c2x;
        int c1y, c2y;
        c1x = Math.min((nPosx+10)/50, map2[0].length - 1);
        c2x = Math.min((nPosx+40)/50, map2[0].length - 1);
        c1y = Math.min((nPosy+10)/50, map2.length - 1);
        c2y = Math.min((nPosy+40 )/50, map2.length - 1);

        if(map2[c1y][c1x]< 8 && map2[c1y][c2x]< 8 && map2[c2y][c1x]< 8 && map2[c2y][c2x]< 8 ){
            pj.setPosx(nPosx);
            pj.setPosy(nPosy);
        }

    }   
}
