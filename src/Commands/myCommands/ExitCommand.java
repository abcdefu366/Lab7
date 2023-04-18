package Commands.myCommands;

import Classes.Colors;
import Commands.CommandEater;
import Commands.CommandPattern;

public class ExitCommand implements CommandPattern {
    /** Метод, завершающий программу */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            CommandEater.setIsProgramRunning(false);
            System.out.println(Colors.YELLOW + "До новых встреч!" + Colors.RESET);
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
