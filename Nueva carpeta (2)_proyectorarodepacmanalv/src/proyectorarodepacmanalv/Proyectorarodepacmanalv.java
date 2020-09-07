package proyectorarodepacmanalv;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Proyectorarodepacmanalv extends JFrame{
    Proyectorarodepacmanalv(CatGame p){
        add(p);
        setTitle("Pacman :D");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(p.x, p.y);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        CatGame p = new CatGame();
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Proyectorarodepacmanalv ex = new Proyectorarodepacmanalv(p);
                ex.setVisible(true);
            }
        });
    }
    
}
