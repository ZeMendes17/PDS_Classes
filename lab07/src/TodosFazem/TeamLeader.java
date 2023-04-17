package src.TodosFazem;

public class TeamLeader extends Decorator {

    // Constructor
    TeamLeader(EmployeeInterface e) {
        super(e);
    }


    // Interface methods
    @Override
    public void start(Date d) {
        e.start(d);
        System.out.println("TeamLeader started working at: " + d.toString());
    }

    @Override
    public void terminate(Date d) {
        e.terminate(d);
        System.out.println("TeamLeader ended working at: " + d.toString());
    }

    @Override
    public void work() {
        e.work();
        System.out.print("is leader ");
    }

    public void plan() {
        System.out.print("is planning ");
    }
    
}
