/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBuilder;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * Classe principal do framework, deve ser estendida por todos os objetos do jogo,
 * pois é através dela que os objetos criaram vida.
 * 
 * @author Freeman
 *
 */
public abstract class GameComponent {

	protected Long idGameComponent; // identificador do objeto. (não é obrigatório)

	private ArrayList<GameComponent> gameComponents; // referencia ao array principal
	private ArrayList<GameSound> gameSounds; // referencia ao array principal de sons

	private ArrayList<Image> sprites;// Armazena Sprites(imagens) do objeto
	private String nome; // nome ou tipo do objeto
	private float posicaoHorizontal; // armazena a posição horizontal do componente
	private float posicaoVertical; // armazena a posição vertical do componente
	private int largura; // armazena largura do componente, utilizada no metodo de colisão
	private int altura; // armazena a altura do componente, utilizada no metedo de colisão

	private long tempoFinal; // armazena um determinado final de tempo para controle de instruções
	private boolean flagTempo; // flag para arterar timeFinal
	private int spriteCorrente; // indica qual imagem ou sprite o objeto deve estar

	/**
	 * Constantes do teclado:
	 */

	public static final int ASPA = 222; // tecla aspa simples
	public static final int TAB = 9;
	public static final int SHIFT = 16;
	public static final int CONTROL = 17;
	public static final int ALT = 18;
	public static final int ESPACO = 32;
	public static final int ENTER = 10;
	public static final int IGUAL = 61;
	public static final int BACKSPACE = 8;
	public static final int MENOS_TECLADO_NUMERICO = 109; // tecla "-" (menos ou ifem) do teclado numerico
	public static final int MENOS = 45; // tecla "-" (menos ou ifem)
	public static final int CAPSLOCK = 20;

	public static final int SETA_DIREITA = 39;
	public static final int SETA_ESQUERDA = 37;
	public static final int SETA_CIMA = 38;
	public static final int SETA_BAIXO = 40;

	public static final int F1 = 112;
	public static final int F2 = 113;
	public static final int F3 = 114;
	public static final int F4 = 115;
	public static final int F5 = 116;
	public static final int F6 = 117;
	public static final int F7 = 118;
	public static final int F8 = 119;
	public static final int F9 = 120;
	public static final int F10 = 121;
	public static final int F11 = 122;
	public static final int F12 = 123;

	public static final int TECLA_0 = 48;
	public static final int TECLA_1 = 49;
	public static final int TECLA_2 = 50;
	public static final int TECLA_3 = 51;
	public static final int TECLA_4 = 52;
	public static final int TECLA_5 = 53;
	public static final int TECLA_6 = 54;
	public static final int TECLA_7 = 55;
	public static final int TECLA_8 = 56;
	public static final int TECLA_9 = 57;

	public static final int A = 65;
	public static final int B = 66;
	public static final int C = 67;
	public static final int D = 68;
	public static final int E = 69;
	public static final int F = 70;
	public static final int G = 71;
	public static final int H = 72;
	public static final int I = 73;
	public static final int J = 74;
	public static final int K = 75;
	public static final int L = 76;
	public static final int M = 77;
	public static final int N = 78;
	public static final int O = 79;
	public static final int P = 80;
	public static final int Q = 81;
	public static final int R = 82;
	public static final int S = 83;
	public static final int T = 84;
	public static final int U = 85;
	public static final int V = 86;
	public static final int W = 87;
	public static final int X = 88;
	public static final int Y = 89;
	public static final int Z = 90;

	/**
	 * Costrutor do GameComponent, deve se implementado nas subclasses(classes
	 * filhas).
	 * 
	 * @param nome              Nome do sprite(imagem) sem o indice.
	 * @param caminhoSprites    Caminho do diretório que contém os sprites.
	 * @param qauntidadeSprites Quanidade de sprites.
	 * @param posicaoHorizontal Posisão do eixo horizontal em que o objeto deve ser
	 *                          desenhado.
	 * @param posicaoVertical   Posisão do eixo vertial em que o objeto deve ser
	 *                          desenhado.
	 * @param largura           Largura do objeto, também define o espaço horizontal
	 *                          da área de colisão.
	 * @param altura            Altura do objeto, também define o espaço vertial da
	 *                          área de colisão.
	 */
	protected GameComponent(String nome, String caminhoSprites, int qauntidadeSprites, float posicaoHorizontal,
			float posicaoVertical, int largura, int altura) {
		this.nome = nome;
		this.posicaoHorizontal = posicaoHorizontal;
		this.posicaoVertical = posicaoVertical;
		this.largura = largura;
		this.altura = altura;
		spriteCorrente = 0;
		flagTempo = false;
		tempoFinal = 0;
		sprites = new ArrayList<Image>();
		carregaSprites(this.nome, caminhoSprites, qauntidadeSprites);
	}

