package org.srv.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Ramkishore
 */
public class _Consumer {

    //DECLARATIVE APPROACH  USING FUNCTIONAL INTERFACE
    static Consumer<Employee> employeeConsumer = employee -> System.out.
            println("DECLARATIVE +++ Please verify the updated details : " + employee.toString());
    //BICONSUMER APPROACH
    static BiConsumer<Employee, Boolean> employeeBooleanBiConsumer = (employee, showId) ->
            System.out.println("DECLARATIVE +++ Thank you for registering Employee " + employee.name + " with Employee Id "
                    + (showId ? employee.id : "****************"));

    public static void main(String[] args) {

        //IMPERATIVE APPROACH
        giveOutMessage(new Employee("Ramkishore", 3797L));

        //DECLARATIVE APPROACH
        employeeConsumer.accept(new Employee("Suganya", 582117L));

        employeeBooleanBiConsumer.accept(new Employee("Vihaan", 25082021L), false);

    }

    //IMPERATIVE APPROACH
    public static void giveOutMessage(Employee employee) {
        System.out.println("IMPERATIVE +++ Please verify the updated details : " + employee.toString());
    }

    //The Employee class
    static class Employee {
        private final String name;
        private final Long id;

        public Employee(String name, Long id) {
            this.name = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
