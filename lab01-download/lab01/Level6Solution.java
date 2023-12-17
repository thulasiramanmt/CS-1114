import student.micro.lightbot.*;

//-------------------------------------------------------------------------
/**
 *  Level 6, together with its solution using a single Light-Bot.
 *
 * @author thulasiramanmt
 * @version 2023.08.28
 */
public class Level6Solution
    extends Level6
{
    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     *  bot goes to the blue spot, and light turns on. Object is bob.
      Methods used is turnRight(), turnLeft(), move(), jump(), 
      and turnLightOn().
     */
    public void myProgram()
    {
        /*# Insert your solution here. */
        LightBot bob = new LightBot();
        this.addObject(bob, 1, 2);
        bob.turnRight();
        bob.move();
        bob.move();
        bob.move();
        bob.turnLeft();
        bob.move();
        bob.turnLeft();
        bob.jump();
        bob.move();
        bob.jump();
        bob.move();
        bob.turnRight();
        bob.jump();
        bob.move();
        bob.jump();
        bob.move();
        bob.turnLightOn();
        bob.jump();
        bob.move();
        bob.turnRight();
        bob.move();
        bob.move();
        bob.move();
        bob.turnLightOn();
        bob.turnRight();
        bob.turnRight();
        bob.move();
        bob.move();
        bob.move();
        bob.move();
        bob.move();
        bob.move();
        bob.turnLightOn();
    }
}
