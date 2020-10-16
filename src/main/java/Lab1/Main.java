package Lab1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("Smallest double: " + Double.MIN_VALUE +
                "\nHighest double: " + Double.MAX_VALUE);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println(Arrays.toString(text.split(" ", text.length())));

        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("Largest number: " + (c > (a > b ? a : b) ? c : ((a > b) ? a : b)));
        System.out.println("Largest number: " + (Math.max(c, (Math.max(a, b)))));

        new ArrayList<Integer>() {
            {
                for (int i = 1; i <= 49; i++) {
                    add(i);
                }
                System.out.println(this);
                int randomNumber;
                for (int i = 0; i < 6; i++) {
                    randomNumber = ThreadLocalRandom.current().nextInt(0, this.size());
                    remove(randomNumber);
                }
                System.out.println(this);
            }
        };
    }
}
