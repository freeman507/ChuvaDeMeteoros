package freemanproject;

import GameBuilder.GameSound;
import GameBuilder.NewGame;
import GameBuilder.GameComponent;
import java.util.ArrayList;

public class FreemanProject {

	public static ArrayList<GameComponent> gameComponents = new ArrayList<>();
	public static ArrayList<GameSound> gameSounds = new ArrayList<>();

	public static void main(String[] args) {

		GameSound spacegun = new GameSound("audio/spacegun.wav");
		gameSounds.add(spacegun);

		BackGround backGround = new BackGround();
		gameComponents.add(backGround);

		SpaceShip spaceShip = new SpaceShip();
		spaceShip.setTiro(spacegun);
		gameComponents.add(spaceShip);

		for (int i = 0; i < 10; i++) {
			Meteour meteoro = new Meteour();
			meteoro.setSpaceship(spaceShip);
			gameComponents.add(meteoro);
		}

		new NewGame().buildGame("chuva de meteoros", gameComponents, gameSounds);
	}
}