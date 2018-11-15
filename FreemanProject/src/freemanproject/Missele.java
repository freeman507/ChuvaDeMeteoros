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
public class Missele extends GameComponent {

	public Missele(float horizontalPosition, float verticalPosition) {
		super("missele", "img/missele/", 2, horizontalPosition, verticalPosition, 4, 15);
	}

	@Override
	public void GameComponentAction(List<Integer> teclas) {
		float y = getGameComponentPositionVertical();
		if (y >= 0) {
			y -= 0.5;
			setGameComponentPositionVertical(y);
		} else {
			gameComponents.remove(this);
		}
	}
}
