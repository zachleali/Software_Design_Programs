import javax.swing.*;
import java.awt.*;

public class ImageRotatorDriver
{
    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        S22_ImageRotator_Hard img = new S22_ImageRotator_Hard();
        main.add(img);
        main.getContentPane().add(BorderLayout.CENTER,img);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(600,600);
        main.setVisible(true);
    }

}
