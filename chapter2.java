import java.util.Scanner; 

public class chapter2 {
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in); 
        System.out.print("Enter an integer: ");
        int number = myObj.nextInt();
        System.out.println("2 * " + number + "= " + number+number);

    }
}
