package controller.input;

@FunctionalInterface
public interface ICommandReceiver {
    void receive(ICommand command);
}