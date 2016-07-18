import org.apache.commons.math3.*;
import org.apache.commons.math3.distribution.NormalDistribution;
import java.util.*;

/**
 *  This is the main class for MonteCarlo to try the simulation. It will loop until there is
 *  less than 1% of estimation error. This may take long time to finish and therefore there is a
 *  loop limit one can set. 
 * 
 *  It will print changing Epsilon (estimation error) and price of the option in every loop
 *  to display their converging nature.

 * @author  Ssangwook Hong
 * @date    April 16 15
 */

public class MonteCarlo {
  public static void main(String[] args) {
    // In loopLimit, the # of loop is limited to loopCount.
    boolean loopLimit = true;
    // in each loop, 10 paths are created. so actual # of loops is loopCount * 10.
    int loopCount=3000;

    // We assumed 252 day, therefore 252 random numbers used for 252 different stock prices each day which will then be used to calculate the payout.
    int days = 252;
    StatCalc calc = new StatCalc();
    List<Double> payoutList = new ArrayList<Double>();
    //   First path is 252 days, $152.35 initial price, 0.01 volatility, 0,0001 r, and strike price $165.
    Path path = new Path(252,152.35, 0.01,0.0001,165.0);
    // payout objects used to get payouts.
    AsianOption aPayout = new AsianOption();
    EuropeanOption ePayout = new EuropeanOption();
    // this is used to calculate the z value for the corresponding confidence interval.
    NormalDistribution nd = new NormalDistribution();
    // z value for 96% probability.
    double z = nd.inverseCumulativeProbability(0.96);
    double total = 0;
    // N is the total number of loops that will run until the program terminates. In test mode, it will end at 3000.
    int aN =1;
    int eN=1;
    double std = 0;
    List<StockPrice> stockPrices = new ArrayList<StockPrice>();
    double eTotal = 0;
    double aTotal = 0;
    double ePrice = 0;
    double aPrice = 0;
    // Epsilon starts with one, so the first loop will execute. In the first loop, it will get the correct value.
    double Epsilon=1;
    int counter=0;

    //Question #1
    //Let's loop until the estimation error is less than 1%.
    while (Epsilon>0.01) {
        for (int i=0; i<10; i++) {
            path = new Path(252,152.35, 0.01,0.0001,165.0);
            double pay = ePayout.getPayout(path);
            payoutList.add(pay);
            std = calc.getStd(payoutList);
            if (std!=0)
                Epsilon = (z * std) / Math.sqrt(eN);
            System.out.println("Epsilon is "+Epsilon);
            eN++;
            eTotal += pay;
            ePrice = eTotal/eN;
            System.out.println("Price of the option is "+ePrice);
//                System.out.println("Avg is "+(total/N));

            if (Epsilon<0.01)
                break;
        }
        counter++;
        if (loopLimit==true) {
            if (counter == loopCount)
                break;
        }
    }

    counter=0;
    //Question #2
    //Let's loop until the estimation error is less than 1%.
    while (Epsilon>0.01) {
        for (int i=0; i<10; i++) {
            path = new Path(252,152.35, 0.01,0.0001,164.0);
            double pay = aPayout.getPayout(path);
            payoutList.add(pay);
            std = calc.getStd(payoutList);
            if (std!=0)
                Epsilon = (z * std) / Math.sqrt(aN);
            aTotal+=pay;
            System.out.println("Epsilon is "+Epsilon);
            aN++;
            aPrice = aTotal/aN;
            System.out.println("Price of the option is "+aPrice);

             if (Epsilon<0.01)
                break;
        }
        counter++;
        if (loopLimit==true) {
            if (counter == loopCount)
                break;
        }
    }
    System.out.println("Q1: Price of the European option with "+ (eN-1) +" loops is "+ePrice);
    System.out.println("Q2: Price of the Asian option with "+ (aN-1) +" loops is "+aPrice);
  }
}
