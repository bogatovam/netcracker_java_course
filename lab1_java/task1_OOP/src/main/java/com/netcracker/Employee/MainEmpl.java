package com.netcracker.Employee;

public class MainEmpl {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1000, "Valery", "Chernenko", 40000);
        Employee employee2 = new Employee(1002, "Margarita", "Mesina", 60000);

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

        System.out.println("Annual salary of " + employee1.getFirstName() +
                " " + employee1.getLastName() + " is " + employee1.getAnnualSalary());

        employee1.raiseSalary(10);
        System.out.println(employee1.getFirstName() + " " + employee1.getLastName() +
                " gets paid in the amount of  " +
                employee1.getSalary());

        System.out.println(employee1.getName() + " and " +
                employee2.getName() + " is" +
                (employee1.equals(employee2) ? " equals" : " not equals"));
    }
}
