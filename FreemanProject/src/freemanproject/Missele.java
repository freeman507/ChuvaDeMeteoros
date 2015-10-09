/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

import GameBuilder.GameComponent;
import java.util.ArrayList;

/**
 *
 * @author freeman
 */
public class Missele extends GameComponent{
    
    public Missele(float horizontalPosition, float verticalPosition, ArrayList<GameComponent> gameComponent) {
        super("missele", "img/missele/", 2, horizontalPosition, verticalPosition, 4, 15, gameComponent, null);
        setGameComponentNoActionKey();
    }
    
    @Override
    public void GameComponentAction(int codAction) {
        float y = getGameComponentPositionVertical();
        if(y>=0)
        {
            y-=0.5;
            setGameComponentPositionVertical(y);
        }
        else
            gameComponents.remove(this);
    }
}
