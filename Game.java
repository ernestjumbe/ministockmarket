import java.util.Scanner;

public class Game {
  double currentfunds = 10000;
  int currentround = 1;
  double sugarstock = 0;
  double steelstock = 0;
  double totalstock;
  double storageprice = 3.00;
  Good sugar = new Good("Sugar", 13.00, 20.00);
  Good steel = new Good("steel", 21.00, 54.00);
  
  public static void main(String [] args){
    //startGame();
    
  }
  
  public void run(){
    
    Scanner sc = new Scanner(System.in);
    String ans;
    boolean canplay = true;
    
    while(canplay){
      System.out.println("Round number: " + currentround);
      double sugarprice = sugar.roundPrice();
      double steelprice = steel.roundPrice();
      System.out.println("You have $" + currentfunds + " available.");
      System.out.println("You have " + sugarstock + " of sugar " + steelstock + " and of steel.");
      System.out.println(sugar.name + " price in this round: " + sugarprice);
      System.out.println(steel.name + " price in this round: " + steelprice);
      
      if (currentfunds > 0 ) {
        System.out.println("Buy sugar? (Enter Y or n):");
        ans = sc.next();
        if (ans.compareToIgnoreCase("Y")==0){
          System.out.println("Enter amount to buy in tonns. (example 100):");
          ans = sc.next();
          double amount = Double.parseDouble(ans);
          buyStock(amount, sugarprice);
          sugarstock += amount;
          printFunds();
        }
        System.out.println("Buy steel? (Enter Y):");
        ans = sc.next();
        if (ans.compareToIgnoreCase("Y")==0){
          System.out.println("Enter amount to buy in tonns. (example 100):");
          ans = sc.next();
          double amount = Double.parseDouble(ans);
          buyStock(amount, sugarprice);
          steelstock += amount;
          printFunds();
        }
        System.out.println("Sell sugar? (Enter Y):");
        ans = sc.next();
        if (ans.compareToIgnoreCase("Y")==0){
          System.out.println("You have " + sugarstock + ". Enter amount to sell in tonns:");
          ans = sc.next();
          double amount = Double.parseDouble(ans);
          if (checkStock(amount, sugarstock)){
            sellStock(amount, sugarprice);
            sugarstock -= amount;
            printFunds();
          } else {
            System.out.println("You do not have enough sugar to sell.");
          }
        }
        System.out.println("Sell steel? (Enter Y):");
        ans = sc.next();
        if (ans.compareToIgnoreCase("Y")==0){
          System.out.println("You have " + steelstock + ". Enter amount to sell in tonns:");
          ans = sc.next();
          double amount = Double.parseDouble(ans);
          if (checkStock(amount, steelstock)){
            sellStock(amount, steelprice);
            steelstock -= amount;
            printFunds();
          } else {
            System.out.println("You do not have enough steel to sell.");
          }
        
        }
      
        totalstock = sugarstock + steelstock;
        chargeStorage(totalstock);
        currentround++;
        System.out.println();
      } else {
        System.out.println("You balance is " + currentfunds + " you do not have enough money to continue playing.");
        canplay = false;
      }
      
    }
  }
  
  // Buy stock
  public void buyStock(double units, double priceperunit){
    // Calculate the total price for the of stock to be purchased.
    double totalprice = units * priceperunit;
    //check if the funds are avaiable to purchase this amount of goods of a certain type.
    if (checkFunds(totalprice, currentfunds)) {
      // Subract the total stock purchased from the funds available.
      currentfunds -= totalprice;
    } else {
      System.out.println("You do not have enough money to but this amount of goods.");
    }
  }
  
  public void sellStock(double units, double priceperunit){
    // Calculate the total price for the of stock sold.
    double totalprice = units * priceperunit;
    // Add the total of the stock sold to the funds available.
    currentfunds += totalprice;
  }
  
  // Charge storage
  private void chargeStorage(double stock){
    // Calculate the cost of storage for current round.
    double storagecost = stock * storageprice;
    // Subtract the storage cost from the funs available.
    currentfunds -= storagecost;
  }
  
  private boolean checkStock(double tosell, double available) {
    if (tosell <= available) {
      return true;
    } else {
      return false;
    }
  }
  
  // Check funds
  private boolean checkFunds(double tospend, double available){
    if (tospend < available){
      return true;
    } else {
      return false;
    }
  }
  
  private void printFunds(){
    System.out.println("You have $" + currentfunds + " available.");
  }
}