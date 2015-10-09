package freemanproject;

import GameBuilder.GameSound;
import GameBuilder.NewGame;
import GameBuilder.GameComponent;
import java.util.ArrayList;

public class FreemanProject {
    
    static ArrayList<GameComponent> gameComponent;
    static ArrayList<GameSound> gameSound;
    
    public static void main(String[] args) {
        
        gameSound = new ArrayList<GameSound>();
        gameComponent = new ArrayList<GameComponent>();
        
        BackGround backGround = new BackGround();
        SpaceShip spaceShip = new SpaceShip();
        
        gameComponent.add(backGround);
        gameComponent.add(spaceShip);
        for(int i=0;i<10;i++)
            gameComponent.add(new Meteour());
        
        GameSound spacegun = new GameSound("audio/spacegun.wav");
        gameSound.add(spacegun);
        new NewGame().buildGame("chuva de meteoros",gameComponent,gameSound);
    }
}