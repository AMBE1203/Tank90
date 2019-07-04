package dtc.com.vn.tank;

import dtc.com.vn.bullet.Bullet;
import dtc.com.vn.frame.MyFrame;
import dtc.com.vn.map.Map;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ÁC MA BÊN EM on 31/8/2016.
 */
public class Tank {

    private ArrayList<Bullet> listBullet=new ArrayList<Bullet>();

    private int _x,_y,xRaw,yRaw;
    Image image;
    Image[] images = new Image[4];
    private int orient; // hướng xe tank
    public static int LEFT=0,RIGHT=1,UP=2,DOWN=3;

    public Tank(int _x, int _y, int orient) {
        this._x = _x;
        this._y = _y;
        this.orient = orient;
    }

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public int getOrien() {
        return orient;
    }

    public void setOrien(int orien) {
        this.orient = orient;
    }

    public void draw(Graphics2D g2D){
        g2D.drawImage(image,_x,_y,null);
    }

    public void move(ArrayList<Map> arrMap){

        int speed=5;
        xRaw=_x;
        yRaw=_y;
        if (orient == LEFT){
            xRaw-=speed;
        } else if (orient == RIGHT){
            xRaw+=speed;
        } else if (orient == UP){
            yRaw-=speed;
        } else if (orient == DOWN){
            yRaw+=speed;
        }
/*
        kiểm tra va chạm với map.
        nếu va chạm thì return luôn
 */
        for (Map map : arrMap){
            Rectangle rectangle = getRect()
                    .intersection(map.getRect());

            if (rectangle.isEmpty() == false){
                if (map.getBit()==0|| map.getBit()==1){
                    return;
                }
            }
        }




        if (xRaw<=0
                || xRaw>= MyFrame.w_FRAME - image.getWidth(null) -10
                || yRaw<=0
                || yRaw>= MyFrame.h_FRAME - image.getHeight(null) -32){
            return;
        }

        _x=xRaw;
        _y=yRaw;
    }

    public void changeOrient(int newOrient){
        orient = newOrient;
        image=images[orient];
    }

// tạo hình chữ nhật để kiểm tra va chạm
    public Rectangle getRect(){
        Rectangle rectangle=new Rectangle(xRaw,yRaw,image.getWidth(null),image.getHeight(null));
        return rectangle;
    }

   public Bullet fire(){
       Bullet bullet=new Bullet(_x+image.getWidth(null)/2,_y+image.getHeight(null)/2,orient);
       return bullet;
   }
}
