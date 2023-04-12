package Commands.myCommands;

import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Collections;
import java.util.Comparator;

public class SortCommand implements CommandPattern {
    /** Метод, сортирующий коллекцию в естественном порядке по заданному полю */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("[1-9]"))) {
                System.out.println("Введён некорректный параметр сортировки");
            }
            if (CommandEater.getSplit().length > 2) {
                System.out.println("Такое количество параметров невозможно для этой команды");
            }
            else {
                Integer parameter = Integer.parseInt(CommandEater.getSplit()[1]);
                if (parameter.equals(1)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortById());
                }
                if (parameter.equals(2)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByX_Coordinate());
                }
                if (parameter.equals(3)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByY_Coordinate());
                }
                if (parameter.equals(4)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByRealHero());
                }
                if (parameter.equals(5)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByHasToothpick());
                }
                if (parameter.equals(6)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByImpactSpeed());
                }
                if (parameter.equals(7)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByWeaponType());
                }
                if (parameter.equals(8)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByMood());
                }
                if (parameter.equals(9)) {
                    Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByCar());
                }
                System.out.println("Коллекция успешно отсортирована");
            }
        }
    }
}
