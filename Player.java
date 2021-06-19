import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Player extends Rectangle {
    private double dx, dy;

    public Player(int x, int y, int width, int height, double dx, double dy)
    {
        setBounds(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }
    
    public void tick()
    {
        this.x += dx; //movimento na horizontal
        this.y += dy; //movimento na vertical
    }
    
    public void collision()
    {
        if(getX()==400||getY()==400||getX()==0||getY()==0)
        {
            setDx(0);
            setDy(0);
            //System.out.println("GameOver!");
            //System.out.println("Colisao: "+" x -> "+ getX() +" y -> "+ getY()); //debug!
        }
    }
    
    /*public void isEat(Food f)
    {
        if((this.getY()== f.getY())&& (this.getX()== f.getX()))
        {
            System.out.println("COMIDA!");
        }
    }*/
    
    
    public void draw(Graphics g)
    {
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
    
    public double getDx()
    {
        return dx;
    }
    
    public double getDy()
    {
        return dy;
    }
}
