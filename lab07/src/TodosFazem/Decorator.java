package src.TodosFazem;

public class Decorator implements EmployeeInterface {

    protected EmployeeInterface e;

    public Decorator(EmployeeInterface e){
        this.e = e;
    }

    // Interface methods
    public void start(Date d) {
        e.start(d);
    }

    public void terminate(Date d) {
        e.terminate(d);
    }

    public void work() {
        e.work();
    }
}
