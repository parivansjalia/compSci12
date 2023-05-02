package craps;

public class Die {
    private int numDots;

    public void roll() {
        numDots = (int) (Math.random() * 6 + 1);
    }

    public int getNumDots() {
        return numDots;
    }

    public static void main(String[] args) {
        Die die = new Die();
        die.roll();
        System.out.println(die.getNumDots());
        die.roll();
        System.out.println(die.getNumDots());
        die.roll();
        System.out.println(die.getNumDots());
    }
}