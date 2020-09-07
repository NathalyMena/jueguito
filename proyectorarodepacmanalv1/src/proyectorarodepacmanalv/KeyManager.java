package proyectorarodepacmanalv;
import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter{
        static int x_axis,y_axis;
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
//                    x_axis = -1;
//                    y_axis = 0;
                    System.out.println("oprimi izquierda");
                } else if (key == KeyEvent.VK_RIGHT) {
//                    x_axis = 1;
//                    y_axis = 0;
                    System.out.println("oprimi derecha");
                } else if (key == KeyEvent.VK_UP) {
//                    x_axis = 0;
//                    y_axis = 1;
                    System.out.println("oprimi arriba");
                } else if (key == KeyEvent.VK_DOWN) {
//                    x_axis = 0;
//                    y_axis = -1;
                    System.out.println("oprimi abajo");
                } else if (key == KeyEvent.VK_ESCAPE) {
                    //Opcion por definir
                }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == Event.LEFT || key == Event.RIGHT
                    || key == Event.UP || key == Event.DOWN) {

            }
        }
    }



