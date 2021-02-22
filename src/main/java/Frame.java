import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */

public class Frame extends JFrame{
   
    public Frame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("RUSH!!! can you survive??? ");
        setSize(450,450); //tamanho da janela
        setResizable(false);
        
        init();
    }
    //https://www.youtube.com/watch?v=Yem67dViGSw
    //1:57
    
    public void init()
    {
        setLocationRelativeTo(null);
        
        setLayout(new GridLayout(1,1,0,0));
        
        Screen s = new Screen();
        
        add(s);
        
        setVisible(true);
        
        /*JPanel panel = new JPanel();
        Label score = new Label("score"+ s.getScore());
        panel.add(score);*/

    }
    
    public static void main(String[] args)
    {
        Frame f = new Frame();
    }
    
    
}
