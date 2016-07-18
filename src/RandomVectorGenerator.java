/**
 * This is the RandomVectorGenerator interface that is used to generate a list of random numbers
 * with a specified seed.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public interface RandomVectorGenerator {
  public void setSeed(long seed);
  public void setLength(int n);
  public double[] getVector();
}
