package Lab7;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static File textFile = new File("src/main/resources/Lab7/text.txt");

    public static void main(String[] args) throws FileNotFoundException {

        exercise_2();

        exercise_7();

        exercise_13();
    }

    private static void exercise_13() {
        Cache<Integer, String> cache = new Cache<>(5);

        for (int i = 0; i < 10; i++) {
            cache.put(i, "string_" + i);
        }

        System.out.println(cache.toString());
    }

    private static void exercise_2() {
        ArrayList<String> strings1 = new ArrayList<>(Collections.singletonList("aaa, bbb, ccc"));
        ArrayList<String> strings2 = ((ArrayList<String>) strings1.clone());
        ArrayList<String> strings3 = ((ArrayList<String>) strings1.clone());

        System.out.println("Before: " + strings1 + " toUpperCaseA: " + toUpperCaseA(strings1));
        System.out.println("Before: " + strings2 + " toUpperCaseB: " + toUpperCaseB(strings2));
        System.out.println("Before: " + strings3 + " toUpperCaseC: " + toUpperCaseC(strings3));
    }

    @Contract("_ -> param1")
    private static ArrayList<String> toUpperCaseA(@NotNull ArrayList<String> strings) {
        for (ListIterator<String> iter = strings.listIterator(); iter.hasNext(); ) {
            String next = iter.next();
            String upper = next.toUpperCase();
            iter.set(upper);
        }
        return strings;
    }

    @Contract("_ -> param1")
    private static ArrayList<String> toUpperCaseB(@NotNull ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String next = strings.get(i);
            String upper = next.toUpperCase();
            strings.set(i, upper);
        }
        return strings;
    }

    @NotNull
    @Contract("_ -> param1")
    private static ArrayList<String> toUpperCaseC(@NotNull ArrayList<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }

    private static void exercise_7() throws FileNotFoundException {
        List<String> words = loadText(textFile);
        System.out.println("Occurrences: " + countOccurrence(words).toString());
    }

    @NotNull
    private static Map<String, Integer> countOccurrence(@NotNull List<String> words) {
        Map<String, Integer> occurrences = new TreeMap<>();
        for (String word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
        return occurrences;
    }

    @Contract("null -> fail")
    private static List<String> loadText(File filename) throws FileNotFoundException {
        if (filename == null || !filename.exists()) {
            throw new IllegalArgumentException("Error: filename incorrect");
        }

        List<String> result = new ArrayList<>();
        Scanner in = new Scanner(filename);
        while (in.hasNext()) {
            result.add(in.next());
        }

        return result;
    }
}
