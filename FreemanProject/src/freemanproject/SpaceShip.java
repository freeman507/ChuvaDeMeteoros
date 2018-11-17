/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

import java.util.List;

import GameBuilder.GameComponent;
import GameBuilder.GameSound;

/**
 *
 * @author freeman
 */
public class SpaceShip extends GameComponent {

	private int numMetours;
	
	private GameSound tiro;

	public GameSound getTiro() {
		return tiro;
	}

	public void setTiro(GameSound spacegun) {
		this.tiro = spacegun;
	}

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
	public void acao(List<Integer> teclas) {
		float x = getPosicaoHorizontal();
		float y = getPosicaoVertical();

		if (isTeclaPressionada(SETA_DIREITA, teclas) && x <= 987) {
			x += 0.5;
			setPosicaoHorizontal(x);
			setSpriteCorrente(2);
		}

		if (isTeclaPressionada(SETA_ESQUERDA, teclas) && x >= 0) {
			x -= 0.5;
			setPosicaoHorizontal(x);
			setSpriteCorrente(0);
		}

		if (isTeclaPressionada(SETA_CIMA, teclas) && y >= 0) {
			y -= 0.5;
			setPosicaoVertical(y);
		}

		if (isTeclaPressionada(SETA_BAIXO, teclas) && y <= 650) {
			y += 0.5;
			setPosicaoVertical(y);
		}

		if (teclas.isEmpty()) {
			setSpriteCorrente(1);
		}

		if (isTeclaPressionada(Z, teclas)) {
			if (!esperar(500)) {
				reproduzirSom(tiro, false);
				Missele m = new Missele(x + 18, y);
				FreemanProject.gameComponents.add(m);
			} else {
				habilitarSom(tiro);
			}
		}

		if (numMetours == 0) {
			FreemanProject.gameComponents.clear();
			FreemanProject.gameComponents.add(new YouWin());
		}
	}
}
