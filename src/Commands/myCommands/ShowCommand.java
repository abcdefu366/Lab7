package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

public class ShowCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (HumanBeingCollection.getHumanBeings().isEmpty()) {
                System.out.println("Коллекция не содержит данных");
            }
            else {
                for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                    System.out.println(humanBeing);
                }
            }
        }
        else {
            System.out.println("Некорректная команда");
        }
    }
}
