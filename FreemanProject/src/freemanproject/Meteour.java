/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

/**
 *
 * @author freeman
 */
public class Meteour extends GameComponent{
    
    public Meteour () {
        super("meteour", "img/meteour/", 1, Math.round(Math.random()*971),
                Math.round(Math.random()*-768), 53, 53, null, null);
        setGameComponentNoActionKey();
    }
    
    public void GameComponentAction(int codAction) {
        float y = getGameComponentPositionVertical();
        if(y<=768) {
            y+=0.3;
            setGameComponentPositionVertical(y);
        }
        else
            setGameComponentPositionVertical(0);
        
        if(GameComponentColision(gameComponents.get(1), this))
            System.exit(0);
        
        if(GameComponentColisionWithType("missele")) {
            gameComponents.remove(this);
        }
   }
        
    
    
}
