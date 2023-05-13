package ex3;

import java.util.Stack;

public class CommandManager {
    private final Stack<CommandInterface> undoStack;

    public CommandManager() {
        undoStack = new Stack<>();
    }

    public void executeCommand(CommandInterface command) {
        command.execute();
        undoStack.push(command);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            CommandInterface lastCommand = undoStack.pop();
            lastCommand.undo();
        }
    }
}