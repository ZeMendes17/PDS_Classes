package Facade;

import java.util.List;
import java.util.ArrayList;

public class SocialSecurity {
    private Person person;
    private boolean bol = false;
    private List<Person> soc = new ArrayList<>();

    SocialSecurity(Person p) {
        person = p;
    }

    public boolean regist(Person p) {
        soc.add(p);
        bol = true;
        return bol;
    }
}