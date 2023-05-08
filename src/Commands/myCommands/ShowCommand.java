package Commands.myCommands;

import Classes.*;
import Commands.*;

/**
 * The type Show command.
 */
public class ShowCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            if (HumanBeingCollection.getHumanBeings().isEmpty()) {
                System.out.println(Colors.YELLOW + "Коллекция не содержит данных" + Colors.RESET);
            }
            else {
                HumanBeingCollection.getHumanBeings().forEach(System.out::println);
            }
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
