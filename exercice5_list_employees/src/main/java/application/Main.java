package application;

import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("How many employess will be registered?");
        int numberOfRegisters = input.nextInt();
        for(int i = 0; i < numberOfRegisters; i++){
            System.out.println("Employee #" + (i+1) + ":");
            System.out.print("Id: ");
            int id = input.nextInt();
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Salary: ");
            double salary = input.nextDouble();
            employeeList.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = input.nextInt();
        System.out.print("Enter the percentage: ");
        double percentage = input.nextDouble();
        Employee employee = employeeList.stream().filter(obj -> obj.getId() == id).findFirst().orElse(null);
        if (employee == null) System.out.println("The employee with this id does not exist!");
        else employee.setSalary(percentage);

        System.out.println("List of employees:");
        for (Employee obj : employeeList){
            System.out.println(obj);
        }
    }
}
