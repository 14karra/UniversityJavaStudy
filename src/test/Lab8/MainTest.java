package Lab8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private static File textFile;

    @BeforeAll
    static void prepareTextFile() {
        textFile = Lab8.Main.getTextFile();
    }

    @Test
    void getInfiniteStreamTest() {
        long seed = 5L;
        long a = 25_214_903_917L;
        long c = 11L;
        long m = 2L ^ 48;
        Stream<Long> expectedLongList = Stream.iterate(seed, xN -> (a * xN + c) % m);

        assertEquals(expectedLongList.limit(100).collect(Collectors.toList()),
                Lab8.Main.executeExercise4().limit(100).collect(Collectors.toList()));
    }

    @Test
    void getAverageStringLengthTest() {

        Double expectedAverage = Lab8.Main.readWords(textFile.getAbsolutePath())
                .parallel()
                .mapToInt(String::length)
                .average()
                .getAsDouble();

        assertEquals(expectedAverage, Lab8.Main.getAverageStringLength(textFile));
    }

    @Test
    void getWordsOfMaxLengthTest() {
        Supplier<Stream<String>> streamSupplier = () -> Lab8.Main.readWords(textFile.getAbsolutePath());
        int maxLength = streamSupplier.get().max(Comparator.comparingInt(String::length)).get().length();

        List<String> expectedList = streamSupplier.get()
                .filter(str -> str.length() == maxLength)
                .collect(Collectors.toList());

        assertEquals(expectedList, Lab8.Main.getWordsOfMaxLength(textFile));
    }

    @Test
    void findUsingSequentialStreamTest() {
        List<BigInteger> expectedBigIntegerList = Stream.iterate(BigInteger.ZERO, BigInteger::nextProbablePrime)
                .sequential()
                .filter(nbr -> nbr.isProbablePrime(10) && nbr.toString().length() <= 50)
                .limit(500).collect(Collectors.toList());

        assertEquals(expectedBigIntegerList, Lab8.Main.findUsingSequentialStream().getValue());
    }

    @Test
    void findUsingParallelStreamTest() {
        List<BigInteger> expectedBigIntegerList = Stream.iterate(BigInteger.ZERO, BigInteger::nextProbablePrime)
                .parallel()
                .filter(nbr -> nbr.isProbablePrime(10) && nbr.toString().length() <= 50)
                .limit(500).collect(Collectors.toList());

        assertEquals(expectedBigIntegerList, Lab8.Main.findUsingParallelStream().getValue());
    }
}