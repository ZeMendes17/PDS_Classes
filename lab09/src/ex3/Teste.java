package ex3;

import java.util.ArrayList;
import java.util.Collection;

public class Teste {
    public static void main(String[] args) {
        // Criar uma coleção
        Collection<String> collection = new ArrayList<>();

        // Crrar um gestor de comandos
        CommandManager commandManager = new CommandManager();

        // Adicionar e remover elementos da coleção
        CommandInterface addCommand1 = new AddCommand<>(collection, "Element 1");
        commandManager.executeCommand(addCommand1);

        CommandInterface addCommand2 = new AddCommand<>(collection, "Element 2");
        commandManager.executeCommand(addCommand2);

        CommandInterface removeCommand = new RemoveCommand<>(collection, "Element 1");
        commandManager.executeCommand(removeCommand);

        // Print (should print "Element 2")
        System.out.println("Collection: " + collection);

        // Undo the last command (remove "Element 1", ou seja, adicionar "Element 1")
        commandManager.undo();

        // Print the collection after undo (Should print "Element 1" and "Element 2")
        System.out.println("Collection after undo: " + collection);
    }
}