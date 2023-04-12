package Commands.myCommands;

import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class ClearCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            HumanBeingCollection.getHumanBeings().clear();
            System.out.println("Коллекция полностью очищена");
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
