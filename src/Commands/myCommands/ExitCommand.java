package Commands.myCommands;

import Commands.CommandEater;
import Commands.CommandPattern;

public class ExitCommand implements CommandPattern {
    /** Метод, завершающий программу */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            CommandEater.setIsProgramRunning(false);
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
