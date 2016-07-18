/**
 * This is the class for Asian option.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class AsianOption implements PayOut {

  double avg=0;

  /**
   * Given the path of stock, return the average price of the option during the given days.
   * @param  path  Path of the option for the given days.
   * @return avgPrice  the average Price of the option
   */
  public double getAvgPrice(Path path) {
      double total = 0;
      for (int i=0; i<path.stockPrices.size(); i++) {
          total+= path.stockPrices.get(i).p;
      }
      avg = total/ path.stockPrices.size();
      return avg;
  }
  
  @Override
  /**
   *  Asian price will pay the max between zero and the average price during the 252 days
   *  minus the strike price
   * @param  path  Path of the stock for the given days.
   * @return  payout  the payout of the Asian stock.
   */
   public double getPayout(Path path) {
    return Math.max(0, getAvgPrice(path)-path.strike);
  }
}
