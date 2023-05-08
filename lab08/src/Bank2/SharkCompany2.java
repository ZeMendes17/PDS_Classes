package Bank2;
import java.util.List;

// import Bank2.Person;

public class SharkCompany2 {
    public static void main(String[] args ) {
        Person[] persons = {new Person("Maria Silva"),
            new Person("Manuel Pereira"),
            new Person("Aurora Machado"),
            new Person("Augusto Lima") 
            };
        
        Company2 shark = new Company2();
        Company2.user = User.OWNER;
        
        shark.admitEmployee(persons[0], 1000);
        shark.admitEmployee(persons[1], 900);
        shark.admitEmployee(persons[2], 1200);
        shark.admitEmployee(persons[3], 1100);
        List<Employee2> sharkEmps = shark.employees();
        for (Employee2 e : sharkEmps)
            System.out.println(e.getSalary());
        shark.paySalaries(1);
    }
}
