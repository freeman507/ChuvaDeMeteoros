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
public class Meteour extends GameComponent {

	private SpaceShip spaceship;

	public Meteour() {
		super("meteour", "img/meteour/", 1, Math.round(Math.random() * 971), Math.round(Math.random() * -768), 53, 53);
	}

	public SpaceShip getSpaceship() {
		return spaceship;
	}

	public void setSpaceship(SpaceShip spaceship) {
		this.spaceship = spaceship;
	}

	@Override
	public void acao(List<Integer> teclas) {
		float y = getPosicaoVertical();
		if (y <= 768) {
			y += 0.3;
			setPosicaoVertical(y);
			;
		} else {
			setPosicaoVertical(Math.round(Math.random() * -768));
			setPosicaoHorizontal(Math.round(Math.random() * 971));
		}

		if (isColisao(spaceship, this)) {
			FreemanProject.gameComponents.clear();
			FreemanProject.gameComponents.add(new GameOver());
		}

		Missele missil = (Missele) isColisao("missele");
		if (missil != null && isColisao(this, missil)) {
			int num = spaceship.getNumMetours();
			spaceship.setNumMetours(--num);
			FreemanProject.gameComponents.remove(missil);
			FreemanProject.gameComponents.remove(this);
		}

	}

}
