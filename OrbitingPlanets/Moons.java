// Zach Leali
// 11/6/2020
// S19_OrbitingPlanets_Hard
import java.awt.*;

/**
 * Class Moons implements Runnable and it's run method calculates the x and y position coordinates of
 * the Moons Object.
 * @author Zach Leali
 * @see <a href="Planets.html#section">Planets</a>
 * @see <a href="S19_OrbitingPlanets_Hard.html#section">S19_OrbitingPlanets_Hard</a>
 */
public class Moons implements Runnable
{

    /** x-coordinate position of moon. */
    private double xPoint; // x position of the moon
    /** y-coordinate position of moon. */
    private double yPoint; // y position of the moon
    /** Starting radians use to calculate the x and y position coordinates. */
    private double radians = 1; // used in cos and sin to calculating angle
    /** Counter used for increases radians by PI. */
    private int counter = 1; // used for increases radians by PI
    /** Planet object used to set the moons position relative to the planets position. */
    private final Planets planet; // planet object used to set the position of the moons x and y relative to the planets.
    /** The distance between the two moons for each planet. */
    private double moonDistance; // used for the second moon.
    /** Color object used for setting the color of the created moon object.*/
    private Color moonColor; // color of the moon


    /**
     * Moons constructor that sets the moon distance from the other moon, moons Planet Object and the color of the moon.
     * @param moonDistance      distance between moon #1 and moon #2
     * @param planet            Planet object
     * @param moonColor         Color of moon
     */
    public Moons(double moonDistance,Planets planet,Color moonColor)
    {
        this.moonDistance = moonDistance;
        this.planet = planet;
        this.moonColor = moonColor;
    }

    /**
     * Calculates the the moons x and y position coordinates relative to the planet passed in.
     */
    @Override
    public  void run()
    {
        while(!Thread.interrupted())
        {
            radians = (counter * Math.PI) / 144;
            xPoint = (planet.getXPoint() + (10) + ((moonDistance+20) * Math.cos(radians)));
            yPoint = (planet.getYPoint() + (10) + ((moonDistance+20) * Math.sin(radians)));
            setXpoint(xPoint);
            setYpoint(yPoint);
            counter++;
            try
            {
                Thread.sleep((long) (20+moonDistance));
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to return the x position of the moon.
     * @return      x-position
     */
    public double getXPoint()
    {
        return xPoint;
    }
    /**
     * Method to return the y position of the moon.
     * @return      y-position
     */
    public double getYPoint()
    {
        return yPoint;
    }

    /**
     * Method to set the x-position of the moon.
     * @param xPoint        double x-position
     */
    public void setXpoint(double xPoint)
    {
        this.xPoint = xPoint;
    }
    /**
     * Method to set the y-position of the moon.
     * @param yPoint        double y-position
     */
    public void setYpoint(double yPoint)
    {
        this.yPoint = yPoint;
    }

    /**
     * Method to get the color of the moon.
     * @return      Color object
     */
    public Color getMoonColor()
    {
        return moonColor;
    }
}
