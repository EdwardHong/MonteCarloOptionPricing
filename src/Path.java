import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Path class that constructs a path of a option with volatility, initial price, strike price
 * and interest rate for given duration of days.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class Path implements StockPath {

  protected int T=1;
  protected int days;
  protected double sT;
  protected double sT1;
  protected double volatility;
  protected double r;
  protected double strike;
  protected double[] randomList;
  GaussianRandomNumberGenerator rng = new GaussianRandomNumberGenerator();
  List<StockPrice> stockPrices = new ArrayList<StockPrice>();

  public Path(int days, double initialP, double v, double r, double s) {
    this.sT = initialP;
    this.volatility = v;
    this.r = r;
    this.strike = s;
    stockPrices.add(new StockPrice(initialP));
    randomList= new double[days];
    // decide the number of random values we need and get these random numbers to the array randomList.
    rng.setLength(days);
    randomList = rng.getVector();
   //Geometric brownian model
    for (int i=0; i<days-1; i++) {
        sT1= sT*Math.exp(((r-(Math.pow(volatility,2)/2)))+(volatility*randomList[T-1]));
        stockPrices.add(new StockPrice(sT1));
        sT=sT1;
        T++;
    }
  }

  @Override
  public List<StockPrice> getPrices() {
      return stockPrices;
  }
}
