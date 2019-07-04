package dtc.com.vn.tank;

import javax.swing.*;

/**
 * Created by ÁC MA BÊN EM on 31/8/2016.
 */
public class MyTank extends Tank {

    public MyTank(int _x, int _y) {
        super(_x, _y,UP);
        images[0]=new ImageIcon(getClass()
                .getResource("/image/player_green_left.png")).getImage();
        images[1]=new ImageIcon(getClass()
                .getResource("/image/player_green_right.png")).getImage();
        images[2]=new ImageIcon(getClass()
                .getResource("/image/player_green_up.png")).getImage();
        images[3]=new ImageIcon(getClass()
                .getResource("/image/player_green_down.png")).getImage();

        image=images[UP];
    }
}
