public class Population {

    public static void main(String[] args) {
        double populationOfMexico = 106200000;
        double growthRate = 1.017;
        int year = 2005;

        while (populationOfMexico < 120000000) {
            populationOfMexico = populationOfMexico * growthRate;
            year++; 
        }

        System.out.println(year); 

    }
}