package src.TodosFazem;

public class Manager extends Decorator {
    
    // Constructor
    Manager(EmployeeInterface e) {
        super(e);
    }


    // Interface methods
    @Override
    public void start(Date d) {
        e.start(d);
        System.out.println("Manager started working at: " + d.toString());
    }

    @Override
    public void terminate(Date d) {
        e.terminate(d);
        System.out.println("Manager ended working at: " + d.toString());
    }

    @Override
    public void work() {
        e.work();
        System.out.print("is manage ");
    }

    // other methods
    public void manage() {
        System.out.print("is managing ");
    }
}