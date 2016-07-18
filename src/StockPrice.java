import org.joda.time.DateTime;

/**
 * This is the Stock Price class that contains the datetime and price for a given stock.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class StockPrice {
  double p;
  DateTime dt;
  // object stockprice containing datetime and double price
  public StockPrice(double x) {
    this.p=x;
    long t=(long)x;
    dt = new DateTime(t);
  }
}
