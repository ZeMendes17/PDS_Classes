package ex3;

import java.util.ArrayList;
import java.util.Collection;

public class Teste {
    public static void main(String[] args) {

        RemoteControl<String> control = new RemoteControl<>();
        Collection<String> storage = new ArrayList<>();

        CommandInterface<String> add = new AddCommand<String>(storage);
        CommandInterface<String> remove = new RemoveCommand<String>(storage);
        
        System.out.println("Before adding or removing:");
        for(String s : storage) {
            System.out.println("\t" + s);
        }

        // add 2 elements
        control.setCommand(add);
        control.execButton("Hello");
        control.execButton("World");
        control.execButton("Tudo");
        control.execButton("Bem?");
        control.execButton("OLAAAAAAAA");

        System.out.println("Added 5 elements");
        for(String s : storage) {
            System.out.println("\t" + s);
        }

        control.undoButton();
        System.out.println("Pressed UNDO Button");
        for(String s : storage) {
            System.out.println("\t" + s);
        }

        control.setCommand(remove);
        control.execButton("Tudo");
        control.execButton("World");
        System.out.println("Removed 2 elements");
        for(String s : storage) {
            System.out.println("\t" + s);
        }

        control.undoButton();
        System.out.println("Pressed UNDO Button");
        for(String s : storage) {
            System.out.println("\t" + s);
        }
    }

}