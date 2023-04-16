package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Collections;
import java.util.LinkedList;

public class PrintFieldAscendingImpactSpeedCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            LinkedList<HumanBeing> humanBeingLinkedList = new LinkedList<>(HumanBeingCollection.getHumanBeings());
            Collections.sort(humanBeingLinkedList, new HumanBeing.SortByImpactSpeed());
            for (HumanBeing humanBeing : humanBeingLinkedList) {
                System.out.println(humanBeing.getImpactSpeed());
            }
            humanBeingLinkedList.clear();
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
