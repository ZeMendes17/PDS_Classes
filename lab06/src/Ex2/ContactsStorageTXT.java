package Ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageTXT implements ContactsStorageInterface{
    private String file;

    public ContactsStorageTXT(String file){
        this.file = file;
    }


    @Override
    public List<Contact> loadContacts(){
        List<Contact> contacts = new ArrayList<>();

        try{
        File f = new File(file);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            String[] info = line.split("\t");
            contacts.add(new Contact(info[0], Integer.parseInt(info[1])));
        }
        sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list){

        String data = "";
        for (Contact contact : list){
            data = data + contact.getName() + "\t" + contact.getNumber() + "\n";
        }

        try {
            Path fpath = Paths.get(file);
            FileWriter writer = new FileWriter(fpath.toString());
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong");
            return false;
        }
        return true;
    }
}
