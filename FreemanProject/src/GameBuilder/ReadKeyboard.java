package GameBuilder;

import GameBuilder.GameComponent;
import java.util.ArrayList;
import java.util.List;

public class ReadKeyboard implements Runnable {

	private final ArrayList<GameComponent> gameComponents;
	private final DrawPanel drawPanel;

	public ReadKeyboard(ArrayList<GameComponent> gameComponents, DrawPanel drawPanel) {
		this.gameComponents = gameComponents;
		this.drawPanel = drawPanel;
	}

	public void run() {

		KeyBoard keyBoard = new KeyBoard();

		do {

			List<Integer> teclas = keyBoard.getTeclas();

			try {
				gameComponents.forEach(gameComponent -> {
					gameComponent.acao(teclas);
				});

				if (teclas.contains(27)) {
					break;
				}
				
			} catch (Exception e) {}

			drawPanel.repaint();
			
			descansar(1L);
		} while (true);

		System.exit(0);
	}

	private void descansar(Long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}