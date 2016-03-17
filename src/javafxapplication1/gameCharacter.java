/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import java.util.ArrayList;
import java.lang.Math;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
/**
 *
 * @author Chris
 */
public class gameCharacter {
    
    int timer = 0;
    
    //Arraysn
    double[] dest = {0,0};
    double[] change = {0,0};
    double[] pos = {0,0};
    double[] temp = {0,0};
    ArrayList<double[]> boundaries = new ArrayList();

    //colors
    
    Color purple = Color.PURPLE;
    Color red = Color.RED;
    
    //shapes
    Rectangle rect = new Rectangle (0,0,50,50);
    Line progress = new Line ();
    Ellipse destination = new Ellipse();
    
    //Methods/functions
    public void setDest(double x, double y){
        this.dest[0] = x;
        this.dest[1] = y;
        this.change[0] = Math.cos(Math.atan2(y - this.pos[1] , x - this.pos[0]))*2;
        this.change[1] = Math.sin(Math.atan2(y - this.pos[1] , x - this.pos[0]))*2;
    }
    public Rectangle moveTowardDest (){
        if(this.pos[0]>this.dest[0]+1||this.pos[0]<this.dest[0]-1||this.pos[1]>this.dest[1]+1||this.pos[1]<this.dest[1]-1){
            this.pos[0]+=this.change[0];
            this.pos[1]+=this.change[1];
            this.rect.setX(this.pos[0]-25);
            this.rect.setY(this.pos[1]-25);
        }
        this.rect.setFill(purple);
        this.timer+=2;
        //this.rect.setRotate(this.timer);
        return(this.rect);
    }
    public Rectangle doNotMove (){
        this.timer+=2;
        //this.rect.setRotate(this.timer);
        return(this.rect);
    }
    public Line showProgress (){
        this.progress.setStartX(this.pos[0]);
        this.progress.setStartY(this.pos[1]);
        this.progress.setEndX(this.dest[0]);
        this.progress.setEndY(this.dest[1]);
        return(this.progress);
    }
    public Ellipse showDest (){
        this.destination.setCenterX(this.dest[0]);
        this.destination.setCenterY(this.dest[1]);
        this.destination.setRadiusX(5);
        this.destination.setRadiusY(5);
        this.destination.setFill(red);
        return(this.destination);
    }
};
