package Lab3;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("John",500);
        employees[1] = new Employee("Richard",6000);
        employees[2] = new Employee("Anna",12000);
        employees[3] = new Employee("Isabelle",35000);
        employees[4] = new Employee("Johnna",37000);
        System.out.println("Average: " + Employee.average(employees));
        System.out.println("Max salary employee: " + ((Employee)employees[0].largest(employees)).getName());
    }
}
