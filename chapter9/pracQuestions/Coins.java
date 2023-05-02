public class Coins {
    private int cents;
    private int nickels;
    private int dimes;
    private int quarters;
    private int pennies;
    public Coins (int cents) {
        this.cents = cents;
        while (cents >= 25) {
            quarters++;
            cents-=25;
        }
        while (cents >=10) {
            dimes++;
            cents-=10;
        }
        while (cents >=5) {
            nickels++;
            cents-=5;
        }
        while (cents >=1) {
            cents--;
            pennies++;
        }
    }
    public int getQuarters(){
        return quarters;
    }
    public int getNickels(){
        return nickels;
    }

public int getDimes(){
        return dimes;
    }

public int getPennies(){
return pennies;                    
}
}
    

