package Facade;

public class Card {
    private Person person;
    private String c;

    Card(Person p) {
        person = p;
    }

    public String create(Person p) {
        c = "Employee: " + p.getName() + " , Salary: " + p.getSalary();
        return c; 
    }

}