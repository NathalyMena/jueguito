/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorarodepacmanalv;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;


public class Ranking extends javax.swing.JFrame {

    static ArrayList<Puntaje> p;
    public Ranking() {
        initComponents();
        p = new ArrayList<>();
        readRanking();
        System.out.println(p.toString());
        repaint();
    }
    
        @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font f = new Font("VCROSDMono", Font.BOLD, 20);
        g.setColor(Color.WHITE);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/FondoC.png")).getImage(), 0, 0, this);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Nombre.png")).getImage(), 250, 300, this);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Puntaje.png")).getImage(), 520, 300, this);    
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Tiempo.png")).getImage(), 790, 300, this);
        
        g.setFont(f);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 250, 350, this);
        g.drawString(p.get(0).getName(), 260, 380);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 520, 350, this);
        g.drawString(p.get(0).getPoints()+"", 530, 380);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 790, 350, this);
        g.drawString(p.get(0).getTime(), 800, 380);
        
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 250, 400, this);
        g.drawString(p.get(1).getName(), 260, 430);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 520, 400, this);
        g.drawString(p.get(1).getPoints()+"", 530, 430);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 790, 400, this);
        g.drawString(p.get(1).getTime(), 800, 430);
        
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 250, 450, this);
        g.drawString(p.get(2).getName(), 260, 480);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 520,450, this);
        g.drawString(p.get(2).getPoints()+"", 530, 480);
        g.drawImage(new ImageIcon(getClass().getResource("../RANKING/Espacio.png")).getImage(), 790, 450, this);
        g.drawString(p.get(2).getTime(), 800, 480);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GAMEOVER/Boton Menu.png"))); // NOI18N
        volverMenu.setBorderPainted(false);
        volverMenu.setContentAreaFilled(false);
        volverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(volverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(521, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(602, Short.MAX_VALUE)
                .addComponent(volverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuActionPerformed
        Iniicio i = new Iniicio();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverMenuActionPerformed



    private void readRanking() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

           archivo = new File ("ranking.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);

           String linea;
           String[]data;
           while((linea=br.readLine())!=null){
               data = linea.split(";");
               p.add(new Puntaje(data[0],Integer.valueOf(data[1]),data[2]));
               System.out.println(linea);
           }
              
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{

           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        Collections.sort(p);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton volverMenu;
    // End of variables declaration//GEN-END:variables
}