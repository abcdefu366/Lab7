package Commands.myCommands;

import Classes.*;
import Commands.CommandEater;
import Commands.CommandPattern;

import java.util.Scanner;

public class InsertAtCommand implements CommandPattern {
    /** Метод, добавляющий новый элемент в заданную позицию */
    @Override
    public void execute() {
        if (CommandEater.getIsProgramRunning()) {
            try {
                Integer index = Integer.parseInt(CommandEater.getSplit()[1]);
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                Long x = Long.parseLong(scanner.nextLine());
                Long y = Long.parseLong(scanner.nextLine());
                Boolean realHero = Boolean.parseBoolean(scanner.nextLine());
                Boolean hasToothpick = Boolean.parseBoolean(scanner.nextLine());
                Integer speed = Integer.parseInt(scanner.nextLine());
                Integer intWeaponType = Integer.parseInt(scanner.nextLine());
                WeaponType weaponType = WeaponType.getWeaponType(intWeaponType);
                Integer intMood = Integer.parseInt(scanner.nextLine());
                Mood mood = Mood.getMood(intMood);
                Boolean cool = Boolean.parseBoolean(scanner.nextLine());
                HumanBeing humanBeing = new HumanBeing(name, new Coordinates(x, y), realHero, hasToothpick, speed, weaponType, mood, new Car(cool));
                HumanBeingCollection.getHumanBeings().add(index, humanBeing);
                System.out.println("Новый элемент добавлен на позицию под номером: " + index);
            }
            catch (Exception e) {}
        }
        else {
            System.out.println("Некорректная команда");
        }
    }
}
