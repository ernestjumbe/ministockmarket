import java.util.Random;

public class Good {
  double currentPrice;
  public double minPrice;
  public double maxPrice;
  
  // Set the price for a specific round
  public double currentPrice(){
    double range = Math.abs(maxPrice - minPrice);
    currentPrice = (Math.random() * range) + (minPrice <= maxPrice ? minPrice : maxPrice);
    //System.out.println("Generated random: " + (double)currentPrice);
    return currentPrice;
     
  }
  
  
}