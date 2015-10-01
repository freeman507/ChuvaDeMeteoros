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
public class SpaceShip extends GameComponent{

    public SpaceShip() {
        super("spaceship", "img/sprites_spaceship/", 3, 0, 600, 37, 34, null, null);
        setGameComponentAddActionKey(keyRight);
        setGameComponentAddActionKey(keyLeft);
        setGameComponentAddActionKey(keyUp);
        setGameComponentAddActionKey(keyDown);
        setGameComponentAddActionKey(keyZ);
        setGameComponentAddActionKey(keyNoPressed);
    }
    
    @Override
    public void GameComponentAction(int codAction) {
        float x = getGameComponentPositionHorizontal();
        float y = getGameComponentPositionVertical();
        
        if(codAction == keyRight && x <= 987) {
            x+=0.5;
            setGameComponentPositionHorizontal(x);
            setGameComponentCurrentSprite(2);
        }
        else if(codAction == keyLeft && x >= 0) {
            x-=0.5;
            setGameComponentPositionHorizontal(x);
            setGameComponentCurrentSprite(0);
        }
        else if(codAction == keyUp && y >= 0) {
            y -= 0.5;
            setGameComponentPositionVertical(y);
        }
        else if(codAction == keyDown && y <= 650) {
            y+=0.5;
            setGameComponentPositionVertical(y);
        }
        else {
            setGameComponentCurrentSprite(1);
        }
        if(codAction == keyZ) {
            if(!GameComponentWait(500)) {
                GameComponentPlaySound(gameSounds.get(0), false);
                Missele m = new Missele(x+18,y,this.gameComponents);
                gameComponents.add(m);
            }
            else {
                gameSounds.get(0).setGameEnableSound(true);
            }
        }
    }
}
