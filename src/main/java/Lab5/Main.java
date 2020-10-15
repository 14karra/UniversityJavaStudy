package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Path numbersPath = Paths.get("src/main/resources/Lab5/numbers.txt");
    private static List<Double> values;

    public static void main(String... args) throws Exception {
        System.out.println("Sum: " + sumOfValues(numbersPath.toString()));

        Double[] numbers = values.toArray(new Double[0]);
        System.out.println("Min: " + min(numbers));

        AutoCloseableWithReentrantLock autoCloseableWithReentrantLock = lock();
        autoCloseableWithReentrantLock.close();
    }

    /**
     * Solution to exercise 1
     *
     * @param filename - the file containing the numbers.
     * @return the list of numbers.
     * @throws FileNotFoundException - thrown in case the provided file path is not found.
     */
    private static List<Double> readValues(String filename) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Error: filename incorrect");
        }

        List<Double> result = new ArrayList<>();
        Scanner in = new Scanner(new File(filename));
        while (in.hasNextDouble()) {
            result.add(in.nextDouble());
        }

        System.out.println(result.toString());
        return result;
    }

    /**
     * Solution to exercise 2.
     *
     * @param filename - the file containing the numbers.
     * @return result - the sum of the loaded values.
     * @throws FileNotFoundException - thrown in case the provided file path is not found.
     */
    private static double sumOfValues(String filename) throws FileNotFoundException {
        values = readValues(filename);
        final Double[] result = {0.0};
        values.forEach((val) -> {
            result[0] += val;
        });
        return result[0];
    }

    /**
     * Solution to exercise 13
     *
     * @param numbers - the number array.
     * @return smallest - the smallest value within the array.
     */
    private static Double min(Double[] numbers) {
        Double minimum = numbers[0];
        for (Double number : numbers) {
            if ((number < minimum)) {
                minimum = number;
            }
        }
        Double smallest = minimum;
        assert Arrays.stream(numbers).allMatch(i -> i >= smallest);
        return smallest;
    }

    /**
     * Solution to exercise 9
     * Helper method combining ReentrantLock and AutoCloseable functionality.
     *
     * @return a fresh AutoCloseableWithReentrantLock object.
     */
    public static AutoCloseableWithReentrantLock lock() {
        AutoCloseableWithReentrantLock reentrantLock = new AutoCloseableWithReentrantLock();
        reentrantLock.lock();
        return reentrantLock;
    }
}
