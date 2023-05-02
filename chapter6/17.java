class Main {
    public static void main(String[] args) {
      int depHour = 9;
      int depMin = 35;
      int curHour = 3;
      int curMin = 45;
  
      int nJars = 5;
      A a = new A();
      double j = a.computeShippingCost(nJars);
  
      System.out.println(j);
  
    }
  
  }
  
  class A {
   public double computeShippingCost(int nJars) {
      int nCartons = (nJars + 11) / 12;
      int totalOunces = nCartons*25 + nJars*21;
      int lbs = totalOunces/16;
        return ((double)nCartons*1.44) + 3 + 0.96*(double)lbs;
  }}