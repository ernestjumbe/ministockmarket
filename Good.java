import java.util.Random;

public class Good {
  String name;
  double currentprice;
  double minprice;
  double maxprice;
  double stock = 0;
  
  Good(String n, double min, double max){
    name = n;
    minprice = min;
    maxprice = max;
  }
  
  // Set the price for a specific round
  public double roundPrice(){
    double range = Math.abs(maxprice - minprice);
    currentprice = (Math.random() * range) + (minprice <= maxprice ? minprice : maxprice);
    //System.out.println("Generated random: " + (double)currentPrice);
    return currentprice;
     
  }
  
  
}