
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Screen extends JPanel implements ActionListener, KeyListener{
    private int score;
    private double vel;
    Random rx = new Random();
    Timer t = new Timer(10,this);
    Player p = new Player(10,10,10,10,0,0);
    Food food = new Food(rx.nextInt(400),rx.nextInt(400),10,10,0,0);
    
    public Screen()
    {
        /*JPanel panel = new JPanel();
        Label scorel = new Label("score"+ getScore());
        panel.add(scorel);*/

        vel = 1;
        score = 0;
        //foodEaten();
        addKeyListener(this);
        setFocusable(true);
        t.start();
    }
    
    public void writeRecord()
    {
        //System.out.println("Digite o nome (sem espaços): ");
        //Scanner nome = new Scanner();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //foodEaten();
        writeRecord();
        //scoreLable();
        p.tick(); //update player position!
        p.collision();
        increaseVelPlayer();
        Eat();
        gameOver();
        repaint();
    }
    
    public void gravarScore()
    {
        String nome;
        
    }
    
    public void scoreLable()
    {
        JPanel panel = new JPanel();
        JLabel jlabel = new JLabel("This is a label");
        jlabel.setFont(new Font("Verdana",1,20));
        panel.add(jlabel);
        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        this.add(panel, new GridBagConstraints());
        this.setSize(400, 400);
        //this.setLocationRelativeTo(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    /*
    True se o player toca nas extermidades
    */
    public boolean checkBorder()
    {
        return (p.getX()==400||p.getY()==400||p.getX()==0||p.getY()==0);
    }
    
    
    /*
    Caso toque nas extermidades gameover
    */
    public void gameOver()
    {
        if (checkBorder())
        {
            p = new Player(10,10,10,10,0,0);
            food = new Food(rx.nextInt(400),rx.nextInt(400),10,10,0,0);
            p.setDx(0);
            p.setDy(0);
            if (score < 10)
            {
                System.out.println("Your score was: "+ score + ", weak score i say HAHAHAHAHA, you realy suck ate this come onnn!!");
            }
            else if (score < 20)
            {
                System.out.println("Your score was: "+ score + ", hmmmm not bad! but still horrible");
            }
            else if (score < 30)
            {
                System.out.println("Your score was: "+ score + ",okayyyy you impressed me! ");
            }
            else if (score < 40)
            {
                System.out.println("Your score was: "+ score + ",are you even human !??!?!?!? ");
            }
            else if (score >= 40)
            {
                System.out.println("Your score was: "+ score + ", seriously stop! you broke the game okay! are you happy??????");
            }
            setScore(0);
        }
    }
    
    
    /*
    A cada multiplo de 10(k * 10) a velocidade sera k+1 ex: score 20 vel -> 3, score 30 -> 4... 
    */
    public void increaseVelPlayer()
    {
        if(score >= 10)
        {
            setVel(((score/10)%10)+1);
            //System.out.println(vel); //debug
        }
        else if(score < 10)
        {
            setVel(1);
            //System.out.println(vel);
        }
    }
    
    /*
    Neste metodo verifica se o player intersteta com a fruta e posicionaa fruta noutra posição!
    */
    public void Eat() 
    {
        if(((p.getX() <= food.getX()) && (food.getX()<= p.getX()+10))&&((p.getY() <= food.getY()) && (food.getY()<= p.getY()+10)))
        {
            //System.out.println("COMIDA!");debug
            food = new Food(rx.nextInt(400),rx.nextInt(400),10,10,0,0); //desloca a fruta pra uma posição random
            score = score + 1; //incrementa os pontos a cada interseção com a fruta
            System.out.println("Score: " + score);
        }
        else
        {
            //System.out.println("NAO É COMIDA!");debug
            //System.out.println("PLAYER : "+" x -> "+ p.getX() +" y -> "+ p.getY()); //debug!
            //System.out.println("FOOD : "+" x -> "+ food.getX() +" y -> "+ food.getY()); //debug!
        }
    }
    
    @Override
    public void paint(Graphics g)
    {
        //g.drawRect(10,10,10,10);
        g.clearRect(0, 0, getWidth(), getHeight());
        
        p.draw(g);
        food.draw(g);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent k) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if((p.getX()>0 && p.getX()< 400) && (p.getY()>0 && p.getY()< 400)){
            switch(k.getKeyCode())
            {
                case KeyEvent.VK_D: //Pressionado na tecla D
                    p.setDx(vel);
                    break;
                case KeyEvent.VK_S: //Pressionado na tecla S
                    p.setDy(vel);
                    break;
                case KeyEvent.VK_A: //Pressionado na tecla A
                    p.setDx(-vel);
                    break;
                case KeyEvent.VK_W: //Pressionado na tecla W
                    p.setDy(-vel);
                    break;
            }
        }
        else if ((p.getX()<0 && p.getX()> 400) || (p.getY()< 0 && p.getY()>400) || ((p.getX()== 400) && (p.getY()== 400)) || (p.getY() == 0))
        {
            p.setDx(0);
            p.setDy(0);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     Getter do score
     */
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    /*
    Getter da velocidade
    */
    public double getVel()
    {
        return vel;
    }
    
    /*
    Setter da velocidade
    */
    public void setVel(int vel)
    {
        this.vel = vel;
    }
}
