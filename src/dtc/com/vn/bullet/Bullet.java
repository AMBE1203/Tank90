package dtc.com.vn.bullet;

import dtc.com.vn.frame.MyFrame;
import dtc.com.vn.map.Map;
import dtc.com.vn.tank.BossTank;
import dtc.com.vn.tank.MyTank;
import dtc.com.vn.tank.Tank;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ÁC MA BÊN EM on 1/9/2016.
 */
public class Bullet {
    private int x,y,orient;
    Image image=new ImageIcon(
            getClass().getResource("/image/bullet.png")).getImage();
    final Image image1=new ImageIcon(
            getClass().getResource("/image/explosion.png")).getImage();

    public Bullet(int x, int y, int orient) {
        this.x = x-image.getWidth(null)/2;
        this.y = y-image.getHeight(null)/2;
        this.orient = orient;
    }

    public Bullet() {
    }

    public boolean move(ArrayList<Map> arrMap ){

        int speed=10;
        if (orient == Tank.LEFT){
            x-=speed;
        } else if (orient == Tank.RIGHT){
            x+=speed;
        } else if (orient == Tank.UP){
            y-=speed;
        } else if (orient == Tank.DOWN){
            y+=speed;
        }
/*
        kiểm tra va chạm với map.
        nếu va chạm thì return false
 */
        for (Map map : arrMap){
            Rectangle rectangle = getRect()
                    .intersection(map.getRect());

            if (rectangle.isEmpty() == false){
                if (map.getBit()==0 || map.getBit()==1){
                    if (map.getBit()==0){
                        map.setBit(5);
                    }
                    return false;
                }
            }
        }






        if (x<=0
                || x>= MyFrame.w_FRAME - image.getWidth(null) -10
                || y<=0
                || y>= MyFrame.h_FRAME - image.getHeight(null) -32){
            return false;
        }

        return true;
    }

    public Rectangle getRect(){
        Rectangle rectangle=new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
        return rectangle;
    }

    public void draw(Graphics2D g2D){
        g2D.drawImage(image,x,y,null);
    }


}
