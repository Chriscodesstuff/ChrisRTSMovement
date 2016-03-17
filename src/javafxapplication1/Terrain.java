/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Chris
 */
public class Terrain {
    
    ArrayList<Rectangle> rectangles = new ArrayList();
    
    Rectangle rect = new Rectangle ();
    
    //methods
    public void add (double x,double y){
        this.rectangles.add(new Rectangle(x,y,25,25));
    };
    public int getSize (){
        return(this.rectangles.size());
    }
    public Rectangle show (int id){
        return (this.rectangles.get(id));
    };
    public void reset (){
        this.rectangles.clear();
    }
}
