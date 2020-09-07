/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorarodepacmanalv;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * @author ReyNellArkad
 */
public class CatGame extends JPanel implements ActionListener{
    int x;
    int y;
    
    //Movimiento de pacman
    int x_axis,y_axis;
    private int posx = 50;
    private int posy = 50;
    private int vel = 5;
    private int[][]map ={   {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
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
        this.x = map2[0].length*50 + 10;
        this.y = (map2.length*50)+30;
        addKeyListener(new KeyManager());
        t = new Timer(50, this);
        t.start();
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(posx, posy, 50, 50);
        g.drawImage(getImage(),posx, posy, 50, 50, this);
        for(int i = 0 ; i < map2.length ; ++i){
            for(int j = 0 ; j< map2[0].length ; ++j){
                if(map2[i][j]>7){
                    g.drawRect(j*50, i*50, 50, 50);
                } 
            }
        }
        //doDrawing(g);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        modificarMovimiento();
        repaint();
        //System.out.println("cosas del timer");
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
    private void modificarMovimiento() {
        int nPosx=(posx+(x_axis*vel)+x)%x;
        int nPosy = (posy+(y_axis*vel)+y)%y;
        int c1x, c2x;
        int c1y, c2y;
        c1x = Math.min((nPosx+10)/50, map2[0].length - 1);
        c2x = Math.min((nPosx+40)/50, map2[0].length - 1);
        c1y = Math.min((nPosy+10)/50, map2.length - 1);
        c2y = Math.min((nPosy+40 )/50, map2.length - 1);
//        int centerX =  Math.min( ((nPosx+25) + (25*x_axis))/50,map2[0].length - 1);
//        int centerY = Math.min( ((nPosy+25) + (25*y_axis))/50 ,map2.length - 1);
//        if(x_axis==1){
//
//            if(map2[centerY][centerX]<8){
//                posx=(posx+(x_axis*vel)+x)%x;
//                posy=(posy+(y_axis*vel)+y)%y;
//            }
//        }else if(y_axis == 1){
//            if(map2[centerY][centerX]<8){
//                posx=(posx+(x_axis*vel)+x)%x;
//                posy=(posy+(y_axis*vel)+y)%y;
//            }
//        }else{
//            if(map2[centerY][centerX]<8){
//                posx=(posx+(x_axis*vel)+x)%x;
//                posy=(posy+(y_axis*vel)+y)%y;
//            }
//        }
        if(map2[c1y][c1x]< 8 && map2[c1y][c2x]< 8 && map2[c2y][c1x]< 8 && map2[c2y][c2x]< 8 ){
            posx = nPosx;
            posy = nPosy;
        }
        
        
        System.out.println("cuadricula: " +(posx/50)+" " + (posy/50));
    }

    class KeyManager extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    x_axis = -1;
                    y_axis = 0;
                    System.out.println("oprimi izquierda");
                } else if (key == KeyEvent.VK_RIGHT) {
                    x_axis = 1;
                    y_axis = 0;
                    System.out.println("oprimi derecha");
                } else if (key == KeyEvent.VK_UP) {
                    x_axis = 0;
                    y_axis = -1;
                    System.out.println("oprimi arriba");
                } else if (key == KeyEvent.VK_DOWN) {
                    x_axis = 0;
                    y_axis = 1;
                    System.out.println("oprimi abajo");
                } else if (key == KeyEvent.VK_ESCAPE) {
                    //Opcion por definir
                }//Se pueden añadir más teclas

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
