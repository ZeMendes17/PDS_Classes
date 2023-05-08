package Facade;

import java.util.List;
import java.util.ArrayList;

public class CompanyFacade {
    public static List<Person> persons = new ArrayList<>();
    private SocialSecurity socialSecurity;
    private Insurance insurance;
    private Card card;
    private Parking parking;

    public void getRegistationEmployee(String name, double salary) {
        Person person = new Person(name, salary);
        persons.add(person);
        Boolean socialRegist = socialSecurity.regist(person);
        Boolean insuranceRegist = insurance.regist(person);
        String EmployeeCard = card.create(person);
        String AllowParking = parking.allow(person);
        System.out.println(socialRegist);
        System.out.println(insuranceRegist);
        System.out.println(EmployeeCard);
        System.out.println(AllowParking);
    }
}