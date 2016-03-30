/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javafxapplication1;


/**
 *
 * @author Chris
 */

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle; 
//import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;



public class JavaFXApplication1 extends Application{
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage theStage){
        
        theStage.setTitle("This is a window; pretty rad, huh");
        final Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        theStage.setHeight(1000);
        theStage.setWidth(2000);
        
        final Color w = Color.WHITE;
        
        
        new AnimationTimer(){
            GameCharacter gC = new GameCharacter();
            Rectangle background = new Rectangle(0,0,w);
            Terrain terrain = new Terrain();
            CollisionHandler cHandler = new CollisionHandler();
            
            public void handle (long currentNanoTime){
                
                //reset animation
                root.getChildren().clear();
                background.setWidth(2000);
                background.setHeight(1000);
                root.getChildren().add(background);
                
                //create terrain and boudaries
                terrain.add(100,200);
                terrain.add(125,200);
                terrain.add(150,200);
                terrain.add(175,200);
                cHandler.add(100,200,25,25);
                cHandler.add(125,200,25,25);
                cHandler.add(150,200,25,25);
                cHandler.add(175,200,25,25);
                
                //draw terrrain
                for (int a=0;a<terrain.getSize();a++){
                    root.getChildren().add(terrain.show(a));
                }
                
                //show progress and destination
                root.getChildren().add(gC.showProgress());
                root.getChildren().add(gC.showDest());
                
                //determine if colliding
                if(cHandler.isColliding(gC.getRect().getX()+gC.getChange()[0]+(gC.getRect().getWidth()/2),gC.getRect().getY()+gC.getChange()[1]+(gC.getRect().getHeight()/2),50,50)){
                    root.getChildren().add(gC.getRect());
                    
                }else{
                    root.getChildren().add(gC.moveTowardDest());
                    
                }
                
                //detect touch mouse
                root.setOnTouchPressed(new EventHandler<TouchEvent>(){
                    public void handle(TouchEvent me){
                        gC.setDest(me.getTouchPoint().getSceneX(),me.getTouchPoint().getSceneY());
                    }
                });            
                root.setOnMousePressed(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent me){
                        gC.setDest(me.getX(),me.getY());
                    }
                });
                
                //reset terrain and bounds
                terrain.reset();
                cHandler.reset();
            }
        }.start();
        
        theStage.show();
        System.out.println("im done now");
    }
    
}