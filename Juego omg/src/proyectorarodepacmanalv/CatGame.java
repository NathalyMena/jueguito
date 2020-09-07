
package proyectorarodepacmanalv;


import PJS.Fantasma;
import PJS.CAT;
import PJS.AZUL;
import PJS.MORADO;
import PJS.ROSA;
import PJS.VERDE;
import PowerUPS.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;

public class CatGame extends JPanel implements ActionListener{
    int x;
    int y;
    long time;
    private CAT pj;
    private Velocidad v;
    private Vida vi;
    private Fantasma azul,morado,rosa,verde;
    private String name;
    private boolean velInField, lifeInField;
    private int[][]map2 = { { 10, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 11 },
                            { 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9 },
                            { 9, 1, 24, 25, 1, 24, 25, 1, 24, 26, 25, 1, 24, 25, 1, 24, 25, 1, 9 },
                            { 9, 1, 1, 1, 1, 1, 1, 1, 1, 27, 1, 1, 1, 1, 1, 1, 1, 1, 9 },
                            { 9, 1, 24, 25, 1, 28, 1, 1, 1, 1, 1, 1, 1, 28, 1, 24, 25, 1, 9 },
                            { 9, 1, 1, 1, 1, 35, 25, 1, 28, 1, 28, 1, 24, 36, 1, 1, 1, 1, 9 },
                            { 13, 8, 8, 8, 1, 27, 1, 1, 29, 0, 29, 1, 1, 27, 1, 8, 8, 8, 12 },
                            { 2, 0, 1, 1, 1, 1, 1, 1, 30, 31, 32, 1, 1, 1, 1, 1, 1, 0, 3 },
                            { 10, 8, 15, 8, 1, 28, 1, 1, 1, 1, 1, 1, 1, 28, 1, 8, 15, 8, 11 },
                            { 9, 1, 14, 1, 1, 27, 1, 24, 31, 26, 31, 25, 1, 27, 1, 1, 14, 1, 9 },
                            { 9, 1, 1, 1, 1, 1, 1, 1, 1, 27, 1, 1, 1, 1, 1, 1, 1, 1, 9 },
                            { 9, 1, 24, 33, 1, 24, 25, 1, 1, 1, 1, 1, 24, 25, 1, 34, 25, 1, 9 },
                            { 9, 1, 1, 27, 1, 1, 1, 1, 28, 1, 28, 1, 1, 1, 1, 27, 1, 1, 9 },
                            { 9, 1, 1, 1, 1, 24, 31, 31, 32, 1, 30, 31, 31, 25, 1, 1, 1, 1, 9 },
                            { 16, 19, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 20, 22 },
                            { 17, 18, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 21, 23 }};
    private static int coins = 158;
    private Timer t;
    
    public CatGame(String name){
        velInField = true;
        lifeInField = true;
        v = new Velocidad();
        vi = new Vida();
        this.name = name;
        time = System.currentTimeMillis();
        pj = new CAT();
        azul = new AZUL(map2);
        morado = new MORADO(map2);
        rosa = new ROSA(map2);
        verde = new VERDE(map2);
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
        
        drawMap(g);
        g.setColor(Color.BLACK);
        g.fillRect(x, 0, 300, y);
        drawHUD(g);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        modificarMovimiento();
        repaint();
        
    }

