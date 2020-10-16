package Lab3;

import java.util.*;

class Employee implements Measurable {
    private String name;
    private final double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return this.salary;
    }

    @Override
    public Measurable largest(Measurable[] objects) {
        return ((Arrays.asList(objects).parallelStream()
                .max(Comparator.comparingDouble(Measurable::getMeasure))
                .get()));
    }

    static double average(Measurable[] objects) {
        OptionalDouble result = Arrays.asList(objects)
                .parallelStream()
                .mapToDouble(Measurable::getMeasure)
                .average();
        return result.isPresent() ? result.getAsDouble() : 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

}
