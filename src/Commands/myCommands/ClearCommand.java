package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class ClearCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            HumanBeingCollection.getHumanBeings().clear();
            System.out.println(Colors.BLUE + "Коллекция полностью очищена" + Colors.RESET);
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
