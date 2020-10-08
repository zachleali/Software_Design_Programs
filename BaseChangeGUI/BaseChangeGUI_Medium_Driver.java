import javax.swing.*;

public class BaseChangeGUI_Medium_Driver
{
    public static void main(String[] args)
    {
        JFrame main = new JFrame();
        BaseChangeGUI_Medium test = new BaseChangeGUI_Medium();
        main.setTitle("Base Change GUI For Bases 2-32");
        main.add(test);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1200,200);
        main.setResizable(false);
        main.setVisible(true);
    }

}
