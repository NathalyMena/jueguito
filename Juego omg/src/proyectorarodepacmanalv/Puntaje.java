/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorarodepacmanalv;


public class Puntaje implements Comparable{
    private String name, time;
    private int points;

    public Puntaje(String name, int points,String time) {
        this.name = name;
        this.time = time;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    @Override
    public int compareTo(Object t) {
        Puntaje t1 = (Puntaje)t;
        if(points > t1.points){
            return -1;
        }else if(points < t1.points){
            return 1;
        }else{
            return time.compareTo(t1.time)*-1;
        }
    }

    @Override
    public String toString() {
        return "Puntaje{" + "name=" + name + ", time=" + time + ", points=" + points + '}';
    }
    
    
    
}
