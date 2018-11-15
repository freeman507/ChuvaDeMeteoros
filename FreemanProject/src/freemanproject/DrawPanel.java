package freemanproject;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import GameBuilder.GameComponent;

/**
 *
 * @author freeman
 */
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<GameComponent> gameComponents;
	private GameComponent gameComponent;

	public DrawPanel(ArrayList<GameComponent> gameComponents) {
		this.gameComponents = gameComponents;
	}

	public void paintComponent(Graphics g) {
		for (int i = 0; i < gameComponents.size(); i++) {
			gameComponent = gameComponents.get(i);
			g.drawImage(gameComponent.getGameComponentSprite(),
					Math.round(gameComponent.getGameComponentPositionHorizontal()),
					Math.round(gameComponent.getGameComponentPositionVertical()), this);
		}
	}
}
