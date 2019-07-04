package dtc.com.vn.manager;

import dtc.com.vn.bullet.Bullet;
import dtc.com.vn.frame.MyFrame;
import dtc.com.vn.map.Map;
import dtc.com.vn.tank.BossTank;
import dtc.com.vn.tank.MyTank;
import dtc.com.vn.tank.Tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ÁC MA BÊN EM on 31/8/2016.
 */
public class Manager {

    int[][] map={
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,1,1,1,1,2,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,3,3,3,3,3,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,3,3,3,3,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,2,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,2,2,2,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,2,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,2,2,2,5,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,2,2,2,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,2,2,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,1,2,2,2,2,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,1,2,2,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,5,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,5},
            {5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,5,5},
            {5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,5,5,5,1,1,1,1,1,1,1,1,0,2,2,0,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,0,0,0,0,0,5,1,1,1,1,1,1,0,2,2,0,1,1,1,1,1,1,5,5},
            {5,5,1,1,1,1,1,1,1,1,1,1,1,1,5,5,5,0,1,5,5,0,5,5,5,1,1,1,1,0,0,0,0,1,1,1,1,1,1,5,5},
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,0,5,5,5,0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,0,5,5,5,0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}

};

    private MyTank myTank;
    private BossTank bossTank;
    private ArrayList<BossTank> listBossTank=new ArrayList<BossTank>();
    private Random random=new Random();
    private ArrayList<Map> listMap=new ArrayList<Map>();
    private ArrayList<Bullet> listMyBullet=new ArrayList<Bullet>();
    private ArrayList<Bullet> listBossBullet=new ArrayList<Bullet>();

    public void initGame(){
        myTank=new MyTank(300,300);
        for (int i=0;i<5;i++){
            int x=random.nextInt(MyFrame.w_FRAME-32);
            bossTank=new BossTank(x,0);
            listBossTank.add(bossTank);
        }

        for (int i=0 ; i<30 ;i++){
            for (int j=0;j<41;j++){
                int x = j*19;
                int y=i*19;
                int bit=map[i][j];
                Map map=new Map(x,y,bit);

                listMap.add(map);

            }
        }
    }

    public void draw(Graphics2D g2D){
        myTank.draw(g2D);
        for (BossTank bossTank : listBossTank){
            bossTank.draw(g2D);
        }

        for (Map map : listMap){
            map.draw(g2D);
        }

        for (Bullet bullet : listMyBullet){
            bullet.draw(g2D);
        }

        for (Bullet bullet : listBossBullet){
            bullet.draw(g2D);
        }
    }

    public void move(int newOrient){
        myTank.changeOrient(newOrient);
        myTank.move(listMap);
    }

    public void AI(){
        for (BossTank bossTank : listBossTank){
            bossTank.creatOrient();
            bossTank.move(listMap);
        }

        for (BossTank bossTank : listBossTank){
            int percent = random.nextInt(101);
            if (percent >=95) {

                Bullet bullet = bossTank.fire();
                listBossBullet.add(bullet);
            }
        }

        for (int i=listMyBullet.size()-1;i>=0;i--){
            boolean check=listMyBullet.get(i).move(listMap);
            if (check == false){
                listMyBullet.remove(i);
            }
        }

        for (int i=listBossBullet.size()-1;i>=0;i--){
            boolean check=listBossBullet.get(i).move(listMap);
            if (check == false){
                listBossBullet.remove(i);
            }
        }


    }

    public void myTankFire(){
        Bullet bullet=myTank.fire();
        listMyBullet.add(bullet);
    }

}
