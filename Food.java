import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilizador
 */
public class Food extends Rectangle{
    
    private int dx, dy;

    public Food (int x, int y, int width, int height, int dx, int dy)
    {
        setBounds(x, y, width, height);
        //this.dx = dx;
        //this.dy = dy;
    }
    
    /*public void tick()
    {
        this.x += dx; //movimento na horizontal
        this.y += dy; //movimento na vertical
    }*/
    
    /*public void collision()
    {
        if(getX()==400||getY()==400||getX()==0||getY()==0)
        {
            setDx(0);
            setDy(0);
            //System.out.println("Colisao: "+" x -> "+ getX() +" y -> "+ getY()); //debug!
        }
    }*/
    
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        //g.fillRect(this.x, this.y, this.width, this.height);
        g2d.setColor(new Color(250, 0, 0)); //vermelho
        //g2d.fillRect(50, 50, 5, 5);
        Random rx = new Random(); 
        g2d.fillRect(this.x, this.y, 5, 5);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
    public int getDx()
    {
        return dx;
    }
    
    public int getDy()
    {
        return dy;
    }
}
