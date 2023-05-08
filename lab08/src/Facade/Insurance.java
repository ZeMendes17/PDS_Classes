package Facade;

import java.util.List;
import java.util.ArrayList;

public class Insurance {
    private Person person;
    private boolean bol = false;
    private List<Person> ins = new ArrayList<>();

    Insurance(Person p) {
        person = p;
    }

    public boolean regist(Person p) {
        ins.add(p);
        bol = true;
        return bol;
    }
}