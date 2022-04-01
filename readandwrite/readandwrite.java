package readandwrite;
import java.util.Scanner;
public class readandwrite {
    public static void main(String[] args) {
        // use a scanner to read the input and write the output
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        System.out.println("You entered: " + number);
    }
}


