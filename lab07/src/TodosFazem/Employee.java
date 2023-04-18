package src.TodosFazem;


public class Employee implements EmployeeInterface {
    private String name;

    // Constructor
    Employee(String name) {
        this.name = name;
    }

    // Interface methods
    @Override
    public void start(Date d) {
        System.out.println("Employee " + name + " started working at: " + d.toString());
    }

    @Override
    public void terminate(Date d) {
        System.out.println("Employee " + name + " ended working at: " + d.toString());
    }

    @Override
    public void work() {
        System.out.print("\n" + name + " is working ");
    }



}