package Bank2;
import java.util.List;

// import Bank2.Employee2;
// import Bank2.Person;

import java.util.ArrayList;
import java.util.Collections;

class Company2 {

    public static User user;
    private List<Employee2> emps = new ArrayList<>();

        public void admitEmployee(Person name, double salary) {
            Employee2 e = new Employee2(name, salary);
            emps.add(e);
        }
        
        public void paySalaries(int month) {
            for (Employee2 e : emps) {
                e.payEmp(e.getSalary());
            }
        }
        
        public List<Employee2> employees() {
            return Collections.unmodifiableList(emps);
        }
}