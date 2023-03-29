package Ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorageBIN implements ContactsStorageInterface{
    private String file;

    public ContactsStorageBIN(String file) {
        this.file = file;
    }

    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();

        try {
            Path path = Paths.get(file);
            BufferedReader reader = new BufferedReader(new FileReader(path.toString()));

            String line = reader.readLine();

            while (line != null) {

                String[] info = line.split("\t");
                Contact c = new Contact(info[0], Integer.parseInt(info[1]));
                contacts.add(c);
                line = reader.readLine();
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (IOException e){
            System.out.println("Something went wrong");
        }
        return contacts;
    }

    public boolean saveContacts(List<Contact> list) {

        try {
            Path fpath = Paths.get(this.file);
            BufferedWriter bwriter = new BufferedWriter(new FileWriter(fpath.toString()));

            for (Contact c : list) {
                bwriter.write(c.toString() + "\n");
            }
            bwriter.close();

        } catch (IOException e) {
            return false;
        }
        return true;

    };
}
