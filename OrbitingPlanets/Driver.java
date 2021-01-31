// Zach Leali
// 11/6/2020
// S19_OrbitingPlanets_Hard
import javax.swing.*;
import java.io.IOException;

public class Driver
{
    public static void main(String[] args) throws IOException {
        JFrame main = new JFrame(); // JFrame
        S19_OrbitingPlanets_Hard myOrbit = new S19_OrbitingPlanets_Hard();
        main.add(myOrbit); // adding JPanel to JFrame
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setSize(1200,1200);
        main.setVisible(true);
    }
}
