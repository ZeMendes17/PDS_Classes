package ex3;

public class RemoteControl<E> {
    private CommandInterface<E> command;

    public void setCommand(CommandInterface<E> command) {
        this.command = command;
    }

    public void execButton(E elem) {
        command.execute(elem);
    }

    public void undoButton() {
        command.undo();
    }
}
