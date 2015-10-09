/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

import GameBuilder.GameComponent;

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
    
    @Override
    public void GameComponentAction(int codAction) {
        float y = getGameComponentPositionVertical();
        if(y<=768) {
            y+=0.3;
            setGameComponentPositionVertical(y);
        }
        else {
            setGameComponentPositionVertical(Math.round(Math.random()*-768));
            setGameComponentPositionHorizontal(Math.round(Math.random()*971));
        }
        
        if(GameComponentColision(gameComponents.get(1), this))
        {
            gameComponents.clear();
            gameComponents.add(new GameOver());
        }
        
        try{
            GameComponent g = GameComponentColisionWithType("missele");
            if(GameComponentColision(this, g)) {
                SpaceShip p = (SpaceShip) gameComponents.get(1);
                int num = p.getNumMetours();
                p.setNumMetours(--num);
                gameComponents.remove(g);
                gameComponents.remove(this);
            }
        }catch(Exception ex){}
   }
        
    
    
}
