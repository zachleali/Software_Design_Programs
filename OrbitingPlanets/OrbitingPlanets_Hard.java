// Zach Leali
// 11/6/2020
// S19_OrbitingPlanets_Hard

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Class S19_OrbitingPlanets_Hard is a JPanel that implements Runnable and communicates with other threads.
 * The class creates a JPanel that displays up to 8 planets orbiting a star, and up to
 * 16 moons(2 per planet) rotating around each planets as the planet rotates around the star.
 * @author Zach Leali
 * @see <a href="Moons.html#section">Moons</a>
 * @see <a href="Planets.html#section">Planets</a>
 */
public class S19_OrbitingPlanets_Hard extends JPanel implements Runnable
{
    /** An ArrayList to hold Planets Objects. */
    private final List<Planets> planets = new ArrayList<>(); // container for the Planet Objects
    /** An ArrayList to hold Moons Objects. */
    private final List<Moons> moons = new ArrayList<>(); // container for the Moon objects
    /** A HashMap for mapping all the first moons to each planet.*/
    private HashMap<Integer,Moons> myMoonsSet1 = new HashMap<>(); // hashmap for all the 1st moons of each planet
    /** A HashMap for mapping all the second moons to each planet.  */
    private HashMap<Integer,Moons> myMoonsSet2 = new HashMap<>(); // hashmap for all the 2nd moons of each planet
    /** A new cached thread pool initialized using ExecutorService to execute each thread. */
    private ExecutorService executorService = Executors.newCachedThreadPool(); // new thread pool to execute the planet and moon threads
    /** The distance between each planet in the window. */
    private double distanceBetweenPlanets = 100; // the distance between the planets
    /** A random number generator used for randomizing the color of each planet and moon. */
    private SecureRandom generator = new SecureRandom(); // used for generating random colors for planets and moons
    /** The background image of the window. */
    private Image backgroundImage; // the background image of the window

    /**
     * Class constructor that reads in the background image and initializes a Swing Timer.  A MouseListener is
     * also added to the JPanel and setup to listen for when the user clicks the mouse on the window.
     * @throws IOException      If background image doesn't get read in correctly.
     */
    public S19_OrbitingPlanets_Hard() throws IOException
    {
        backgroundImage = ImageIO.read(new File("space.jpg")); // reading in background image file
        this.setFocusable(true); // set to true so JPanel will listen for key presses
        // adding mouse listener to add planets to screen
        addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(planets.size() < 8) // only 8 planets are allowed to be created
                {
                    Planets newPlanet = new Planets(distanceBetweenPlanets,new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
                    planets.add(newPlanet); // adding the new Planets object to the arraylist
                    executorService.execute(newPlanet); // executing the current thread
                    distanceBetweenPlanets += 40;
                }
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        // adding key listener to JPanel
        MyKeyListener keyHandler = new MyKeyListener();
        addKeyListener(keyHandler);

        Timer timer = new Timer(5,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint(); // repaints every 10ms
            }
        });
        timer.start(); // starts the timer
    }

    /**
     * Overridden paintComponent of Super class JPanel to draw the planets and moons to the screen when
     * the information is available during every repaint.
     * @param g         graphics
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,null); // drawing background image
        Graphics2D g2d = (Graphics2D) g;
        for(Planets p: planets) // iterating through all planet threads
        {
            // setColor, new Shape, fill the shape
            g2d.setColor(p.getPlanetColor());
            Shape shape = new RoundRectangle2D.Double(p.getXPoint(),p.getYPoint(),20,20,20,20);
            g2d.fill(shape);
        }
        for(Moons m: moons) // iterating through all moon threads
        {
            g2d.setColor(m.getMoonColor());
            Shape moonShape = new RoundRectangle2D.Double(m.getXPoint(),m.getYPoint(),5,5,5,5);
            g2d.fill(moonShape);
        }
        g2d.setColor(Color.YELLOW); // color of the star
        g2d.fillRoundRect(625,475,100,100,100,100); // drawing star
    }

    /**
     * Implementing Runnable Objects run() method to allow for main thread to listen for Planets threads
     * to notify when information is ready.
     */
    @Override
    public void run()
    {
        synchronized (planets)
        {
            try {
                planets.wait(); // waiting for planets to notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Private inner class that implements KeyListener that creates new Moons threads when the user presses
     * keys 1-8.(only 2 moons per planets)
     */
    private class MyKeyListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) { }
        @Override
        public void keyPressed(KeyEvent e) {
            // only allows for user to enter keys 1-8 because keys 1-8 correspond to positions of planet threads in the array list.
            if(!myMoonsSet1.containsKey(e.getKeyCode()))
            {
                try
                {
                    Moons newMoon = new Moons(0,planets.get(Integer.parseInt(String.valueOf(e.getKeyChar()))-1),new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
                    moons.add(newMoon);
                    executorService.execute(newMoon);
                    myMoonsSet1.putIfAbsent(e.getKeyCode(),newMoon);
                }
                catch(IndexOutOfBoundsException ex) {}
            }
            else if(!myMoonsSet2.containsKey(e.getKeyCode()) && myMoonsSet1.containsKey(e.getKeyCode()))
            {
                try
                {
                    Moons newMoon = new Moons(5,planets.get(Integer.parseInt(String.valueOf(e.getKeyChar()))-1),new Color(generator.nextInt(255),generator.nextInt(255),generator.nextInt(255)));
                    moons.add(newMoon);
                    executorService.execute(newMoon);
                    myMoonsSet2.putIfAbsent(e.getKeyCode(),newMoon);
                }
                catch(IndexOutOfBoundsException ex){}
            }
        }
        @Override
        public void keyReleased(KeyEvent e) { }
    }
}
