/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class CollisionHandler {
    double[] temp = {0,0,0,0};
    ArrayList<double[]> hitboxes = new ArrayList();
    public void add (double x, double y, double w, double h){
        this.temp[0]=x;
        this.temp[1]=y;
        this.temp[2]=w;
        this.temp[3]=h;
        this.hitboxes.add(this.temp);
    };
    public void reset (){
        this.hitboxes.clear();
    }
    private boolean check (double checkX, double checkY, double xTL, double yTL,double xBR, double yBR){
        if(checkX>xTL&&checkX<xBR&&checkY>yTL&&checkY<yBR){
            return(true);
        }else{
            return(false);
        }
    }
    public boolean isColliding (double x,double y, double w, double h){
        for(int a = 1; a < this.hitboxes.size();a++){
            /*if(x>this.hitboxes.get(a)[0]-26&&x<this.hitboxes.get(a)[0]+this.hitboxes.get(a)[2]+26&&y>this.hitboxes.get(a)[1]-26&&y<this.hitboxes.get(a)[1]+this.hitboxes.get(a)[3]+26){
                return(true);
            }*/
            //System.out.println("stuff " + a);
            System.out.println(a);
            if(this.check(x-(w/2),y-(h/2),this.hitboxes.get(a)[0],this.hitboxes.get(a)[1],this.hitboxes.get(a)[0]+this.hitboxes.get(a)[2],this.hitboxes.get(a)[1]+this.hitboxes.get(a)[3])){
                //System.out.println("stuff 1");
                
                return(true);
                
            }else if(this.check(x+(w/2),y-(h/2),this.hitboxes.get(a)[0],this.hitboxes.get(a)[1],this.hitboxes.get(a)[0]+this.hitboxes.get(a)[2],this.hitboxes.get(a)[1]+this.hitboxes.get(a)[3])){
                //System.out.println("stuff 2");
                return(true);
            }else if(this.check(x-(w/2),y+(h/2),this.hitboxes.get(a)[0],this.hitboxes.get(a)[1],this.hitboxes.get(a)[0]+this.hitboxes.get(a)[2],this.hitboxes.get(a)[1]+this.hitboxes.get(a)[3])){
                //System.out.println("stuff 3");

                return(true);
            }else if(this.check(x+(w/2),y+(h/2),this.hitboxes.get(a)[0],this.hitboxes.get(a)[1],this.hitboxes.get(a)[0]+this.hitboxes.get(a)[2],this.hitboxes.get(a)[1]+this.hitboxes.get(a)[3])){
                //System.out.println("stuff 4");
                return(true);
            }else{
                
            }
        }
        //System.out.println("other Stuff");
        return(false);
    };
}
