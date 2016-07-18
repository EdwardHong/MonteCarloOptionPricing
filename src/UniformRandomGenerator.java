import java.util.Random;

/**
 * This is the UniformRandomGenerator interface that is used to generate a list of random numbers
 * with a specified seed.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public interface UniformRandomGenerator {
  Random rnd = new Random();
  public void setSeed(long seed);
  public double getUniformRandomNumber();
}
