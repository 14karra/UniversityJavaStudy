package Lab8;

import javafx.util.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final File textFile = new File("src/main/resources/Lab8/text.txt");

    public static void main(String[] args) {

        executeExercise4();

        executeExercise10();

        executeExercise11();

        executeExercise16();
    }

    @Contract(pure = true)
    static @NotNull Stream<Long> executeExercise4() {
        return getInfiniteStream(5L, 25_214_903_917L, 11L, 2L ^ 48);
    }

    static void executeExercise10() {
        System.out.println("\n\nAverage word length: " + getAverageStringLength(textFile));
    }

    static void executeExercise11() {
        System.out.println(MessageFormat.format("\n\nMax length words: {0}", getWordsOfMaxLength(textFile).toString()));
    }

    static void executeExercise16() {

        Pair<Long, List<BigInteger>> longListPairSequential = findUsingSequentialStream();
        System.out.println(new StringBuilder()
                .append("Sequential - Prime numbers: ")
                .append(longListPairSequential.getValue().toString())
                .append("\nExecution time: ")
                .append(longListPairSequential.getKey())
                .append("s")
                .toString());

        Pair<Long, List<BigInteger>> longListPairParallel = findUsingParallelStream();
        System.out.println(new StringBuilder()
                .append("Parallel - Prime numbers: ")
                .append(longListPairParallel.getValue().toString())
                .append("\nExecution time: ")
                .append(longListPairParallel.getKey())
                .append("s")
                .toString());
    }

    @NotNull
    static Pair<Long, List<BigInteger>> findUsingParallelStream() {
        long start = System.currentTimeMillis();

        List<BigInteger> bigIntegerList = Stream.iterate(BigInteger.ZERO, BigInteger::nextProbablePrime)
                .parallel()
                .filter(nbr -> nbr.isProbablePrime(10) && nbr.toString().length() <= 50)
                .limit(500).collect(Collectors.toList());

        long finish = System.currentTimeMillis();
        return new Pair<>(finish - start, bigIntegerList);
    }

    @NotNull
    static Pair<Long, List<BigInteger>> findUsingSequentialStream() {
        long start = System.currentTimeMillis();

        List<BigInteger> bigIntegerList = Stream.iterate(BigInteger.ZERO, BigInteger::nextProbablePrime)
                .sequential()
                .filter(nbr -> nbr.isProbablePrime(10) && nbr.toString().length() <= 50)
                .limit(500).collect(Collectors.toList());

        long finish = System.currentTimeMillis();
        return new Pair<>(finish - start, bigIntegerList);
    }

    static List<String> getWordsOfMaxLength(File textFile) {
        Supplier<Stream<String>> streamSupplier = () -> readWords(textFile.getAbsolutePath());
        int maxLength = streamSupplier.get().max(Comparator.comparingInt(String::length)).get().length();

        return streamSupplier.get()
                .filter(str -> str.length() == maxLength)
                .collect(Collectors.toList());
    }

    static Stream<String> readWords(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            return reader
                    .lines()
                    .flatMap(line -> Stream.of(line.split("\\s+|(?<!\\d)[,.](?!\\d+)")));
        } catch (IOException exn) {
            return Stream.empty();
        }
    }

    static double getAverageStringLength(@NotNull File textFile) {
        return readWords(textFile.getAbsolutePath())
                .parallel()
                .mapToInt(String::length)
                .average()
                .getAsDouble();
    }

    @NotNull
    @Contract(pure = true)
    static Stream<Long> getInfiniteStream(Long seed, Long a, Long c, Long m) {
        return Stream.iterate(seed, xN -> (a * xN + c) % m);
    }

    public static File getTextFile() {
        return textFile;
    }
}