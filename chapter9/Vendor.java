/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

public class Vendor {
  private int stock;
  private int price;
  private int deposit;
  private int changeDue;
  private static double totalSales = 0;

  // Constructor
  // Parameters:
  // int price of a single item in cents
  // int number of items to place in stock
  public Vendor(int itemPrice, int numOfStock) {
    deposit = 0;
    changeDue = 0;
    price = itemPrice;
    stock = numOfStock;
  }

  // return current value of totalSale and resets totalSales to zera
  public static double getTotalSales() {
    double newTotal = totalSales;
    totalSales = 0;
    System.out.println("hi");
    return newTotal;
  }

  // Sets the quantity of items in stock.
  // Parameters:
  // int number of items to place in stock
  // Return:
  // None
  public void setStock(int newStock)

  {
    stock += newStock;
  }

  // Returns the number of items currently in stock.
  // Parameters:
  // None
  // Return:
  // int number of items currently in stock
  public int getStock() {
    return stock;
  }

  // Adds a specified amount (in cents) to the deposited amount.
  // Parameters:
  // int number of cents to add to the deposit
  // Return:
  // None
  public void addMoney(int cents) {
    deposit += cents;
  }

  // Returns the currently deposited amount (in cents).
  // Parameters:
  // None
  // Return:
  // int number of cents in the current deposit
  public int getDeposit() {
    return deposit;
  }

  // Implements a sale. If there are items in stock and
  // the deposited amount is greater than or equal to
  // the single item price, then adjusts the stock
  // and calculates and sets change and returns true;
  // otherwise refunds the whole deposit (moves it into change)
  // and returns false.
  // Parameters:
  // None
  // Return:
  // boolean successful sale (true) or failure (false)
  public boolean makeSale() {
    if (stock > 0 && (deposit >= price)) {
      stock -= 1;
      changeDue = deposit - price;
      deposit = 0;
      totalSales += price / 100.0;
      return true;
    } else {
      changeDue = deposit;
      deposit = 0;
      return false;
    }

  }

  // Returns and zeroes out the amount of change (from the last
  // sale or refund).
  // Parameters:
  // None
  // Return:
  // int number of cents in the current change
  public int getChange() {
    int change = changeDue;
    changeDue = 0;
    return change;

  }
}