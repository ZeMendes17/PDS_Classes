package src.TodosFazem;

public class TeamMember extends Decorator {
    
    // Constructor
    TeamMember(EmployeeInterface e) {
        super(e);
    }


    // Interface methods
    @Override
    public void start(Date d) {
        e.start(d);
        System.out.println("TeamMember started working at: " + d.toString());
    }

    @Override
    public void terminate(Date d) {
        e.terminate(d);
        System.out.println("TeamMember ended working at: " + d.toString());
    }

    @Override
    public void work() {
        e.work();
        System.out.print("is member ");
    }

    // other methods
    public void colaborate() {
        System.out.print("is colaborating ");
    }
}