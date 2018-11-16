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

	public Meteour() {
		super("meteour", "img/meteour/", 1, Math.round(Math.random() * 971), Math.round(Math.random() * -768), 53, 53);
	}

	@Override
	public void acao(List<Integer> teclas) {
		float y = getPosicaoVertical();
		if (y <= 768) {
			y += 0.3;
			setPosicaoVertical(y);;
		} else {
			setPosicaoVertical(Math.round(Math.random() * -768));
			setPosicaoHorizontal(Math.round(Math.random() * 971));
		}

		if (isColisao(gameComponents.get(1), this)) {
			gameComponents.clear();
			gameComponents.add(new GameOver());
		}

		try {
			GameComponent g = isColisao("missele");
			if (isColisao(this, g)) {
				SpaceShip p = (SpaceShip) gameComponents.get(1);
				int num = p.getNumMetours();
				p.setNumMetours(--num);
				gameComponents.remove(g);
				gameComponents.remove(this);
			}
		} catch (Exception ex) {
		}
	}

}
