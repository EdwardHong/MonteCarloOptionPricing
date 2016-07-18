/**
 * This is the class for European option.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class EuropeanOption implements PayOut{

  @Override
  /**
   *  European price will be the difference between spot price and strike price.
   * @param  path  Path of the stock for the given days.
   * @return  payout  the payout of the European option.
   */
  public double getPayout(Path path) {
      return Math.max(0, path.stockPrices.get(path.stockPrices.size()-1).p-path.strike);
  }
}
