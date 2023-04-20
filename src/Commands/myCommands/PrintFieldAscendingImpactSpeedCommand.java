package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Collections;
import java.util.LinkedList;

/**
 * The type Print field ascending impact speed command.
 */
public class PrintFieldAscendingImpactSpeedCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            if (HumanBeingCollection.getHumanBeings().isEmpty()) {
                System.out.println(Colors.YELLOW + "Коллекция не содержит данных" + Colors.RESET);
            }
            else {
                LinkedList<HumanBeing> humanBeingLinkedList = new LinkedList<>(HumanBeingCollection.getHumanBeings());
                Collections.sort(humanBeingLinkedList, new HumanBeing.SortByImpactSpeed());
                for (HumanBeing humanBeing : humanBeingLinkedList) {
                    System.out.println(Colors.BLACK + humanBeing.getImpactSpeed() + Colors.RESET);
                }
                humanBeingLinkedList.clear();
            }
        }
        else {
            System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
        }
    }
}
