package freemanproject;

import java.util.ArrayList;

public class FreemanProject {
    
    static ArrayList<GameComponent> gameComponents;
    static ArrayList<GameSound> gameSounds;
    
    public static void main(String[] args) {
        gameSounds = new ArrayList<GameSound>();
        gameComponents = new ArrayList<GameComponent>();
        
        BackGround backGround = new BackGround();
        SpaceShip spaceShip = new SpaceShip();
        
        gameComponents.add(backGround);
        gameComponents.add(spaceShip);
        for(int i=0;i<10;i++)
            gameComponents.add(new Meteour());
        
        GameSound spacegun = new GameSound("audio/spacegun.wav");
        gameSounds.add(spacegun);
        new NewGame().buildGame("chuva de meteoros");
    }
}