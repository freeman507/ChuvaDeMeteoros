
package GameBuilder;

import java.awt.event.*;

/**
 * Classe que implementa a interface KeyListener
 * <br>O objetivo dela e ler, em qualquer momento, uma tecla que o usuário
 * digitar<br>
 * e guardar o código ANSI dela em uma váriavel
 */
public class KeyBoard implements KeyListener {

    //Vetor que guarda quais teclas estãoapertadas  
    private static boolean[] TeclasPressionadas = new boolean[256];

    /**
     * Função que é disparada quando o usuário digita qualquer
     * <br> tecla, mesmo que fora de uma leitura.
     * <br> Ela guarda a tecla que o usuário digitou.
     */
    public KeyBoard() {
        for (int i = 0; i < 256; i++) {
            TeclasPressionadas[i] = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 256) {
            TeclasPressionadas[e.getKeyCode()] = true;
        }
    }

    /**
     * Função que é disparada quando o usuário solta uma tecla que ele apertou
     * <br>Ela atualiza o valor da variável funcionou
     */
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 256) {
            TeclasPressionadas[e.getKeyCode()] = false;
        }

    }

    /**
     * Função que é dispara enquanto o usuário está com uma tecla pressionada
     */
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Função usada para fazer a interface com o programador que<br>
     * usar esta classe.
     *
     * @return <code>CodTecla</code> - o valor ANSI da última tecla digitada
     * pelo usuário
     */
    public static boolean EstaPressionada(int Tecla) {
        return TeclasPressionadas[Tecla];
    }
    
    public static boolean nenhumaPressionada()
    {
        for(int i=0;i<256;i++)
        {
            if(TeclasPressionadas[i])
                return false;
        }
        return true;
    }

}
