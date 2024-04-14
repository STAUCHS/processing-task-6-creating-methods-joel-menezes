import java.nio.file.FileAlreadyExistsException;
import java.util.Random;
import processing.core.PApplet;

public class Sketch extends PApplet {
  int intEntities;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(400, 400);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    noLoop();
    surface.setResizable(true);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    Random myRandom = new Random();
    noStroke();
    for (int intExtraCircles = 0; intExtraCircles <= 105; intExtraCircles++) {
      drawCircles(myRandom.nextInt(255), myRandom.nextInt(255), myRandom.nextInt(255), myRandom.nextInt(22, 50),
          myRandom.nextInt(width), myRandom.nextInt(height));
    }
    stroke(0);
    drawFlowerGrid(myRandom.nextInt(1, 5), myRandom.nextInt(1, 5), 8);
  }

  /**
   * Description: Draws a certain amount of flowers in a grid
   * 
   * @param intRows    How many flowers in each row
   * @param intColumns How many flowers in each Column
   * @param intPetals  How many petals on each flower
   * @author Joel Menezes
   */
  private void drawFlowerGrid(int intRows, int intColumns, int intPetals) {

    Random myRandom = new Random();

    for (int intPositionX = (width / intRows) / 2; intPositionX <= width; intPositionX += width / intRows) {
      for (int intPositionY = (height / intColumns) / 2; intPositionY <= height; intPositionY += height
          / intColumns) {

        drawFlower(intPositionX, intPositionY, myRandom.nextInt(6, 10));
      }
    }
  }

  /**
   * Description: Checks how many flowers on screen and returns a true or false
   * value if divisible by 2
   * 
   * @param intAmountEntities amount of flowers on screen
   * @return Returns true of flowers are divisible by 2, if not returns false
   * @author Joel Menezes
   */
  private boolean checkEntities(int intAmountEntities) {
    if (intAmountEntities % 2 == 0) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Description: Draws a circle a certain colour, shape, and position where the
   * user wants
   * 
   * @param intRed       How Red the user wants the circle
   * @param intGreen     How Green the user wants the circle
   * @param intBlue      How Blue the user wants the circle
   * @param intSize      How big the user wants the circle
   * @param intPositionX Where on the X axis the user wants the circle
   * @param intPositionY Where on the Y axis the user wants the circle
   * @author Joel Menezes
   */

  private void drawCircles(int intRed, int intGreen, int intBlue, int intSize, int intPositionX, int intPositionY) {
    fill(intRed, intBlue, intGreen);
    circle(intPositionX, intPositionY, intSize);
  }

  /**
   * Description: Draws a Flower to the screen
   * 
   * @param intPositionX Where on the X axis the user wants the circle
   * @param intPositionY Where on the Y axis the user wants the circle
   * @param intPetals    How many petals the user wants
   * @author Joel Menezes
   */

  private void drawFlower(int intPositionX, int intPositionY, int intPetals) {

    stroke(0);
    translate(intPositionX, intPositionY); // Translates this to desired quadrant
    intEntities++;
    boolean blnCheckEntities = checkEntities(intEntities);
    for (int intDegrees = 0; intDegrees < 360; intDegrees += 360 / intPetals) {
      pushMatrix(); // Saves current Matrix
      if (blnCheckEntities) {
        fill(255, 125, 0);
      } else {
        fill(0, 125, 255);
      }

      rotate((float) Math.toRadians(intDegrees)); // Roates Petals
      ellipse(0, 25, 20, 75);
      popMatrix(); // Previous Matrix Loaded
    }

    // Creates inner circle
    noStroke();
    if (blnCheckEntities) {
      fill(255, 255, 0);
    } else {
      fill(0, 0, 125);
    }
    circle(0, 0, 60);

    resetMatrix();

  }

}