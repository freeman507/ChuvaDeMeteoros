/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBuilder;

import java.util.ArrayList;

//import static freemanproject.FreemanProject.gameComponents;
//import static freemanproject.FreemanProject.gameSounds;
import freemanproject.DrawPanel;

/**
 *
 * @author freeman
 */
public class NewGame {
	DrawPanel drawPanel;
	Runnable theJob;
	Runnable theJob2;

	public void buildGame(String gameName, ArrayList<GameComponent> gameComponents, ArrayList<GameSound> gameSounds) {

		for (GameComponent gameComponent : gameComponents) {
			gameComponent.upLoadGameComponents(gameComponents, gameSounds);
		}
		
		drawPanel = new DrawPanel(gameComponents);
		theJob = new GameWindow(gameComponents, drawPanel, gameName);
		Thread alpha = new Thread(theJob);
		alpha.start();
		theJob2 = new ReadKeyboard(gameComponents, drawPanel);
		Thread beta = new Thread(theJob2);
		beta.start();
	}
}
