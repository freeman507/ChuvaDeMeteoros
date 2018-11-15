package freemanproject;

import GameBuilder.GameSound;
import GameBuilder.NewGame;
import GameBuilder.GameComponent;
import java.util.ArrayList;

public class FreemanProject {

	public static void main(String[] args) {

		ArrayList<GameComponent> gameComponents = new ArrayList<>();
		ArrayList<GameSound> gameSounds = new ArrayList<>();

		BackGround backGround = new BackGround();
		SpaceShip spaceShip = new SpaceShip();

		gameComponents.add(backGround);
		gameComponents.add(spaceShip);
		for (int i = 0; i < 10; i++) {
			gameComponents.add(new Meteour());
		}

		GameSound spacegun = new GameSound("audio/spacegun.wav");
		gameSounds.add(spacegun);
		new NewGame().buildGame("chuva de meteoros", gameComponents, gameSounds);
	}
}