package dtc.com.vn.tank;

import javax.swing.*;
import java.util.Random;

/**
 * Created by ÁC MA BÊN EM on 31/8/2016.
 */
public class BossTank extends Tank {

    private Random random=new Random();

    public BossTank(int _x, int _y) {
        super(_x, _y,DOWN);
        images[0]=new ImageIcon(getClass()
                .getResource("/image/bossyellow_left.png")).getImage();
        images[1]=new ImageIcon(getClass()
                .getResource("/image/bossyellow_right.png")).getImage();
        images[2]=new ImageIcon(getClass()
                .getResource("/image/bossyellow_up.png")).getImage();
        images[3]=new ImageIcon(getClass()
                .getResource("/image/bossyellow_down.png")).getImage();

        image=images[DOWN];
    }

    public void creatOrient(){
        int percent = random.nextInt(101);
        if (percent >=90) {
            int newOrient = random.nextInt(4);
            changeOrient(newOrient);
        }
    }


}
