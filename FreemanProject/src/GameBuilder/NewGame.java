/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBuilder;

//import static freemanproject.FreemanProject.gameComponents;
//import static freemanproject.FreemanProject.gameSounds;
import freemanproject.DrawPanel;
import java.util.ArrayList;

/**
 *
 * @author freeman
 */
public class NewGame {
    DrawPanel drawPanel;
    Runnable theJob;
    Runnable theJob2;
    
    private ArrayList<GameComponent> gameComponents;
    private ArrayList<GameSound> gameSounds;
    
    public void buildGame(String gameName, ArrayList<GameComponent> gameComponents, ArrayList<GameSound> gameSounds) {
        this.gameComponents = gameComponents;
        this.gameSounds = gameSounds;
        for(int i=0;i<gameComponents.size();i++)
            gameComponents.get(i).upLoadGameComponents(gameComponents, gameSounds);
        drawPanel = new DrawPanel(gameComponents);
        theJob = new GameWindow(gameComponents,drawPanel,gameName);
        Thread alpha = new Thread(theJob);
        alpha.start();
        theJob2 = new ReadKeyboard(gameComponents,drawPanel);
        Thread beta = new Thread(theJob2);
        beta.start();
    }
}
