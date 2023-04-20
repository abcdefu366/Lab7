package Commands.myCommands;

import Classes.Colors;
import Classes.HumanBeing;
import Classes.HumanBeingCollection;
import Commands.CommandEater;
import Commands.CommandPattern;

import javax.crypto.Cipher;
import java.util.Collections;

/**
 * The type Sort command.
 */
public class SortCommand implements CommandPattern {
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            if (CommandEater.getSplit().length > 2) {
                System.out.println(Colors.YELLOW + "Такое количество параметров невозможно для этой команды" + Colors.RESET);
            }
            else if (CommandEater.getSplit().length < 2 || !(CommandEater.getSplit()[1].matches("^[+]?\\d+$"))) {
                System.out.println(Colors.YELLOW + "Введён некорректный параметр сортировки" + Colors.RESET);
            }
            else if (HumanBeingCollection.getHumanBeings().isEmpty()) {
                System.out.println(Colors.YELLOW + "Коллекция не содержит данных" + Colors.RESET);
            }
            else {
                Integer parameter = Integer.parseInt(CommandEater.getSplit()[1]);
                if (parameter > 10 || parameter < 1) {
                    System.out.println(Colors.YELLOW + "Введён некорректный параметр сортировки" + Colors.RESET);;
                }
                else {
                    if (parameter.equals(1)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortById());
                    }
                    if (parameter.equals(2)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByName());
                    }
                    if (parameter.equals(3)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByX_Coordinate());
                    }
                    if (parameter.equals(4)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByY_Coordinate());
                    }
                    if (parameter.equals(5)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByRealHero());
                    }
                    if (parameter.equals(6)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByHasToothpick());
                    }
                    if (parameter.equals(7)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByImpactSpeed());
                    }
                    if (parameter.equals(8)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByWeaponType());
                    }
                    if (parameter.equals(9)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByMood());
                    }
                    if (parameter.equals(10)) {
                        Collections.sort(HumanBeingCollection.getHumanBeings(), new HumanBeing.SortByCar());
                    }
                    System.out.println(Colors.BLUE + "Коллекция успешно отсортирована" + Colors.RESET);
                }
            }
        }
    }
}
