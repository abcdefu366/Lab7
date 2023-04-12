package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Classes.Mood;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueMoodCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning() && CommandEater.getSplit().length == 1) {
            Set<Mood> set = new HashSet();
            for (HumanBeing humanBeing : HumanBeingCollection.getHumanBeings()) {
                set.add(humanBeing.getMood());
            }
            for (Mood mood : set) {
                System.out.println(mood);
            }
            set.clear();
        }
        else {
            System.out.println("Такое количество параметров невозможно для этой команды");
        }
    }
}
