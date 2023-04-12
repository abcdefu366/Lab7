package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Collections;
import java.util.LinkedList;

public class PrintFieldDescendingCarCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            LinkedList<HumanBeing> humanBeingLinkedList = new LinkedList<>(HumanBeingCollection.getHumanBeings());
            Collections.sort(humanBeingLinkedList, new HumanBeing.SortByCar().reversed());
            for (HumanBeing humanBeing : humanBeingLinkedList) {
                System.out.println(humanBeing.getCar().getCool());
            }
            humanBeingLinkedList.clear();
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
