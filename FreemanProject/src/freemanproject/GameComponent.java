/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freemanproject;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author freeman
 */
abstract class GameComponent {
    private ArrayList<Image> sprites;
    static ArrayList<GameComponent> gameComponents;
    ArrayList<GameSound> gameSounds;
    private String componentName;
    float componentPositionHorizontal;
    float componentPositionVertical;
    private int componentSizeWidth;
    private int componentSizeHeight;
    private long time;
    private long timeFinal;
    private boolean flagTime;
    int currentSprite;
    private boolean[] keyPressed;
    
    public static final int keyNoPressed = 0;
    
    public static final int keyQuote = 222; //tecla aspa simples
    public static final int keyTab = 9;
    public static final int keyShift = 16;
    public static final int keyControl = 17;
    public static final int keyAlt = 18;
    public static final int keySpace = 32;
    public static final int keyEnter = 10;
    public static final int keyEquals = 61;
    public static final int keyBackSpace = 8;
    public static final int keySubtract = 109 ; // tecla "-" (menos ou ifem) do teclado numerico
    public static final int keyMinus = 45;  // tecla "-" (menos ou ifem)
    public static final int keyCapsLock = 20;
    
    public static final int keyRight = 39;
    public static final int keyLeft = 37;
    public static final int keyUp = 38;
    public static final int keyDown = 40;
    
    public static final int keyF1 = 112;
    public static final int keyF2 = 113;
    public static final int keyF3 = 114;
    public static final int keyF4 = 115;
    public static final int keyF5 = 116;
    public static final int keyF6 = 117;
    public static final int keyF7 = 118;
    public static final int keyF8 = 119;
    public static final int keyF9 = 120;
    public static final int keyF10 = 121;
    public static final int keyF11 = 122;
    public static final int keyF12 = 123;
    
    public static final int key0 = 48;
    public static final int key1 = 49;
    public static final int key2 = 50;
    public static final int key3 = 51;
    public static final int key4 = 52;
    public static final int key5 = 53;
    public static final int key6 = 54;
    public static final int key7 = 55;
    public static final int key8 = 56;
    public static final int key9 = 57;
    
    public static final int keyA = 65;
    public static final int keyB = 66;
    public static final int keyC = 67;
    public static final int keyD = 68;
    public static final int keyE = 69;
    public static final int keyF = 70;
    public static final int keyG = 71;
    public static final int keyH = 72;
    public static final int keyI = 73;
    public static final int keyJ = 74;
    public static final int keyK = 75;
    public static final int keyL = 76;
    public static final int keyM = 77;
    public static final int keyN = 78;
    public static final int keyO = 79;
    public static final int keyP = 80;
    public static final int keyQ = 81;
    public static final int keyR = 82;
    public static final int keyS = 83;
    public static final int keyT = 84;
    public static final int keyU = 85;
    public static final int keyV = 86;
    public static final int keyW = 87;
    public static final int keyX = 88;
    public static final int keyY = 89;
    public static final int keyZ = 90;
    
    protected GameComponent(String name, String pathSprites, int numSprites,float positionHorizontal,
            float positionVertical, int width, int height, ArrayList<GameComponent> gameComponents, ArrayList<GameSound> gameSounds)
    {
        componentName = name;
        componentPositionHorizontal = positionHorizontal;
        componentPositionVertical = positionVertical;
        componentSizeWidth = width;
        componentSizeHeight = height;
        currentSprite = 0;
        flagTime = false;
        time = 0;
        timeFinal =0;
        sprites = new ArrayList<Image>();
        this.gameComponents = gameComponents;
        this.gameSounds = gameSounds;
        this.keyPressed = new boolean[256];
        Arrays.fill(keyPressed, Boolean.FALSE);
        loadSprites(this.componentName,pathSprites, numSprites);
    }
    
    public void loadSprites(String componentName, String pathSprites, int numSprites)
    {
        for(int i=0;i<numSprites;i++)
            sprites.add(new ImageIcon(pathSprites+componentName+i+".png").getImage());
    }
    
