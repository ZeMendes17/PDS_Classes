package Facade;

import java.util.List;
import java.util.ArrayList;

public class Parking {
    private Person person;
    private int count = 0;
    private double avgSalary;
    private String result = "Parking not allowed";
    private List<Person> park = new ArrayList<>();

    Parking(Person p) {
        person = p;
    }

    public void AverageSalary() {
        for (Person p : CompanyFacade.persons) {
            avgSalary += p.getSalary();
            count++;
        }
        avgSalary = avgSalary/count;
    }

    public String allow(Person p) {
        AverageSalary();
        if (p.getSalary() > avgSalary) {
            park.add(p);
            result = "Parking Allowed!";
        }
        return result;
    }
}