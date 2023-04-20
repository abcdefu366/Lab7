package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

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
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    System.out.println(humanBeing);
                }
            }
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
