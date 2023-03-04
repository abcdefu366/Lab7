package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class ClearCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            HumanBeingCollection.getHumanBeings().clear();
            System.out.println("Коллекция полностью очищена");
        }
        else {
            System.out.println("Некорректная команда");
        }
    }
}
