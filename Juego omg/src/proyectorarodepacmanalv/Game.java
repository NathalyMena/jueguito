package proyectorarodepacmanalv;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Game extends JFrame{
    public Game(String name){
        CatGame p = new CatGame(name);
        p.setVisible(true);
        add(p);
        setTitle("INTERCAT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(p.x+300, p.y);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    
}
