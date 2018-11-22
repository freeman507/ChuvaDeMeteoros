/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBuilder;

import GameBuilder.KeyBoard;
import GameBuilder.GameComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

public class GameWindow implements Runnable
    {
        JFrame frame;
        DrawPanel drawPanel;
        String gameName;
        ArrayList<GameComponent> gameComponents;
        
        public GameWindow(ArrayList<GameComponent> gameComponents,DrawPanel drawPanel, String gameName) {
            this.gameComponents = gameComponents;
            this.drawPanel = drawPanel;
            this.gameName = gameName;
        }
        
        public void run()
        {
            //criar janela
            frame = new JFrame(gameName);

            frame.addKeyListener(new KeyBoard());
            
            //adicionando componentes no frame
            frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

            //propriedades finais do frame
            frame.setBackground(Color.BLACK);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1024,768);
            frame.setVisible(true);
        }       
    }