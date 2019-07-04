package dtc.com.vn.map;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * Created by ÁC MA BÊN EM on 5/9/2016.
 */
public class Map {
    private int x,y,bit;
    Image[] images = {
            new ImageIcon(getClass()
                    .getResource("/image/brick.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/image/rock.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/image/tree.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/image/water.png")).getImage(),
            new ImageIcon(getClass()
                    .getResource("/image/bird.png")).getImage()
    };
    Image imageBird=new ImageIcon(getClass()
    .getResource("/image/tank_exp5.png")).getImage();


    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    public Map() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public void draw(Graphics2D g2D){
        if (bit != 5){
            g2D.drawImage(images[bit],x,y,null);
        }
    }

    public Rectangle getRect(){
        Rectangle rectangle;
        if (bit == 5){
            rectangle = new Rectangle();
        } else {
            rectangle = new Rectangle(
                    x,
                    y,
                    images[bit].getWidth(null),
                    images[bit].getHeight(null));
        }
        return rectangle;
    }
}
