import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //the osis in the edpuzzle is 215711656
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the osis: ");
        int osis = sc.nextInt();
        Calculate c = new Calculate(osis);
        System.out.println(c.toString());
    }
}
