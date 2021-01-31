// Zach Leali
// 11/6/2020
// S19_OrbitingPlanets_Hard
import java.awt.*;

/**
 * Class Planets implements Runnable and it's run method calculates the x and y position coordinates of
 * the Planets Object.
 * @author Zach Leali
 * @see <a href="Moons.html#section">Moons</a>
 * @see <a href="S19_OrbitingPlanets_Hard.html#section">S19_OrbitingPlanets_Hard</a>
 */
public class Planets implements Runnable
{
    /** x-coordinate position of planet. */
    private double xPoint;
    /** y-coordinate position of planet. */
    private double yPoint;
    /** radius of the rotation of the planet */
    private double radius;
    /** Starting radians use to calculate the x and y position coordinates. */
    private double radians = 1;
    /** Counter used for increases radians by PI. */
    private int counter = 1;
    /** Color object that is the color of the planet. */
    private Color planetColor;

    /**
     * Planets constructor that sets the x position, y position, radius, and color of the planet.
     * @param radius        rotation radius
     * @param planetColor   color of planet
     */
    public Planets(double radius,Color planetColor)
    {
        this.radius = radius;
        this.planetColor = planetColor;
    }


    /**
     * Calculates and then sets the x and y position of the planet.  Once the points are found and set,
     * the thread notifies the JPanel thread and allows for the program to continue and draw the created planet thread.
     */
    @Override
    public void run()
    {
        while(!Thread.interrupted())
        {
            synchronized (this)
            {
                radians = (counter * Math.PI) / 144; // radians used in cos,sin
                xPoint = (650 + (radius * Math.cos(radians))); // x-position
                yPoint = (525 + (radius * Math.sin(radians))); // y-position
                setXpoint(xPoint); // setting the x position
                setYpoint(yPoint); // setting the y position
                counter++; // incrementing radians by pi
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify(); // JPanel can now use the information
            }
        }
    }

    /**
     * Method to return the x position of the planet.
     * @return      x-position
     */
    public double getXPoint()

    {
        return xPoint;
    }

    /**
     * Method to return the y position of the planet.
     * @return      y-position
     */
    public double getYPoint()
    {
        return yPoint;
    }

    /**
     * Method to set the x-position of the planet.
     * @param xPoint        double x-position
     */
    public void setXpoint(double xPoint)
    {
        this.xPoint = xPoint;
    }

    /**
     * Method to set the y-position of the planet.
     * @param yPoint        double y-position
     */
    public void setYpoint(double yPoint)
    {
        this.yPoint = yPoint;
    }

    /**
     * Method to get the color of the planet.
     * @return      Color object
     */
    public Color getPlanetColor()
    {
        return planetColor;
    }
}
