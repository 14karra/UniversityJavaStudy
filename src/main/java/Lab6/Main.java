package Lab6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    private static List<Employee> expected = new ArrayList<>(
            Arrays.asList(new Employee(1), new Employee(2), new Employee((3)), new Employee(4))
    );
    private static List<Employee> dest = new ArrayList<>(Arrays.asList(new Employee(1), new Employee(2)));
    private static List<Employee> src = new ArrayList<>(Arrays.asList(new Employee(3), new Employee(4)));
    private static final int STACK_SIZE = 5;

    public static void main(String[] args) {
        startExercises_1_and_2();

        startExercise_6();

        exercise_12();
    }

    private static void startExercise_6() {
        exercise_6_1();

        exercise_6_2();
    }

    private static void exercise_12() {
        List<Employee> result = new ArrayList<>(2);
        minmax(expected, Employee::compareTo, result);

        System.out.println("\nMin: " + result.get(0).toString() + "\nMax: " + result.get(1).toString());
    }

    private static void exercise_6_1() {
        append(dest, src);

        if (expected.equals(dest)) {
            System.out.println("They're equals");
        } else {
            System.out.println("They're not equals");
        }
    }

    private static void exercise_6_2() {
        append2(dest, src); //OK

        List<Developer> dest2 = new ArrayList<>(Arrays.asList(new Developer(1), new Developer(2)));

        // append2(dest2, src); //Error at coding due to restrictions and types incompatibility.

        List<Developer> src2 = new ArrayList<>(Arrays.asList(new Developer(3), new Developer(4)));

        append2(dest2, src2); //OK
    }

    private static void startExercises_1_and_2() {
        Stack<Integer> stack = new Stack<>(STACK_SIZE);
        StackWithObjectArray<Long> stackWithObjectArray = new StackWithObjectArray<>(STACK_SIZE);
        StackWithEArray<Long> stackWithEArray = new StackWithEArray<>(STACK_SIZE);

        Random random = new Random();
        for (int i = 0; i < STACK_SIZE / 2; i++) {
            stack.push(random.nextInt());
            stackWithObjectArray.push(random.nextLong());
            stackWithEArray.push(random.nextLong());
        }

        processStack(stack);
        processStack(stackWithObjectArray);
        processStack(stackWithEArray);
    }

    private static <T extends IStack> void processStack(@NotNull T someStack) {
        System.out.println("pop-ed: " + someStack.pop());
        System.out.println("Is empty? -> " + someStack.isEmpty());
        System.out.println("pop-ed: " + someStack.pop());
        System.out.println("Is empty? -> " + someStack.isEmpty());
    }

    private static <E> void append(@NotNull List<E> destination, List<E> source) {
        destination.addAll(source);
    }

    private static <E> void append2(@NotNull List<? super E> destination, List<? extends E> source) {
        destination.addAll(source);
    }

    private static <T> void minmax(List<T> elements,
                                   Comparator<? super T> comp,
                                   @NotNull List<? super T> result) {
        result.add(Collections.min(elements, comp));
        result.add(Collections.max(elements, comp));
    }
}
