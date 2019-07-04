package dtc.com.vn.frame;

import dtc.com.vn.bullet.Bullet;
import dtc.com.vn.manager.Manager;
import dtc.com.vn.tank.MyTank;
import dtc.com.vn.tank.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by ÁC MA BÊN EM on 29/8/2016.
 */
public class MyPanel extends JPanel {
    private boolean isRunning = true;

    private Manager manager=new Manager();

    public MyPanel(){

        setBackground(Color.BLACK);
        manager.initGame();
        addKeyListener(keyListener);
        setFocusable(true);

        Thread thread = new Thread(runnable);

        thread.start();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D= (Graphics2D) g;
        manager.draw(g2D);

    }







/*
    bắt sự kiện các phím di chuyển
     */

    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                manager.move(Tank.LEFT);

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                manager.move(Tank.RIGHT);

            } else if (e.getKeyCode() == KeyEvent.VK_UP){
                manager.move(Tank.UP);

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
                manager.move(Tank.DOWN);
            } else if (e.getKeyCode()== KeyEvent.VK_SPACE){
                manager.myTankFire();
            }
            repaint();

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while (isRunning){
                try {
                    Thread.sleep(50);
                    manager.AI();
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}
