package Commands.myCommands;

import Commands.CommandEater;
import Commands.CommandPattern;

public class ExitCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            CommandEater.setIsProgramRunning(false);
        }
        else {
            System.out.println("Некорректная команда");
        }
    }
}
