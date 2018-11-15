
package GameBuilder;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa a interface KeyListener <br>
 * O objetivo dela e ler, em qualquer momento, uma tecla que o usuário
 * digitar<br>
 * e guardar o código ANSI dela em uma váriavel
 */
public class KeyBoard implements KeyListener {

	private static List<Integer> teclas;
	
	public KeyBoard() {
		teclas = new ArrayList<>();
	}
	
	public List<Integer> getTeclas() {
		return teclas;
	}
	
	public void keyPressed(KeyEvent e) {
		if (!teclas.contains(e.getKeyCode())) {
			teclas.add(e.getKeyCode());
		}
	}

	/**
	 * Função que é disparada quando o usuário solta uma tecla que ele apertou <br>
	 * Ela atualiza o valor da variável funcionou
	 */
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < teclas.size(); i++) {
			if (teclas.get(i) == e.getKeyCode()) {
				teclas.remove(i);
			}
		}
	}
	
	public void limpaTeclas() {
		teclas = new ArrayList<>();
	}

	/**
	 * Função que é dispara enquanto o usuário está com uma tecla pressionada
	 */
	public void keyTyped(KeyEvent e) {
	}


}
