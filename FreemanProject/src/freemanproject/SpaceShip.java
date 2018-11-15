/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

import java.util.List;

import GameBuilder.GameComponent;

/**
 *
 * @author freeman
 */
public class SpaceShip extends GameComponent {

	private int numMetours;

	public SpaceShip() {
		super("spaceship", "img/sprites_spaceship/", 3, 0, 600, 37, 34);
		numMetours = 10;
	}

	public void setNumMetours(int numMetours) {
		this.numMetours = numMetours;
	}

	public int getNumMetours() {
		return this.numMetours;
	}

	@Override
	public void GameComponentAction(List<Integer> teclas) {
		float x = getGameComponentPositionHorizontal();
		float y = getGameComponentPositionVertical();

		if (teclas.contains(keyRight) && x <= 987) {
			x += 0.5;
			setGameComponentPositionHorizontal(x);
			setGameComponentCurrentSprite(2);
		}

		if (teclas.contains(keyLeft) && x >= 0) {
			x -= 0.5;
			setGameComponentPositionHorizontal(x);
			setGameComponentCurrentSprite(0);
		}

		if (teclas.contains(keyUp) && y >= 0) {
			y -= 0.5;
			setGameComponentPositionVertical(y);
		}

		if (teclas.contains(keyDown) && y <= 650) {
			y += 0.5;
			setGameComponentPositionVertical(y);
		}

		if (teclas.isEmpty()) {
			setGameComponentCurrentSprite(1);
		}

		if (teclas.contains(keyZ)) {
			if (!GameComponentWait(500)) {
				GameComponentPlaySound(gameSounds.get(0), false);
				Missele m = new Missele(x + 18, y);
				m.setGameComponents(gameComponents);
				gameComponents.add(m);
			} else {
				gameSounds.get(0).setGameEnableSound(true);
			}
		}

		if (numMetours == 0) {
			gameComponents.clear();
			gameComponents.add(new YouWin());
		}
	}
}
