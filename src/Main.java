import Classes.*;
import Commands.CommandEater;
public class Main {
    public static void main(String[] args) {
        CommandEater.setFileName(args[0]);
        HumanBeingCollection.readerFromFile(CommandEater.getFileName());
        CommandEater.commandEat();
    }
}