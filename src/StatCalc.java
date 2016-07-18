import java.util.List;

/**
 * This is the Stat Calculator class for variance and standard deviation.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class StatCalc {
  public double getVariance(List<Double> arr) {
    double sum=0;
    double sqrdsum=0;
    int N= arr.size();
    for (int i=0; i<N;i++) {
        sum += arr.get(i);
    }
    double mu = (1.0/N)*sum;
    double musq = Math.pow(mu,2);
    for (int i=0; i<N;i++) {
        sqrdsum += Math.pow(arr.get(i),2);
    }
    double xsq = (1.0/N)*sqrdsum;
    double var = xsq -musq;
    return var;
  }

  public double getStd(List<Double> arr) {
    return Math.sqrt(getVariance(arr));
  }
}
