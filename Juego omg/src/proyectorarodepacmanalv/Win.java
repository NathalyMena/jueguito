
package proyectorarodepacmanalv;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Win extends javax.swing.JFrame {
    private int points;
    private String name;
    public Win(int points, String name) {
        initComponents();
        this.points = points;
        Graphics g = getGraphics();
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image i = new ImageIcon(getClass().getResource("../GANASTE/FondoC.png")).getImage();
        g.setColor(Color.BLACK);
        g.drawImage(i, 0, 0, this);
        g.drawImage(new ImageIcon(getClass().getResource("../GANASTE/Tu_puntaje_fue.png")).getImage(), 350, 300, this);
        Font f = new Font("VCROSDMono", Font.BOLD, 40);
        g.setFont(f);
        g.setColor(Color.WHITE);
        g.drawString(points+"", 700, 330);
//        g.drawImage(new ImageIcon(getClass().getResource("../REGISTROUSUARIO/Play.png")).getImage(), jButton1.getX()+20, jButton1.getY()+20, this);
//        System.out.println(jButton1.getX() + " " + jButton1.getY());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jugarDeNuevo = new javax.swing.JButton();
        volverMenu = new javax.swing.JButton();
        ranking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jugarDeNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GAMEOVER/BotonJugardenuevo.png"))); // NOI18N
        jugarDeNuevo.setBorderPainted(false);
        jugarDeNuevo.setContentAreaFilled(false);
        jugarDeNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarDeNuevoActionPerformed(evt);
            }
        });

        volverMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GAMEOVER/Boton Menu.png"))); // NOI18N
        volverMenu.setBorderPainted(false);
        volverMenu.setContentAreaFilled(false);
        volverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuActionPerformed(evt);
            }
        });

        ranking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GAMEOVER/Ranking.png"))); // NOI18N
        ranking.setBorderPainted(false);
        ranking.setContentAreaFilled(false);
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugarDeNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(jugarDeNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(volverMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarDeNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarDeNuevoActionPerformed
        Game g = new Game(name);
    }//GEN-LAST:event_jugarDeNuevoActionPerformed

    private void volverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuActionPerformed
        Iniicio i = new Iniicio();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverMenuActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        Ranking r = new Ranking();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_rankingActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jugarDeNuevo;
    private javax.swing.JButton ranking;
    private javax.swing.JButton volverMenu;
    // End of variables declaration//GEN-END:variables
}