// Zach Leali
// 9/25/2020
// Program #3 ImageRotator_Hard

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;

/**
 * ImageRotator class extending Jpanel that rotates an image continuously or specifically a number of degrees.
 * @author Zach Leali
 */
public class S22_ImageRotator_Hard extends JPanel
{
    /** The number of degrees in radians to rotate the object. */
    private double theta; // theta is always in radians
    /** The X-coordinate value for the middle of the Image and Frame. */
    private final double x1 = 300; // The middle of the window for a 600x600 frame
    /** The Y-coordinate value for the middle of the Image and Frame. */
    private final double y1 = 300; // The middle of the window for a 600x600 frame


    // Buttons for starting rotation, resetting rotation, and specifying rotation.
    /** The button to start continuous rotation of the image. */
    private JButton startButton;
    /** The button to reset the image to 0 degrees which also stops the continuous rotation. */
    private JButton resetButton;
    /** The button the user presses to rotate the object by a specific number of degrees. */
    private JButton userButton;

    // BufferedImage is being used so that we can manipulate the image with Graphics2D.
    /** Buffered Image to set the image and be able to manipulate the image. */
    private BufferedImage golem;
    /** The container for the buffered image. */
    private JLabel golemLabel;

    /** Where the user types specific number of degrees. */
    private JTextField userInput;
    /** Tells the user where 0 degrees starts for image. */
    private JTextArea rotationKey;

    /** For resetting image and allowing for non-overlapping repainting of image. */
    private boolean rotationOn;
    /** Allows for start/stop of the rotation of the image.*/
    private boolean userRotation;

    /** A Timer object for continuous rotation of the image. */
    private Timer timer;
    /** A counter for rotation continuously adding 1 to theta. */
    private int counter = 1;

    /** A JSlider object for increasing and decreasing the speed of the rotation dynamically. */
    private JSlider slider;
    /** A table to display to the user which way is to slide the JSlider to increase/decrease rotation speed. */
    private Hashtable sliderTable;


    /**
     * ImageRotator Constructor sets up a JPanel for the user interface.
     * The JPanel includes the buttons, text fields, text area, slider, and timer.
     * Action listener for the buttons and text fields as well as the Change listener for the slider are also
     * set up in the constructor.
     */
    public S22_ImageRotator_Hard()
    {
        startButton = new JButton("START");
        add(startButton);

        resetButton = new JButton("RESET");
        add(resetButton);

        userButton = new JButton("Specified Degree");
        add(userButton);

        userInput = new JTextField(10);
        add(userInput);

        slider = new JSlider(JSlider.HORIZONTAL,1,500,250);
        add(slider);

        rotationKey = new JTextArea("Image starts at 0 degrees and rotates clockwise as degrees increase.");
        add(rotationKey);

        // setting up slider and labels for the slider for dynamic change of image rotation speed.
        sliderTable = new Hashtable();
        sliderTable.put(1, new JLabel("Fast"));
        sliderTable.put(499, new JLabel("Slow"));
        slider.setLabelTable(sliderTable);
        slider.setPaintLabels(true);

        // Setting up the action listeners for the buttons and timer.
        ButtonFieldHandler handler = new ButtonFieldHandler();
        startButton.addActionListener(handler);
        resetButton.addActionListener(handler);
        userButton.addActionListener(handler);
        timer = new Timer(250,handler);

        // Setting up the change listener for the slider.
        SliderListener listen = new SliderListener();
        slider.addChangeListener(listen);
    }

    /**
     * A method to read in the image file and set it as a BufferedImage and adding it to a JLabel.
     *
     */
    public void readFile()
    {
        golem = null;
        try
        {
            // The path of the image file is the path of the file by right clicking on Golem.jpg and copying file path.
            // uses ImageIO so that Graphics2D can be used on the buffered image.
            golem = ImageIO.read(new File("/iahome/z/zl/zleali/Desktop/zleali_swd/oral_exam1/S22_ImageRotator_Hard/src/Golem.jpg"));

        }
        catch(IOException e)
        {
            System.out.println("Can't find file.");
        }
        golemLabel = new JLabel(new ImageIcon(golem));
    }

    /**
     * A method to set the value of theta in radians.
     * @param theta         Number of degrees in radians.
     */
    public void setTheta(double theta)
    {
        this.theta = theta;
    }

    /**
     * Overriding JLabel's paintComponent to manually draw the image and rotated image.
     * @param g         Graphics
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // calling super classes paint component.
        readFile(); // setting up the image to rotate.
        Graphics2D g2d = (Graphics2D) g; // creating a new 2D graphics to manipulate the image.
        AffineTransform aTransform = new AffineTransform(); // Affine Transform is for rotating the image.
        if(timer.isRunning()) // continuous rotation
        {
            counter++;
            setTheta((counter*Math.PI)/12);
            aTransform.setTransform(g2d.getTransform());
            aTransform.rotate(theta,x1,y1);
            aTransform.translate(300-(golem.getWidth()/2.0),300-(golem.getHeight()/2.0));
            g2d.drawImage(golem,aTransform,null);
        }
        if(!timer.isRunning() && userRotation) // specific degree by user rotation
        {
            aTransform.setTransform(g2d.getTransform()); // setting the aTransforms transform matrix to the Graphics transform matrix.
            aTransform.rotate(theta,x1,y1); // rotate the image by theta centered at x1 = 300 and y1 = 300.
            aTransform.translate(300-(golem.getWidth()/2.0),300-(golem.getHeight()/2.0)); // sets the position of the origin of the rotated image.
            g2d.drawImage(golem,aTransform,null); // draws the image where the rotated image coordinates were calculated.
        }
        if(!rotationOn) // image when reset or initial state.
        {
            g2d.drawImage(golem,(int)(300-(golem.getWidth()/2.0)),(int)(300-(golem.getHeight()/2.0)),null);
        }
    }


    /**
     * ButtonFieldHandler implements ActionListener that listens for a button clicked by user to rotate, reset
     *  or continuously rotate the image.
     */
    private class ButtonFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == resetButton)
            {
                rotationOn = false;
                userRotation = false;
                timer.stop();
            }
            if(e.getSource() == startButton)
            {
                counter = 0;
                rotationOn = true;
                userRotation = false;
                setTheta(theta);
                timer.setDelay(250);
                timer.start();
            }
            if(e.getSource() == userButton)
            {
                timer.stop();
                userRotation = true;
                rotationOn = true;
                double userDegree = Double.parseDouble(userInput.getText());
                setTheta((userDegree*Math.PI)/180);
            }
            repaint();
        }
    }


    /**
     * SliderListener implements ChangeListener to change the speed of the image
     * when the user slides the slider left or right.
     */
    private class SliderListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e)
        {
            JSlider s = (JSlider) e.getSource();
            timer.setDelay(s.getValue());
        }
    }
}
