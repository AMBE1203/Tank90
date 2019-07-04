package dtc.com.vn.frame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ÁC MA BÊN EM on 29/8/2016.
 */
public class MyFrame extends JFrame {


    public static int w_FRAME=800;
    public static int h_FRAME=600;


    MyPanel myPanel=new MyPanel();


    public MyFrame(String titile){
        super(titile);
        setBackground(Color.BLACK);
        setSize(w_FRAME,h_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        add(myPanel);
        setVisible(true);



    }




}