	/**
	 * Adiciona um identificador ao objeto.
	 * 
	 * @param idGameComponent Identificador do objeto.
	 */
	public void setIdGameComponent(Long idGameComponent) {
		this.idGameComponent = idGameComponent;
	}

	/**
	 * Recupera o identificador dor objeto.
	 * 
	 * @return idenificador do objeto.
	 */
	public Long getIdGameComponent() {
		return idGameComponent;
	}

	/**
	 * Recupera a referencia dos objetos do jogo.
	 * 
	 * @return Retorna uma lista de GameComponents.
	 */
	public ArrayList<GameComponent> getGameComponents() {
		return gameComponents;
	}

	/**
	 * Adiciona ao objeto a referência de todos os objetos do jogo, pode ser usado
	 * para adicionar mais objetos ao jogo e também remover.
	 * 
	 * @param gameComponents Lista de objtos do jogo.
	 */
	public void setGameComponents(ArrayList<GameComponent> gameComponents) {
		this.gameComponents = gameComponents;
	}

	/**
	 * Recupera a lista de sons do objeto.
	 * 
	 * @return
	 */
	public ArrayList<GameSound> getGameSounds() {
		return gameSounds;
	}

	/**
	 * Adiciona uma lista de sons para o objeto.
	 * 
	 * @param gameSounds Lista que contém os sons.
	 */
	public void setGameSounds(ArrayList<GameSound> gameSounds) {
		this.gameSounds = gameSounds;
	}

	/**
	 * Recupera o nome do objeto.
	 * 
	 * @return Nome do objeto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome do objeto, esse nome é usado no caminho para procurar os
	 * sprites do objeto.
	 * 
	 * @param name Nome da imagem sem o indice.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Define a posição atual do objeto no eixo horizontal na tela.
	 * 
	 * @param position Posição horizontal do objeto.
	 */
	public void setPosicaoHorizontal(float posicaohorizontal) {
		this.posicaoHorizontal = posicaohorizontal;
	}

	/**
	 * Define a posição atual do objeto no eixo vertial na tela.
	 * 
	 * @param position Posição vertual do objeto
	 */
	public void setPosicaoVertical(float posicalVertical) {
		this.posicaoVertical = posicalVertical;
	}

	/**
	 * Define a largura em pixels do objeto, essa propriedade é usada para testar a
	 * área de colisão.
	 * 
	 * @param largura Largura do objeto.
	 */
	public void setLargura(int largura) {
		this.largura = largura;
	}

	/**
	 * Define a altura em pixels do objeto, essa propriedade é usada para testar a
	 * área de colisão.
	 * 
	 * @param altura Altura do objeto.
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Define o sprite que será exibido na tela.
	 * 
	 * @param spriteCorrente indice do sprite.
	 */
	public void setSpriteCorrente(int spriteCorrente) {
		this.spriteCorrente = spriteCorrente;
	}

	/**
	 * Recupera a posição do eixo horizontal do objeto na tela.
	 * 
	 * @return Posição horizontal.
	 */
	public float getPosicaoHorizontal() {
		return posicaoHorizontal;
	}

	/**
	 * Recupera a posição do eixo vertical do objeto na tela.
	 * 
	 * @return Posição vertical.
	 */
	public float getPosicaoVertical() {
		return posicaoVertical;
	}

	/**
	 * Retorna a largura do objeto, essa propriedade é usada para verificar a
	 * colisão com outros objetos.
	 * 
	 * @return Largura do objeto.
	 */
	public int getLargura() {
		return largura;
	}

	/**
	 * Retorna a Altura do objeto, essa propriedade é usada para verificar a colisão
	 * com outros objetos.
	 * 
	 * @return Altura do objeto.
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Retorna o indice do sprite atual do objeto.
	 * 
	 * @return indice do sprite.
	 */
	public int getSpriteCorrente() {
		return spriteCorrente;
	}

	/**
	 * Retorna a imagem do sprite corrente.
	 * 
	 * @return Imagem do sprite.
	 */
	public Image getSprite() {
		return sprites.get(spriteCorrente);
	}

	/**
	 * Carrega as imagens ou sprites para o componente
	 * 
	 * @param nome
	 * @param caminhoSprites
	 * @param quantidadeSprites
	 */
	public void carregaSprites(String nome, String caminhoSprites, int quantidadeSprites) {
		for (int i = 0; i < quantidadeSprites; i++) {
			sprites.add(new ImageIcon(caminhoSprites + nome + i + ".png").getImage());
		}
	}

