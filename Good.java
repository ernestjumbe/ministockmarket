import java.util.Random;

public class Good {
  String name;
  double currentPrice;
  double minprice;
  double maxprice;
  
  Good(String n, double min, double max){
    name = n;
    minprice = min;
    maxprice = max;
  }
  
  // Set the price for a specific round
  public double roundPrice(){
    double range = Math.abs(maxprice - minprice);
    currentPrice = (Math.random() * range) + (minprice <= maxprice ? minprice : maxprice);
    //System.out.println("Generated random: " + (double)currentPrice);
    return currentPrice;
     
  }
  
  
}