import java.util.Scanner;

public class Game {
  
  double currentfunds;
  
  Game(double funds){
    currentfunds = funds;
  }
  int currentround = 1;
  double sugarstock = 0;
  double steelstock = 0;
  double totalstock;
  double storageprice = 3.00;
  
  Good[] goodArray = new Good[3];
  
  public void run(){
    
    goodArray[0] = new Good("Sugar", 13.00, 20.00);
    goodArray[1] = new Good("Steel", 21.00, 54.00);
    
    String s;
    int amount;
    boolean canplay = true;
    
    while(canplay){
      double roundendstock = 0;
      addGood(currentfunds);
      System.out.println("Round number: " + currentround);
      for(int i = 0; i < goodArray.length; i++) {
        if (goodArray[i] != null) {
          goodArray[i].roundPrice();
        }
      }
      System.out.println("You have $ " + currentfunds + " available.");
      System.out.println("Goods in stock:");
      
      for(int i = 0; i < goodArray.length; i++) {
        if (goodArray[i] != null) {
          System.out.println("You have: " + goodArray[i].stock + " of " + goodArray[i].name);
        }
      }
      for(int i = 0; i < goodArray.length; i++) {
        if (goodArray[i] != null) {
          System.out.println(goodArray[i].name + " price in this round: " + goodArray[i].roundPrice());
        }
      }
      
      
      if (currentfunds > 0 ){
        for(int i = 0; i < goodArray.length; i++){
          if (goodArray[i] != null) {
            System.out.println("Buy " + goodArray[i].name + " ? (Enter Y or n):");
            s = StdIn.readString();
            if (s.equals("Y")){
              System.out.print("Enter amount to buy in tons. (example 100): ");
              amount = StdIn.readInt();
              buyStock(amount, goodArray[i].currentprice);
              goodArray[i].stock += amount;
              System.out.println("Funds: $ " + currentfunds);
            }
          }
        }
        for(int i = 0; i < goodArray.length; i++){
        if (goodArray[i] != null){
          System.out.println("Sell " + goodArray[i].name + " ? (Enter Y or n):");
          s = StdIn.readString();
          if (s.equals("Y")){
            System.out.print("Enter amount to sell in tons. (example 100): ");
            amount = StdIn.readInt();
            sellStock(amount, goodArray[i].currentprice);
            goodArray[i].stock -= amount;
            System.out.println("Funds: $ " + currentfunds);
            System.out.println("Stock: " + goodArray[i].stock);
          }
        }
      }
        for(int i = 0; i < goodArray.length; i++){
        if (goodArray[i] != null) {
          roundendstock += goodArray[i].stock;
        }
      }
        
      System.out.println("Round end stock :" + roundendstock);
      totalstock = roundendstock;
      chargeStorage(totalstock);
      currentround++;
      System.out.println("Total stock :" + totalstock);
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
  
  private void addGood(double funds){
    if (funds >= 15000 && goodArray[2] == null){
      goodArray[2] = new Good("Gold", 50.00, 120.00);
      System.out.println("******** Congratulations you can now trade Gold ********");
    } else {
      System.out.println("Nothing to add!");
    }
  }
}