	/**
	 * Atualiza os componentes e suas referencias, importante para o metodo de
	 * colisão
	 * 
	 * @param gameComponents
	 * @param gameSounds
	 */
	public void atualizaGameComponents(ArrayList<GameComponent> gameComponents, ArrayList<GameSound> gameSounds) {
		this.gameComponents = gameComponents;
		this.gameSounds = gameSounds;
	}

	/**
	 * Testa se há colisao entre dois componentes, se houver retorna true
	 * 
	 * @param a Objeto de jogo
	 * @param b Objeto de jogo
	 * @return
	 */
	public boolean isColisao(GameComponent a, GameComponent b) {

		if ((((a.getPosicaoHorizontal() <= (b.getPosicaoHorizontal() + b.getLargura()))
				&& (a.getPosicaoHorizontal() >= b.getPosicaoHorizontal()))
				|| ((a.getPosicaoHorizontal() + a.getLargura()) >= b.getPosicaoHorizontal())
						&& (a.getPosicaoHorizontal() + a.getLargura()) <= (b.getPosicaoHorizontal() + b.getLargura()))
				&& ((a.getPosicaoVertical() <= (b.getPosicaoVertical() + b.getAltura()))
						&& (a.getPosicaoVertical() + a.getAltura()) >= (b.getPosicaoVertical())))
			return true;
		else if ((((b.getPosicaoHorizontal() <= (a.getPosicaoHorizontal() + a.getLargura()))
				&& (b.getPosicaoHorizontal() >= a.getPosicaoHorizontal()))
				|| ((b.getPosicaoHorizontal() + b.getLargura()) >= a.getPosicaoHorizontal())
						&& (b.getPosicaoHorizontal() + b.getLargura()) <= (a.getPosicaoHorizontal() + a.getLargura()))
				&& ((b.getPosicaoVertical() <= (a.getPosicaoVertical() + a.getAltura()))
						&& (b.getPosicaoVertical() + b.getAltura()) >= (a.getPosicaoVertical())))
			return true;
		else
			return false;
	}

	/**
	 * Verifica se existe colisão com um determinado tipo de GameComponent
	 * 
	 * @param nome Nome do tipo do GameComponent
	 * @return Retorna a referencia do GameComponent que colidiu
	 */
	public GameComponent isColisao(String nome) {
		for (int i = 0; i < gameComponents.size(); i++) {
			if (gameComponents.get(i).getNome().equals(nome))
				if (isColisao(gameComponents.get(i), this)) {
					return gameComponents.get(i);
				}
		}
		return null;
	}

	/**
	 * Para o tempo, NAO FUNCIONA!
	 * 
	 * @param time
	 */
	public void stopTime(int time) {
		Thread t = new Thread();
		t.start();
		try {
			Thread.sleep(time);
		} catch (Exception ex) {
		}
	}

	/**
	 * Faz um intervalo de tempo, retorna false quando acaba o intervalo
	 * 
	 * @param tempo em milisegundos.
	 * @return
	 */
	public boolean esperar(long tempo) {
		if (!flagTempo) {
			tempoFinal = System.currentTimeMillis() + tempo;
			flagTempo = true;
		}
		if (System.currentTimeMillis() <= tempoFinal) {
			return true;
		} else {
			flagTempo = false;
			return false;
		}
	}

	/**
	 * reproduz e faz o controle de som
	 * 
	 * @param gameSound som a ser referenciado
	 * @param looping   verdadeiro para o som ficar em repetição
	 */
	public void reproduzirSom(GameSound gameSound, boolean looping) {
		if (gameSound.getGameSoundEnable()) {
			gameSound.setGameEnableSound(false);
			if (looping)
				gameSound.GameSoundLoopWav();
			else
				gameSound.GameSoundPlayWav();
		}
	}
	
	public void habilitarSom(GameSound gameSound) {
		gameSound.setGameEnableSound(true);
	}

	/**
	 * Verfica se uma tecla foi pressionada.
	 * 
	 * @param tecla Código ou constante da tecla.
	 * @param teclas Lista de teclas pressionadas
	 * @return Retorna true quando a tecla está pressionada.
	 */
	public boolean isTeclaPressionada(int tecla, List<Integer> teclas) {
		return teclas.contains(tecla);
	}

	/**
	 * Método que faz a ação do objeto. Este método deve ser sobreescrito nas subclasses(classes filhas).
	 * 
	 * @param teclas Lista de teclas pressionadas.
	 */
	public void acao(List<Integer> teclas) {

	}
}