    public void setGameComponentName(String name) {
        componentName = name;
    }
    
    public void setGameComponentPositionHorizontal(float position) {
        componentPositionHorizontal = position;
    }
    
    public void setGameComponentPositionVertical(float position) {
        componentPositionVertical = position;
    }
    
    public void setGameComponentSizeWidth(int width) {
        componentSizeWidth = width;
    }
    
    public void setGameComponentSizeHeight(int height) {
        componentSizeHeight = height;
    }
    
    public void setGameComponentCurrentSprite(int currentSprite) {
        this.currentSprite = currentSprite;
    }
    
    public void setGameComponentAddActionKey(int codAction) {
        keyPressed[codAction] = true;
    }
    
    public void setGameComponentRemoveActionKey(int codAction) {
        keyPressed[codAction] = false;
    }
    
    public void setGameComponentNoActionKey() {
        keyPressed[255] = true;
    }
    
    public String getGameComponentName() {
        return componentName;
    }
    
    public float getGameComponentPositionHorizontal() {
        return componentPositionHorizontal;
    }
    
    public float getGameComponentPositionVertical() {
        return componentPositionVertical;
    }
    
    public int getGameComponentSizeWidth() {
        return componentSizeWidth;
    }
    
    public int getGameComponentSizeHeight() {
        return componentSizeHeight;
    }
    
    public int getGameComponentCurrentSprite() {
        return currentSprite;
    }
    
    public Image getGameComponentSprite() {
        return sprites.get(currentSprite);
    }
    
    public boolean getGameComponentKeyAction(int codAction) {
        return keyPressed[codAction];
    }
    
    public boolean getGameComponentNoActionKey() {
        return keyPressed[255];
    }
    
    public void upLoadGameComponents(ArrayList<GameComponent> gameComponents, ArrayList<GameSound> gameSounds) {
        this.gameComponents = gameComponents;
        this.gameSounds = gameSounds;
    }
    
    public boolean GameComponentColision(GameComponent a, GameComponent b) {
      if((((a.getGameComponentPositionHorizontal() <= (b.getGameComponentPositionHorizontal() + b.getGameComponentSizeWidth())) 
              && (a.getGameComponentPositionHorizontal() >= b.getGameComponentPositionHorizontal()))
                || ((a.getGameComponentPositionHorizontal() + a.getGameComponentSizeWidth()) >= b.getGameComponentPositionHorizontal()) 
              && (a.getGameComponentPositionHorizontal() + a.getGameComponentSizeWidth()) <= (b.getGameComponentPositionHorizontal() + b.getGameComponentSizeWidth()))
                && ((a.getGameComponentPositionVertical()<=(b.getGameComponentPositionVertical() + b.getGameComponentSizeHeight())) 
              && (a.getGameComponentPositionVertical()+a.getGameComponentSizeHeight())>=(b.getGameComponentPositionVertical())))
            return true;
        else
            return false;
    }
    
    public boolean GameComponentColisionWithType(String nameComponent) {
        for(int i=0; i<gameComponents.size();i++) {
            if(gameComponents.get(i).getGameComponentName().equals(nameComponent))
                if(GameComponentColision(gameComponents.get(i), this)) {
                    return true;
                }
        }
        return false;
    }
    
    public void stopTime(int time) {
        Thread t = new Thread();
        t.start();
        try
        {
            Thread.sleep(time);
        }catch(Exception ex){}
    }
    
    public boolean GameComponentWait(long wait) {
        if(!flagTime) {
            timeFinal = System.currentTimeMillis() + wait;
            flagTime = true;
        }
        if(System.currentTimeMillis() <= timeFinal) {
            return true;
        }
        else {
            flagTime = false;
            return false;
        }
    }
    
    public void GameComponentPlaySound(GameSound gameSound, boolean looping)
    {
        if(gameSound.getGameSoundEnable()) {
            gameSound.setGameEnableSound(false);
            if(looping)
                gameSound.GameSoundLoopWav();
            else
                gameSound.GameSoundPlayWav();
        }
    }
    
    public void GameComponentAction(int codAction) {
       
    }
}