    private void modificarMovimiento() {
        pj.move(map2,x,y);
        azul.move();
        verde.move();
        rosa.move();
        morado.move();
        v.frame();
        vi.frame();
        //System.out.println(v.);
        if(map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)]==1){
            map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)] = 0;
            pj.setPuntos(pj.getPuntos() + 7);
            coins--;
        }
        if(map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)] == 2){
            map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)] = 0;
            v.gotcha();
            velInField = false;
            pj.setBoosted(true);
            pj.affect(3, 5000);
        }
        if(map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)] == 3){
            map2[pj.getPosy()/50][Math.min(pj.getPosx()/50, 18)] = 0;
            vi.gotcha();
            lifeInField = false;
            pj.setVidas(pj.getVidas()+1);
        }
        if(v.isActive() && !velInField){
            while(true){
                    
                    Dimension d = v.site(map2[0].length, map2.length);
                    if(map2[d.height][d.width]==0){
                        map2[d.height][d.width]=2;
                        velInField = true;
                         break;
                    }
                

            }
        }
        
        if(vi.isActive() && !lifeInField){
            while(true){ 
                Dimension d = vi.site(map2[0].length, map2.length);
                if(map2[d.height][d.width]==0){
                    map2[d.height][d.width]=3;
                    lifeInField = true;
                     break;
                }
            }
        }
        if(coins==0){
            setVisible(false);
            t.stop();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            Win g = new Win(pj.getPuntos(),name);
            g.setVisible(true);
            frame.dispose();
            ranking();
        }
        if((pj.getPosx()/50 == azul.getPosX()/50 && pj.getPosy()/50 == azul.getPosY()/50) && azul.isActive()){
            azul.usePower(pj);
            pj.setVidas(pj.getVidas()-1);
        }
        if((pj.getPosx()/50 == verde.getPosX()/50 && pj.getPosy()/50 == verde.getPosY()/50) && verde.isActive()){
            verde.usePower(pj);
            pj.setVidas(pj.getVidas()-1);
        }
        if((pj.getPosx()/50 == rosa.getPosX()/50 && pj.getPosy()/50 == rosa.getPosY()/50) && rosa.isActive()){
            rosa.usePower(pj);
            pj.setVidas(pj.getVidas()-1);
        }
        if((pj.getPosx()/50 == morado.getPosX()/50 && pj.getPosy()/50 == morado.getPosY()/50) && morado.isActive()){
            morado.usePower(pj);
            pj.setVidas(pj.getVidas()-1);
        }
        if(pj.getVidas()==0){
            setVisible(false);
            t.stop();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            GameOver g = new GameOver(pj.getPuntos(),name);
            g.setVisible(true);
            frame.dispose();
            ranking();
        }
    }
    

    private Image getWall(int n) {
        return new ImageIcon(getClass().getResource("../Laberinto/"+n+".png")).getImage();
    }

    private void drawMap(Graphics g) {
        g.drawImage(new ImageIcon(getClass().getResource("../Laberinto/FONDO.png")).getImage(), 0, 0,x,y, this);
        for(int i = 0 ; i < map2.length ; ++i){
            for(int j = 0 ; j< map2[0].length ; ++j){
                if(map2[i][j] == 2){
                    if(v.isActive())
                    g.drawImage(v.getImage(), j*50, i*50,50,50, this);
                    else{
                        map2[i][j] = 0;
                        velInField = false;
                    }
                }
                if(map2[i][j] == 3){
                    if(vi.isActive())
                        g.drawImage(vi.getImage(), j*50, i*50,50,50, this);
                    else{
                        map2[i][j] = 0;
                        lifeInField = false;
                    }
                }
                if(map2[i][j] == 1){

                    g.setColor(Color.yellow);
                    g.fillOval((j*50)+25, (i*50)+25, 10, 10);
                    g.setColor(Color.black);
                }
                if(map2[i][j]>7){
                    g.drawImage(getWall(map2[i][j]), j*50, i*50, this);
                } 
            }

        }
        g.drawImage(pj.getImage(),pj.getPosx(), pj.getPosy(), 50, 50, this);
        g.drawImage(azul.getImage(), azul.getPosX(), azul.getPosY(),50,50, this);
        g.drawImage(morado.getImage(), morado.getPosX(), morado.getPosY(),50,50, this);
        g.drawImage(rosa.getImage(), rosa.getPosX(), rosa.getPosY(),50,50, this);
        g.drawImage(verde.getImage(), verde.getPosX(), verde.getPosY(),50,50, this);
    }

    private void drawHUD(Graphics g) {
        for(int i = 0 ; i < pj.getVidas() ; ++i){
            g.drawImage(new ImageIcon(getClass().getResource("../Personajes/1x/Vida.png")).getImage(), x+20 + (i*80), 50,70,70, this);
        }
        Font f = new Font("VCROSDMono", Font.BOLD, 50);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString("TIEMPO:", x+50, 200);
       
        long sec = (System.currentTimeMillis() - time)/1000;
        long min = sec/60;
        sec = sec%60;
        g.drawString(String.format("%02d", min)+" : "+String.format("%02d", sec), x+50, 300);
        
        g.drawString("Puntos: ", x+50, 400);
        g.drawString(pj.getPuntos()+" ", x+50, 450);
    }

    private void ranking() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("ranking.txt",true);
            pw = new PrintWriter(fichero);
             long sec = (System.currentTimeMillis() - time)/1000;
            long min = sec/60;
            sec = sec%60;
            pw.println(name+";"+pj.getPuntos()+";"+String.format("%02d", min)+" : "+String.format("%02d", sec));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        System.out.println("escrito");
    }

}
