package Commands.myCommands;

import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class InfoCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            HumanBeingCollection.getInfo();
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
