import java.util.Scanner;

public class Game {
  double currentfunds = 10000;
  int currentround = 0;
  double sugarstock = 0;
  double steelstock = 0;
  int totalstaock = 0;
  double storageprice = 3.00;
  Good sugar = new Good();
  Good steel = new Good();
  
  public static void main(String [] args){
    //startGame();
    
  }
  
  public void run(){
    
    Good sugar = new Good();
    sugar.minPrice = 13.00;
    sugar.maxPrice = 20.00;
    //sugar.setPrice();
    Good steel = new Good();
    steel.minPrice = 21.00;
    steel.maxPrice = 54.00;
    //steel.setPrice();
    Scanner sc = new Scanner(System.in);
    String ans;
    
    while(true){
      chargeStorage(totalstaock);
      double sugarprice = sugar.currentPrice();
      double steelprice = steel.currentPrice();
      System.out.println("You have $" + currentfunds + " available.");
      System.out.println("You have " + sugarstock + " of sugar" + steelstock + "and of steel.");
      System.out.println("Sugar price: " + sugarprice);
      System.out.println("Steel price: " + steelprice);
      
      System.out.println("Buy sugar? (Enter Y or n):");
      ans = sc.next();
      if (ans.compareTo("Y")==0){
        System.out.println("Enter amount to buy in tonns. (example 100):");
        ans = sc.next();
        double amount = Double.parseDouble(ans);
        buyStock(amount, sugarprice);
        sugarstock = sugarstock + amount;
        System.out.println("You have $" + currentfunds + " available.");
      } else {
      }
      System.out.println("Buy steel? (Enter Y):");
      ans = sc.next();
      if (ans.compareTo("Y")==0){
        System.out.println("Enter amount to buy in tonns. (example 100):");
        ans = sc.next();
        double amount = Double.parseDouble(ans);
        buyStock(amount, sugarprice);
        steelstock = steelstock + amount;
        System.out.println("You have $" + currentfunds + " available.");
      } else {
      }
      System.out.println("Sell sugar? (Enter Y):");
      ans = sc.next();
      if (ans.compareTo("Y")==0){
        System.out.println("Enter amount to sell in tonns. (example 100):");
        ans = sc.next();
        double amount = Double.parseDouble(ans);
        sellStock(amount, sugarprice);
        sugarstock = sugarstock - amount;
        System.out.println("You have $" + currentfunds + " available.");
      } else {
      }
      System.out.println("Sell steel? (Enter Y):");
      ans = sc.next();
      if (ans.compareTo("Y")==0){
        System.out.println("Enter amount to sell in tonns. (example 100):");
        ans = sc.next();
        double amount = Double.parseDouble(ans);
        sellStock(amount, sugarprice);
        steelstock = steelstock - amount;
        System.out.println("You have $" + currentfunds + " available.");
      } else {
      }
      
      
    }
  }
  
  public void stockPrices() {
    steel.currentPrice();
    sugar.currentPrice(); 
  }
  
  public void roundNumber(){
    currentround++;
  }
  
  // Buy stock
  public void buyStock(double units, double priceperunit){
    // Calculate the total price for the of stock to be purchased.
    double totalprice = units * priceperunit;
    //check if the funds are avaiable to purchase this amount of goods of a certain type.
    // Subract the total stock purchased from the funds available.
    currentfunds = currentfunds - totalprice;
    // Add stock to stoage
    
    
  }
  
  public void sellStock(double units, double priceperunit){
    // Calculate the total price for the of stock sold.
    double totalprice = units * priceperunit;
    // Add the total of the stock sold to the funds available.
    currentfunds = currentfunds + totalprice;
  }
  
  // Charge storage
  public void chargeStorage(int stock){
    // Calculate the cost of storage for curren round.
    double storagecost = stock * storageprice;
    // Subtract the storage cost from the funs available.
    currentfunds = currentfunds - storagecost;
  }
  
  // Check funds
  public void checkFunds(){
  }
}