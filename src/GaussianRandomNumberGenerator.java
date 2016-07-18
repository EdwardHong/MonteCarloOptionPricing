import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import java.util.Random;

/**
 * This is the class that generates Gaussian Random Number of a specified length.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class GaussianRandomNumberGenerator implements RandomVectorGenerator, UniformRandomGenerator {

  private int length;

  public GaussianRandomNumberGenerator(int length){
      this.length = length;
  }

  public double getUniformRandomNumber(){
      return rnd.nextDouble();
  }

  /**
   * Sets the seed in order to return the same sequence of random doubles.
   * @param  seed   unique seed to return the same sequence.
   */
  @Override
  public void setSeed(long seed) {
      rnd.setSeed(seed);
  }

  /**
   * Sets the length for the list of random doubles.
   * @param  seed   unique seed to return the same sequence.
   */
  public void setLength(int n) {
      this.length = n;
  }

  /**
   * Returns the list of random doubles generated according to normal distribution.
   * @return  the list of random doubles.
   */
  @Override
  public double[] getVector() {
      double[] vector = new double[length];
      NormalDistribution nd = new NormalDistribution();
      
      for (int i=0; i<vector.length/2; i++) {
          double n=nd.sample();
          vector[i]= n;
      }
      //antithetic variables
      for (int i=vector.length/2; i<vector.length; i++) {
          double n=nd.sample();
          vector[i]=-1*n;
      }
      return vector;
  }
}
