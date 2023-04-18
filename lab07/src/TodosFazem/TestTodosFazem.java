package src.TodosFazem;

public class TestTodosFazem {
    public static void main(String[] args) {
        EmployeeInterface e = new Employee("António");
        Manager m1 = new Manager(new Employee("Manuel"));
        TeamLeader tl1 = new TeamLeader(e);
        TeamMember tm1 = new TeamMember(tl1);
        TeamMember tm2 = new TeamMember(m1);
        Manager m2 = new Manager(
                        new TeamLeader(
                            new TeamMember(
                                new Employee("Jorge")
                            )
                        )
        );
        Manager m3 = new Manager(
                        new TeamLeader(
                                new Employee("Carlão")));

    EmployeeInterface lista[] = {e, m1, tl1, tm1, tm2, m2, m3};
    for(EmployeeInterface emp : lista){
        emp.work();
    }
    }
}
