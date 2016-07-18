import org.joda.time.DateTime;

import java.util.List;

/**
 * This is the Stock Path interface that is used to store and return prices associated
 * with the stock along the time path.
 * 
 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public interface StockPath {
  public List<StockPrice> getPrices();
}
